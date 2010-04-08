package ee.ut.model.cpn2;

public abstract class BPMNElement {

	protected CPNet cpnet;
	private String elementId;

	public BPMNElement(CPNet cpnet) {
		this.cpnet = cpnet;
	}

	public String getId() {
		return elementId;
	}

	public void setId(String id) {
		elementId = id;
	}

}
