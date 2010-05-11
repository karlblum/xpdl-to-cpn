package ee.ut.model.bpmn;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessTimer extends BPMNElement {

	String outputPlaceId;
	String okPlaceId;
	String nokPlaceId;
	String timerTokenPlaceId;
	String completeTransId;
	String parentProcessId;

	public BPMNSubprocessTimer(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);

		okPlaceId = cPNProcess.getCpnet().addPlace(elementName + "OK").getId();
		nokPlaceId = cPNProcess.getCpnet().addPlace(elementName + "NOK")
				.getId();
		timerTokenPlaceId = cPNProcess.getCpnet().addPlace(
				elementName + "TIMER").getId();
		String exeptionTransId = cPNProcess.getCpnet().addTrans(
				elementName + "EXCEPTION").getId();
		outputPlaceId = cPNProcess.getCpnet().addPlace(
				elementName + "TIMER OUT").getId();

		cPNProcess.getCpnet().addArc(okPlaceId, exeptionTransId);
		cPNProcess.getCpnet().addArc(exeptionTransId, nokPlaceId);

		cPNProcess.getCpnet().addArc(timerTokenPlaceId, exeptionTransId);

		parentProcessId = elementParser.getBoundaryEventTaskId(obj);

	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		BPMNSubprocess parentProcess = (BPMNSubprocess) cPNProcess
				.getElement(parentProcessId);
		parentProcess.setBoundTimer(this);

	}

	public String getOKPlaceId() {
		return okPlaceId;
	}

	public String getNOKPlaceId() {
		return nokPlaceId;
	}

	public String getTimerTokenPlaceId() {
		return timerTokenPlaceId;
	}

	@Override
	public String getInputPlaceId() {
		return null;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return outputPlaceId;
	}

}
