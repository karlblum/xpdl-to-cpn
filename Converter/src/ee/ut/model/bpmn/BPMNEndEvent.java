package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNEndEvent extends BPMNElement {

	String endPlaceId;

	public BPMNEndEvent(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		this.endPlaceId = process.getCpnet().addPlace().getId();
		elementId = parser.getElementParser().getId(o);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInputPlaceId() {
		return endPlaceId;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return endPlaceId;
	}

}
