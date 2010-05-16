package ee.ut.converter.factory;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.model.bpmn.BPMNThrowExceptionEvent;

public class BPMNThrowExceptionEventFactory extends AbstractElementFactory {

	public BPMNThrowExceptionEventFactory(Parser p) {
		super(p);
	}

	@Override
	public Element create(BProcess pr, Object obj) throws Exception {
		return new BPMNThrowExceptionEvent(pr, parser, obj);
	}
}
