package ee.ut.model.cpn2;

import org.apache.xmlbeans.XmlString;

import noNamespace.Trans;

public final class BPMNActivity extends BPMNElement {

	private String inputPlaceId;
	private String outputPlaceId;

	public BPMNActivity(CPNet cpnet, String id) {
		super(cpnet, id);

		Trans t = cpnet.addTrans();
		t.addNewText().set(XmlString.Factory.newValue(id));

		inputPlaceId = cpnet.addPlace().getId();
		outputPlaceId = cpnet.addPlace().getId();

		cpnet.addArc(inputPlaceId, t.getId());
		cpnet.addArc(t.getId(), outputPlaceId);
	}

	public String getInputPlaceId() {
		return inputPlaceId;
	}

	public String getOutputPlaceId() {
		return outputPlaceId;
	}

}
