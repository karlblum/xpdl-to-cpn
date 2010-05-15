package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessTimer extends BPMNElement {

	String outputPlaceId;
	String okPlaceId;
	String nokPlaceId;
	String timerTokenPlaceId;
	String completeTransId;
	String parentProcessId;

	public BPMNSubprocessTimer(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		okPlaceId = process.getCpnet().addPlace(elementName + "OK").getId();
		nokPlaceId = process.getCpnet().addPlace(elementName + "NOK").getId();
		timerTokenPlaceId = process.getCpnet().addPlace(elementName + "TIMER")
				.getId();
		String exeptionTransId = process.getCpnet().addTrans(
				elementName + "EXCEPTION").getId();
		outputPlaceId = process.getCpnet().addPlace(elementName + "TIMER OUT")
				.getId();

		process.getCpnet().addArc(okPlaceId, exeptionTransId);
		process.getCpnet().addArc(exeptionTransId, nokPlaceId);

		process.getCpnet().addArc(timerTokenPlaceId, exeptionTransId);

		parentProcessId = parser.getElementParser().getBoundaryEventTaskId(o);

	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		/*
		 * BPMNSubprocess parentProcess = (BPMNSubprocess) process
		 * .getElement(parentProcessId); parentProcess.setBoundTimer(this);
		 */
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
