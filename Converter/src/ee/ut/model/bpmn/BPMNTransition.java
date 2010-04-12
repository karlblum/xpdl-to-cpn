package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ParserHelper;

public class BPMNTransition extends BPMNElement {

	public BPMNTransition(CPNProcess cPNProcess, Object object,
			ParserHelper parserHelper) {
		super(cPNProcess);

		String transId = cPNProcess.getCpnet().addTrans().getId();

		Place toPlace = null;
		Place fromPlace = null;

		Object objectFrom = cPNProcess.getElement(parserHelper
				.getTransitionFrom(object));
		Object objectTo = cPNProcess.getElement(parserHelper
				.getTransitionTo(object));

		// TODO: We should extract some parent class from all of these objects
		if (objectFrom instanceof BPMNTask) {
			fromPlace = ((BPMNTask) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNGateway) {
			fromPlace = ((BPMNGateway) objectFrom).makeOutputPlace();
		} else if (objectFrom instanceof BPMNStartEvent) {
			fromPlace = ((BPMNStartEvent) objectFrom).getOutputPlace();
		}

		if (objectTo instanceof BPMNTask) {
			toPlace = ((BPMNTask) objectTo).makeInputPlace();
		} else if (objectTo instanceof BPMNGateway) {
			toPlace = ((BPMNGateway) objectTo).makeInputPlace();
		}

		cPNProcess.getCpnet().addArc(fromPlace.getId(), transId);
		cPNProcess.getCpnet().addArc(transId, toPlace.getId());
	}

}
