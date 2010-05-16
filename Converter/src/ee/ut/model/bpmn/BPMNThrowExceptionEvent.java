package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNThrowExceptionEvent extends BPMNElement {

	String ioID;

	public BPMNThrowExceptionEvent(BProcess pr, Parser parser, Object o) {
		super(parser, pr);
		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);
		ioID = process.getCpnet().addPlace(elementName + "THROW EXCEPTION")
				.getId();
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInputPlaceId() {
		return ioID;
	}

	@Override
	public String getOutputPlaceId(String ref) throws Exception {
		return ioID;
	}
}
