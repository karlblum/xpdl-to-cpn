package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNStartEvent;

public class BPMNStartEventFactory extends AbstractElementFactory {

	public BPMNStartEventFactory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	@Override
	public Element create(Object obj) {
		return new BPMNStartEvent(cPNProcess, obj, elementParser);
	}
}
