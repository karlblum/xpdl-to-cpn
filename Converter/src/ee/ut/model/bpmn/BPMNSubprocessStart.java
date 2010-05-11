package ee.ut.model.bpmn;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessStart extends BPMNElement {

	private String startPlaceId;
	private String outputPlaceId;
	private String timerTransitionId;

	public BPMNSubprocessStart(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);

		startPlaceId = cPNProcess.getCpnet().addPlace(elementName).getId();
		outputPlaceId = cPNProcess.getCpnet().addPlace(elementName).getId();

		timerTransitionId = cPNProcess.getCpnet().addTrans().getId();
		cPNProcess.getCpnet().addArc(startPlaceId, timerTransitionId);
		cPNProcess.getCpnet().addArc(timerTransitionId, outputPlaceId);

		String parentProcessId = elementParser.getSubprocessId(obj);

		boolean connectedToParent = false;

		// TODO: This is hack at the moment
		for (Object o : cPNProcess.getElelments().values()) {
			if (o instanceof BPMNSubprocess
					&& ((BPMNSubprocess) o).getSubProcessId().equals(
							parentProcessId)) {
				((BPMNSubprocess) o).setInputPlace(startPlaceId);
				((BPMNSubprocess) o).setTimerTransitionId(timerTransitionId);
				connectedToParent = true;
			}
		}

		if (connectedToParent) {
			System.out.println("Start event parent connected");
		} else {
			System.out.println("Start event parent connection failed");
		}
		// END TODO:
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInputPlaceId() {
		return startPlaceId;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return outputPlaceId;
	}
}
