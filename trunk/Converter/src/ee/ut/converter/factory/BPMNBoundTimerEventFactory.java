package ee.ut.converter.factory;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.model.bpmn.BPMNBoundTimerEvent;

public class BPMNBoundTimerEventFactory extends AbstractElementFactory {

	public BPMNBoundTimerEventFactory(Parser p) {
		super(p);
	}

	@Override
	public Element create(BProcess pr, Object obj) {
		return new BPMNBoundTimerEvent(pr, parser, obj);
	}

}
