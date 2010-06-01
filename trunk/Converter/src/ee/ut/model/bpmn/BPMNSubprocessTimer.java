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
	int timerTime;

	public BPMNSubprocessTimer(BProcess pr, Parser p, Object o)
			throws Exception {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);
		timerTime = parser.getElementParser().getEventTimer(o);

		okPlaceId = process.getCpnet().addPlace(elementName + "OK").getId();
		nokPlaceId = process.getCpnet().addPlace(elementName + "NOK").getId();
		timerTokenPlaceId = process.getCpnet().addPlace(elementName + "TIMER")
				.getId();
		String exeptionTransId = process.getCpnet().addTrans(
				elementName + "EXCEPTION").getId();
		
		outputPlaceId = process.getCpnet().addPlace(elementName + "TIMER OUT")
				.getId();
		

		process.getCpnet().addArc(okPlaceId, exeptionTransId,"c");
		process.getCpnet().addArc(exeptionTransId, nokPlaceId,"c");

		process.getCpnet().addArc(timerTokenPlaceId, exeptionTransId,"c");

	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
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

	public int getTimerTime() {
		return timerTime;
	}

}
