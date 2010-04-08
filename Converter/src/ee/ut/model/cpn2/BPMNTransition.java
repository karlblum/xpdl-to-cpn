package ee.ut.model.cpn2;

public class BPMNTransition extends BPMNElement {

	String transitionId;

	public BPMNTransition(CPNet cpnet, String elementId) {
		super(cpnet, elementId);

		transitionId = cpnet.addTrans().getId();
	}

	public void setFrom(String outputId) {
		cpnet.addArc(outputId, transitionId);
	}

	public void setTo(String inputId) {

		cpnet.addArc(transitionId, inputId);
	}

}
