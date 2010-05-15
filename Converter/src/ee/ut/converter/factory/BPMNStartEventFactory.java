package ee.ut.converter.factory;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.model.bpmn.BPMNStartEvent;
import ee.ut.model.bpmn.BPMNSubprocessStart;

public class BPMNStartEventFactory extends AbstractElementFactory {

	public BPMNStartEventFactory(Parser p) {
		super(p);
	}

	@Override
	public Element create(BProcess pr, Object obj) throws Exception {
		if (pr.getId().equals("0")) {
			return new BPMNStartEvent(pr, parser, obj);
		} else
			return new BPMNSubprocessStart(pr, parser, obj);
	}
}
