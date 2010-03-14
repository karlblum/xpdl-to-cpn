/*
 * BRITNeY Suite Copyright (C) 2004-2006 Michael Westergaard and others This program is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later version. This program is distributed in
 * the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a
 * copy of the GNU General Public License along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package dk.au.daimi.ascoveco.cpn.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * @author Michael Westergaard
 */
public class SimulatorService extends Observable implements Iterable<Simulator>, Runnable {
	static SimulatorService s = new SimulatorService();

	/**
	 * Get a static instance of SimulatorService
	 * 
	 * @return the static instance
	 */
	public static SimulatorService getInstance() {
		return SimulatorService.s;
	}

	private final Map<String, Simulator> simulatorMap;

	private final Map<Simulator, String> reverseSimulatorMap;

	int maxId = 0;

	List<Simulator> simulators;

	private SimulatorService() {
		simulators = new ArrayList<Simulator>();
		simulatorMap = new HashMap<String, Simulator>();
		reverseSimulatorMap = new HashMap<Simulator, String>();
		Runtime.getRuntime().addShutdownHook(new Thread(this, "SimulatorService shutdown hook")); //$NON-NLS-1$
	}

	/**
	 * @return a new simulator
	 * @throws Exception
	 *             if an error occurred
	 */
	@SuppressWarnings("null")
	public Simulator getNewSimulator() throws Exception {
		try {
			final ScopedPreferenceStore preferences = new ScopedPreferenceStore(new ConfigurationScope(),
			        Activator.PLUGIN_ID);
			final String pluginid = preferences.getString(EnginePreferences.IMPLEMENTATION);
			final IExtensionPoint extensionpoint = Platform.getExtensionRegistry().getExtensionPoint(
			        Activator.PLUGIN_ID, "simulatorImplementation");
			IConfigurationElement simulatorConfigurationElement = null;
			for (final IExtension extension : extensionpoint.getExtensions()) {
				for (final IConfigurationElement element : extension.getConfigurationElements()) {
					if (element.getAttribute("id").equals(pluginid) || pluginid == null || "".equals(pluginid)) {
						simulatorConfigurationElement = element;
					}
				}
			}
			SimulatorImplementation implementation;
			try {
				implementation = (SimulatorImplementation) simulatorConfigurationElement
				        .createExecutableExtension("class");
			} catch (final Exception e) {
				StatusManager.getManager().handle(
				        new Status(IStatus.WARNING, Activator.PLUGIN_ID,
				                "Error starting simulator; try killing any processes containing cpnmld or run.x86", e),
				        StatusManager.LOG);
				return null;
			}
			final Simulator simulator = new Simulator(implementation);
			simulators.add(simulator);
			try {
				// This yields a warning
				// simulator.evaluate(this, "CPN'CodeGen.set_dumping_filename(\"asapdump-initial.sml\";");
				simulator.evaluate(this, "CPN'Animation.version := (!CPN'Animation.version + 1)"); //$NON-NLS-1$
				simulator.evaluate(this, "CPN'Animation.id := \"" + simulator.getId() + "\""); //$NON-NLS-1$//$NON-NLS-2$
			} catch (final Exception e) {
				StatusManager
				        .getManager()
				        .handle(
				                new Status(
				                        IStatus.WARNING,
				                        Activator.PLUGIN_ID,
				                        "Setting up animation for BRITNeY failed; you are probably using a wrong simulator.",
				                        e), StatusManager.LOG);

			}
			setChanged();
			notifyObservers(simulator);
			return simulator;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param id
	 *            id of simulator
	 * @return the simulator with the id
	 */
	public Simulator getSimulator(final String id) {
		return simulatorMap.get(id);
	}

	/**
	 * @param simulator
	 *            simulator to ID
	 * @return a new unique id for the given simulator
	 */
	public synchronized String getUniqueId(final Simulator simulator) {
		String id = reverseSimulatorMap.get(simulator);
		if (id != null) { return id; }
		id = "simulator" + maxId++; //$NON-NLS-1$
		simulatorMap.put(id, simulator);
		reverseSimulatorMap.put(simulator, id);
		return id;
	}

	/**
	 * @return an iterator of all simulators
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Simulator> iterator() {
		return simulators.iterator();
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		for (final Simulator simulator : new ArrayList<Simulator>(simulators)) {
			try {
				simulator.destroy();
			} catch (final Exception ex) { // Ignore error
			}
		}
	}

	/**
	 * @return the current number of simulators
	 */
	public int size() {
		return simulators.size();
	}

	/**
	 * @param id
	 *            id of simulator
	 * @param simulator
	 *            simulator
	 */
	public void unregisterSimulator(final String id, final Simulator simulator) {
		reverseSimulatorMap.remove(simulator);
		simulatorMap.remove(id);
		simulators.remove(simulator);
		setChanged();
		notifyObservers(simulator);
	}
}
