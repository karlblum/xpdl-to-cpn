package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNIntermediateTimerEvent extends BPMNElement {

	String inputPlaceId;
	String outputPlaceId;
	int timerDelay;

	public BPMNIntermediateTimerEvent(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);

		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);

		inputPlaceId = cPNProcess.getCpnet().addPlace(elementName + "IN")
				.getId();
		String transitionId = cPNProcess.getCpnet().addTrans(elementName)
				.getId();

		cPNProcess.getCpnet().addArc(inputPlaceId, transitionId);
		outputPlaceId = cPNProcess.getCpnet().addPlace(elementName + "OUT")
				.getId();

		String delayArc = cPNProcess.getCpnet().addArc(transitionId,
				outputPlaceId).getId();
		timerDelay = elementParser.getEventTimer(obj);
		cPNProcess.getCpnet().setArcAnnot(delayArc, "c@+" + timerDelay);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

	public Place getInputPlace() {
		return cPNProcess.getCpnet().getPlace(inputPlaceId);
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

	public int getTimerDelay() {
		return timerDelay;
	}

}
