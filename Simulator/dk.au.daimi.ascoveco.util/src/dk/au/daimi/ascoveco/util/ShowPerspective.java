package dk.au.daimi.ascoveco.util;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * @author mw
 */
public class ShowPerspective {

	private static final String ALLWAYS_NO = ".allwaysNo";
	private static final String ALLWAYS_YES = ".allwaysYes";

	/**
	 * @param plugin plugin to use to get workbench
	 * @param pluginId plugin id (to use for storing preference)
	 * @param perspectiveName perspective to switch to
	 */
	@java.lang.SuppressWarnings("fallthrough")
	@SuppressWarnings("SF_SWITCH_FALLTHROUGH")
	public static void showPerspective(final AbstractUIPlugin plugin, final String pluginId,
	        final String perspectiveName) {
		final IWorkbench workbench = plugin.getWorkbench();
		if (workbench != null) {
			final IWorkbenchPage activePage = workbench.getActiveWorkbenchWindow().getActivePage();
			if (activePage == null) { return; }
			final IPerspectiveDescriptor currentPerspective = activePage.getPerspective();
			final IDialogSettings dialogSettings = plugin.getDialogSettings();
			try {
				if (dialogSettings.getBoolean(pluginId + ShowPerspective.ALLWAYS_YES)) {
					workbench.showPerspective(pluginId, workbench.getActiveWorkbenchWindow());
				} else if (dialogSettings.getBoolean(pluginId + ShowPerspective.ALLWAYS_NO)) {
					return;
				} else if (!pluginId.equals(currentPerspective.getId())) {
					final MessageDialog dialog = new MessageDialog(new Shell(), "Change Perspective", null,
					        "Change perspective to " + perspectiveName + "? (Recomended)", 0, new String[] { "Yes",
					                "Always Yes", "No", "Always No" }, 0);
					final int dialogResult = dialog.open();
					switch (dialogResult) {
					case 1:
						dialogSettings.put(pluginId + ShowPerspective.ALLWAYS_YES, true);
					case 0:
						workbench.showPerspective(pluginId, workbench.getActiveWorkbenchWindow());
						break;
					case 3:
						dialogSettings.put(pluginId + ShowPerspective.ALLWAYS_NO, true);
						break;
					default:
						break;
					}
				}
			} catch (final WorkbenchException e) {
				e.printStackTrace();
			}
		}
	}

}
