package ee.ut.model.bpmn;

import java.util.ArrayList;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocess extends BPMNElement {

	private String startPlaceId;
	private String endPlaceId;
	private String timerTransitionId;
	private BProcess subProcess;

	public BPMNSubprocess(BProcess pr, Parser p, Object o) throws Exception {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);
		String pid = parser.getElementParser().getSubprocessId(o);

		subProcess = process.createSubprocess(pid);
		
		//Here we will recursively parse the subprocess.
		parser.parse(subProcess);

		startPlaceId = subProcess.getSource().getInputPlaceId();
		timerTransitionId = ((BPMNSubprocessStart)subProcess.getSource()).getTimerTransitionId();
		endPlaceId = subProcess.getDefaultSink().getOutputPlaceId(null);
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
		return subProcess.getId();
	}


	public void setBoundTimer(BPMNSubprocessTimer bpmnSubprocessTimer) throws Exception {
		ArrayList<Element> lastTasks = subProcess.getLastBeforeSink();
		for (Element e : subProcess.getElements().values()) {
			if(e instanceof BPMNTask){
				BPMNTask task = (BPMNTask)e;
				if(!lastTasks.contains(task)){
				task.addSubprocessSkipper(bpmnSubprocessTimer.getNOKPlaceId(),
						bpmnSubprocessTimer.getOKPlaceId());
				} else {
					System.out.println("LAST TASK: " + task.getName());
					task.addLastSubprocessSkipper(bpmnSubprocessTimer.getNOKPlaceId(),
							bpmnSubprocessTimer.getOKPlaceId(),bpmnSubprocessTimer.getOutputPlaceId(null));
				}
			}
		}

		process.getCpnet().addArc(timerTransitionId,
				bpmnSubprocessTimer.getOKPlaceId());
		process.getCpnet().addArc(timerTransitionId,
				bpmnSubprocessTimer.getTimerTokenPlaceId());

	}

	@Override
	public String getInputPlaceId() {
		return startPlaceId;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return endPlaceId;
	}

	public void addExceptionHandler(String handlerId) throws Exception {
			for(Element e: subProcess.getSinks()){
				if(e instanceof BPMNThrowExceptionEvent){
					String t = process.getCpnet().addTrans().getId();
					process.getCpnet().addArc(e.getOutputPlaceId(null), t);
					process.getCpnet().addArc(t, handlerId);
				}
			}
	}

}
