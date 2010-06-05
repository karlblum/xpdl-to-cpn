package ee.ut.converter.factory;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.model.bpmn.BPMNBoundMessageEvent;

public class BPMNBoundMessageEventFactory extends AbstractElementFactory {

	public BPMNBoundMessageEventFactory(Parser p) {
		super(p);
	}

	@Override
	public Element create(BProcess pr, Object obj) {
		return new BPMNBoundMessageEvent(pr, parser, obj);
	}

}
