package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNTransition2 extends BPMNElement {

	public BPMNTransition2(CPNProcess cPNProcess, Object object,
			ElementParser elementParser) throws Exception {
		super(cPNProcess);

		elementId = elementParser.getId(object);

		Place toPlace = null;
		Place fromPlace = null;

		Object objectFrom = cPNProcess.getElement(elementParser
				.getTransitionFrom(object));
		Object objectTo = cPNProcess.getElement(elementParser
				.getTransitionTo(object));

		if (objectFrom == null || objectTo == null) {
			throw new Exception("Error creating transition: " + objectFrom
					+ " " + objectTo);
		}

		// TODO: We should extract some parent class from all of these objects

		// FROM object
		if (objectFrom instanceof BPMNTask2) {
			fromPlace = ((BPMNTask2) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNGateway) {
			fromPlace = ((BPMNGateway) objectFrom).getOutputPlace(elementId);
		} else if (objectFrom instanceof BPMNStartEvent) {
			fromPlace = ((BPMNStartEvent) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNIntermediateTimerEvent) {
			fromPlace = ((BPMNIntermediateTimerEvent) objectFrom)
					.getOutputPlace();
		} else if (objectFrom instanceof BPMNIntermediateMessageEvent) {
			fromPlace = ((BPMNIntermediateMessageEvent) objectFrom)
					.getOutputPlace();
		} else if (objectFrom instanceof BPMNBoundMessageEvent) {
			fromPlace = ((BPMNBoundMessageEvent) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNBoundTimerEvent) {
			fromPlace = ((BPMNBoundTimerEvent) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNSubprocess) {
			fromPlace = ((BPMNSubprocess) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNSubprocessStart) {
			fromPlace = ((BPMNSubprocessStart) objectFrom).getOutputPlace();
		}  else {
			throw new Exception("Unknown BPMNElement type: " + objectFrom);
		}

		// TO object
		if (objectTo instanceof BPMNTask2) {
			toPlace = ((BPMNTask2) objectTo).getInputPlace();
		} else if (objectTo instanceof BPMNGateway) {
			toPlace = ((BPMNGateway) objectTo).getInputPlace();
		} else if (objectTo instanceof BPMNEndEvent) {
			toPlace = ((BPMNEndEvent) objectTo).getInputPlace();
		} else if (objectTo instanceof BPMNIntermediateTimerEvent) {
			toPlace = ((BPMNIntermediateTimerEvent) objectTo).getInputPlace();
		} else if (objectTo instanceof BPMNIntermediateMessageEvent) {
			toPlace = ((BPMNIntermediateMessageEvent) objectTo).getInputPlace();
		} else if (objectTo instanceof BPMNSubprocess) {
			toPlace = ((BPMNSubprocess) objectTo).getInputPlace();
		}else if (objectTo instanceof BPMNSubprocessEnd) {
			toPlace = ((BPMNSubprocessEnd) objectTo).getInputPlace();
		} else {
			throw new Exception("Unknown BPMNElement type: " + objectTo);
		}

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

		cPNProcess.getCpnet().addArc(fromPlace.getId(), transId);
		cPNProcess.getCpnet().addArc(transId, toPlace.getId());
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

}
