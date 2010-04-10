package ee.ut.model.cpn2;

import ee.ut.model.xpdl2.Transition;

public class BPMNTransitionFactory extends AbstractElementFactory {

	public BPMNTransitionFactory(Process process) {
		super(process);
	}

	@Override
	public Object create(Object obj) {
		return new BPMNTransition(process, (Transition) obj);
	}

}
