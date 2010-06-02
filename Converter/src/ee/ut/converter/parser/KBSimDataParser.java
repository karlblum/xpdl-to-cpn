package ee.ut.converter.parser;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ee.ut.model.sim.GateRef;
import ee.ut.model.sim.Gateway;
import ee.ut.model.sim.Gateways;
import ee.ut.model.sim.MessageEvent;
import ee.ut.model.sim.MessageEvents;
import ee.ut.model.sim.Resource;
import ee.ut.model.sim.Resources;
import ee.ut.model.sim.SimulationData;
import ee.ut.model.sim.Task;
import ee.ut.model.sim.Tasks;

public class KBSimDataParser implements SimDataParser {

	JAXBElement<SimulationData> simDataRoot;

	@SuppressWarnings("unchecked")
	public KBSimDataParser(File simulationDataFile) {
		if (simulationDataFile.exists())
			simDataRoot = unMasrhall(simulationDataFile, "ee.ut.model.sim");
	}

	@SuppressWarnings("unchecked")
	protected JAXBElement unMasrhall(File file, String model) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(model);

			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement rootElement = (JAXBElement) u.unmarshal(file);
			return rootElement;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getTaskDuration(String id) {
		Tasks ts = simDataRoot.getValue().getTasks();
		if (ts != null) {
			for (Task t : simDataRoot.getValue().getTasks().getTask()) {
				if (t.getId().equals(id))
					return t.getProcessingTime();
			}
		}
		return "0";
	}

	@Override
	public HashMap<String, String> getDistribution(String id) {
		HashMap<String, String> distributions = new HashMap<String, String>();
		Gateways gws = simDataRoot.getValue().getGateways();
		if (gws != null) {
			for (Gateway gw : gws.getGateway()) {
				if (gw.getId().equals(id)) {
					for (GateRef gwRef : gw.getGateRefs().getGateRef()) {
						distributions.put(gwRef.getIdRef(), String
								.valueOf(gwRef.getProbability()));
					}
				}
			}
			return distributions;
		}
		return null;
	}

	@Override
	public String getTotalTokens() {
		return String.valueOf(simDataRoot.getValue().getSimulationProfile()
				.getTotalTokens());
	}

	@Override
	public String getTokensPerBundle() {
		return String.valueOf(simDataRoot.getValue().getSimulationProfile()
				.getTokensInBundle());
	}

	@Override
	public String getStartTime() {
		return simDataRoot.getValue().getSimulationProfile().getStartTime();
	}

	@Override
	public String getEndTime() {
		return simDataRoot.getValue().getSimulationProfile().getEndTime();
	}

	@Override
	public String getResources(String elementId) {
		Tasks ts = simDataRoot.getValue().getTasks();
		if (ts != null) {
			for (Task t : ts.getTask()) {
				if (t.getId().equals(elementId))

					return t.getResourceType();
			}
		}
		return "";
	}

	@Override
	public HashMap<String, Integer> getResourceData() {
		HashMap<String, Integer> resources = new HashMap<String, Integer>();
		Resources rs = simDataRoot.getValue().getResources();
		if (rs != null) {
			for (Resource r : simDataRoot.getValue().getResources()
					.getResource()) {
				resources.put(r.getResourceType(), r.getResourceAmount());
			}
		}
		return resources;
	}

	@Override
	public String getTimeBetweenBundles() {
		int tbb = simDataRoot.getValue().getSimulationProfile()
				.getTimeBetweenBundles();
		return String.valueOf(tbb);
	}

	@Override
	public int getBoundMessageEventProbability(String elementId) {
		// TODO: Not implemented
		return 10;
	}

	@Override
	public int getBoundTimer(String elementId) {
		// TODO: Not implemented
		return 20;
	}

	@Override
	public boolean hasData() {
		if (simDataRoot != null)
			return true;
		return false;
	}

	@Override
	public String getMessageTime(String elementId) {
		MessageEvents me = simDataRoot.getValue().getMessageEvents();
		if (me != null) {
			for (MessageEvent e : me.getMessageEvent()) {
				if (e.getId().equals(elementId))
					return e.getTime();
			}
		}
		return "0";
	}
}
