package dk.au.daimi.ascoveco.util.logging;

import java.text.MessageFormat;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import dk.au.daimi.ascoveco.util.Activator;

/**
 * @author mw
 */
public class PluginLogDelegateHandler extends Handler {

	/**
	 * @see java.util.logging.Handler#close()
	 */
	@Override
	public void close() {
		// Implement interface
	}

	/**
	 * @see java.util.logging.Handler#flush()
	 */
	@Override
	public void flush() {
		// Implement interface
	}

	/**
	 * @see java.util.logging.Handler#publish(java.util.logging.LogRecord)
	 */
	@Override
	public void publish(final LogRecord record) {
		if (record.getLevel() == Level.SEVERE) {
			final Throwable t = record.getThrown();
			String message = record.getMessage();

			try {
				if (record.getMessage() != null) {
					message = MessageFormat.format(record.getMessage(), record.getParameters());
				}
			} catch (final Throwable e) {
				e.printStackTrace();
			}

			if (t != null) {
				if (t.getMessage() != null) {
					message = t.getMessage();
				}
			}

			if (message == null) {
				message = "Error in " + record.getLoggerName();
			}
			final Status s = new Status(IStatus.ERROR, record.getLoggerName(), IStatus.ERROR, message, record
			        .getThrown());
			Bundle bundle = Platform.getBundle(record.getLoggerName());
			if (bundle == null) {
				bundle = Activator.getDefault().getBundle();
			}
			final Bundle fBundle = bundle;

			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					try {

						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
						        "org.eclipse.pde.runtime.LogView");
					} catch (final Throwable e) {
						// ignore
					}
					Platform.getLog(fBundle).log(s);
				}
			});

		}
	}

}