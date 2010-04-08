package ee.ut.model.cpn2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import example.ExLucianoWrapper;

import noNamespace.Arc;
import noNamespace.Cpnet;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Trans;
import noNamespace.WorkspaceElementsDocument;

public class CPNet {

	private WorkspaceElementsDocument cpnWorkspace;
	private Cpnet cpnet;
	private Page page;
	private HashMap<String, Place> places = new HashMap<String, Place>();
	private HashMap<String, Arc> arcs = new HashMap<String, Arc>();
	private HashMap<String, Trans> transitions = new HashMap<String, Trans>();
	private int currentId = 7000;

	public CPNet() {
		File blankCPN = new File("./files/cpn/blank3.cpn");

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
		for (Page p : cpnet.getPageArray())
			// ExLucianoWrapper.doLayouting(p);

			try {
				File convertedCPNFile = new File(file);
				cpnWorkspace.save(convertedCPNFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
}
