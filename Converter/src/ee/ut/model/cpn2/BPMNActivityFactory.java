package ee.ut.model.cpn2;

public class BPMNActivityFactory implements AbstractElementFactory {

	@Override
	public Object create(Object obj, CPNet cpnet, String id) {
		return new BPMNActivity(cpnet, id);
	}

}
