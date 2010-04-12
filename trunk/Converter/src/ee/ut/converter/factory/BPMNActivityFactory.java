package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.model.bpmn.BPMNTask;

public class BPMNActivityFactory extends AbstractElementFactory {

	public BPMNActivityFactory(CPNProcess cPNProcess) {
		super(cPNProcess);
	}

	@Override
	public Object create(Object obj) {
		return new BPMNTask(cPNProcess, obj);
	}

}
