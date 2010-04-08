package ee.ut.model.cpn2;

public class BPMNTransitionFactory implements AbstractElementFactory {

	@Override
	public Object create(Object obj, CPNet cpnet) {
		return new BPMNTransition(cpnet, obj);
	}

}
