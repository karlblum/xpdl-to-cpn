package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ParserHelper;
import ee.ut.model.bpmn.BPMNTask;

public class BPMNTaskFactory extends AbstractElementFactory {

	public BPMNTaskFactory(CPNProcess cPNProcess, ParserHelper parserHelper) {
		super(cPNProcess, parserHelper);
	}

	@Override
	public Object create(Object obj) {
		return new BPMNTask(cPNProcess, obj, parserHelper);
	}

}
