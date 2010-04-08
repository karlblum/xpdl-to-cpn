package ee.ut.model.cpn2;

import ee.ut.model.xpdl2.Transaction;

public final class BPMNFactory implements AbstractElementFactory {

	AbstractElementFactory activityFactory = null;
	AbstractElementFactory transitionFactory = null;

	public void registerActivityFactory(AbstractElementFactory f) {
		this.activityFactory = f;
	}

	public void registerTransitionFactory(AbstractElementFactory f) {
		this.transitionFactory = f;
	}

	@Override
	public Object create(Object obj, CPNet cpnet, String id) {
		if (obj instanceof ee.ut.model.xpdl2.Activity)
			return activityFactory.create(obj, cpnet, id);
		else if (obj instanceof ee.ut.model.xpdl2.Transition)
			return transitionFactory.create(obj, cpnet, id);
		else
			return null;
	}

}
