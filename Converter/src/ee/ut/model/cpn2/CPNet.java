package ee.ut.model.cpn2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import ee.ut.model.bpmne.BPMNeIdGen;
import example.ExLucianoWrapper;

import noNamespace.Arc;
import noNamespace.Cpnet;
import noNamespace.Instance;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Subpageinfo;
import noNamespace.Subst;
import noNamespace.Trans;
import noNamespace.Type;
import noNamespace.WorkspaceElementsDocument;

public class CPNet {

	private WorkspaceElementsDocument cpnWorkspace;
	private Cpnet cpnet;
	private Page page;
	private HashMap<String, Place> places = new HashMap<String, Place>();
	private HashMap<String, Arc> arcs = new HashMap<String, Arc>();
	private HashMap<String, Trans> transitions = new HashMap<String, Trans>();
	private int currentId = 9000;

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
		String id = createId();
		Place place = page.addNewPlace();
		place.setId(id);
		places.put(id, place);

		Type type = place.addNewType();
		type.addNewText();

		return place;
	}

	public Trans addTrans() {
		String id = createId();
		Trans trans = page.addNewTrans();
		trans.setId(id);
		transitions.put(id, trans);
		return trans;
	}

	public Arc addArc(String sourceId, String targetId) {
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

		arcs.put(id, arc);
		return arc;

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

	public Instance getRootInstance() {
		return cpnet.getInstances().getInstanceArray(0);
	}
}
