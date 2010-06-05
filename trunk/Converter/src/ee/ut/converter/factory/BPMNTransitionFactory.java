package ee.ut.converter.factory;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.model.bpmn.BPMNTransition;

public class BPMNTransitionFactory extends AbstractElementFactory {

	public BPMNTransitionFactory(Parser p) {
		super(p);
	}

	@Override
	public Element create(BProcess pr, Object obj) {
		return new BPMNTransition(pr, parser, obj);
	}

}
