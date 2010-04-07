package ee.ut.model.cpn;

public class BPMNTransitionFactory implements AbstractElementFactory {

	@Override
	public Object create(Object obj, CPNet cpnet, String id) {
		BPMNActivity a = new BPMNActivity(cpnet, id, id);
		return a;
		
	}

}
