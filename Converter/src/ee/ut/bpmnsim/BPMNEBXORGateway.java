package ee.ut.bpmnsim;

import org.apache.xmlbeans.XmlObject;
import noNamespace.Page;
import noNamespace.Place;

public class BPMNEBXORGateway extends BPMNXORGateway implements BPMNGateway {
	
	public BPMNEBXORGateway(Page page, String name, GWType type, XmlObject color, XmlObject variable) {
		super(page, name, type, color, variable);
	}

	public Place addExitPlace(String to) {
		return splittingPlace;
	}
}
