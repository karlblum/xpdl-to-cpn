package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNEvent;

public class BPMNEventFactory extends AbstractElementFactory {

	public BPMNEventFactory(CPNProcess cPNProcess, ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	@Override
	Element create(Object obj) throws Exception {
		return new BPMNEvent(cPNProcess, obj, elementParser);
	}

}
