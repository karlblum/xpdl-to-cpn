package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessStart extends BPMNElement {

	private String startPID;
	private String exceptionTID;
	private String outputPID;
	

	public BPMNSubprocessStart(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		startPID = process.getCpnet().addPlace(elementName).getId();
		exceptionTID = process.getCpnet().addTrans(elementName + "EXCEPTION_INPUT").getId();
		outputPID = process.getCpnet().addPlace(elementName).getId();
		process.getCpnet().addArc(startPID, exceptionTID);
		process.getCpnet().addArc(exceptionTID, outputPID);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

	}

	@Override
	public String getInputPID() {
		return startPID;
	}

	@Override
	public String getOutputPID(String ref) {
		return outputPID;
	}

	@Override
	public String getOutputPID() {
		return outputPID;
	}
	
	public String getExceptionTID(){
		return exceptionTID;
	}

}
