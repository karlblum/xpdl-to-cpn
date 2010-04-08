package ee.ut.model.cpn2;

public final class BPMNFactory implements AbstractElementFactory {

	AbstractElementFactory activityFactory = null;
	AbstractElementFactory transitionFactory = null;

	public void registerActivityFactory(AbstractElementFactory f) {
		this.activityFactory = f;
	}

	public void registerTransitionFactory(AbstractElementFactory f) {
		this.transitionFactory = f;
	}

	// What logic should we have here? Should we have a factory for every BPMN
	// element or for every XPDL element? For example gateway in BPMN is a
	// activity in XPDL.
	@Override
	public Object create(Object obj, CPNet cpnet) {
		if (obj instanceof ee.ut.model.xpdl2.Activity)
			return activityFactory.create(obj, cpnet);
		else if (obj instanceof ee.ut.model.xpdl2.Transition)
			return transitionFactory.create(obj, cpnet);
		else
			return null;
	}

}
