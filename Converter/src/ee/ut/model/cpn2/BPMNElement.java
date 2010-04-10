package ee.ut.model.cpn2;

public abstract class BPMNElement {

	protected Process process;
	private String elementId;

	public BPMNElement(Process process) {
		this.process = process;
	}

	public String getId() {
		return elementId;
	}

	public void setId(String id) {
		elementId = id;
	}

}
