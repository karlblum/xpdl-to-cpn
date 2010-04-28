package ee.ut.model.bpmn;

import noNamespace.Place;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNBoundEvent extends BPMNElement{

	String outputPlaceId;
	private String transitionId;
	String triggerPlaceId;
	boolean isEventRecurring;
	String eventTime;
	
	public BPMNBoundEvent(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);
		isEventRecurring = elementParser.isEventRecurring(obj);
		eventTime = elementParser.getEventTime(obj);
		
		//TODO: fix the recurring interval problem
		outputPlaceId = cPNProcess.getCpnet().addPlace(elementName + elementId + "_OUT").getId();
		setTransitionId(cPNProcess.getCpnet().addTrans(elementName + elementId).getId());
		cPNProcess.getCpnet().addArc(getTransitionId(), outputPlaceId);

		triggerPlaceId = cPNProcess.getCpnet().addPlace("TRIG_TOKEN",elementName + elementId + "_TRIGGER").getId();
		cPNProcess.getCpnet().setPlaceValue(triggerPlaceId,"1`1@+" +eventTime);
		cPNProcess.getCpnet().addArc(triggerPlaceId, getTransitionId(),"tt");
		
		// If the event is recurring then we put the trigger token back
		if(isEventRecurring){
			cPNProcess.getCpnet().addArc(getTransitionId(), triggerPlaceId,"tt@+" + eventTime);
		}
		
		BPMNTask2 task = (BPMNTask2) cPNProcess.getElement(elementParser.getBoundaryEventTaskId(obj));
		task.addBoundaryEvent(this);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub
		
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

	void setTransitionId(String transitionId) {
		this.transitionId = transitionId;
	}

	public String getTransitionId() {
		return transitionId;
	}

}
