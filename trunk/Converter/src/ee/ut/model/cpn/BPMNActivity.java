package ee.ut.model.cpn;

import org.apache.xmlbeans.XmlString;

import noNamespace.Place;
import noNamespace.Trans;


public final class BPMNActivity extends Activity{

	public BPMNActivity(CPNet cpnet, String id, String name) {
		super(cpnet, id, name);
		
		Trans t = cpnet.addTrans();
		Place placeIn = cpnet.addPlace();
		inputPlaceIds.add(placeIn.getId());
		t.addNewText().set(XmlString.Factory.newValue(name));
		
		Place placeOut = cpnet.addPlace();
		outputPlaceIds.add(placeOut.getId());
		
		cpnet.addArc(placeIn.getId(), t.getId());
		cpnet.addArc(t.getId(), placeOut.getId());
	}
	
	
	
}
