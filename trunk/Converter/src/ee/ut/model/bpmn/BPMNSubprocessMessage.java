package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessMessage extends BPMNElement {

	private String outputPlaceId;

	public BPMNSubprocessMessage(BProcess pr, Parser parser, Object obj) {
		super(parser, pr);
		elementId = parser.getElementParser().getId(obj);
		elementName = parser.getElementParser().getName(obj);

		outputPlaceId = process.getCpnet().addPlace(elementName + "TIMER OUT")
				.getId();
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getInputPID() {
		return outputPlaceId;
	}

	@Override
	public String getOutputPID(String ref) {
		return outputPlaceId;
	}

	@Override
	public String getOutputPID() {
		return outputPlaceId;
	}

	public String getTimeFunction() {
		return "round(uniform(0.0,1000.0))";
	}

}
