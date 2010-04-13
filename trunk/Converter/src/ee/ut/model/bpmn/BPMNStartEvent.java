package ee.ut.model.bpmn;

import noNamespace.Place;
import noNamespace.Subst;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNStartEvent extends BPMNElement {

	private String outputPlaceId;
	private String transitionId;

	public BPMNStartEvent(CPNProcess cPNProcess, Object o,
			ElementParser elementParser) {
		super(cPNProcess);

		elementId = elementParser.getId(o);
		elementName = elementParser.getName(o);

		Trans trans = cPNProcess.getCpnet().addTrans(elementName);
		transitionId = trans.getId();

		// Activity can have only one output place, because it is like an
		// inclusive gateway
		outputPlaceId = cPNProcess.getCpnet().addPlace().getId();
		cPNProcess.getCpnet().addArc(transitionId, outputPlaceId);

		Subst subst = cPNProcess.getCpnet().addSubst(trans, "PAGE_GENERATOR");
		subst.setPortsock(String.format("(%s,%s)", "ID1264234111",
				outputPlaceId)); // TODO: modify the place id in cpnet template
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub
		
	}

}
