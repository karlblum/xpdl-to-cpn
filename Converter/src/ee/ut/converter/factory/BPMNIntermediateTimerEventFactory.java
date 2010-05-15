package ee.ut.converter.factory;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.model.bpmn.BPMNIntermediateTimerEvent;

public class BPMNIntermediateTimerEventFactory extends AbstractElementFactory {

	public BPMNIntermediateTimerEventFactory(Parser p) {
		super(p);
	}

	@Override
	public Element create(BProcess pr, Object obj) throws Exception {
		return new BPMNIntermediateTimerEvent(pr, parser, obj);
	}

}
