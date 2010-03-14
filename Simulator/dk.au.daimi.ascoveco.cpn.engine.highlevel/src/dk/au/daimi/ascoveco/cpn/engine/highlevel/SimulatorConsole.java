package dk.au.daimi.ascoveco.cpn.engine.highlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.ui.statushandlers.StatusManager;

import dk.au.daimi.ascoveco.cpn.engine.Activator;
import dk.au.daimi.ascoveco.cpn.engine.Simulator;

/**
 * @author mw
 */
public final class SimulatorConsole extends IOConsole implements Observer {
	private final IOConsoleOutputStream error;
	private final IOConsoleOutputStream input;
	private final IOConsoleOutputStream output;

	/**
	 * @param simulator
	 *            simulator to view in console
	 */
	public SimulatorConsole(final HighLevelSimulator simulator) {
		this(simulator.getSimulator());
	}

	/**
	 * @param simulator
	 *            simulator to view in console
	 */
	public SimulatorConsole(final Simulator simulator) {
		super("Simulator Console", null);
		simulator.addObserver(this);
		input = newOutputStream();
		input.setColor(new Color(Display.getDefault(), 0, 0, 0));
		output = newOutputStream();
		output.setColor(new Color(Display.getDefault(), 0, 0, 255));
		error = newOutputStream();
		error.setColor(new Color(Display.getDefault(), 255, 0, 0));
		new Thread() {
			@Override
			public void run() {
				try {
					final BufferedReader inputReader = new BufferedReader(new InputStreamReader(getInputStream()));
					while (true) {
						final String expr = inputReader.readLine();
						final Job job = new Job("Evaluate expression") {
							@Override
							protected IStatus run(final IProgressMonitor monitor) {
								monitor.beginTask("Evaluate expression", IProgressMonitor.UNKNOWN);
								try {
									simulator.evaluate(SimulatorConsole.this, expr);
								} catch (final Exception e) {
									// Ignore execution exception -- it is shown
									// in
									// the console
								}
								monitor.done();
								return Status.OK_STATUS;
							}
						};
						job.setUser(true);
						job.schedule();
					}
				} catch (final IOException e) {
					// Mask error when closing ASAP
				} catch (final Exception e) {
					StatusManager.getManager().handle(
					        new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Input from console failed", e),
					        StatusManager.LOG);
				}
			}
		}.start();
		try {
			input.write(simulator.getBanner());
			input.write("- ");
		} catch (final Exception e) {
			// Ignore if unable to draw prompt
		}
	}

	/**
	 * Register this console. Should only be called once (best at creation);
	 */
	public void register() {
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { this });
	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable o, final Object arg) {
		try {
			final Simulator.SimulatorUpdate update = (Simulator.SimulatorUpdate) arg;
			if (update instanceof Simulator.Output) {
				if (update instanceof Simulator.PartialResult) {
					final Simulator.PartialResult result = (Simulator.PartialResult) update;
					if (result.isError()) {
						error.write(result.getText());
					} else {
						output.write(result.getText());
					}
				} else {
					if (update instanceof Simulator.Error) {
						input.write('\n');
					}
					input.write("- ");
				}
			}
			if (update instanceof Simulator.Input) {
				final Simulator.Input in = (Simulator.Input) update;
				if (in.getSource() != this) {
					input.write(in.getText());
					input.write('\n');
				}
			}
			if (update instanceof Simulator.PacketUpdate
			        && dk.au.daimi.ascoveco.cpn.engine.highlevel.Activator.DEBUG_SIMULATOR
			        && (dk.au.daimi.ascoveco.util.Activator.getDefault() == null || dk.au.daimi.ascoveco.util.Activator
			                .getDefault().getDevelopment())) {
				final Simulator.PacketUpdate pu = (Simulator.PacketUpdate) update;
				if (update instanceof Simulator.PacketReceived) {
					output.write("Receive ");
					output.write(pu.getPacket().toString());
					input.write("\n- ");
				} else if (update instanceof Simulator.PacketSent) {
					input.write("Send ");
					input.write(pu.getPacket().toString());
					input.write('\n');
				}
			}
		} catch (final IOException e) {
			StatusManager.getManager().handle(
			        new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to show message on console", e),
			        StatusManager.LOG);

		}
	}
}
