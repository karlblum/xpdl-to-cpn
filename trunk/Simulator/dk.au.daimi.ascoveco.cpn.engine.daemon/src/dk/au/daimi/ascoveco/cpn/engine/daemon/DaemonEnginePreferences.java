package dk.au.daimi.ascoveco.cpn.engine.daemon;

import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * @author mw
 */
public class DaemonEnginePreferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * 
	 */
	public static final String HOST = "host";
	/**
	 * 
	 */
	public static final String PORT = "port";
	private final ScopedPreferenceStore preferences;

	/**
	 * 
	 */
	public DaemonEnginePreferences() {
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
			        new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Could not save engine preferences", e),
			        StatusManager.LOG);
		}
		return super.performOk();
	}

	@Override
	protected void createFieldEditors() {
		final StringFieldEditor host = new StringFieldEditor(DaemonEnginePreferences.HOST, "Host:",
		        getFieldEditorParent());
		addField(host);
		final StringFieldEditor port = new IntegerFieldEditor(DaemonEnginePreferences.PORT, "Port:",
		        getFieldEditorParent());
		addField(port);
	}
}
