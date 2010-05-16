package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessStart extends BPMNElement {

	private String outputPlaceId;
	private String startPlaceId;
	private String timerTransitionId;

	public BPMNSubprocessStart(BProcess pr, Parser p, Object o)
			throws Exception {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		startPlaceId = process.getCpnet().addPlace(elementName).getId();
		outputPlaceId = process.getCpnet().addPlace(elementName).getId();

		timerTransitionId = process.getCpnet().addTrans(
				elementName + "TIMER_TRANSITIONS").getId();
		process.getCpnet().addArc(startPlaceId, timerTransitionId);
		process.getCpnet().addArc(timerTransitionId, outputPlaceId);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

	}

	@Override
	public String getInputPlaceId() {
		return startPlaceId;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return outputPlaceId;
	}

	public String getTimerTransitionId() {
		return timerTransitionId;
	}

}
