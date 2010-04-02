package ee.ut.model.cpn;

import org.apache.xmlbeans.XmlString;

import noNamespace.Arc;
import noNamespace.Trans;


import org.apache.xmlbeans.XmlString;

public abstract class Activity extends Element{

	private String inputPlaceId;
	private String outputPlaceId;
	private String transitionId;
	
	public Activity(CPNet cpnet,String id,String name){
		super(cpnet,id);
		
		inputPlaceId = cpnet.addPlace().getId();
		outputPlaceId = cpnet.addPlace().getId();
		
		Trans trans = cpnet.addTrans();
		trans.addNewText().set(XmlString.Factory.newValue(name));
		transitionId = trans.getId();
		
		cpnet.addArc(inputPlaceId, transitionId);
		cpnet.addArc(transitionId, outputPlaceId);
	}
	
	public String getInputPlaceId() {
		return inputPlaceId;
	}

	public String getOutputPlaceId() {
		return outputPlaceId;
	}

	
}
