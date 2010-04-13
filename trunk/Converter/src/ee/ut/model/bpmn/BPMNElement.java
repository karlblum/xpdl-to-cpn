package ee.ut.model.bpmn;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;

public abstract class BPMNElement implements Element{

	protected CPNProcess cPNProcess;
	protected String elementId;
	protected String elementName;

	public BPMNElement(CPNProcess cPNProcess) {
		this.cPNProcess = cPNProcess;
	}

	public String getId() {
		return elementId;
	}

	public void setId(String id) {
		elementId = id;
	}

	public void setName(String name) {
		this.elementName = name;
	}

	public enum BPMNElementType {
		TASK, GATEWAY, START, END, TRANSITION
	};
}
