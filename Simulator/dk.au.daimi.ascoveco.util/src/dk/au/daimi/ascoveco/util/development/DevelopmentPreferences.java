package dk.au.daimi.ascoveco.util.development;

import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.statushandlers.StatusManager;

import dk.au.daimi.ascoveco.util.Activator;

/**
 * @author mw
 */
public class DevelopmentPreferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * 
	 */
	public static final String DEVELOPMENT = "development";
	private final ScopedPreferenceStore preferences;

	/**
	 * 
	 */
	public DevelopmentPreferences() {
		super(FieldEditorPreferencePage.FLAT);
		preferences = new ScopedPreferenceStore(new ConfigurationScope(), Activator.PLUGIN_ID);
		setPreferenceStore(preferences);
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(final IWorkbench workbench) {
		// Implement interface
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		try {
			preferences.save();
		} catch (final IOException e) {
			StatusManager.getManager().handle(
			        new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Could not save development preferences", e),
			        StatusManager.LOG);
		}
		return super.performOk();
	}

	@Override
	protected void createFieldEditors() {
		final BooleanFieldEditor development = new BooleanFieldEditor(DevelopmentPreferences.DEVELOPMENT,
		        "Enable features under development:", getFieldEditorParent());
		addField(development);
	}
}
