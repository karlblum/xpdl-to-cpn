package dk.au.daimi.ascoveco.cpn.engine.highlevel;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import dk.au.daimi.ascoveco.util.logging.PluginLogDelegateHandler;
import dk.au.daimi.ascoveco.util.logging.SingleLineLogFormatter;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	/**
	 * 
	 */
	public final static boolean DEBUG_SIMULATOR = true;

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "dk.au.daimi.ascoveco.cpn.engine.highlevel";
	/**
	 * 
	 */
	public static final Logger logger = Logger.getLogger("HighLevelSimulator log");

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

	static {
		logger.addHandler(new PluginLogDelegateHandler());
		if (DEBUG_SIMULATOR
		        && (dk.au.daimi.ascoveco.util.Activator.getDefault() == null || dk.au.daimi.ascoveco.util.Activator
		                .getDefault().getDevelopment())) {
			synchronized (Activator.logger) {
				Activator.logger.setLevel(Level.ALL);
				final Handler handler = new ConsoleHandler();
				handler.setLevel(Level.ALL);
				handler.setFormatter(new SingleLineLogFormatter());
				Activator.logger.setUseParentHandlers(false);
				Activator.logger.addHandler(handler);
			}
		}
	}

}
