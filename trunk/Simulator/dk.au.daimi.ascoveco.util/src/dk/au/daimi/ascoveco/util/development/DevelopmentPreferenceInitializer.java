package dk.au.daimi.ascoveco.util.development;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import dk.au.daimi.ascoveco.util.Activator;

/**
 * @author mw
 */
public class DevelopmentPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * 
	 */
	public DevelopmentPreferenceInitializer() {
		super();
	}

	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		final IEclipsePreferences defaults = new DefaultScope().getNode(Activator.PLUGIN_ID);
		defaults.putBoolean(DevelopmentPreferences.DEVELOPMENT, false);
	}
}
