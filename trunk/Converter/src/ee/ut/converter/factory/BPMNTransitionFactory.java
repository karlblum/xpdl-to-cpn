package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ParserHelper;
import ee.ut.model.bpmn.BPMNTransition;
import ee.ut.model.xpdl2.Transition;

public class BPMNTransitionFactory extends AbstractElementFactory {

	public BPMNTransitionFactory(CPNProcess cPNProcess,
			ParserHelper parserHelper) {
		super(cPNProcess, parserHelper);
	}

	@Override
	public Object create(Object obj) {
		return new BPMNTransition(cPNProcess, obj,parserHelper);
	}

}
