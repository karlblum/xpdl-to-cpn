package ee.ut.model.bpmne;

import org.apache.xmlbeans.XmlObject;
import noNamespace.Page;
import noNamespace.Place;

public class BPMNeEBXORGateway extends BPMNeXORGateway implements BPMNeGateway {
	
	public BPMNeEBXORGateway(Page page, String name, GWType type, XmlObject color, XmlObject variable) {
		super(page, name, type, color, variable);
	}

	public Place addExitPlace(String to) {
		return splittingPlace;
	}
}
