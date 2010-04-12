package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;

public abstract class AbstractElementFactory {

	protected CPNProcess cPNProcess;

	public AbstractElementFactory(CPNProcess cPNProcess) {
		this.cPNProcess = cPNProcess;
	}

	abstract Object create(Object obj);

}
