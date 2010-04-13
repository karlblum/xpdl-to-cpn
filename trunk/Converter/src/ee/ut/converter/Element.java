package ee.ut.converter;

import ee.ut.converter.parser.SimDataParser;

public interface Element {

	public String getId();

	public void addSimulationData(SimDataParser simDataParser);
}
