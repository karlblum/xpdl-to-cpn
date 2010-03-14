package dk.au.daimi.ascoveco.cpn.engine.daemon;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "dk.au.daimi.ascoveco.cpn.engine.daemon";

	// The shared instance
	private static Activator plugin;

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return Activator.plugin;
	}

	/**
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	@SuppressWarnings("ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		Activator.plugin = this;
	}

	/**
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	@SuppressWarnings("ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")
	public void stop(final BundleContext context) throws Exception {
		Activator.plugin = null;
		super.stop(context);
	}

}
