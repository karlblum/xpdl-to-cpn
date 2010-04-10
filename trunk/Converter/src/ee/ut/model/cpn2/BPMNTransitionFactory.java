package ee.ut.model.cpn2;

public class BPMNTransitionFactory extends AbstractElementFactory {

	public BPMNTransitionFactory(CPNet cpnet, Process process) {
		super(cpnet, process);
	}

	@Override
	public Object create(Object obj) {
		return new BPMNTransition(cpnet, obj);
	}

}
