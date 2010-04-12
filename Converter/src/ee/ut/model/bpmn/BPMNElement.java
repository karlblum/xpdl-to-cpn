package ee.ut.model.bpmn;

import ee.ut.converter.CPNProcess;

public abstract class BPMNElement {

	protected CPNProcess cPNProcess;
	private String elementId;

	public BPMNElement(CPNProcess cPNProcess) {
		this.cPNProcess = cPNProcess;
	}

	public String getId() {
		return elementId;
	}

	public void setId(String id) {
		elementId = id;
	}

	public enum BPMNElementType {
		TASK, GATEWAY, START, END, TRANSITION
	};
}
