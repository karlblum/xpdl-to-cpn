package ee.ut.model.cpn;

public interface AbstractElementFactory {

	Object create(Object obj, CPNet cpnet, String id);

}
