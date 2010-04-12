package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.model.bpmn.BPMNGateway;

public class BPMNGatewayFactory extends AbstractElementFactory {

	public BPMNGatewayFactory(CPNProcess cPNProcess) {
		super(cPNProcess);
	}

	@Override
	Object create(Object obj) {
		return new BPMNGateway(cPNProcess, obj);
	}

}
