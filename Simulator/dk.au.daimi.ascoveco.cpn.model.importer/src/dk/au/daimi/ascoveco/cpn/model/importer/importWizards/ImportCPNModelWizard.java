/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package dk.au.daimi.ascoveco.cpn.model.importer.importWizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * @author mw
 */
public class ImportCPNModelWizard extends Wizard implements IImportWizard {

	ImportCPNModelWizardPage mainPage;
	private IWorkbench workbench;

	/**
	 * 
	 */
	public ImportCPNModelWizard() {
		super();
	}

	/**
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		addPage(mainPage);
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(final IWorkbench theWorkbench, final IStructuredSelection selection) {
		setWindowTitle("Import CPN model from CPN Tools"); // NON-NLS-1
		setNeedsProgressMonitor(true);
		this.workbench = theWorkbench;
		mainPage = new ImportCPNModelWizardPage("Import File", selection); // NON-NLS-1
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		final IFile file = mainPage.createNewFile();
		if (file == null) { return false; }

		// Select the new file resource in the current view.
		//
		final IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		final IWorkbenchPage page = workbenchWindow.getActivePage();
		final IWorkbenchPart activePart = page.getActivePart();
		if (activePart instanceof ISetSelectionTarget) {
			final ISelection targetSelection = new StructuredSelection(file);
			getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					((ISetSelectionTarget) activePart).selectReveal(targetSelection);
				}
			});
		}

		return true;
	}

}
