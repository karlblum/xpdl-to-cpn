package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNTransition2 extends BPMNElement {

	public BPMNTransition2(CPNProcess cPNProcess, Object object,
			ElementParser elementParser) {
		super(cPNProcess);

		String transId = cPNProcess.getCpnet().addTrans().getId();
		elementId = elementParser.getId(object);
		
		Place toPlace = null;
		Place fromPlace = null;

		Object objectFrom = cPNProcess.getElement(elementParser
				.getTransitionFrom(object));
		Object objectTo = cPNProcess.getElement(elementParser
				.getTransitionTo(object));

		// TODO: We should extract some parent class from all of these objects
		if (objectFrom instanceof BPMNTask2) {
			fromPlace = ((BPMNTask2) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNGateway) {
			fromPlace = ((BPMNGateway) objectFrom).makeOutputPlace(elementId);
		} else if (objectFrom instanceof BPMNStartEvent) {
			fromPlace = ((BPMNStartEvent) objectFrom).getOutputPlace();
		}

		if (objectTo instanceof BPMNTask2) {
			toPlace = ((BPMNTask2) objectTo).makeInputPlace();
		} else if (objectTo instanceof BPMNGateway) {
			toPlace = ((BPMNGateway) objectTo).makeInputPlace();
		} else if (objectTo instanceof BPMNEndEvent) {
			toPlace = ((BPMNEndEvent) objectTo).getInputPlace();
		} 

		cPNProcess.getCpnet().addArc(fromPlace.getId(), transId);
		cPNProcess.getCpnet().addArc(transId, toPlace.getId());
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub
		
	}

}
