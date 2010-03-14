package dk.au.daimi.ascoveco.cpn.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * @author mw
 */
public class EnginePreferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * 
	 */
	public static final String IMPLEMENTATION = "implementation";
	/**
	 * 
	 */
	public static final String IMAGE = "image";
	private final ScopedPreferenceStore preferences;

	/**
	 * 
	 */
	public EnginePreferences() {
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
		final StringFieldEditor image = new StringFieldEditor(EnginePreferences.IMAGE, "Image name:",
		        getFieldEditorParent());
		addField(image);
		final List<String[]> labels = new ArrayList<String[]>();
		for (final IExtension extension : Platform.getExtensionRegistry().getExtensionPoint(Activator.PLUGIN_ID,
		        "simulatorImplementation").getExtensions()) {
			for (final IConfigurationElement element : extension.getConfigurationElements()) {
				String name = element.getAttribute("name");
				final String clazz = element.getAttribute("class");
				if (name == null) {
					name = clazz;
				}
				final String id = element.getAttribute("id");
				labels.add(new String[] { name, id });
			}
		}
		final RadioGroupFieldEditor implementation = new RadioGroupFieldEditor(EnginePreferences.IMPLEMENTATION,
		        "Preferred engine implementation:", 3, labels.toArray(new String[][] {}), getFieldEditorParent());
		addField(implementation);
	}
}
