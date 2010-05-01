package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNIntermediateMessageEvent;

public class BPMNIntermediateMessageEventFactory extends AbstractElementFactory {

	public BPMNIntermediateMessageEventFactory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		super(cPNProcess, elementParser);
		// TODO Auto-generated constructor stub
	}

	@Override
	Element create(Object obj) throws Exception {
		return new BPMNIntermediateMessageEvent(cPNProcess, obj, elementParser);
	}

}
