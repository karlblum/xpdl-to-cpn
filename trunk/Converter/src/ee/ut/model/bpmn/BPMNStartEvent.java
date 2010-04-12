package ee.ut.model.bpmn;

import java.util.ArrayList;

import noNamespace.Place;
import noNamespace.Subst;
import noNamespace.Trans;

import org.apache.xmlbeans.XmlString;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ParserHelper;
import ee.ut.model.xpdl2.Activity;

public class BPMNStartEvent extends BPMNElement  {

	private String outputPlaceId;
	private String transitionId;

	public BPMNStartEvent(CPNProcess cPNProcess, Object o, ParserHelper parserHelper) {
		super(cPNProcess);

		Activity xpdlActivity = ((Activity) o);
		this.setId(xpdlActivity.getId());


		Trans trans = cPNProcess.getCpnet().addTrans(xpdlActivity.getName());
		transitionId = trans.getId();

		// Activity can have only one output place, because it is like an
		// inclusive gateway
		Place pOut = cPNProcess.getCpnet().addPlace();
		pOut.getTypeArray()[0].getText().set(
				XmlString.Factory.newValue(cPNProcess.getCpnet()
						.getFlowObjectType()));
		outputPlaceId = pOut.getId();
		cPNProcess.getCpnet().addArc(transitionId, pOut.getId());

		
		Subst subst = cPNProcess.getCpnet().addSubst(trans,
				"PAGE_GENERATOR");
		subst.setPortsock(String.format("(%s,%s)", "ID1264234111", pOut
				.getId()));
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}


}
