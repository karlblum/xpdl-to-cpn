package ee.ut.converter;

import ee.ut.converter.parser.SimDataParser;

public abstract class Element {

	protected CPNProcess cPNProcess;
	protected String elementId;
	protected String elementName;

	public String getId() {
		return elementId;
	}

	public abstract void addSimulationData(SimDataParser simDataParser);

	public abstract String getInputPlaceId();

	public abstract String getOutputPlaceId(String ref);
}
