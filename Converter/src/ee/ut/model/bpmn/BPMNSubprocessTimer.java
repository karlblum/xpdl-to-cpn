package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessTimer extends BPMNElement {

	String outputPlaceId;
	int timerTime;

	public BPMNSubprocessTimer(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);
		timerTime = parser.getElementParser().getEventTimer(o);

		outputPlaceId = process.getCpnet().addPlace(elementName + "TIMER OUT")
				.getId();
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
	}

	@Override
	public String getInputPID() {
		return outputPlaceId;
	}

	@Override
	public String getOutputPID(String ref) {
		return outputPlaceId;
	}

	public int getTimerTime() {
		return timerTime;
	}

	@Override
	public String getOutputPID() {
		return getOutputPID(null);
		
	}

}
