package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNBoundTimerEvent extends BPMNElement {
	private String taskId;
	private String outputPlaceId;

	public BPMNBoundTimerEvent(BProcess pr, Parser p, Object o) throws Exception {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);
		taskId = parser.getElementParser().getBoundaryEventTaskId(o);

		BPMNTask task = (BPMNTask) process.getElement(taskId);
		String placeId = task.getBoundTimerPlaceId();
		String transId = process.getCpnet().addTrans(elementName + " EVENT")
				.getId();
		outputPlaceId = process.getCpnet().addPlace(elementName + " OUT")
				.getId();
		process.getCpnet().addArc(placeId, transId);
		process.getCpnet().addArc(transId, outputPlaceId);

		int timer = parser.getElementParser().getEventTimer(o);
		task = (BPMNTask) process.getElement(taskId);
		task.setBoundTimer(timer);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

	}

	public Place getOutputPlace() {
		return process.getCpnet().getPlace(outputPlaceId);
	}

	@Override
	public String getInputPlaceId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return outputPlaceId;
	}

}
