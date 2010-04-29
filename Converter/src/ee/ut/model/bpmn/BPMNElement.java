package ee.ut.model.bpmn;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;

public abstract class BPMNElement implements Element {

	protected CPNProcess cPNProcess;
	protected String elementId;
	protected String elementName;

	public static final int TASK = 0;
	public static final int GATEWAY = 1;
	public static final int START = 2;
	public static final int END = 3;
	public static final int TRANSITION = 4;
	public static final int EVENT = 5;
	public static final int BOUND_EVENT = 6;

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
}