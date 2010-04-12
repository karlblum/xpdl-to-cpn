package ee.ut.model.cpn2;

import java.util.ArrayList;

import org.apache.xmlbeans.XmlString;

import ee.ut.converter.CPNConverter.ActivityType;
import ee.ut.model.bpmne.BPMNeIdGen;
import ee.ut.model.bpmne.BPMNeUtil;
import ee.ut.model.xpdl2.Activity;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Instance;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Subpageinfo;
import noNamespace.Subst;
import noNamespace.Trans;

public final class BPMNTask extends BPMNElement {

	private ArrayList<String> inputPlaceIds = new ArrayList<String>();
	private String midInputPlaceId;
	private String outputPlaceId;
	private String transitionId;

	public BPMNTask(Process process, Object o,ActivityType type) {
		super(process);

		Activity xpdlActivity = ((Activity) o);
		this.setId(xpdlActivity.getId());

		// We assume that we only need a transition, because all the inputs and
		// outputs can be generated dynamically.
		Trans trans = process.getCpnet().addTrans();

		// Set name
		trans.addNewText().set(
				XmlString.Factory.newValue(xpdlActivity.getName()));
		transitionId = trans.getId();

		
		// Activity can have only one output place, because it is like an
		// inclusive gateway
		Place pOut = process.getCpnet().addPlace();
		pOut.getTypeArray()[0].getText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectType()));
		outputPlaceId = pOut.getId();
		Arc arc = process.getCpnet().addArc(transitionId, pOut.getId());
		Annot annot = arc.addNewAnnot();
		annot.addNewText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectVariable()));


		if(type == ActivityType.START){
			Subst subst = process.getCpnet().addSubst(trans,"PAGE_GENERATOR");
			subst.setPortsock(String.format("(%s,%s)","ID1264234111",pOut.getId()));

		} else {
			// This will be the mid-input place where we add input connections to
			Place pMidIn = process.getCpnet().addPlace();
			pMidIn.getTypeArray()[0].getText().set(
					XmlString.Factory.newValue(process.getCpnet()
							.getFlowObjectType()));
			midInputPlaceId = pMidIn.getId();
			arc = process.getCpnet().addArc(pMidIn.getId(), transitionId);
			annot = arc.addNewAnnot();
			annot.addNewText().set(
					XmlString.Factory.newValue(process.getCpnet()
							.getFlowObjectVariable()));
		}


	}

	/**
	 * Method generates an input place with an exclusive join to the task
	 * 
	 * @return input place for the task
	 */
	public Place makeInputPlace() {
		Place p = process.getCpnet().addPlace();
		p.getTypeArray()[0].getText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectType()));
		inputPlaceIds.add(p.getId());

		// TODO: if a token is coming from two inputs, then it generates 2x
		// output!
		Trans trans = process.getCpnet().addTrans();
		trans.addNewText().set(
				XmlString.Factory.newValue("EXCLUSIVE_JOIN_" + trans.getId()));
		
		// Here we connect the input to the mid-input place for Exclusive join
		Arc arc = process.getCpnet().addArc(p.getId(), trans.getId());
		Annot annot = arc.addNewAnnot();
		annot.addNewText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectVariable()));
		
		arc = process.getCpnet().addArc(trans.getId(), midInputPlaceId);
		annot = arc.addNewAnnot();
		annot.addNewText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectVariable()));

		return p;
	}

	public Place getOutputPlace() {
		return process.getCpnet().getPlace(outputPlaceId);
	}

}
