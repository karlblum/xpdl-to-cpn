package ee.ut.converter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Code;
import noNamespace.Cond;
import noNamespace.Cpnet;
import noNamespace.Instance;
import noNamespace.Ml;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Subpageinfo;
import noNamespace.Subst;
import noNamespace.Time;
import noNamespace.Trans;
import noNamespace.Type;
import noNamespace.WorkspaceElementsDocument;

import org.apache.xmlbeans.XmlString;

import example.ExLucianoWrapper;

/**
 * @author karl
 * 
 */
public class CPNet {

	private WorkspaceElementsDocument cpnWorkspace;
	private Cpnet cpnet;
	private Page page;
	private HashMap<String, Place> places = new HashMap<String, Place>();
	private HashMap<String, Arc> arcs = new HashMap<String, Arc>();
	private HashMap<String, Trans> transitions = new HashMap<String, Trans>();
	private int currentId = 1;

	private String flowObjectType = "CASE";
	private String flowObjectVariable = "c";

	public CPNet() {
		File blankCPN = new File("./files/cpn/blank2.cpn");

		try {
			cpnWorkspace = WorkspaceElementsDocument.Factory.parse(blankCPN);
		} catch (Exception e) {
			e.printStackTrace();
		}

		cpnet = cpnWorkspace.getWorkspaceElements().getCpnet();
		page = cpnet.getPageArray()[0];
	}

	public Place addPlace() {
		return addPlace(flowObjectType, "");
	}

	public Place addPlace(String name) {
		return addPlace(flowObjectType, name);
	}

	/**
	 * Generates a new Place to the root page
	 * 
	 * @param placeType
	 *            Place type
	 * @param name
	 *            Place name
	 * @return
	 */
	public Place addPlace(String placeType, String name) {
		String id = createId();
		Place place = page.addNewPlace();
		place.setId(id);
		places.put(id, place);

		Type type = place.addNewType();
		type.addNewText().set(XmlString.Factory.newValue(placeType));

		name = name != null && name != "" ? name + "_" + id : id;
		place.addNewText().set(XmlString.Factory.newValue(name));

		return place;
	}

	/**
	 * Override method to generate a new transition to the process page with
	 * name = id
	 * 
	 * @return Created transition
	 */
	public Trans addTrans() {
		return addTrans("");
	}

	/**
	 * Creates a new transition to the process page.
	 * 
	 * @param name
	 *            Transition name
	 * @return Created transition
	 */
	public Trans addTrans(String name) {
		String id = createId();
		Trans trans = page.addNewTrans();
		trans.setId(id);
		name = name != null && name != "" ? name + "_" + id : id;
		trans.addNewText().set(XmlString.Factory.newValue(name));
		
		Cond cond = trans.addNewCond();
		cond.setId(createId());
		cond.addNewText();

		Time time = trans.addNewTime();
		time.setId(createId());
		time.addNewText();

		Code code = trans.addNewCode();
		code.setId(createId());
		code.addNewText();
		
		transitions.put(id, trans);
		return trans;
	}

	/**
	 * Override method that generates a new arc with the flow object variable
	 * between a Place and a Transition
	 * 
	 * @param sourceId
	 * @param targetId
	 * @return
	 */
	public Arc addArc(String sourceId, String targetId) {
		return addArc(sourceId, targetId, flowObjectVariable);
	}

	/**
	 * Generates a new arc between a Place and a Transition. The type is
	 * determined by the objects the id's are referring.
	 * 
	 * @param sourceId
	 * @param targetId
	 * @param variable
	 * @return
	 */
	public Arc addArc(String sourceId, String targetId, String variable) {
		String id = createId();
		Arc arc = page.addNewArc();
		arc.setId(id);

		if (places.get(sourceId) != null && transitions.get(targetId) != null) {
			arc.addNewPlaceend().setIdref(sourceId);
			arc.addNewTransend().setIdref(targetId);
			arc.setOrientation("PtoT");
		} else if (transitions.get(sourceId) != null
				&& places.get(targetId) != null) {
			arc.addNewPlaceend().setIdref(targetId);
			arc.addNewTransend().setIdref(sourceId);
			arc.setOrientation("TtoP");
		} else {
			System.out.println("ERROR in CPNet.addArc  source: " + sourceId
					+ " target: " + targetId);
		}

		Annot annot = arc.addNewAnnot();
		annot.addNewText().set(XmlString.Factory.newValue(variable));

		arcs.put(id, arc);
		return arc;

	}

	/**
	 * Converts the transition to the sub-page connector.
	 * 
	 * @param trans
	 * @param pageId
	 * @return
	 */
	public Subst addSubst(Trans trans, String pageId) {
		Subst subst = trans.addNewSubst();
		subst.setSubpage(pageId);
		Subpageinfo subpageinfo = subst.addNewSubpageinfo();
		subpageinfo.setId(createId());

		Instance rootInstance = getRootInstance();
		Instance i = rootInstance.addNewInstance();
		i.setId(createId());
		i.setTrans(trans.getId());
		return subst;
	}

	public String createId() {
		return "ID" + (currentId++);
	};

	public void saveToFile(String file) {
		for (Page p : cpnet.getPageArray()) {
			if (!p.getId().equals("PAGE_GENERATOR")) {
				ExLucianoWrapper.doLayouting(p);
			}
		}

		try {
			File convertedCPNFile = new File(file);
			cpnWorkspace.save(convertedCPNFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getFlowObjectType() {
		return flowObjectType;
	}

	public String getFlowObjectVariable() {
		return flowObjectVariable;
	}

	public Place getPlace(String id) {
		return places.get(id);
	}

	public Page getPage(String id) {
		for (Page p : cpnet.getPageArray()) {
			if (p.getId().equals(id))
				return p;
		}
		return null;
	}
	

	public Trans getTransition(String id){
		return transitions.get(id);
	}

	public Instance getRootInstance() {
		return cpnet.getInstances().getInstanceArray(0);
	}

	public void setTransitionTime(String id, String value) {
		Trans trans = transitions.get(id);
		trans.getTimeArray()[0].getText().set(XmlString.Factory.newValue(value));
	}

	public void setTransitionAction(String id, String value) {
		Trans trans = transitions.get(id);
		trans.getCodeArray()[0].getText().set(XmlString.Factory.newValue(value));
		
	}

	public void setTotalTokens(int startTokens) {
		createOrUpdateDef("val totalNoOfToken = ",startTokens);
	}
	
	public void setTokensPerBundle(int bundleTokens) {
		createOrUpdateDef("val noOfTokensPerBundle = ",bundleTokens);
	}

	private void createOrUpdateDef(String def, int value) {
		//TODO: no update yet
		Ml ml = cpnet.getGlobbox().addNewMl();
		ml.setId(createId());
		ml.set(XmlString.Factory.newValue(def + value+ ";"));
		
		
	}
}
