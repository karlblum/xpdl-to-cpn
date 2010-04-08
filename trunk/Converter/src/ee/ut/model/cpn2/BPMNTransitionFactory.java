package ee.ut.model.cpn2;

public class BPMNTransitionFactory implements AbstractElementFactory {

	@Override
	public Object create(Object obj, CPNet cpnet, String id) {
		return new BPMNTransition(cpnet, id);
	}

}
