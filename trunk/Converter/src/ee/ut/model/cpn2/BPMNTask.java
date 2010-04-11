package ee.ut.model.cpn2;

import java.util.ArrayList;

import org.apache.xmlbeans.XmlString;

import ee.ut.converter.CPNConverter.ActivityType;
import ee.ut.model.bpmne.BPMNeIdGen;
import ee.ut.model.bpmne.BPMNeUtil;
import ee.ut.model.xpdl2.Activity;

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



		if(type == ActivityType.START){
			Page generatorPage = process.getCpnet().getPage("PAGE_GENERATOR");
		
			Subst subst = trans.addNewSubst();
			subst.setSubpage("PAGE_GENERATOR");
			Subpageinfo subpageinfo = subst.addNewSubpageinfo();
			subpageinfo.setId(BPMNeIdGen.createId());
			
			
			Instance rootInstance = process.getCpnet().getRootInstance();			
			Instance i = rootInstance.addNewInstance();
			i.setId(BPMNeIdGen.createId());
			i.setTrans(transitionId);
			
			/*
			outputPlace = BPMNeUtil.createPlace(page, "new case");
			outputPlace.addNewPort().setType("Out");
			outputPlace.getTypeArray()[0].getText().set(caseType.copy());
			
			
			//TODO: THIS DOES NOT SEEM TO WORK!
			transition.getSubst().setPortsock(String.format("(%s,%s)","PAGE_GENERATOR", outputPlace.getId()));
*/
			
			
		} else {
			// This will be the mid-input place where we add input connections to
			Place pMidIn = process.getCpnet().addPlace();
			pMidIn.getTypeArray()[0].getText().set(
					XmlString.Factory.newValue(process.getCpnet()
							.getFlowObjectType()));
			midInputPlaceId = pMidIn.getId();
			process.getCpnet().addArc(pMidIn.getId(), transitionId);
		}
		
		// Activity can have only one output place, because it is like an
		// inclusive gateway
		Place pOut = process.getCpnet().addPlace();
		pOut.getTypeArray()[0].getText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectType()));
		outputPlaceId = pOut.getId();
		process.getCpnet().addArc(transitionId, pOut.getId());

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
		process.getCpnet().addArc(p.getId(), trans.getId());
		process.getCpnet().addArc(trans.getId(), midInputPlaceId);

		return p;
	}

	public Place getOutputPlace() {
		return process.getCpnet().getPlace(outputPlaceId);
	}

}
