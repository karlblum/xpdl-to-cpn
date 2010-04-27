package ee.ut.model.bpmn;

import noNamespace.Place;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNEvent extends BPMNElement{

	String outputPlaceId;
	String transitionId;
	String triggerPlaceId;
	boolean isEventRecurring;
	String eventTime;
	
	public BPMNEvent(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);
		isEventRecurring = elementParser.isEventRecurring(obj);
		eventTime = elementParser.getEventTime(obj);
		
		//TODO: fix the recurring interval problem
		outputPlaceId = cPNProcess.getCpnet().addPlace(elementName + elementId + "_OUT").getId();
		transitionId = cPNProcess.getCpnet().addTrans(elementName + elementId).getId();
		cPNProcess.getCpnet().addArc(transitionId, outputPlaceId);

		triggerPlaceId = cPNProcess.getCpnet().addPlace("TRIG_TOKEN",elementName + elementId + "_TRIGGER").getId();
		cPNProcess.getCpnet().setPlaceValue(triggerPlaceId,"1`1@+" +eventTime);
		cPNProcess.getCpnet().addArc(triggerPlaceId, transitionId,"tt");
		
		// If the event is recurring then we put the trigger token back
		if(isEventRecurring){
			cPNProcess.getCpnet().addArc(transitionId, triggerPlaceId,"tt@+" + eventTime);
		}
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub
		
	}

	public Trans getInputPlace() {
		return cPNProcess.getCpnet().getTransition(transitionId);
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

}
