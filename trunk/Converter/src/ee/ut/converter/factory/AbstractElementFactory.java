package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ParserHelper;

public abstract class AbstractElementFactory {

	protected CPNProcess cPNProcess;
	protected ParserHelper parserHelper;

	public AbstractElementFactory(CPNProcess cPNProcess,
			ParserHelper parserHelper) {
		this.cPNProcess = cPNProcess;
		this.parserHelper = parserHelper;
	}

	abstract Object create(Object obj);

}
