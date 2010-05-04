package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNSubprocessStart;

public class BPMNSubprocessStartFactory extends AbstractElementFactory {

	public BPMNSubprocessStartFactory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	@Override
	public Element create(Object obj) throws Exception {
		return new BPMNSubprocessStart(cPNProcess, obj, elementParser);
	}

}