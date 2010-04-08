package ee.ut.model.cpn2;

import ee.ut.model.xpdl2.Transition;

public class BPMNTransition extends BPMNElement {

	String transitionId;

	public BPMNTransition(CPNet cpnet, Object obj) {
		super(cpnet);

		transitionId = cpnet.addTrans().getId();
		String fromId = ((Transition) obj).getFrom();
		String toId = ((Transition) obj).getTo();

		// I am in trouble here again... I do not know about the other created
		// BPMN objects and at this point I am not aware of the process
		// instance. I now have input(ID) and output(ID) to connect, but there
		// ID's reffer to BPMN objects... So would it be correct if the BPMN
		// objects had a reference to the BPMNProcess class?
	}

	public void setFrom(String outputId) {
		cpnet.addArc(outputId, transitionId);
	}

	public void setTo(String inputId) {

		cpnet.addArc(transitionId, inputId);
	}

}
