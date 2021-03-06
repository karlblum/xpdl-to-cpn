package dk.au.daimi.ascoveco.cpn.engine.highlevel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import dk.au.daimi.ascoveco.cpn.engine.Packet;
import dk.au.daimi.ascoveco.cpn.model.Arc;
import dk.au.daimi.ascoveco.cpn.model.HLArcType;
import dk.au.daimi.ascoveco.cpn.model.HLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.Instance;
import dk.au.daimi.ascoveco.cpn.model.Node;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.ParameterAssignment;
import dk.au.daimi.ascoveco.cpn.model.Place;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.RefPlace;
import dk.au.daimi.ascoveco.cpn.model.Transition;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.util.CpntypesSwitch;
import dk.au.daimi.ascoveco.cpn.model.declaration.DeclarationStructure;
import dk.au.daimi.ascoveco.cpn.model.declaration.GlobalReferenceDeclaration;
import dk.au.daimi.ascoveco.cpn.model.declaration.MLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration;
import dk.au.daimi.ascoveco.cpn.model.declaration.UseDeclaration;
import dk.au.daimi.ascoveco.cpn.model.declaration.VariableDeclaration;
import dk.au.daimi.ascoveco.cpn.model.declaration.util.DeclarationSwitch;

/**
 * @author mw
 */
public class PacketGenerator {
	/**
	 * 
	 */
	public static final PacketGenerator instance = new PacketGenerator();

	private PacketGenerator() {
		// Hide constructor
	}

	/**
	 * @param decl
	 *            decl to check
	 * @return packet for checking decl
	 */
	public Packet constructCheckDeclaration(final HLDeclaration decl) {
		final DeclarationStructure structure = decl.getStructure();
		final Packet p = new Packet(300);
		p.addInteger(1);
		p.addString(decl.getId()); // id

		return new DeclarationSwitch<Packet>() {
			@Override
			public Packet caseGlobalReferenceDeclaration(final GlobalReferenceDeclaration globref) {
				return constructGlobalReferenceDeclaration(p, globref);
			}

			@Override
			public Packet caseMLDeclaration(final MLDeclaration mldecl) {
				return constructMLDeclaration(p, mldecl);
			}

			@Override
			public Packet caseTypeDeclaration(final TypeDeclaration typeDeclaration) {
				return constructTypeDeclaration(p, typeDeclaration);
			}

			@Override
			public Packet caseUseDeclaration(final UseDeclaration use) {
				return constructUseDeclaration(p, use);
			}

			@Override
			public Packet caseVariableDeclaration(final VariableDeclaration var) {
				return constructVariableDeclaration(p, var);
			}

		}.doSwitch(structure);
	}

	/**
	 * @param page
	 *            page to check
	 * @param prime
	 *            whether the page is prime
	 * @return package to check page
	 */
	public Packet constructCheckPage(final Page page, final boolean prime) {
		final Packet p = new Packet(400);
		p.addInteger(2);

		p.addString(page.getId());
		p.addString(Util.mlEscape(page.getName().getText()));
		constructIsPrime(p, prime);
		constructIsIncludedInSim(p);
		constructCheckedPlaces(p);
		constructCheckedTransitions(p);

		// Here we ignore unchecked instance fusion places
		constructUncheckedPlacesAndCount(p, page.readyPlaces(), page.readyPortPlaces());

		// Here we ignore unchecked page fusion places
		constructUncheckedGlobalFusionPlacesAndCount(p, page.readyFusionGroups());

		// Hvordan f�r vi instancerne fra siden?
		constructUncheckedSubstitutionTransitionsAndCount(p, page.readyInstances());

		constructUncheckedTransitionsAndCount(p, page.readyTransitions());

		return p;
	}

	/**
	 * @param id
	 *            id of fusion group
	 * @return packet to generate instances for fusion group
	 */
	public Packet constructGenerateInstanceForFusionGroup(final String id) {
		return constructGenerateInstanceForPlace(id);
	}

	/**
	 * @param id
	 *            id of place
	 * @return packet to generate instances for place
	 */
	public Packet constructGenerateInstanceForPlace(final String id) {
		final Packet p = new Packet(500);
		p.addInteger(3);
		p.addBoolean(false); // create instance form scratch
		p.addInteger(1); // # places
		p.addInteger(0); // # refs ?
		p.addInteger(0); // # transitions
		p.addString(id);
		return p;
	}

	/**
	 * @param id
	 *            id of transition
	 * @return packet to generate instances of transition
	 */
	public Packet constructGenerateInstanceForTransition(final String id) {
		final Packet p = new Packet(500);
		p.addInteger(3);
		p.addBoolean(false); // create instance form scratch
		p.addInteger(0); // # places
		p.addInteger(0); // # refs ?
		p.addInteger(1); // # transitions
		p.addString(id);
		return p;
	}

	/**
	 * @return packet to generate all instances
	 */
	public Packet constructGenerateInstances() {
		final Packet p = new Packet(500);
		p.addInteger(1);
		return p;
	}

	/**
	 * @return packet to initialise scheduler
	 */
	public Packet constructInitialiseSimulationScheduler() {
		final Packet p = new Packet(500);
		p.addInteger(5);
		return p;
	}

	/**
	 * @return a packet
	 */
	public Packet constructInitialize() {
		final Packet p = new Packet(100);
		p.addString("intinf"); //$NON-NLS-1$
		p.addString("IntInf.fromInt 0"); //$NON-NLS-1$
		IPath dumpfiledir;
		if (Activator.getDefault() != null) {
			dumpfiledir = Activator.getDefault().getStateLocation().append("dumpfile");
		} else {
			dumpfiledir = new Path("/tmp/");
		}
		dumpfiledir.toFile().mkdirs();
		p.addString(dumpfiledir.append("asapdump.sml").toString()); //$NON-NLS-1$
		return p;
	}

	/**
	 * @return packet to initialise syntax check
	 */
	public Packet constructInitializeSyntaxCheck() {
		final Packet p = new Packet(400);
		p.addInteger(1);
		return p;
	}

	/**
	 * @param resetRan
	 *            parameter
	 * @param resetRef
	 *            parameter
	 * @param randomSeed
	 *            parameter
	 * @return packet to set simulation options with given parameters
	 */
	public Packet constructSetInitializationSimulationOptions(final boolean resetRan, final boolean resetRef,
	        final int randomSeed) {
		final Packet p = new Packet(200);
		p.addInteger(11);
		p.addBoolean(resetRan);
		p.addBoolean(resetRef);
		p.addString(Integer.toString(randomSeed));
		return p;
	}

	/**
	 * @param pausebefore
	 *            parameter
	 * @param pauseafter
	 *            parameter
	 * @param pauseshow
	 *            parameter
	 * @param reporttrans
	 *            parameter
	 * @param reportbinds
	 *            parameter
	 * @param showmarking
	 *            parameter
	 * @param showenabling
	 *            parameter
	 * @param untilstep
	 *            parameter
	 * @param addstep
	 *            parameter
	 * @param untiltime
	 *            parameter
	 * @param addtime
	 *            parameter
	 * @param pausecont
	 *            parameter
	 * @param reportfunc
	 *            parameter
	 * @return packet to set simulation options to given parameters
	 */
	public Packet constructSetSimulationOptions(final boolean pausebefore, final boolean pauseafter,
	        final boolean pauseshow, final boolean reporttrans, final boolean reportbinds, final boolean showmarking,
	        final boolean showenabling, final String untilstep, final String addstep, final String untiltime,
	        final String addtime, final String pausecont, final String reportfunc) {
		final Packet p = new Packet(200);
		p.addInteger(10);
		p.addBoolean(pausebefore);
		p.addBoolean(pauseafter);
		p.addBoolean(pauseshow);
		p.addBoolean(reporttrans);
		p.addBoolean(reportbinds);
		p.addBoolean(showmarking);
		p.addBoolean(showenabling);
		p.addString(untilstep);
		p.addString(addstep);
		p.addString(untiltime);
		p.addString(addtime);
		p.addString(pausecont);
		p.addString(reportfunc);
		return p;
	}

	private void constructCheckedPlaces(final Packet p) {
		p.addInteger(0); // Checked places
	}

	private void constructCheckedTransitions(final Packet p) {
		p.addInteger(0); // Checked transitions
	}

	private void constructIsIncludedInSim(final Packet p) {
		p.addBoolean(true); // isIncludedInSim
	}

	private void constructIsPrime(final Packet p, final boolean prime) {
		if (prime) {
			p.addInteger(1);
		} else {
			p.addInteger(0);
		}
	}

	private void constructUncheckedGlobalFusionPlacesAndCount(final Packet p, final Iterable<RefPlace> refplaceIterable) {
		int count = 0;
		for (final RefPlace refplace : refplaceIterable) {
			final RefPlace refPlace = refplace;
			p.addString(refPlace.getId());
			p.addString(refPlace.getRef().getId());
			p.addString(Util.mlEscape(refPlace.getName().getText()));
			p.addString(refPlace.getType().getText());
			p.addString(Util.emptyOrNull(refPlace.getInitialMarking().getText()));

			count++;
		}
		p.addInteger(count);
	}

	private void constructUncheckedPlacesAndCount(final Packet p, final Iterable<Place> placeIterable,
	        final Iterable<RefPlace> portPlaceIterable) {
		int count = 0;
		for (final Place place : placeIterable) {
			p.addString(place.getId());
			try {
				p.addString(Util.mlEscape(place.getName().getText()));
			} catch (final NullPointerException e) {
				throw new RuntimeException("Place with id " + place.getId()
				        + " does not have a name.  Make sure all places have a unique name.");
			}
			p.addString(place.getType().getText());
			p.addString(Util.emptyOrNull(place.getInitialMarking().getText()));

			count++;
		}

		for (final RefPlace refPlace : portPlaceIterable) {
			p.addString(refPlace.getId());
			try {
				p.addString(Util.mlEscape(refPlace.getName().getText()));
			} catch (final NullPointerException e) {
				throw new RuntimeException("Place with id " + refPlace.getId()
				        + " does not have a name.  Make sure all places have a unique name.");
			}
			p.addString(refPlace.getType().getText());
			p.addString(Util.emptyOrNull(refPlace.getInitialMarking().getText()));

			count++;
		}

		p.addInteger(count);
	}

	@edu.umd.cs.findbugs.annotations.SuppressWarnings("DLS_DEAD_LOCAL_STORE")
	private void constructUncheckedSubstitutionTransitionsAndCount(final Packet p,
	        final Iterable<Instance> instanceIterable) {
		int count = 0;

		for (@SuppressWarnings("unused")
		final Instance inst : instanceIterable) {
			count++;
		}
		p.addInteger(count);

		for (final Instance inst : instanceIterable) {
			p.addString(inst.getId());
			try {
				p.addString(Util.mlEscape(inst.getName().getText()));
			} catch (final NullPointerException e) {
				throw new RuntimeException("Transition with id " + inst.getId()
				        + " does not have a name.  Make sure all transitions have a unique name.");
			}

			p.addString(inst.getSubPageID());
			int paCount = 0;
			for (final ParameterAssignment pa : inst.getParameterAssignment()) {
				p.addString(pa.getValue()); // Port
				p.addString(pa.getParameter()); // Socket
				paCount++;
			}
			p.addInteger(paCount);
		}
	}

	private void constructUncheckedTransitionsAndCount(final Packet p, final Iterable<Transition> transitionIterable) {
		int count = 0;
		for (@SuppressWarnings("unused")
		final Transition transition : transitionIterable) {
			count++;
		}
		p.addInteger(count);

		for (final Transition transition : transitionIterable) {
			p.addString(transition.getId());
			try {
				p.addString(Util.mlEscape(transition.getName().getText()));
			} catch (final NullPointerException e) {
				throw new RuntimeException("Transition with id " + transition.getId()
				        + " does not have a name.  Make sure all transitions have a unique name.");
			}
			p.addString(Util.emptyOrNull(transition.getCondition().getText()));
			p.addString(Util.emptyOrNull(transition.getTime().getText()));
			p.addString(Util.emptyOrNull(transition.getCode().getText()));
			p.addString(""); // Channel - not supported
			p.addBoolean(true); // Controllable

			final ArrayList<Arc> inOutArcs = new ArrayList<Arc>();
			int countInputArcs = 0;

			for (final Arc arc : transition.getTargetArc()) {
				if (arc.getType() == HLArcType.NORMAL) {
					// The arc is only an input arc
					p.addString(arc.getId());
					p.addString(arc.getOtherEnd(transition).getId());
					p.addString(arc.getHlinscription().getText());

					countInputArcs++;
				} else if (arc.getType() == HLArcType.TEST) {
					// The arc is an input/output arc
					inOutArcs.add(arc);
				} else {
					assert false;
				}
			}
			p.addInteger(countInputArcs);

			int countOutputArcs = 0;
			for (final Arc arc : transition.getSourceArc()) {
				if (arc.getType() == HLArcType.NORMAL) {
					// The arc is only an output arc
					p.addString(arc.getId());
					p.addString(arc.getOtherEnd(transition).getId());
					p.addString(arc.getHlinscription().getText());

					countOutputArcs++;
				} else if (arc.getType() == HLArcType.TEST) {
					// The arc is an input/output arc
					inOutArcs.add(arc);
				}
			}
			p.addInteger(countOutputArcs);

			for (final Arc arc : inOutArcs) {
				p.addString(arc.getId());
				p.addString(arc.getOtherEnd(transition).getId());
				p.addString(arc.getHlinscription().getText());
			}
			p.addInteger(inOutArcs.size());
		}
	}

	protected Packet constructCPNAlias(final Packet p, final CPNAlias cpnalias) {
		p.addInteger(15);
		p.addString(cpnalias.getType());
		return p;
	}

	protected Packet constructCPNBool(final Packet p, final CPNBool cpnbool) {
		p.addInteger(2);
		p.addString(Util.emptyOrNull(cpnbool.getFalseValue())); // low
		p.addString(Util.emptyOrNull(cpnbool.getTrueValue())); // high
		return p;
	}

	protected Packet constructCPNEnum(final Packet p, final CPNEnum cpnenum) {
		p.addInteger(6);
		p.addInteger(cpnenum.getValues().size());
		for (final String value : cpnenum.getValues()) {
			p.addString(value); // enums
		}
		return p;
	}

	protected Packet constructCPNIndex(final Packet p, final CPNIndex cpnindex) {
		p.addInteger(7);
		p.addString(cpnindex.getName()); // idx
		p.addString(cpnindex.getLow()); // low
		p.addString(cpnindex.getHigh()); // high
		return p;
	}

	protected Packet constructCPNInt(final Packet p, final CPNInt cpnint) {
		p.addInteger(3);
		p.addString(Util.emptyOrNull(cpnint.getLow())); // low
		p.addString(Util.emptyOrNull(cpnint.getHigh())); // high
		return p;
	}

	protected Packet constructCPNList(final Packet p, final CPNList cpnlist) {
		p.addInteger(8);
		p.addString(cpnlist.getType()); // cs
		p.addString(Util.emptyOrNull(cpnlist.getLow())); // min
		p.addString(Util.emptyOrNull(cpnlist.getHigh())); // max
		return p;
	}

	protected Packet constructCPNProduct(final Packet p, final CPNProduct cpnproduct) {
		p.addInteger(9);
		p.addInteger(cpnproduct.getTypes().size());
		for (final String type : cpnproduct.getTypes()) {
			p.addString(type); // comps
		}
		return p;
	}

	protected Packet constructCPNRecord(final Packet p, final CPNRecord cpnrecord) {
		p.addInteger(10);
		p.addInteger(cpnrecord.getValues().size());
		for (final NameTypePair pair : cpnrecord.getValues()) {
			p.addString(pair.getName()); // comps
			p.addString(pair.getType());
		}
		return p;
	}

	protected Packet constructCPNString(final Packet p, final CPNString cpnstring) {
		p.addInteger(5);
		p.addString(Util.emptyOrNull(cpnstring.getRangeLow())); // low
		p.addString(Util.emptyOrNull(cpnstring.getRangeHigh())); // high
		p.addString(Util.emptyOrNull(cpnstring.getLengthLow())); // min
		p.addString(Util.emptyOrNull(cpnstring.getLengthHigh())); // max
		return p;
	}

	protected Packet constructCPNSubset(final Packet p, final CPNSubset cpnsubset) {
		if (cpnsubset.getBy() != null && !cpnsubset.getBy().equals("")) { // function
			// subset
			p.addInteger(12);
			p.addString(cpnsubset.getType()); // cs
			p.addString(cpnsubset.getBy()); // subset
		} else if (cpnsubset.getWith() != null && !cpnsubset.getWith().equals("")) { // list
			// subset
			p.addInteger(13);
			p.addString(cpnsubset.getType()); // cs
			p.addInteger(1); // #subset-elems, only one since we send the
			// whole list
			String list = cpnsubset.getWith();
			list = list.replaceAll("\\[", "");
			list = list.replaceAll("\\]", "");
			p.addString(list); // subset-elem1
		}

		return p;
	}

	protected Packet constructCPNUnion(final Packet p, final CPNUnion cpnunion) {
		p.addInteger(11);
		p.addInteger(cpnunion.getValues().size());
		for (final NameTypePair pair : cpnunion.getValues()) {
			p.addString(pair.getName()); // comps
			p.addString(Util.emptyOrNull(pair.getType()));
		}
		return p;
	}

	protected Packet constructCPNUnit(final Packet p, final CPNUnit cpnunit) {
		p.addInteger(1);
		if (cpnunit.getId() == null) {
			p.addString(""); // str
		} else {
			p.addString(cpnunit.getId());
		}
		return p;
	}

	protected Packet constructExecute(final String id, final int instance2) {
		final Packet p = new Packet(500);
		p.addInteger(12);
		p.addString(id);
		p.addInteger(instance2);
		return p;
	}

	protected Packet constructGetTimeAndStep() {
		final Packet p = new Packet(500);
		p.addInteger(2);
		return p;
	}

	protected Packet constructGlobalReferenceDeclaration(final Packet p, final GlobalReferenceDeclaration globref) {
		p.addInteger(16);
		p.addString(globref.getName()); // name
		p.addString(globref.getValue()); // exp
		return p;
	}

	protected Packet constructIsEnabled(final String id, final int instance2) {
		final Packet p = new Packet(500);
		p.addInteger(13);
		p.addString(id);
		p.addInteger(instance2);
		return p;
	}

	protected Packet constructIsEnabled(
	        final List<? extends dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance<? extends Transition>> tis) {
		final Packet p = new Packet(500);
		p.addInteger(35);
		addNodes(p, tis);
		return p;
	}

	protected Packet constructGetMarking(
	        final List<? extends dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance<? extends PlaceNode>> pis) {
		final Packet p = new Packet(500);
		p.addInteger(31);
		addNodes(p, pis);
		return p;
	}

	private void addNodes(final Packet p,
	        final List<? extends dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance<? extends Node>> nis) {
		p.addInteger(nis.size());
		for (final dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance<? extends Node> ni : nis) {
			p.addInteger(ni.getInstanceNumber());
			p.addString(ni.getNode().getId());
		}
	}

	protected Packet constructMLDeclaration(final Packet p, final MLDeclaration mldecl) {
		p.addInteger(18);
		p.addString(mldecl.getCode()); // exp
		return p;
	}

	protected Packet constructSaveSimulationReport(final String absolutePath) {
		final Packet p = new Packet(500);
		p.addInteger(41);
		p.addString(absolutePath);
		return p;
	}

	protected Packet constructTypeDeclaration(final Packet p, final TypeDeclaration typeDeclaration) {
		final Packet q = new CpntypesSwitch<Packet>() {
			@Override
			public Packet caseCPNAlias(final CPNAlias cpnalias) {
				return constructCPNAlias(p, cpnalias);
			}

			@Override
			public Packet caseCPNBool(final CPNBool cpnbool) {
				return constructCPNBool(p, cpnbool);
			}

			@Override
			public Packet caseCPNEnum(final CPNEnum cpnenum) {
				return constructCPNEnum(p, cpnenum);
			}

			@Override
			public Packet caseCPNIndex(final CPNIndex cpnindex) {
				return constructCPNIndex(p, cpnindex);
			}

			@Override
			public Packet caseCPNInt(final CPNInt cpnint) {
				return constructCPNInt(p, cpnint);
			}

			@Override
			public Packet caseCPNList(final CPNList cpnlist) {
				return constructCPNList(p, cpnlist);
			}

			@Override
			public Packet caseCPNProduct(final CPNProduct cpnproduct) {
				return constructCPNProduct(p, cpnproduct);
			}

			@Override
			public Packet caseCPNRecord(final CPNRecord cpnrecord) {
				return constructCPNRecord(p, cpnrecord);
			}

			@Override
			public Packet caseCPNString(final CPNString cpnstring) {
				return constructCPNString(p, cpnstring);
			}

			@Override
			public Packet caseCPNSubset(final CPNSubset cpnsubset) {
				return constructCPNSubset(p, cpnsubset);
			}

			@Override
			public Packet caseCPNUnion(final CPNUnion cpnunion) {
				return constructCPNUnion(p, cpnunion);
			}

			@Override
			public Packet caseCPNUnit(final CPNUnit cpnunit) {
				return constructCPNUnit(p, cpnunit);
			}

		}.doSwitch(typeDeclaration.getType());

		if (q == null) {
			return p;
		} else {
			q.addBoolean(typeDeclaration.getType().getTimed()); // is-timed
			q.addString(typeDeclaration.getTypeName()); // name
			q.addInteger(0); // #vars
			q.addInteger(0); // #ms-vars
			q.addInteger(0); // #aliases
			q.addInteger(typeDeclaration.getType().getDeclares().size()); // #declares
			for (final String declare : typeDeclaration.getType().getDeclares()) {
				q.addString(declare); // declares
			}

			return q;
		}
	}

	protected Packet constructUseDeclaration(final Packet p, final UseDeclaration use) {
		p.addInteger(17);
		p.addString(use.getFileName());
		return p;
	}

	protected Packet constructVariableDeclaration(final Packet p, final VariableDeclaration var) {
		p.addInteger(20);
		p.addString(var.getTypeName()); // name
		p.addInteger(var.getVariables().size()); // n
		for (final String variable : var.getVariables()) {
			p.addString(variable); // vars
		}
		return p;
	}

	protected Packet constructResetSimulationReport() {
		final Packet p = new Packet(500);
		p.addInteger(42);
		return p;
	}

	protected Packet constructCheckMarking(final String type, final String marking) {
		final Packet p = new Packet(400);
		p.addInteger(3);
		p.addString(marking);
		p.addString(type);
		return p;
	}

	protected Packet constructSetMarking(final String id, final int instanceNumber, final boolean initial) {
		final Packet p = new Packet(500);
		p.addInteger(22);
		p.addBoolean(initial);
		p.addInteger(1); // # nodes, hardwired to 1
		p.addInteger(instanceNumber);
		p.addString(id);
		return p;
	}

	protected Packet constructInitialState() {
		final Packet p = new Packet(500);
		p.addInteger(21);
		return p;
	}

	protected Packet constructExecuteSteps() {
		final Packet p = new Packet(500);
		p.addInteger(11);
		return p;
	}

	protected Packet constructModelNameModelDirOutputDir(final String modelName, final String modelDir,
	        final String outputDir) {
		final Packet p = new Packet(200);
		p.addInteger(9);
		p.addString(modelName);
		p.addString(modelDir);
		p.addString(outputDir);
		return p;
	}

	protected Packet constructSetSimulatorTime(final String timeStamp) {
		final Packet p = new Packet(500);
		p.addInteger(23);
		p.addString(timeStamp);
		return p;
	}

	protected Packet createIncreaseTime() {
		final Packet p = new Packet(500);
		p.addInteger(24);
		return p;
	}

}
