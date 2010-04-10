package ee.ut.model.cpn2;

import ee.ut.model.xpdl2.Transition;

public class BPMNTransition extends BPMNElement {

	String transitionId;

	public BPMNTransition(Process process, Object obj) {
		super(process);

		transitionId = process.getCpnet().addTrans().getId();
		String fromId = ((Transition) obj).getFrom();
		String toId = ((Transition) obj).getTo();


	}

	public void setFrom(String outputId) {
		process.getCpnet().addArc(outputId, transitionId);
	}

	public void setTo(String inputId) {

		process.getCpnet().addArc(transitionId, inputId);
	}

}
