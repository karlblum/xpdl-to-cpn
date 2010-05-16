package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNTransition extends BPMNElement {

	public BPMNTransition(BProcess pr, Parser p, Object o) throws Exception {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		Element objectFrom = (Element) ((Object[]) o)[1];
		Element objectTo = (Element) ((Object[]) o)[0];

		if (objectFrom == null || objectTo == null) {
			throw new Exception("Error making transition between:"
					+ objectFrom.getId() + " AND " + objectTo.getId());
		}
		
		if (objectTo instanceof BPMNBoundTimerEvent)
			return;
		
		if(objectTo instanceof BPMNSubprocessTimer){
			((BPMNSubprocess)objectFrom).setBoundTimer((BPMNSubprocessTimer)objectTo);
			return;
		}

		process.addEdge(objectFrom, objectTo);

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

		String transId = process.getCpnet().addTrans().getId();

		String tId = null;
		if (objectFrom instanceof BPMNGateway)
			tId = parser.getElementParser().getXorGWOutputIdentifier(
					objectFrom.getId(), objectTo.getId());

		process.getCpnet().addArc(objectFrom.getOutputPlaceId(tId), transId);
		process.getCpnet().addArc(transId, objectTo.getInputPlaceId());
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
