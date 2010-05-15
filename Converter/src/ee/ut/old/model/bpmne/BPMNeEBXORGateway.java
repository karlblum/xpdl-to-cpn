package ee.ut.old.model.bpmne;

import noNamespace.Page;
import noNamespace.Place;

import org.apache.xmlbeans.XmlObject;

public class BPMNeEBXORGateway extends BPMNeXORGateway implements BPMNeGateway {

	public BPMNeEBXORGateway(Page page, String name, GWType type,
			XmlObject color, XmlObject variable) {
		super(page, name, type, color, variable);
	}

	@Override
	public Place addExitPlace(String to) {
		return splittingPlace;
	}
}
