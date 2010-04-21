package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNTask2;

public class BPMNTask2Factory extends AbstractElementFactory {

	public BPMNTask2Factory(CPNProcess cPNProcess, ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	@Override
	public Element create(Object obj) {
		return new BPMNTask2(cPNProcess, obj, elementParser);
	}

}