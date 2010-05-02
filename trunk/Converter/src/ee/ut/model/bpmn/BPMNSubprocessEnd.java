package ee.ut.model.bpmn;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocessEnd extends BPMNElement {

	private String endPlaceId;

	public BPMNSubprocessEnd(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);
		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);

		endPlaceId = cPNProcess.getCpnet().addPlace(elementName).getId();

		boolean connectedToParent = false;

		String parentProcessId = elementParser.getSubprocessId(obj);
		for (Object o : cPNProcess.getElelments().values()) {
			if (o instanceof BPMNSubprocess
					&& ((BPMNSubprocess) o).getSubProcessId().equals(
							parentProcessId)) {
				((BPMNSubprocess) o).setOutputPlace(endPlaceId);
				connectedToParent = true;
			}
		}

		if (connectedToParent) {
			System.out.println("Parent connected");
		} else {
			System.out.println("Parent connection failed");
		}
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub

	}

	public Place getInputPlace() {
		return cPNProcess.getCpnet().getPlace(endPlaceId);
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(endPlaceId);
	}

}
