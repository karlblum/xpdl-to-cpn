package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ParserHelper;
import ee.ut.model.bpmn.BPMNStartEvent;

public class BPMNStartEventFactory extends AbstractElementFactory {

	public BPMNStartEventFactory(CPNProcess cPNProcess,
			ParserHelper parserHelper) {
		super(cPNProcess, parserHelper);
	}

	@Override
	public Object create(Object obj) {
		return new BPMNStartEvent(cPNProcess, obj, parserHelper);
	}
}
