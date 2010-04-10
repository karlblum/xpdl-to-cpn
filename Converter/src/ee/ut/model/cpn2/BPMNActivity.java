package ee.ut.model.cpn2;

import java.util.ArrayList;

import org.apache.xmlbeans.XmlString;

import ee.ut.model.xpdl2.Activity;

import noNamespace.Place;
import noNamespace.Trans;

public final class BPMNActivity extends BPMNElement {

	private ArrayList<String> inputPlaceIds = new ArrayList<String>();
	private ArrayList<String> outputPlaceIds = new ArrayList<String>();
	private String transitionId;

	public BPMNActivity(Process process, Object o) {
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

		// TODO:If this acctivity has start event, then we have to attach a
		// generator

	}

	public Place makeInputPlace() {
		Place p = process.getCpnet().addPlace();
		p.getTypeArray()[0].getText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectType()));
		inputPlaceIds.add(p.getId());
		process.getCpnet().addArc(p.getId(), transitionId);
		return p;
	}

	public Place makeOutputPlace() {
		Place p = process.getCpnet().addPlace();
		p.getTypeArray()[0].getText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectType()));
		outputPlaceIds.add(p.getId());
		process.getCpnet().addArc(transitionId, p.getId());
		return p;
	}

}
