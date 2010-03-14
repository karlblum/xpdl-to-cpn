package dk.au.daimi.ascoveco.util;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.BundleContext;

import dk.au.daimi.ascoveco.util.development.DevelopmentPreferences;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * @author mw
 */
public class Activator extends AbstractUIPlugin {
	/**
	 * 
	 */
	public static final String PLUGIN_ID = "dk.au.daimi.ascoveco.util";

	private static Activator plugin;
	ScopedPreferenceStore preferences = null;

	/**
	 * 
	 */
	public Activator() {
		Platform.getAdapterManager().registerAdapters(new SimpleTreeAdapterFactory(), SimpleTree.class);
	}

	private ScopedPreferenceStore getPreferences() {
		if (preferences == null) {
			preferences = new ScopedPreferenceStore(new ConfigurationScope(), Activator.PLUGIN_ID);
		}
		return preferences;
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return Activator.plugin;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	@SuppressWarnings("ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		Activator.plugin = this;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	@SuppressWarnings("ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")
	public void stop(final BundleContext context) throws Exception {
		Activator.plugin = null;
		super.stop(context);
	}

	/**
	 * @return enable development features?
	 */
	public boolean getDevelopment() {
		return getPreferences().getBoolean(DevelopmentPreferences.DEVELOPMENT);
	}
}
