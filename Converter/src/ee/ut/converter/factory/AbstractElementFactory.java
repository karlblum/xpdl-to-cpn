package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;

public abstract class AbstractElementFactory {

	protected CPNProcess cPNProcess;
	protected ElementParser elementParser;

	public AbstractElementFactory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		this.cPNProcess = cPNProcess;
		this.elementParser = elementParser;
	}

	abstract Element create(Object obj) throws Exception;

}
