package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNEndEvent extends BPMNElement {
	
	String endPlaceId;

	public BPMNEndEvent(CPNProcess cPNProcess, Object obj, ElementParser elementParser) {
		super(cPNProcess);
		
		this.endPlaceId = cPNProcess.getCpnet().addPlace().getId();
		elementId = elementParser.getId(obj);
	}
	
	public Place getInputPlace() {
		return cPNProcess.getCpnet().getPlace(endPlaceId);
	}
	
	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub
		
	}

}
