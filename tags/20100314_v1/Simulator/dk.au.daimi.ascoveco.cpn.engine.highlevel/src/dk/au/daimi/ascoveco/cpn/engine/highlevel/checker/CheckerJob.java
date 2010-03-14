package dk.au.daimi.ascoveco.cpn.engine.highlevel.checker;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import dk.au.daimi.ascoveco.cpn.engine.highlevel.Activator;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.CheckerException;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.DeclarationCheckerException;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.HighLevelSimulator;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.LocalCheckFailed;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.PageSorter;
import dk.au.daimi.ascoveco.cpn.model.FusionGroup;
import dk.au.daimi.ascoveco.cpn.model.HLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.Place;
import dk.au.daimi.ascoveco.cpn.model.RefPlace;
import dk.au.daimi.ascoveco.cpn.model.Transition;

/**
 * @author mw
 */
public class CheckerJob extends Job {

	// private HighLevelSimulator s;
	private final Checker checker;
	private final PetriNet petriNet;

	/**
	 * @param name
	 *            name of job
	 * @param petriNet
	 *            net to check
	 * @param output
	 *            output directory; if null will be set to modelo directory
	 * @param highLevelSimulator
	 *            simulator to use for checking
	 */
	public CheckerJob(final String name, final PetriNet petriNet, final File output,
	        final HighLevelSimulator highLevelSimulator) {
		super(name);
		this.petriNet = petriNet;
		// this.s = highLevelSimulator;
		checker = new Checker(petriNet, output, highLevelSimulator);
	}

	private void checkDeclarations(final IProgressMonitor monitor) throws IOException, DeclarationCheckerException {
		monitor.subTask("Checking declarations");
		for (final HLDeclaration decl : petriNet.declaration()) {
			checker.checkDeclaration(decl);
			monitor.worked(1);
		}
	}

	private void checkInitializing(final IProgressMonitor monitor) throws IOException, Exception {
		monitor.subTask("Initializing");
		checker.checkInitializing();
		monitor.worked(1);
	}

	private void checkPages(final IProgressMonitor monitor) throws IOException, CheckerException {
		monitor.subTask("Checking pages");
		final PageSorter ps = new PageSorter(petriNet.getPage());
		for (final Page page : ps) {
			monitor.subTask("Checking page " + page.getName().getText());
			checker.checkPage(page, ps.isPrime(page));
			monitor.worked(1);
		}
	}

	private void generateInstances(final IProgressMonitor monitor) throws IOException, Exception {
		monitor.subTask("Generating instances");

		for (final FusionGroup fusionGroup : petriNet.getFusionGroups()) {
			checker.generateInstanceForFusionGroup(fusionGroup.getId());
		}

		for (final Page page : petriNet.getPage()) {
			monitor.subTask("Generating instances for " + page.getName().getText());

			for (final RefPlace refPlace : page.readyFusionGroups()) {
				checker.generateInstanceForPlace(refPlace.getId());
			}

			for (final RefPlace refPlace : page.readyPortPlaces()) {
				checker.generateInstanceForPlace(refPlace.getId());
			}

			for (final Place place : page.readyPlaces()) {
				checker.generateInstanceForPlace(place.getId());
			}

			monitor.worked(1);

			for (final Transition transition : page.readyTransitions()) {
				checker.generateInstanceForTransition(transition.getId());
			}

			monitor.worked(1);
		}

		checker.initialiseSimulationScheduler();
	}

	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		int workload = 2;
		for (@SuppressWarnings("unused")
		final HLDeclaration hld : petriNet.declaration()) {
			workload++;
		}
		workload += petriNet.getPage().size() * 3;
		workload++;
		monitor.beginTask("Checking Petri net", workload);

		try {
			localCheck(monitor);
			checkInitializing(monitor);
			checkDeclarations(monitor);
			checkPages(monitor);
			generateInstances(monitor);
			instantiateSMLInterface();

		} catch (final ErrorInitializingSMLInterface e) {
			return new Status(IStatus.WARNING, Activator.PLUGIN_ID,
			        "Could not instantiate SML interface.  You can simulate but not run state space analysis", e);
		} catch (final Exception e) {
			// e.printStackTrace();
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error checking Petri net", e);
		} finally {
			monitor.done();
		}

		return Status.OK_STATUS;
	}

	private void localCheck(final IProgressMonitor monitor) throws LocalCheckFailed {
		monitor.subTask("Checking names");
		checker.localCheck();
		monitor.worked(1);
	}

	private void instantiateSMLInterface() throws Exception {
		checker.instantiateSMLInterface();
	}

}
