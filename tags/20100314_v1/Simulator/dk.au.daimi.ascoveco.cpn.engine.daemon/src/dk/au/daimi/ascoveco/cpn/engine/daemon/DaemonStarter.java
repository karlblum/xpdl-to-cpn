package dk.au.daimi.ascoveco.cpn.engine.daemon;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

/**
 * @author mw
 */
public class DaemonStarter implements Runnable {
	private static DaemonStarter instance = null;

	/**
	 * @return a static instance
	 * @throws IOException
	 */
	public static DaemonStarter getInstance() throws IOException {
		if (DaemonStarter.instance == null) {
			DaemonStarter.instance = new DaemonStarter();
		}
		return DaemonStarter.instance;
	}

	/**
	 * 
	 */
	public IPath simulatorDir;

	Process daemon = null;

	private final String cpnmld;

	private final String run;

	private DaemonStarter() throws IOException {
		String arch;
		String platform;
		try {
			arch = Platform.getOSArch();
			platform = Platform.getOS();
			if (Platform.OS_MACOSX.equals(platform)) {
				platform = "darwin";
			} else if (Platform.OS_WIN32.equals(platform)) {
				platform = "cygwin";
			} else if (Platform.OS_LINUX.equals(platform)) {
				platform = "linux";
			} else {
				platform = "unknown";
			}
		} catch (final Exception e) {
			final String name = System.getProperty("os.name").toLowerCase(Locale.US);
			if (name.indexOf("mac os x") > -1) {
				platform = "darwin";
			} else if (name.indexOf("windows") > -1) {
				platform = "cygwin";
			} else if (System.getProperty("path.separator").equals(":") && name.indexOf("linux") >= 0) {
				platform = "linux";
			} else {
				platform = "unknown";
			}

			if ("x86".equals(System.getProperty("os.arch").toLowerCase(Locale.US))
			        || "i386".equals(System.getProperty("os.arch").toLowerCase(Locale.US))) {
				arch = "x86";
			} else {
				arch = "unknown";
				arch = "x86"; // We don't have 64-bit versions, this should allow sensible fallback
			}
		}

		final String archOS = '.' + arch + '-' + platform;

		simulatorDir = new Path(getPluginResource("")).append("simulator");

		if (!simulatorDir.toFile().exists()) {
			if (!simulatorDir.toFile().mkdirs()) { throw new IOException("Could not create dir for storing simulator"); }
		}
		if (simulatorDir.toFile().isFile()) { throw new IOException(
		        "Location for storing simulator exists but is a file"); }

		cpnmld = simulatorDir.append("cpnmld" + archOS).toString();
		run = new Path(".").append("run" + archOS).toString();

		try {
			ProcessBuilder pb = new ProcessBuilder("chmod", "u+x", cpnmld);
			pb.directory(simulatorDir.toFile());
			pb.start().waitFor();
			pb = new ProcessBuilder("chmod", "u+x", run);
			pb.directory(simulatorDir.toFile());
			pb.start().waitFor();
		} catch (final InterruptedException e) {
			e.printStackTrace();
			// Ignore error
		} catch (final IOException e) {
			// e.printStackTrace();
			// Ignore if chmod does not exist -- this typically happens on
			// Windows where chmod is not needed to run executables
		}

		Runtime.getRuntime().addShutdownHook(new Thread(this, "Daemon shutdown hook")); //$NON-NLS-1$
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		destroy();
	}

	/**
	 * @param port
	 *            port to start simulator on
	 * @throws IOException
	 *             if, for some reason, we could not start simulator
	 */
	public void startSimulatorDaemon(final int port) throws IOException {
		final ProcessBuilder pb = new ProcessBuilder(cpnmld, "" + port, run);
		pb.redirectErrorStream(true);
		pb.directory(simulatorDir.toFile());
		daemon = pb.start();
		new Thread() {
			@Override
			public void run() {
				final InputStream out = daemon.getInputStream();
				while (daemon != null) {
					try {
						out.skip(out.available());
						Thread.sleep(100);
					} catch (final Exception e) {
						// Mask error
					}
				}
			}
		}.start();
	}

	/**
	 * @param name
	 * @return
	 */
	static String getPluginResource(final String name) {
		String locationName;
		if (Activator.getDefault() == null) {
			return DaemonStarter.class.getResource("").getPath() + "../../../../../../../../";
		} else {
			locationName = Activator.getDefault().getBundle().getLocation() + name;
			String pluginArea = extractFileName(locationName);

			if (pluginArea.charAt(0) != '/') {
				final String configurationArea = extractFileName(Platform.getConfigurationLocation().getURL()
				        .toString());
				final IPath p = new Path(configurationArea).append("..").append(pluginArea);
				pluginArea = p.toString();
			}
			return pluginArea;
		}
	}

	private static String extractFileName(final String name) {
		String locationName = name;
		try {
			URL location;
			do {
				location = new URL(locationName);
				locationName = location.getFile();
			} while (!location.getProtocol().equals("file"));
		} catch (final MalformedURLException e) {
			// First was not an URL, ignore
		}
		return locationName;
	}

	void destroy() {
		if (daemon != null) {
			try {
				Thread.sleep(250);
			} catch (final InterruptedException e) {
				// Ignore error
			}
			daemon.destroy();
			try {
				daemon.waitFor();
			} catch (final InterruptedException e) {
				// Ignore error
			}
		}
		daemon = null;
	}
}
