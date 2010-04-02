package ee.ut.model.cpn;

public final class BPMNElementFactory implements AbstractElementFactory {

	public Activity makeActivity(CPNet cpnet, String id, String name){
		return new BPMNActivity(cpnet, id, name);
	}
	
	public Transition makeTransition(CPNet cpnet, String id, String targetActivityId, String sourceActivityId){
		return new BPMNTransition(cpnet, id, sourceActivityId, targetActivityId);
	}
	
	public BPMNGateway makeGateway(CPNet cpnet, String id, String name){
		return new BPMNGateway(cpnet, id, name);
	}
}
