package ee.ut.converter.factory;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.model.bpmn.BPMNEndEvent;

public class BPMNEndEventFactory extends AbstractElementFactory {

	public BPMNEndEventFactory(Parser p) {
		super(p);
	}

	@Override
	public Element create(BProcess pr, Object obj) {
		return new BPMNEndEvent(pr, parser, obj);
	}

}
