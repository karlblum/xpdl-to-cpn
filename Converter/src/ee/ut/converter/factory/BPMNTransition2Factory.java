package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNTransition;
import ee.ut.model.bpmn.BPMNTransition2;

public class BPMNTransition2Factory extends AbstractElementFactory {

	public BPMNTransition2Factory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	@Override
	public Element create(Object obj) {
		return new BPMNTransition2(cPNProcess, obj, elementParser);
	}

}
