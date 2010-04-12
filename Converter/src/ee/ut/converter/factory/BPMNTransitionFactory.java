package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.model.bpmn.BPMNTransition;
import ee.ut.model.xpdl2.Transition;

public class BPMNTransitionFactory extends AbstractElementFactory {

	public BPMNTransitionFactory(CPNProcess cPNProcess) {
		super(cPNProcess);
	}

	@Override
	public Object create(Object obj) {
		return new BPMNTransition(cPNProcess, (Transition) obj);
	}

}
