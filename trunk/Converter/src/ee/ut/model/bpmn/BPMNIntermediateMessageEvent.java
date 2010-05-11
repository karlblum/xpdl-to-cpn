package ee.ut.model.bpmn;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNIntermediateMessageEvent extends BPMNElement {

	String inputPlaceId;
	String outputPlaceId;
	String delayArcId;
	String ebXORId;

	public BPMNIntermediateMessageEvent(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);

		elementName = elementParser.getName(obj);
		elementId = elementParser.getId(obj);

		inputPlaceId = cPNProcess.getCpnet().addPlace(elementName + "IN")
				.getId();
		String transitionId = cPNProcess.getCpnet().addTrans(elementName)
				.getId();

		cPNProcess.getCpnet().addArc(inputPlaceId, transitionId);
		outputPlaceId = cPNProcess.getCpnet().addPlace(elementName + "OUT")
				.getId();

		delayArcId = cPNProcess.getCpnet().addArc(transitionId, outputPlaceId)
				.getId();
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

		boolean timerPresent = false;
		if (ebXORId != null) {
			BPMNGateway gw = (BPMNGateway) cPNProcess.getElement(ebXORId);
			int timerDelay = gw.getEBXORTimerDelay();
			if (timerDelay > 0) {
				cPNProcess.getCpnet().setArcAnnot(delayArcId,
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
