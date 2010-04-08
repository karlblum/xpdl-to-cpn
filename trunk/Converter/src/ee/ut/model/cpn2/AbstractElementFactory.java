package ee.ut.model.cpn2;

public interface AbstractElementFactory {

	Object create(Object obj, CPNet cpnet, String id);

}
