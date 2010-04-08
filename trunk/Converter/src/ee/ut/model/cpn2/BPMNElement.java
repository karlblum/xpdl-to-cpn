package ee.ut.model.cpn2;

public abstract class BPMNElement {

	protected CPNet cpnet;
	private String elementId;

	public BPMNElement(CPNet cpnet, String elementId) {
		this.elementId = elementId;
		this.cpnet = cpnet;
	}

	public String getId() {
		return elementId;
	}

}
