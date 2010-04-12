package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ParserHelper;
import ee.ut.model.bpmn.BPMNGateway;

public class BPMNGatewayFactory extends AbstractElementFactory {

	public BPMNGatewayFactory(CPNProcess cPNProcess, ParserHelper parserHelper) {
		super(cPNProcess, parserHelper);
	}

	@Override
	Object create(Object obj) {
		return new BPMNGateway(cPNProcess, obj, parserHelper);
	}

}
