package ee.ut.model.cpn;


public class BPMNTransition extends Transition{
	
	private String somethingBPMNSpecific;
	
	public BPMNTransition(CPNet cpnet, String id, String sourceActivityId, String targetActivityId){
		super(cpnet,id,sourceActivityId,targetActivityId);
	}
}
