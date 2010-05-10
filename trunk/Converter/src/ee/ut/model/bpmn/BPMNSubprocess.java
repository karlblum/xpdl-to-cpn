package ee.ut.model.bpmn;

import java.util.ArrayList;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocess extends BPMNElement {

	String startPlaceId;
	String endPlaceId;
	String timerTransitionId;

	private String subProcessId;
	ArrayList<BPMNTask2> bpmnTasks = new ArrayList<BPMNTask2>();

	public BPMNSubprocess(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);
		subProcessId = elementParser.getSubprocessId(obj);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

	public Place getInputPlace() {
		return cPNProcess.getCpnet().getPlace(startPlaceId);
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(endPlaceId);
	}

	public void setOutputPlace(String id) {
		endPlaceId = id;
	}

	public void setInputPlace(String id) {
		startPlaceId = id;
	}

	public String getSubProcessId() {
		return subProcessId;
	}

	public void addChildTransition(BPMNTask2 bpmnTask2) {
		bpmnTasks.add(bpmnTask2);
	}

	public void setBoundTimer(BPMNSubprocessTimer bpmnSubprocessTimer) {
		for (BPMNTask2 task : bpmnTasks) {
			task.addSubprocessSkipper(bpmnSubprocessTimer.getNOKPlaceId(),
					bpmnSubprocessTimer.getOKPlaceId());
		}

		cPNProcess.getCpnet().addArc(timerTransitionId,
				bpmnSubprocessTimer.getOKPlaceId());
		cPNProcess.getCpnet().addArc(timerTransitionId,
				bpmnSubprocessTimer.getTimerTokenPlaceId());

	}

	public void setTimerTransitionId(String timerTransitionId) {
		this.timerTransitionId = timerTransitionId;
	}

}
