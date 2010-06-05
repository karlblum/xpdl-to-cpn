package ee.ut.converter.factory;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.model.bpmn.BPMNSubprocessMessage;

public class BPMNSubprocessMessageFactory extends AbstractElementFactory {

	public BPMNSubprocessMessageFactory(Parser p) {
		super(p);
	}

	@Override
	public Element create(BProcess pr, Object obj) {
		return new BPMNSubprocessMessage(pr, parser, obj);
	}
}
