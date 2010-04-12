package ee.ut.old.model.bpmne;

import org.apache.xmlbeans.XmlString;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Code;
import noNamespace.Cond;
import noNamespace.Cpnet;
import noNamespace.Initmark;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Time;
import noNamespace.Trans;
import noNamespace.Type;

public class BPMNeUtil {

	/**
	 * Method adds a CPN Place to a given page
	 * 
	 * @param page
	 *            Where to add a new place
	 * @param name
	 *            Name of the new place
	 * @return
	 */
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

	/**
	 * Method adds a CPN transition to a given page
	 * 
	 * @param page
	 *            Where to add a new transition
	 * @param name
	 *            Name of the new transition
	 * @return
	 */
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

	/**
	 * Method adds an CPN arc from Place to Transition
	 * 
	 * @param page
	 *            The page where to add arc
	 * @param place
	 *            Place from where the arc comes
	 * @param trans
	 *            Transition where the arc goes
	 * @param annot
	 * @return
	 */
	public static Arc createArc(Page page, Place place, Trans trans,
			XmlString annot) {
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

	/**
	 * Method adds an CPN arc from Transition to Place
	 * 
	 * @param page
	 *            The page where to add arc
	 * @param trans
	 *            Transition where the arc comes
	 * @param place
	 *            Place from where the arc goes
	 * @param annot
	 * @return
	 */
	public static Arc createArc(Page page, Trans trans, Place place,
			XmlString annot) {
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

	/**
	 * Makes a new child page (to root)
	 * 
	 * @param name
	 *            Name of the new Page
	 * @return New Page
	 */
	public static Page createChildPage(Cpnet cpnet, String name) {
		Page childpage = cpnet.addNewPage();
		childpage.setId(BPMNeIdGen.createId());
		childpage.addNewPageattr().setName(name);
		return childpage;
	}

}
