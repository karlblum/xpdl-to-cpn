package dk.au.daimi.ascoveco.cpn.engine;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 * @author mw
 */
public class EnginePreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * 
	 */
	public EnginePreferenceInitializer() {
		super();
	}

	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		final IEclipsePreferences defaults = new DefaultScope().getNode(Activator.PLUGIN_ID);
		defaults.put(EnginePreferences.IMAGE, "cpn.ML");
	}
}
