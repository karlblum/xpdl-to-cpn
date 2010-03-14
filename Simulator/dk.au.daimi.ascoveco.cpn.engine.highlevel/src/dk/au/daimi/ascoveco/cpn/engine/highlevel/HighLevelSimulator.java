package dk.au.daimi.ascoveco.cpn.engine.highlevel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import dk.au.daimi.ascoveco.cpn.engine.Handler;
import dk.au.daimi.ascoveco.cpn.engine.Packet;
import dk.au.daimi.ascoveco.cpn.engine.Simulator;
import dk.au.daimi.ascoveco.cpn.engine.SimulatorService;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.checker.LocalChecker;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.State;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment;
import dk.au.daimi.ascoveco.cpn.model.Arc;
import dk.au.daimi.ascoveco.cpn.model.HLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.Transition;
import dk.au.daimi.ascoveco.util.logging.PluginLogDelegateHandler;
import dk.au.daimi.ascoveco.util.logging.SingleLineLogFormatter;
import dk.klafbang.tools.StreamUtillities;

/**
 * @author mw
 */
public class HighLevelSimulator {
	/**
	 * @author mw
	 */
	public static class GramHandler implements Handler {
		private static List<Object> handlers = Collections.synchronizedList(new ArrayList<Object>());
		private static final Logger logger = Logger.getLogger("GramHandler");

		static {

			logger.addHandler(new PluginLogDelegateHandler());
			if (Activator.DEBUG_SIMULATOR
			        && (dk.au.daimi.ascoveco.util.Activator.getDefault() == null || dk.au.daimi.ascoveco.util.Activator
			                .getDefault().getDevelopment())) {
				synchronized (logger) {
					logger.setLevel(Level.ALL);
					final java.util.logging.Handler handler = new ConsoleHandler();
					handler.setLevel(Level.ALL);
					handler.setFormatter(new SingleLineLogFormatter());
					logger.setUseParentHandlers(false);
					logger.addHandler(handler);
				}
			}
		}

		/**
		 * @param handler
		 *            new handler to add
		 */
		public static void addGlobalHandler(final Object handler) {
			GramHandler.handlers.add(handler);
		}

		private final LinkedList<Object> localHandlers;

		GramHandler() {
			localHandlers = new LinkedList<Object>();
		}

		/**
		 * @param newHandlers
		 *            handler local to this simulator instance
		 */
		public synchronized void addLocalHandler(final Object... newHandlers) {
			for (final Object handler : newHandlers) {
				localHandlers.add(handler);
			}
		}

		/**
		 * @param newHandlers
		 *            handler temporary to a single invocation
		 */
		public synchronized void addTemporaryHandler(final Object... newHandlers) {
			for (int i = newHandlers.length; i > 0; i--) {
				final Object handler = newHandlers[i - 1];
				localHandlers.addFirst(handler);
			}
		}

		/**
		 * @see dk.au.daimi.ascoveco.cpn.engine.Handler#handle(java.util.List)
		 */
		public Object handle(final List<Object> parameters) {
			final LinkedList<Object> structured = new LinkedList<Object>();
			parse(structured, parameters, 0, parameters.size());
			if (structured.isEmpty()) { return null; }
			if (GramHandler.logger.isLoggable(Level.FINEST)) {
				GramHandler.logger.log(Level.FINEST, "Call: " + structured);
			}
			final Object o = structured.removeFirst();
			if (!(o instanceof String)) { return null; }
			final String name = (String) o;
			final Class<?>[] parameterTypes = new Class<?>[structured.size()];
			int i = 0;
			for (final Object p : structured) {
				parameterTypes[i++] = p.getClass();
			}
			if (GramHandler.logger.isLoggable(Level.FINE)) {
				GramHandler.logger.log(Level.FINE, "Call to `" + name + "' " + structured + " : "
				        + Arrays.toString(parameterTypes));
			}
			Method m = null;
			Object p = null;
			for (final Object handler : localHandlers) {
				try {
					m = handler.getClass().getMethod(name, parameterTypes);
					p = handler;
					break;
				} catch (final Exception e) {
					m = null;
				}
			}
			if (m == null) {
				for (final Object handler : GramHandler.handlers) {
					try {
						m = handler.getClass().getMethod(name, parameterTypes);
						p = handler;
						break;
					} catch (final Exception e) {
						m = null;
					}
				}
			}
			if (GramHandler.logger.isLoggable(Level.FINE)) {
				GramHandler.logger.log(Level.FINE, "Found `" + m + "' at " + p);
			}
			if (p != null && m != null) {
				try {
					return m.invoke(p, structured.toArray());
				} catch (final InvocationTargetException e) {
					GramHandler.logger.log(Level.WARNING, "Execution of `" + name + "' failed", e.getTargetException());
				} catch (final IllegalArgumentException e) {
					GramHandler.logger.log(Level.SEVERE, "Execution of `" + name + "' failed", e);
				} catch (final IllegalAccessException e) {
					GramHandler.logger.log(Level.SEVERE, "Execution of `" + name + "' failed", e);
				}
			}
			return null;
		}

		private int parse(final List<Object> result, final List<Object> source, final int givenPos, final int max) {
			int pos = givenPos;
			while (pos < source.size() && result.size() < max) {
				Object o = source.get(pos++);
				if (o instanceof byte[]) {
					final byte[] arr = (byte[]) o;
					if (arr.length == 0) {
						o = source.get(pos++);
						if (o instanceof Integer) {
							final List<Object> tmp = new ArrayList<Object>();
							pos = parse(tmp, source, pos, (Integer) o);
							result.add(tmp);
						} else {
							result.add(arr);
							result.add(o);
						}
					} else {
						result.add(o);
					}
				} else {
					result.add(o);
				}
			}
			return pos;
		}

		/**
		 * @param handler
		 *            handler to remove
		 */
		public void removeLocalHandler(final Object handler) {
			localHandlers.remove(handler);
		}

		/**
		 * @param handlersToRemove
		 *            handlers to remove after incocation
		 */
		public synchronized void removeTemporaryHandler(final Object... handlersToRemove) {
			for (final Object handler : handlersToRemove) {
				if (localHandlers.getFirst() == handler) {
					localHandlers.removeFirst();
				}
			}
		}
	}

	private static Map<Simulator, HighLevelSimulator> existing = new HashMap<Simulator, HighLevelSimulator>();

	State state = null;
	List<Binding> bindings = null;

	private final StateEventReceiver stateReceiver, eventReceiver;

	/**
	 * @return a fresh HLS associated with a fresh simulator
	 * @throws Exception
	 *             if we could not instantiate the new simulator
	 */
	public static HighLevelSimulator getHighLevelSimulator(final PetriNet petriNet) throws Exception {
		return new HighLevelSimulator(SimulatorService.getInstance().getNewSimulator(), petriNet);
	}

	/**
	 * @param simulator
	 *            the simulator we want a HLS for
	 * @return a canonical HLS for the given simulator
	 */
	public static HighLevelSimulator getHighLevelSimulator(final Simulator simulator, final PetriNet petriNet) {
		if (HighLevelSimulator.existing.containsKey(simulator)) { return HighLevelSimulator.existing.get(simulator); }
		return new HighLevelSimulator(simulator, petriNet);
	}

	private final GramHandler gramHandler;

	private final Simulator simulator;

	private boolean pausebefore;

	private boolean pauseafter;

	private boolean pauseshow;

	private boolean reporttrans;

	private boolean reportbinds;

	private boolean showmarking;

	private boolean showenabling;

	private String untilstep;

	private String addstep;

	private String untiltime;

	private String addtime;

	private String pausecont;

	private String reportfunc;

	private HighLevelSimulator(final Simulator simulator, final PetriNet petriNet) {
		this.simulator = simulator;
		pausebefore = false;
		pauseafter = false;
		pauseshow = false;
		reporttrans = false;
		reportbinds = false;
		showmarking = true;
		showenabling = true;
		untilstep = "";
		addstep = "";
		untiltime = "";
		addtime = "";
		pausecont = "";
		reportfunc = "";

		gramHandler = new GramHandler();
		simulator.setHandler(2, gramHandler);
		HighLevelSimulator.existing.put(simulator, this);
		if (petriNet != null) {
			stateReceiver = new StateReceiver(petriNet);
			eventReceiver = new EventReceiver(petriNet);
		} else {
			stateReceiver = null;
			eventReceiver = null;
		}
	}

	private class StateReceiver extends StateEventReceiver {
		public StateReceiver(final PetriNet net) {
			super(net);
		}

		@SuppressWarnings("unused")
		public void sendState(final ArrayList<?> values) {
			state = parseState(values);
		}
	}

	private class EventReceiver extends StateEventReceiver {
		public EventReceiver(final PetriNet net) {
			super(net);
		}

		@SuppressWarnings("unused")
		public void sendEvent(final ArrayList<List<?>> values) {
			bindings = new ArrayList<Binding>();
			for (final List<?> list : values) {
				bindings.add(super.parseBinding(list));
			}
		}
	}

	/**
	 * @param handlers
	 *            new local handlers to add
	 */
	public void addHandler(final Object... handlers) {
		gramHandler.addLocalHandler(handlers);
	}

	/**
	 * @param decl
	 *            declaration to check
	 * @throws IOException
	 *             if an IO error occured
	 * @throws DeclarationCheckerException
	 *             the declaration is not correct
	 */
	public void checkDeclaration(final HLDeclaration decl) throws IOException, DeclarationCheckerException {
		getSimulator().lock();
		Packet p = null;
		try {
			final Packet q = PacketGenerator.instance.constructCheckDeclaration(decl);
			p = send(q);
		} finally {
			getSimulator().release();
		}
		final String id = p.getString();
		final String errorMessage = p.getString();
		if (!"".equals(errorMessage)) { throw new DeclarationCheckerException(id, errorMessage); }
	}

	/**
	 * @param page
	 *            page to check
	 * @param prime
	 *            whether the page is prime
	 * @throws IOException
	 *             if an IO error occurred
	 * @throws CheckerException
	 *             if the page is not syntactically correct
	 */
	public void checkPage(final Page page, final boolean prime) throws IOException, CheckerException {
		getSimulator().lock();
		Packet p = null;
		try {
			final Packet q = PacketGenerator.instance.constructCheckPage(page, prime);
			p = send(q);
		} finally {
			getSimulator().release();
		}
		p.getInteger(); // TERMTAG=1
		final int numberOfErrors = p.getInteger();
		if (numberOfErrors > 0) {
			String errorMessage = "";
			for (int i = 0; i < numberOfErrors; i++) {
				errorMessage += p.getString() + ": " + p.getString() + "\n";
			}

			throw new SyntaxCheckerException(page.getId(), errorMessage);
		} else if (numberOfErrors == -1) { throw new SyntaxFatalErrorException("Fatal error occurred in syntax check"); }
	}

	/**
	 * 
	 */
	public void destroy() {
		getSimulator().destroy();
	}

	/**
	 * @param expr
	 *            expression to evaluate
	 * @return the ML result
	 * @throws Exception
	 *             if ML raises an exception
	 */
	public String evaluate(final String expr) throws Exception {
		return getSimulator().evaluate(expr);
	}

	/**
	 * Evaluate with response handlers
	 * 
	 * @param expr
	 *            expression to evaluate
	 * @param wrap
	 *            whether to wrap expression in JavaExecute
	 * @param handlers
	 *            handlers to take care of responses
	 * @return the ML result
	 * @throws Exception
	 *             if ML raises an exception
	 */
	public String evaluate(final String expr, final boolean wrap, final Object... handlers) throws Exception {
		try {
			gramHandler.addTemporaryHandler(handlers);
			if (wrap) {
				return getSimulator().evaluate("let open JavaExecute in\n" + expr + "\nend");
			} else {
				return getSimulator().evaluate(expr);
			}
		} finally {
			gramHandler.removeTemporaryHandler(handlers);
		}
	}

	/**
	 * Evaluate expression, wrapping in JavaExecute
	 * 
	 * @param expr
	 *            expression to evaluate
	 * @param handlers
	 *            handlers to take care of responses
	 * @return the ML result
	 * @throws Exception
	 *             if ML raises an exception
	 */
	public String evaluate(final String expr, final Object... handlers) throws Exception {
		return evaluate(expr, true, handlers);
	}

	/**
	 * @param arc
	 * @param binding
	 * @return
	 */
	public Marking evaluate(final Arc arc, final Binding binding) {
		final ArrayList<MultisetEntry> markings = new ArrayList<MultisetEntry>();
		getSimulator().lock();
		try {
			StringBuilder expression = new StringBuilder();
			expression.append("((fn { ");
			boolean first = true;
			for (final ValueAssignment valueAssignment : binding.getAllAssignments()) {
				if (!first) {
					expression.append(", ");
				}
				first = false;
				expression.append(valueAssignment.getName());
			}
			expression.append(" } =>\n");
			expression.append(arc.getHlinscription().getText());
			expression.append(") { ");
			first = true;
			for (final ValueAssignment valueAssignment : binding.getAllAssignments()) {
				if (first) {
					first = false;
				} else {
					expression.append(", ");
				}
				expression.append(valueAssignment);
			}
			expression.append(" })");
			final String expr = expression.toString();

			try {
				expression = new StringBuilder();
				expression.append("val CPN'string_result : string list = [");
				expression.append(arc.getPlaceNode().getType().getText());
				expression.append(".mkstr ");
				expression.append(expr);
				expression.append("]");
				try {
					// System.out.println(expression.toString());
					// System.out.println(evaluate(expression.toString()));
					evaluate(expression.toString());
				} catch (final Exception e) {
					expression = new StringBuilder();
					expression.append("val CPN'string_result : string list = List.map ");
					expression.append(arc.getPlaceNode().getType().getText());
					expression.append(".mkstr ");
					expression.append(expr);
					// System.out.println(expression.toString());
					// System.out.println(evaluate(expression.toString()));
					evaluate(expression.toString());
				}

				evaluate("execute \"sendMarking\" [vLIST (List.map (fn elm => vSTRING elm) CPN'string_result)]",
				        new Object() {

					        @SuppressWarnings("unused")
					        public void sendMarking(final ArrayList<?> elms) {
						        String last = null;
						        int count = 0;
						        for (final Object elm : elms) {
							        final String value = elm.toString();
							        if (value.equals(last)) {
								        count++;
							        } else {
								        if (count > 0) {
									        markings.add(InstanceFactory.eINSTANCE.createMultisetEntry(count, last));
								        }
								        last = value;
								        count = 1;
							        }
						        }
						        if (count > 0) {
							        markings.add(InstanceFactory.eINSTANCE.createMultisetEntry(count, last));
						        }
					        }
				        });
				return InstanceFactory.eINSTANCE.createMarking(null, markings);
			} catch (final Exception e) {
				assert false;
				e.printStackTrace();
				return null;
			}
		} finally {
			getSimulator().release();
		}
	}

	/**
	 * @param file
	 *            url of file to load
	 * @return the result
	 * @throws Exception
	 *             on error; if Exception an exception was raised in ML, if IOException, comm error
	 */
	public String use(final URL file) throws Exception {
		final ByteArrayOutputStream o = new ByteArrayOutputStream();
		StreamUtillities.copy(file.openStream(), o);
		return evaluate(o.toString());
	}

	/**
	 * @param id
	 *            id of fusion group
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void generateInstanceForFusionGroup(final String id) throws IOException {
		getSimulator().lock();
		try {
			send(PacketGenerator.instance.constructGenerateInstanceForFusionGroup(id));
		} finally {
			getSimulator().release();
		}
	}

	/**
	 * @param id
	 *            id of the place
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void generateInstanceForPlace(final String id) throws IOException {
		getSimulator().lock();
		try {
			send(PacketGenerator.instance.constructGenerateInstanceForPlace(id));
		} finally {
			getSimulator().release();
		}
	}

	/**
	 * @param id
	 *            id of the transition
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void generateInstanceForTransition(final String id) throws IOException {
		getSimulator().lock();
		try {
			send(PacketGenerator.instance.constructGenerateInstanceForTransition(id));
		} finally {
			getSimulator().release();
		}
	}

	/**
	 * @return the simulator banner
	 */
	public String getBanner() {
		return getSimulator().getBanner();
	}

	/**
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void initialiseSimulationScheduler() throws IOException {
		send(PacketGenerator.instance.constructInitialiseSimulationScheduler());
	}

	/**
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void initialize() throws IOException {
		send(PacketGenerator.instance.constructInitialize());
	}

	/**
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void initializeSyntaxCheck() throws IOException {
		send(PacketGenerator.instance.constructInitializeSyntaxCheck());
	}

	/**
	 * 
	 */
	public void lock() {
		getSimulator().lock();
	}

	/**
	 * 
	 */
	public void release() {
		getSimulator().release();
	}

	/*
	 * public void generateInstances() throws IOException { // TODO: generete instancer for hver fusions gruppe, plads
	 * og trans send(PacketGenerator.instance.constructGenerateInstances()); }
	 */

	/**
	 * @param handlers
	 *            handler to remove
	 */
	public void removeHandler(final Object... handlers) {
		gramHandler.removeLocalHandler(handlers);
	}

	/**
	 * @param p
	 *            packet to send
	 * @return the resulting packet from the simulator
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public Packet send(final Packet p) throws IOException {
		return getSimulator().send(p);
	}

	/**
	 * @param resetRan
	 *            reset random number generator
	 * @param resetRef
	 *            reset ref
	 * @param randomSeed
	 *            seed for random number generator
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void setInitializationSimulationOptions(final boolean resetRan, final boolean resetRef, final int randomSeed)
	        throws IOException {
		send(PacketGenerator.instance.constructSetInitializationSimulationOptions(resetRan, resetRef, randomSeed));
	}

	/**
	 * @param pausebefore
	 *            pause before executing transition
	 * @param pauseafter
	 *            pause after executing transition
	 * @param pauseshow
	 *            pause before showing
	 * @param reporttrans
	 *            report transitions
	 * @param reportbinds
	 *            report binding elements
	 * @param showmarking
	 *            show marking
	 * @param showenabling
	 *            show enabling
	 * @param untilstep
	 *            run until step
	 * @param addstep
	 *            run for additional steps
	 * @param untiltime
	 *            run until time
	 * @param addtime
	 *            run additional time units
	 * @param pausecont
	 *            pause cont
	 * @param reportfunc
	 *            reporting function
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void setSimulationOptions(final boolean pausebefore, final boolean pauseafter, final boolean pauseshow,
	        final boolean reporttrans, final boolean reportbinds, final boolean showmarking,
	        final boolean showenabling, final String untilstep, final String addstep, final String untiltime,
	        final String addtime, final String pausecont, final String reportfunc) throws IOException {
		this.pausebefore = pausebefore;
		this.pauseafter = pauseafter;
		this.pauseshow = pauseshow;
		this.reporttrans = reporttrans || reportbinds;
		this.reportbinds = reportbinds;
		this.showmarking = showmarking;
		this.showenabling = showenabling;
		this.untilstep = untilstep;
		this.addstep = addstep;
		this.untiltime = untiltime;
		this.addtime = addtime;
		this.pausecont = pausecont;
		this.reportfunc = reportfunc;
		send(PacketGenerator.instance.constructSetSimulationOptions(pausebefore, pauseafter, pauseshow,
		        this.reporttrans, reportbinds, showmarking, showenabling, untilstep, addstep, untiltime, addtime,
		        pausecont, reportfunc));
	}

	/**
	 * Start reporting; clears data gathered until now and sets options for future reporting.
	 * 
	 * @param reporttrans
	 *            report transition executions
	 * @param reportbinds
	 *            report bindings
	 * @param reportfunc
	 *            function for reporting
	 * @throws IOException
	 *             on error
	 */
	public void setSimulationReportOptions(final boolean reporttrans, final boolean reportbinds, final String reportfunc)
	        throws IOException {
		lock();
		try {
			setSimulationOptions(pausebefore, pauseafter, pauseshow, reporttrans, reportbinds, showmarking,
			        showenabling, untilstep, addstep, untiltime, addtime, pausecont, reportfunc);
			send(PacketGenerator.instance.constructResetSimulationReport());
		} finally {
			release();
		}
	}

	/**
	 * Save the current report in the given file.
	 * 
	 * @param file
	 *            file to save report to.
	 * @throws IOException
	 *             on error
	 */
	public void saveSimulationReport(final File file) throws IOException {
		send(PacketGenerator.instance.constructSaveSimulationReport(file.getAbsolutePath()));
	}

	/**
	 * @return the current simulator time (as a string)
	 * @throws IOException
	 *             on error
	 */
	public BigInteger getTime() throws IOException {
		final Packet p = send(PacketGenerator.instance.constructGetTimeAndStep());
		return new BigInteger(p.getString());
	}

	/**
	 * @return the current simulator step (as a string)
	 * @throws IOException
	 *             on error
	 */
	public BigInteger getStep() throws IOException {
		final Packet p = send(PacketGenerator.instance.constructGetTimeAndStep());
		p.getString();
		return new BigInteger(p.getString());
	}

	/**
	 * @param ti
	 *            the transition instance to execute
	 * @return if the transition was successfully executed
	 * @throws Exception
	 *             on error; if IOException communication failed, if plain Exception an exception was rasied on the ML
	 *             side
	 */
	public boolean execute(final Instance<? extends Transition> ti) throws Exception {
		lock();
		try {
			if (isEnabled(ti)) {
				final Packet p = send(PacketGenerator.instance.constructExecute(ti.getNode().getId(), ti
				        .getInstanceNumber()));
				p.getString();
				p.getString();
				final String whyStopped = p.getString();
				if (whyStopped.startsWith("Error")) { throw new Exception(whyStopped); }
				return true;
			} else {
				return false;
			}
		} finally {
			release();
		}
	}

	/**
	 * @param binding
	 * @return
	 */
	public boolean execute(final Binding binding) {
		try {
			final StringBuilder expr = new StringBuilder(
			        "CPNToolsModel.nextStates (CPNToolsModel.getCurrentState(), Bind.");
			expr.append(LocalChecker.getName(binding.getTransitionInstance().getNode().getPage()));
			expr.append('\'');
			expr.append(LocalChecker.getName(binding.getTransitionInstance().getNode()));
			expr.append(" (");
			expr.append(binding.getTransitionInstance().getInstanceNumber());
			expr.append(", { ");
			boolean first = true;
			for (final ValueAssignment valueAssignment : binding.getAllAssignments()) {
				if (first) {
					first = false;
				} else {
					expr.append(", ");
				}
				expr.append(valueAssignment);
			}
			expr.append(" }))");

			evaluate(expr.toString());
			return true;
		} catch (final Exception e) {
			return false;
		}
	}

	/**
	 * @param tis
	 *            the list of transition instance to execute
	 * @return if any transition was successfully executed
	 * @throws Exception
	 *             on error; if IOException communication failed, if plain Exception an exception was rasied on the ML
	 *             side
	 */
	public Instance<? extends Transition> executeAnyGetWhich(final List<Instance<? extends Transition>> tis)
	        throws Exception {
		Collections.shuffle(tis);
		lock();
		try {
			for (final Instance<? extends Transition> ti : tis) {
				if (execute(ti)) { return ti; }
			}
		} finally {
			release();
		}
		return null;
	}

	/**
	 * @param bindings
	 *            the list of bindings to execute
	 * @return if any binding was successfully executed
	 * @throws Exception
	 *             on error; if IOException communication failed, if plain Exception an exception was rasied on the ML
	 *             side
	 */
	public Binding executeAnyGetWhich(final List<Binding> bindings) throws Exception {
		Collections.shuffle(bindings);
		lock();
		try {
			for (final Binding binding : bindings) {
				if (execute(binding)) { return binding; }
			}
		} finally {
			release();
		}
		return null;
	}

	/**
	 * @param tis
	 *            the list of transition instance to execute
	 * @return if any transition was successfully executed
	 * @throws Exception
	 *             on error; if IOException communication failed, if plain Exception an exception was rasied on the ML
	 *             side
	 */
	public boolean executeAny(final List<Instance<? extends Transition>> tis) throws Exception {
		Collections.shuffle(tis);
		lock();
		try {
			for (final Instance<? extends Transition> ti : tis) {
				if (execute(ti)) { return true; }
			}
		} finally {
			release();
		}
		return false;
	}

	/**
	 * @param amount
	 *            number of additional steps to execute
	 * @return why simulation was stopped
	 * @throws Exception
	 *             on error; if IOException communication failed, if plain Exception an exception was rasied on the ML
	 *             side
	 */
	public String executeSteps(final int amount) throws Exception {
		lock();
		try {
			setSimulationOptions(pausebefore, pauseafter, pauseshow, reporttrans, reportbinds, showmarking,
			        showenabling, untilstep, Integer.valueOf(amount).toString(), untiltime, addtime, pausecont,
			        reportfunc);
			final Packet p = send(PacketGenerator.instance.constructExecuteSteps());
			p.getString();
			p.getString();
			final String whyStopped = p.getString();
			if (whyStopped.startsWith("Error")) { throw new Exception(whyStopped); }
			return whyStopped;
		} finally {
			release();
		}
	}

	/**
	 * @param ti
	 *            the transition instance to check enabledness for
	 * @return whether the TI is enabled
	 * @throws IOException
	 *             on error
	 */
	public boolean isEnabled(final Instance<? extends Transition> ti) throws IOException {
		return send(PacketGenerator.instance.constructIsEnabled(ti.getNode().getId(), ti.getInstanceNumber()))
		        .getBoolean();
	}

	/**
	 * @param tis
	 *            list of transition instances to check enabledness for
	 * @return list of enabled transition instances from the list
	 * @throws IOException
	 *             on error
	 */
	public List<Instance<? extends Transition>> isEnabled(final List<? extends Instance<? extends Transition>> tis)
	        throws IOException {
		final Packet p = send(PacketGenerator.instance.constructIsEnabled(tis));
		final List<Instance<? extends Transition>> result = new ArrayList<Instance<? extends Transition>>();
		for (final Instance<? extends Transition> ti : tis) {
			if (p.getBoolean()) {
				result.add(ti);
			}
		}
		return result;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public State getMarking() throws Exception {
		if (stateReceiver == null) { throw new Exception(
		        "You did not give a PetriNet on creation, so you cannot get the marking."); }

		synchronized (stateReceiver) {
			try {
				evaluate(
				        "JavaExecute.execute \"sendState\" [CPNToolsPacker.StatePacker.map (CPNToolsModel.getCurrentState())]",
				        stateReceiver);
			} catch (final Exception e) {
				e.printStackTrace();
			}
			return state;
		}
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public List<Binding> getBindings() throws Exception {
		if (eventReceiver == null) { throw new Exception(
		        "You did not give a PetriNet on creation, so you cannot get the bindings."); }

		synchronized (eventReceiver) {
			try {
				evaluate(
				        "execute \"sendEvent\" [vLIST (List.map CPNToolsPacker.EventPacker.map (CPNToolsModel.getEvents (CPNToolsModel.getCurrentState())))]",
				        eventReceiver);
			} catch (final Exception e) {
				e.printStackTrace();
			}
			return bindings;
		}
	}

	/**
	 * @param p
	 *            place
	 * @param marking
	 *            marking
	 * @return whether marking is legal for place
	 * @throws IOException
	 *             on error
	 */
	public boolean checkMarking(final PlaceNode p, final String marking) throws IOException {
		return send(PacketGenerator.instance.constructCheckMarking(p.getType().getText(), marking)).getBoolean();
	}

	/**
	 * Set marking of place instance if it is legal. There is no need to call checkMArking (as the manual says) as this
	 * takes care of that.
	 * 
	 * @param pi
	 *            place instance
	 * @param marking
	 *            marking
	 * @throws IOException
	 *             on error
	 */
	public boolean setMarking(final Instance<? extends PlaceNode> pi, final String marking) throws IOException {
		lock();
		try {
			if (checkMarking(pi.getNode(), marking)) {
				send(PacketGenerator.instance.constructSetMarking(pi.getNode().getId(), pi.getInstanceNumber(), false));
				try {
					evaluate("CPNToolsModel.markDirty()");
				} catch (final Exception e) {
					// Mask if SML interface is not loaded correctly
				}
				return true;
			}
		} finally {
			release();
		}
		return false;
	}

	/**
	 * @param pi
	 * @param marking
	 * @return
	 * @throws IOException
	 */
	public boolean setMarking(final Instance<? extends PlaceNode> pi, final Marking marking) throws IOException {
		return setMarking(pi, marking.getMarking());
	}

	/**
	 * @throws IOException
	 *             on error
	 */
	public void initialState() throws IOException {
		send(PacketGenerator.instance.constructInitialState());
	}

	/**
	 * @param modelName
	 *            name of model
	 * @param modelDir
	 *            directory of model (should be absolute path)
	 * @param outputDir
	 *            output dir (if "" set to modeldir/output)
	 * @throws Exception
	 *             on error; if Exception something went wrong setting paths (probably because paths do not exist or are
	 *             not writable; if IOException comm error
	 */
	public void setModelNameModelDirOutputDir(final String modelName, final String modelDir, final String outputDir)
	        throws Exception {
		final Packet p = send(PacketGenerator.instance.constructModelNameModelDirOutputDir(modelName, modelDir,
		        outputDir));
		if (!p.getBoolean()) { throw new Exception(p.getString()); }
	}

	/**
	 * @param timeStamp
	 * @throws IOException
	 */
	public void setSimulatorTime(final BigInteger timeStamp) throws IOException {
		send(PacketGenerator.instance.constructSetSimulatorTime(timeStamp.toString()));
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public String increaseTime() throws IOException {
		final Packet p = send(PacketGenerator.instance.createIncreaseTime());
		if (p.getBoolean()) { return null; }
		return p.getString();
	}

	public Simulator getSimulator() {
		return simulator;
	}
}
