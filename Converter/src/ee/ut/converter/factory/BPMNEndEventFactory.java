package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNEndEvent;
import ee.ut.model.bpmn.BPMNStartEvent;

public class BPMNEndEventFactory extends AbstractElementFactory  {

	public BPMNEndEventFactory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	@Override
	Element create(Object obj) {
		return new BPMNEndEvent(cPNProcess, obj, elementParser);
	}

}
