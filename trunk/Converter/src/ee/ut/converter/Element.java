package ee.ut.converter;

import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public abstract class Element {

	protected Parser parser;
	protected BProcess process;
	protected String elementId;
	protected String elementName;

	public Element(Parser p, BProcess pr) {
		parser = p;
		process = pr;
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

	public String getName() {
		return elementName;
	}

	public abstract void addSimulationData(SimDataParser simDataParser);

	public abstract String getInputPlaceId();

	public abstract String getOutputPlaceId(String ref) throws Exception;
}
