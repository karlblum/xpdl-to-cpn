package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNIntermediateMessageEvent extends BPMNElement {

	String inputPlaceId;
	String outputPlaceId;
	String delayArcId;
	String ebXORId;

	public BPMNIntermediateMessageEvent(BProcess pr, Parser p, Object o)
			throws Exception {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		inputPlaceId = process.getCpnet().addPlace(elementName + "IN").getId();
		String transitionId = process.getCpnet().addTrans(elementName).getId();

		process.getCpnet().addArc(inputPlaceId, transitionId);
		outputPlaceId = process.getCpnet().addPlace(elementName + "OUT")
				.getId();

		delayArcId = process.getCpnet().addArc(transitionId, outputPlaceId)
				.getId();
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

		boolean timerPresent = false;
		if (ebXORId != null) {
			BPMNGateway gw = (BPMNGateway) process.getElement(ebXORId);
			int timerDelay = gw.getEBXORTimerDelay();
			if (timerDelay > 0) {
				process.getCpnet().setArcAnnot(delayArcId,
						"c@+round(uniform(0.0," + timerDelay + ".0))");
				timerPresent = true;
			}
		}

		if (!timerPresent) {
			// TODO: add delay from simulation data (message receiving
			// frequency)
		}
	}

	public void setEBXORId(String id) {
		ebXORId = id;
	}

	@Override
	public String getInputPlaceId() {
		return inputPlaceId;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return outputPlaceId;
	}

}
