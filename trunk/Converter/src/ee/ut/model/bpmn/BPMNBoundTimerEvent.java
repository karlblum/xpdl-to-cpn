package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNBoundTimerEvent extends BPMNElement {
	private String taskId;
	private String outputPlaceId;

	public BPMNBoundTimerEvent(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);
		taskId = elementParser.getBoundaryEventTaskId(obj);

		BPMNTask2 task = (BPMNTask2) cPNProcess.getElement(taskId);
		String placeId = task.getBoundTimerPlaceId();
		String transId = cPNProcess.getCpnet().addTrans(elementName + " EVENT")
				.getId();
		outputPlaceId = cPNProcess.getCpnet().addPlace(elementName + " OUT")
				.getId();
		cPNProcess.getCpnet().addArc(placeId, transId);
		cPNProcess.getCpnet().addArc(transId, outputPlaceId);

		int timer = elementParser.getEventTimer(elementId);
		task = (BPMNTask2) cPNProcess.getElement(taskId);
		task.setBoundTimer(timer);

	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

}
