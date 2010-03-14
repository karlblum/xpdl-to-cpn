package ee.ut.bpmnsim;

import org.apache.xmlbeans.XmlString;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Code;
import noNamespace.Cond;
import noNamespace.Initmark;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Time;
import noNamespace.Trans;
import noNamespace.Type;

public class Util {
	public static Place createPlace(Page page, String name) {
		Place p = page.addNewPlace();
		p.setId(IdGen.createId());
		name = name != null && name != "" ? name : p.getId();
		p.addNewText().set(XmlString.Factory.newValue(name));
		
		Type type = p.addNewType();
		type.setId2(IdGen.createId());
		type.addNewText();
		
		Initmark im = p.addNewInitmark();
		im.setId(IdGen.createId());
		im.addNewText();
		
		return p;
	}
	public static Trans createTrans(Page page, String name) {
		Trans t = page.addNewTrans();
		t.setId(IdGen.createId());
		name = name != null && name != "" ? name : t.getId();
		t.addNewText().set(XmlString.Factory.newValue(name));
		
		Cond cond = t.addNewCond();
		cond.setId(IdGen.createId());
		cond.addNewText();
		
		Time time = t.addNewTime();
		time.setId(IdGen.createId());
		time.addNewText();
		
		Code code = t.addNewCode();
		code.setId(IdGen.createId());
		code.addNewText();
		
		return t;
	}
	
	public static Arc createArc(Page page, Place place, Trans trans, XmlString annot) {
		Arc arc = page.addNewArc();
		arc.setId(IdGen.createId());
		arc.setOrientation("PtoT");
		arc.addNewPlaceend().setIdref(place.getId());
		arc.addNewTransend().setIdref(trans.getId());
		
		if (annot != null) {
			Annot a = arc.addNewAnnot();
			a.setId(IdGen.createId());
			a.addNewText().set(annot);
		}
		
		return arc;
	}
	public static Arc createArc(Page page, Trans trans, Place place, XmlString annot) {
		Arc arc = page.addNewArc();
		arc.setId(IdGen.createId());
		arc.setOrientation("TtoP");
		arc.addNewPlaceend().setIdref(place.getId());
		arc.addNewTransend().setIdref(trans.getId());
		
		if (annot != null) {
			Annot a = arc.addNewAnnot();
			a.setId(IdGen.createId());
			a.addNewText().set(annot);
		}
		
		return arc;
	}
}
