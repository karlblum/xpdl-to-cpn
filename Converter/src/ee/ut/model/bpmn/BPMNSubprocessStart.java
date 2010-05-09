package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessStart extends BPMNElement {

	private String startPlaceId;

	public BPMNSubprocessStart(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);

		startPlaceId = cPNProcess.getCpnet().addPlace(elementName).getId();
		String parentProcessId = elementParser.getSubprocessId(obj);

		boolean connectedToParent = false;

		//TODO: This is hack at the moment
		for (Object o : cPNProcess.getElelments().values()) {
			if (o instanceof BPMNSubprocess
					&& ((BPMNSubprocess) o).getSubProcessId().equals(
							parentProcessId)) {
				((BPMNSubprocess) o).setInputPlace(startPlaceId);
				connectedToParent = true;
			}
		}

		if (connectedToParent) {
			System.out.println("Start event parent connected");
		} else {
			System.out.println("Start event parent connection failed");
		}
		//END TODO:
	}

	public Place getInputPlace() {
		return cPNProcess.getCpnet().getPlace(startPlaceId);
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(startPlaceId);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}
}
