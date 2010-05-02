package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNSubprocess;

public class BPMNSubprocessFactory extends AbstractElementFactory {

	public BPMNSubprocessFactory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	@Override
	Element create(Object obj) throws Exception {
		return new BPMNSubprocess(cPNProcess, obj, elementParser);
	}

}
