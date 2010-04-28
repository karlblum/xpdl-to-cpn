package ee.ut.model.bpmn;

import noNamespace.Place;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;
import ee.ut.model.bpmn.BPMNGateway.GatewayType;
import ee.ut.old.model.bpmne.BPMNeGateway.GWType;

public class BPMNTransition2 extends BPMNElement {

	public BPMNTransition2(CPNProcess cPNProcess, Object object,
			ElementParser elementParser) throws Exception {
		super(cPNProcess);

		elementId = elementParser.getId(object);

		Place toPlace = null;
		Trans toTransition = null;
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
			fromPlace = ((BPMNTask2) objectFrom).makeOutputPlace();
		} else if (objectFrom instanceof BPMNGateway) {
			fromPlace = ((BPMNGateway) objectFrom).makeOutputPlace(elementId);
		} else if (objectFrom instanceof BPMNStartEvent) {
			fromPlace = ((BPMNStartEvent) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNEvent) {
			fromPlace = ((BPMNEvent) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNBoundEvent) {
			fromPlace = ((BPMNBoundEvent) objectFrom).getOutputPlace();
		} else {
			throw new Exception("Unknown BPMNElement type: " + objectFrom);
		}

		// TO object
		if (objectTo instanceof BPMNTask2) {
			toPlace = ((BPMNTask2) objectTo).makeInputPlace();
		} else if (objectTo instanceof BPMNGateway) {
			toPlace = ((BPMNGateway) objectTo).makeInputPlace();
		} else if (objectTo instanceof BPMNEndEvent) {
			toPlace = ((BPMNEndEvent) objectTo).getInputPlace();
		} else if (objectTo instanceof BPMNEvent) {
			toTransition = ((BPMNEvent) objectTo).getInputPlace();
		} else {
			throw new Exception("Unknown BPMNElement type: " + objectTo);
		}

		// If we connect an exclusive gateway to the event then there can be no
		// intermediate transitions. So here we connect the output place
		// directly to event transition.
		if (objectTo instanceof BPMNEvent) {
			cPNProcess.getCpnet().addArc(fromPlace.getId(),
					toTransition.getId());
		} else {
			String transId = cPNProcess.getCpnet().addTrans().getId();

			cPNProcess.getCpnet().addArc(fromPlace.getId(), transId);
			cPNProcess.getCpnet().addArc(transId, toPlace.getId());
		}
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

}
