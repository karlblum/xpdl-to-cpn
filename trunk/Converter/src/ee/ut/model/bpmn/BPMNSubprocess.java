package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocess extends BPMNElement {

	String startPlaceId;
	String endPlaceId;
	private String subProcessId;

	public BPMNSubprocess(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);

		subProcessId = elementParser.getSubprocessId(obj);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

	public Place getInputPlace() {
		return cPNProcess.getCpnet().getPlace(startPlaceId);
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(endPlaceId);
	}

	public void setOutputPlace(String id) {
		endPlaceId = id;
	}

	public void setInputPlace(String id) {
		startPlaceId = id;
	}

	public String getSubProcessId() {
		return subProcessId;
	}

}
