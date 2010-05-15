package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessStart extends BPMNElement {

	private String outputPlaceId;

	public BPMNSubprocessStart(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		outputPlaceId = process.getCpnet().addPlace().getId();
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

	}

	@Override
	public String getInputPlaceId() {
		return outputPlaceId;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return outputPlaceId;
	}

}
