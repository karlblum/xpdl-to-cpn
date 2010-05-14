package ee.ut.model.bpmn;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNTransition extends BPMNElement {

	public BPMNTransition(CPNProcess cPNProcess, Object object,
			ElementParser elementParser) throws Exception {
		super(cPNProcess);

		Element objectFrom = (Element) ((Object[]) object)[1];
		Element objectTo = (Element) ((Object[]) object)[0];

		cPNProcess.addEdge(objectFrom, objectTo);
		
		// If we have a connection from XOR gateway to Message intermediate
		// event (Event based XOR gateway), then we let the message event know
		// where it has to get its delay range if there are timers present in
		// XOR gateway.
		if (objectFrom instanceof BPMNGateway
				&& objectTo instanceof BPMNIntermediateMessageEvent) {
			((BPMNIntermediateMessageEvent) objectTo)
					.setEBXORId(((BPMNGateway) objectFrom).getId());
		}

		// If a gateway is attached to the timer event (we have an event based
		// gateway), then we set the timer value from the timer to the gateway.
		// This is needed for the message events to genrate a proper delay.
		if (objectFrom instanceof BPMNGateway
				&& objectTo instanceof BPMNIntermediateTimerEvent) {
			((BPMNGateway) objectFrom)
					.setEBXORTimerDelay(((BPMNIntermediateTimerEvent) objectTo)
							.getTimerDelay());
		}

		String transId = cPNProcess.getCpnet().addTrans().getId();

		cPNProcess.getCpnet()
				.addArc(objectFrom.getOutputPlaceId(null), transId);
		cPNProcess.getCpnet().addArc(transId, objectTo.getInputPlaceId());
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInputPlaceId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return null;
	}

}
