package ee.ut.model.bpmne;

import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Port;
import noNamespace.Trans;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

public class BPMNeANDGateway implements BPMNeGateway {
	private String name;
	private Page page;
	private GWType type;
	private XmlObject color;
	private XmlObject variable;
	private Trans transition;
	
	public BPMNeANDGateway(Page page, String name, GWType type, XmlObject color, XmlObject variable) {
		this.page = page;
		this.name = name;
		this.type = type;
		this.color = color;
		this.variable = variable;
		
		transition = BPMNeUtil.createTrans(page, name);
	}

	public Place addEntryPlace(String from) {
		Place place = BPMNeUtil.createPlace(page, from + "_" + name);
		place.getTypeArray(0).getText().set(color.copy());
		Port inPort = place.addNewPort();
		inPort.setType("In");

		BPMNeUtil.createArc(page, place, transition, (XmlString)variable.copy());
		return place;
	}

	public Place addExitPlace(String to) {
		Place place = BPMNeUtil.createPlace(page, name + "_" + to);
		place.getTypeArray(0).getText().set(color.copy());
		Port inPort = place.addNewPort();
		inPort.setType("Out");
		BPMNeUtil.createArc(page, transition, place, (XmlString)variable.copy());

		return place;
	}
}
