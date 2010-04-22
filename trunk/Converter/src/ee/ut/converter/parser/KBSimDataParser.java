package ee.ut.converter.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ee.ut.model.sim.GateRef;
import ee.ut.model.sim.Gateway;
import ee.ut.model.sim.Resource;
import ee.ut.model.sim.SimulationData;
import ee.ut.model.sim.Task;

public class KBSimDataParser implements SimDataParser {

	JAXBElement<SimulationData> simDataRoot;

	@SuppressWarnings("unchecked")
	public KBSimDataParser(File simulationDataFile) {
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
		for (Task t : simDataRoot.getValue().getTasks().getTask()){
			if(t.getId().equals(id))
			return t.getProcessingTime();
		}
		return "0";
	}

	@Override
	public HashMap<String,String> getDistribution(String id) {
		HashMap<String, String> distributions = new HashMap<String, String>();
		for(Gateway gw :simDataRoot.getValue().getGateways().getGateway()){
			if(gw.getId().equals(id)){
				for(GateRef gwRef : gw.getGateRefs().getGateRef()){
					distributions.put(gwRef.getIdRef(), String.valueOf(gwRef.getProbability())); 
				}
			}
		}
		return distributions;
	}

	@Override
	public String getTotalTokens() {
		return String.valueOf(simDataRoot.getValue().getSimulationProfile().getTotalTokens());
	}

	@Override
	public String getTokensPerBundle() {
		return String.valueOf(simDataRoot.getValue().getSimulationProfile().getTokensInBundle());
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
	public String getWaitTimeDuration(String elementId) {
		for (Task t : simDataRoot.getValue().getTasks().getTask()){
			if(t.getId().equals(elementId))
				
			return t.getResourceWaitTime();
		}
		return "0";
	}

	@Override
	public String getResources(String elementId) {
		for (Task t : simDataRoot.getValue().getTasks().getTask()){
			if(t.getId().equals(elementId))
				
			return t.getResourceType();
		}
		return "";
	}

	@Override
	public HashMap<String, Integer> getResourceData() {
		HashMap<String,Integer> resources = new HashMap<String, Integer>(); 
		
		for (Resource r : simDataRoot.getValue().getResources().getResource()){
			resources.put(r.getResourceType(), r.getResourceAmount()); 
		}
		return resources;
	}

	@Override
	public String getTimeBetweenBundles() {
		int tbb = simDataRoot.getValue().getSimulationProfile().getTimeBetweenBundles();
		return String.valueOf(tbb);
	}
}
