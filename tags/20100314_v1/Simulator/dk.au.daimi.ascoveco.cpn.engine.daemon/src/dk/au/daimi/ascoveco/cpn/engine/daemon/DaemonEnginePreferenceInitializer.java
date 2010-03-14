package dk.au.daimi.ascoveco.cpn.engine.daemon;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 * @author mw
 */
public class DaemonEnginePreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * 
	 */
	public DaemonEnginePreferenceInitializer() {
		super();
	}

	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		final IEclipsePreferences defaults = new DefaultScope().getNode(Activator.PLUGIN_ID);
		defaults.put(DaemonEnginePreferences.HOST, "localhost");
		defaults.putInt(DaemonEnginePreferences.PORT, 20001);
	}
}
