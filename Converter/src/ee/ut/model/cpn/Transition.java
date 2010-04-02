package ee.ut.model.cpn;


public abstract class Transition extends Element{

	
	public Transition(CPNet cpnet, String id, String sourceActivityId, String targetActivityId){
		super(cpnet, id);
		
		String transitionId = cpnet.addTrans().getId();
		cpnet.addArc(sourceActivityId,transitionId).getId();
		cpnet.addArc(transitionId, targetActivityId).getId();
	}
}
