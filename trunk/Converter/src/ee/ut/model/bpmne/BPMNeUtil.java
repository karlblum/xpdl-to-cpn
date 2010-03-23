package ee.ut.model.bpmne;

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

public class BPMNeUtil {
	public static Place createPlace(Page page, String name) {
		Place p = page.addNewPlace();
		p.setId(BPMNeIdGen.createId());
		name = name != null && name != "" ? name : p.getId();
		p.addNewText().set(XmlString.Factory.newValue(name));
		
		Type type = p.addNewType();
		type.setId2(BPMNeIdGen.createId());
		type.addNewText();
		
		Initmark im = p.addNewInitmark();
		im.setId(BPMNeIdGen.createId());
		im.addNewText();
		
		return p;
	}
	public static Trans createTrans(Page page, String name) {
		Trans t = page.addNewTrans();
		t.setId(BPMNeIdGen.createId());
		name = name != null && name != "" ? name : t.getId();
		t.addNewText().set(XmlString.Factory.newValue(name));
		
		Cond cond = t.addNewCond();
		cond.setId(BPMNeIdGen.createId());
		cond.addNewText();
		
		Time time = t.addNewTime();
		time.setId(BPMNeIdGen.createId());
		time.addNewText();
		
		Code code = t.addNewCode();
		code.setId(BPMNeIdGen.createId());
		code.addNewText();
		
		return t;
	}
	
	public static Arc createArc(Page page, Place place, Trans trans, XmlString annot) {
		Arc arc = page.addNewArc();
		arc.setId(BPMNeIdGen.createId());
		arc.setOrientation("PtoT");
		arc.addNewPlaceend().setIdref(place.getId());
		arc.addNewTransend().setIdref(trans.getId());
		
		if (annot != null) {
			Annot a = arc.addNewAnnot();
			a.setId(BPMNeIdGen.createId());
			a.addNewText().set(annot);
		}
		
		return arc;
	}
	public static Arc createArc(Page page, Trans trans, Place place, XmlString annot) {
		Arc arc = page.addNewArc();
		arc.setId(BPMNeIdGen.createId());
		arc.setOrientation("TtoP");
		arc.addNewPlaceend().setIdref(place.getId());
		arc.addNewTransend().setIdref(trans.getId());
		
		if (annot != null) {
			Annot a = arc.addNewAnnot();
			a.setId(BPMNeIdGen.createId());
			a.addNewText().set(annot);
		}
		
		return arc;
	}
}
