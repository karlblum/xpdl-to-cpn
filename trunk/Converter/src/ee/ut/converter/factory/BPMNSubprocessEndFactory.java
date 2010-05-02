package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNSubprocessEnd;

public class BPMNSubprocessEndFactory extends AbstractElementFactory  {

	public BPMNSubprocessEndFactory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	@Override
	Element create(Object obj) throws Exception {
		return new BPMNSubprocessEnd(cPNProcess, obj, elementParser);
	}

}