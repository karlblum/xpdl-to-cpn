package ee.ut.model.cpn;

public interface AbstractElementFactory {

	public Activity makeActivity(CPNet cpnet, String id, String name);
	
	public Transition makeTransition(CPNet cpnet, String id, String targetActivityId, String sourceActivityId);
}
