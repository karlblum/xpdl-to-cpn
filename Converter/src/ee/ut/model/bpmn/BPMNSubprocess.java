package ee.ut.model.bpmn;

import java.util.ArrayList;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocess extends BPMNElement {

	String startPlaceId;
	String endPlaceId;
	String timerTransitionId;

	private String subProcessId;
	ArrayList<BPMNTask> bpmnTasks = new ArrayList<BPMNTask>();

	public BPMNSubprocess(BProcess pr, Parser p, Object o) throws Exception {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);
		subProcessId = parser.getElementParser().getSubprocessId(o);

		BProcess subProcess = process.createSubprocess(subProcessId);
		parser.parse(subProcess);

		startPlaceId = subProcess.getSource().getInputPlaceId();
		endPlaceId = subProcess.getSource().getOutputPlaceId(null);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

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

	public void addChildTransition(BPMNTask bpmnTask2) {
		bpmnTasks.add(bpmnTask2);
	}

	public void setBoundTimer(BPMNSubprocessTimer bpmnSubprocessTimer) {
		for (BPMNTask task : bpmnTasks) {
			task.addSubprocessSkipper(bpmnSubprocessTimer.getNOKPlaceId(),
					bpmnSubprocessTimer.getOKPlaceId());
		}

		process.getCpnet().addArc(timerTransitionId,
				bpmnSubprocessTimer.getOKPlaceId());
		process.getCpnet().addArc(timerTransitionId,
				bpmnSubprocessTimer.getTimerTokenPlaceId());

	}

	public void setTimerTransitionId(String timerTransitionId) {
		this.timerTransitionId = timerTransitionId;
	}

	@Override
	public String getInputPlaceId() {
		return startPlaceId;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return endPlaceId;
	}

}
