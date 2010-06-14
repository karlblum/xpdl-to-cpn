package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNThrowExceptionEvent extends BPMNElement {

	String inputPID;
	String errorTID;


	public BPMNThrowExceptionEvent(BProcess pr, Parser parser, Object o) {
		super(parser, pr);
		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);
	
		inputPID = process.getCpnet().addPlace(elementName + "ERR_IN")
				.getId();
		errorTID = process.getCpnet().addTrans("ERR").getId();
		process.getCpnet().setTransitionGuard(errorTID, "[#ID c = (#ID (#pr cp))]");
		process.getCpnet().addArc(inputPID, errorTID);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInputPID() {
		return inputPID;
	}

	@Override
	public String getOutputPID(String ref) {
		return null;
	}

	@Override
	public String getOutputPID() {
		return null;
	}
	
	public String getErrorTID(){
		return errorTID;
	}
}
