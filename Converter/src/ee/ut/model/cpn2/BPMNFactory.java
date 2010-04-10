package ee.ut.model.cpn2;

public final class BPMNFactory extends AbstractElementFactory {

	public BPMNFactory(CPNet cpnet, Process process) {
		super(cpnet, process);
	}

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
	public Object create(Object obj) {
		if (obj instanceof ee.ut.model.xpdl2.Activity)
			return activityFactory.create(obj);
		else if (obj instanceof ee.ut.model.xpdl2.Transition)
			return transitionFactory.create(obj);
		else
			return null;
	}

}
