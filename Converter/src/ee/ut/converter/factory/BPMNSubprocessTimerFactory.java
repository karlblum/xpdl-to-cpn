package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNSubprocessTimer;

public class BPMNSubprocessTimerFactory extends AbstractElementFactory {

	public BPMNSubprocessTimerFactory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		super(cPNProcess, elementParser);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Element create(Object obj) throws Exception {
		return new BPMNSubprocessTimer(cPNProcess, obj, elementParser);
	}

}
