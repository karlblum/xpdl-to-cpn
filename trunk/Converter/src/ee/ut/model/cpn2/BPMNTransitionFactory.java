package ee.ut.model.cpn2;

public class BPMNTransitionFactory extends AbstractElementFactory {

	public BPMNTransitionFactory(Process process) {
		super(process);
	}

	@Override
	public Object create(Object obj) {
		return new BPMNTransition(process, obj);
	}

}
