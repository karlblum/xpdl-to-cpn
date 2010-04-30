package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNBoundMessageEvent extends BPMNElement{

	private String outputPlaceId;
	private int percentage; //how frequently this event will happen
	private String taskId;
	


	public BPMNBoundMessageEvent(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);


		outputPlaceId = cPNProcess.getCpnet().addPlace(elementName)
				.getId();

		taskId = elementParser.getBoundaryEventTaskId(obj);
		BPMNTask2 task = (BPMNTask2) cPNProcess.getElement(taskId);
		task.addBounMessageEvent(this);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		int probability = simDataParser.getBoundMessageEventProbability(elementId);
		BPMNTask2 task = (BPMNTask2) cPNProcess.getElement(taskId);
		task.setBoundMessageEventProbability(elementId,probability);
		
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

	public int getPercentage() {
		return percentage;
	}
}
