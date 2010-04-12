package ee.ut.model.bpmn;

import java.util.ArrayList;

import noNamespace.Place;
import noNamespace.Subst;
import noNamespace.Trans;

import org.apache.xmlbeans.XmlString;

import ee.ut.converter.CPNProcess;
import ee.ut.model.xpdl2.Activity;

public final class BPMNTask extends BPMNElement {

	private ArrayList<String> inputPlaceIds = new ArrayList<String>();
	private String midInputPlaceId;
	private String outputPlaceId;
	private String transitionId;

	public BPMNTask(CPNProcess cPNProcess, Object o) {
		super(cPNProcess);

		Activity xpdlActivity = ((Activity) o);
		this.setId(xpdlActivity.getId());

		// We assume that we only need a transition, because all the inputs and
		// outputs can be generated dynamically.
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

		// if (type == ActivityType.START) {
		if (false) {
			Subst subst = cPNProcess.getCpnet().addSubst(trans, "PAGE_GENERATOR");
			subst.setPortsock(String.format("(%s,%s)", "ID1264234111", pOut
					.getId()));

		} else {
			// This will be the mid-input place where we add input connections
			// to
			Place pMidIn = cPNProcess.getCpnet().addPlace();

			midInputPlaceId = pMidIn.getId();
			cPNProcess.getCpnet().addArc(pMidIn.getId(), transitionId);
		}

	}

	/**
	 * Method generates an input place with an exclusive join to the task
	 * 
	 * @return input place for the task
	 */
	public Place makeInputPlace() {
		Place p = cPNProcess.getCpnet().addPlace();
		inputPlaceIds.add(p.getId());

		// TODO: if a token is coming from two inputs, then it generates 2x
		// output!
		Trans trans = cPNProcess.getCpnet().addTrans("XOR_JOIN");

		// Here we connect the input to the mid-input place for Exclusive join
		cPNProcess.getCpnet().addArc(p.getId(), trans.getId());
		cPNProcess.getCpnet().addArc(trans.getId(), midInputPlaceId);

		return p;
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

}
