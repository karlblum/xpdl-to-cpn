/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package dk.au.daimi.ascoveco.cpn.model.importer.importWizards;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.importer.DOMParser;

/**
 * @author mw
 */
public class ImportCPNModelWizardPage extends WizardNewFileCreationPage {

	protected FileFieldEditor editor;

	/**
	 * @param pageName name of page
	 * @param selection selection in workspace
	 */
	public ImportCPNModelWizardPage(final String pageName, final IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(pageName); // NON-NLS-1
		setDescription("Import a file from the local file system into the workspace"); // NON-NLS-1
	}

	/**
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createAdvancedControls(final Composite parent) {
		final Composite fileSelectionArea = new Composite(parent, SWT.NONE);
		final GridData fileSelectionData = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		fileSelectionArea.setLayoutData(fileSelectionData);

		final GridLayout fileSelectionLayout = new GridLayout();
		fileSelectionLayout.numColumns = 3;
		fileSelectionLayout.makeColumnsEqualWidth = false;
		fileSelectionLayout.marginWidth = 0;
		fileSelectionLayout.marginHeight = 0;
		fileSelectionArea.setLayout(fileSelectionLayout);

		editor = new FileFieldEditor("fileSelect", "Select File: ", fileSelectionArea); // NON-NLS-1 //NON-NLS-2
		editor.getTextControl(fileSelectionArea).addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				final IPath path = new Path(editor.getStringValue().replaceFirst("[.]cpn$", ".model"));
				setFileName(path.lastSegment());
			}
		});
		final String[] extensions = new String[] { "*.cpn", "*.xml" }; // NON-NLS-1
		editor.setFileExtensions(extensions);
		fileSelectionArea.moveAbove(null);

	}

	/**
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createNewFile()
	 */
	@Override
	public IFile createNewFile() {
		try {
			final IPath containerPath = getContainerFullPath();
			final IPath newFilePath = containerPath.append(getFileName());
			final URI uri = URI.createPlatformResourceURI(newFilePath.toString(), false);

			final PetriNet petriNet = DOMParser.parse(new FileInputStream(new File(editor.getStringValue())),
			        getFileName());
			final XMLResourceImpl xmlResource = new XMLResourceImpl(uri);
			xmlResource.getContents().add(petriNet);
			xmlResource.save(null);

			return createFileHandle(newFilePath);
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#getInitialContents()
	 */
	@Override
	protected InputStream getInitialContents() {
		try {
			return new FileInputStream(new File(editor.getStringValue()));
		} catch (final FileNotFoundException e) {
			return null;
		}
	}

	/**
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#getNewFileLabel()
	 */
	@Override
	protected String getNewFileLabel() {
		return "New File Name:"; // NON-NLS-1
	}

	/**
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validateLinkedResource()
	 */
	@Override
	protected IStatus validateLinkedResource() {
		return new Status(IStatus.OK, "dk.au.daimi.ascoveco.cpn.model.importer", IStatus.OK, "", null); // NON-NLS-1
		// //NON-NLS-2
	}

}
