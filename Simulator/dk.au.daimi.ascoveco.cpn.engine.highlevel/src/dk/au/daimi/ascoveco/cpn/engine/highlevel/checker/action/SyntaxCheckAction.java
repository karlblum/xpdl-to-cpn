package dk.au.daimi.ascoveco.cpn.engine.highlevel.checker.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.statushandlers.StatusManager;

import dk.au.daimi.ascoveco.cpn.engine.highlevel.Activator;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.HighLevelSimulator;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.SimulatorConsole;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.checker.CheckerJob;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;

/**
 * @author mw
 */
public class SyntaxCheckAction implements IObjectActionDelegate {
	URI domainModelURI;

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(final IAction action) {
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
		final ResourceSet resourceSet = domain.getResourceSet();
		EObject diagramRoot = null;
		try {
			final Resource resource = resourceSet.getResource(domainModelURI, true);
			diagramRoot = resource.getContents().get(0);
		} catch (final WrappedException ex) {
			StatusManager.getManager().handle(
			        new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Unable to load resource: " + domainModelURI, ex),
			        StatusManager.LOG);

			ex.printStackTrace();
		}

		if (diagramRoot == null || !(diagramRoot instanceof PetriNet)) { return; }

		try {
			final HighLevelSimulator highLevelSimulator = HighLevelSimulator
			        .getHighLevelSimulator((PetriNet) diagramRoot);
			try {
				new SimulatorConsole(highLevelSimulator).register();
			} catch (final Exception e) {
				// Mask if we could not start console
			}
			final CheckerJob checker = new CheckerJob("Checking net", (PetriNet) diagramRoot, null, highLevelSimulator);
			checker.schedule();
		} catch (final Exception e) {
			// Ignore
		}
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(final IAction action, final ISelection selection) {
		domainModelURI = null;
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection == false || selection.isEmpty()) { return; }
		final IFile file = (IFile) ((IStructuredSelection) selection).getFirstElement();
		domainModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		action.setEnabled(true);
	}

	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
		// Implement interface

	}

}
