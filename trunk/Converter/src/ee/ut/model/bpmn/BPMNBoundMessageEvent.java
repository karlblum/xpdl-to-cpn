package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNBoundMessageEvent extends BPMNElement {

	private String outputPlaceId;
	private int percentage; // how frequently this event will happen
	private String taskId;
	private String inputPlaceId;
	private String delayArcId;

	public BPMNBoundMessageEvent(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);

		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);

		inputPlaceId = cPNProcess.getCpnet().addPlace(elementName + "IN")
				.getId();

		outputPlaceId = cPNProcess.getCpnet().addPlace(elementName + "OUT")
				.getId();

		String t = cPNProcess.getCpnet().addTrans().getId();

		cPNProcess.getCpnet().addArc(inputPlaceId, t);
		delayArcId = cPNProcess.getCpnet().addArc(t, outputPlaceId).getId();

		taskId = elementParser.getBoundaryEventTaskId(obj);
		BPMNTask2 task = (BPMNTask2) cPNProcess.getElement(taskId);
		task.addBounMessageEvent(this);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		int probability = simDataParser
				.getBoundMessageEventProbability(elementId);
		BPMNTask2 task = (BPMNTask2) cPNProcess.getElement(taskId);
		task.setBoundMessageEventProbability(elementId, probability);

		int i = task.getBoundTimer();
		if (i > 0) {
			cPNProcess.getCpnet().setArcAnnot(delayArcId,
					"@+round(uniform(0.0," + i + ".0))");
		}

	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

	public int getPercentage() {
		return percentage;
	}

	public Place getInputPlace() {
		return cPNProcess.getCpnet().getPlace(inputPlaceId);
	}
}
