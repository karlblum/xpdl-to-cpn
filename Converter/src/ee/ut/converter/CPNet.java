package ee.ut.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Code;
import noNamespace.Cond;
import noNamespace.Cpnet;
import noNamespace.Initmark;
import noNamespace.Instance;
import noNamespace.Ml;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Posattr;
import noNamespace.Subpageinfo;
import noNamespace.Subst;
import noNamespace.Time;
import noNamespace.Trans;
import noNamespace.Type;
import noNamespace.WorkspaceElementsDocument;

import org.apache.xmlbeans.XmlString;

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
	private HashMap<String, Trans> transs = new HashMap<String, Trans>();
	private String resourcePlaceId;
	private int currentId = 1000;

	private String flowObjectType = "CASE";
	private String flowObjectVariable = "c";

	public CPNet() {
		File blankCPN = new File("./files/cpn/template.cpn");

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

		name = name != null && name != "" ? name + " (" + id + ")" : "";
		place.addNewText().set(XmlString.Factory.newValue(name));

		Initmark im = place.addNewInitmark();
		im.setId(createId());
		im.addNewText();

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
		name = name != null && name != "" ? name + " (" + id + ")" : "";
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

		transs.put(id, trans);
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

		if (places.get(sourceId) != null && transs.get(targetId) != null) {
			arc.addNewPlaceend().setIdref(sourceId);
			arc.addNewTransend().setIdref(targetId);
			arc.setOrientation("PtoT");
		} else if (transs.get(sourceId) != null && places.get(targetId) != null) {
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

	public void setArcAnnot(String arcId, String annotation) {
		Arc arc = arcs.get(arcId);
		arc.getAnnot().getText().set(XmlString.Factory.newValue(annotation));
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
				try {
					doLayouting(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	public Arc getArc(String id) {
		return arcs.get(id);
	}

	public Page getPage(String id) {
		for (Page p : cpnet.getPageArray()) {
			if (p.getId().equals(id))
				return p;
		}
		return null;
	}

	public Trans getTrans(String id) {
		return transs.get(id);
	}

	public Instance getRootInstance() {
		return cpnet.getInstances().getInstanceArray(0);
	}

	public void setTransitionTime(String id, String value) {
		Trans trans = transs.get(id);
		trans.getTimeArray()[0].getText()
				.set(XmlString.Factory.newValue(value));
	}

	public void setTransitionAction(String id, String value) {
		Trans trans = transs.get(id);
		trans.getCodeArray()[0].getText()
				.set(XmlString.Factory.newValue(value));

	}

	public void setTotalTokens(String startTokens) {
		createOrUpdateDef("val totalNoOfToken = ", startTokens);
	}

	public void setTokensPerBundle(String bundleTokens) {
		createOrUpdateDef("val noOfTokensPerBundle = ", bundleTokens);
	}

	public void createOrUpdateDef(String def, String value) {
		// TODO: no update functionality yet
		Ml ml = cpnet.getGlobbox().addNewMl();
		ml.setId(createId());
		ml.set(XmlString.Factory.newValue(def + value + ";"));

	}

	public void setStartTime(String startTime) {
		String arg[] = startTime.split(",");
		String value = "Date.date{day = " + arg[2] + ", hour = " + arg[3]
				+ ", minute = " + arg[4]
				+ ", month = Date.Jan, offset = NONE, second = " + arg[5]
				+ ", year = " + arg[0] + "}";
		createOrUpdateDef("val startDate = ", value);
	}

	public void setEndTime(String endTime) {
		String arg[] = endTime.split(",");
		String value = "Date.date{day = " + arg[2] + ", hour = " + arg[3]
				+ ", minute = " + arg[4]
				+ ", month = Date.Jan, offset = NONE, second = " + arg[5]
				+ ", year = " + arg[0] + "}";
		createOrUpdateDef("val endDate = ", value);
	}

	public String getResourcePlace() {
		if (resourcePlaceId == null) {
			resourcePlaceId = addPlace("RES", "RESOURCES").getId();
		}
		return resourcePlaceId;
	}

	public void setTransitionGuard(String id, String value) {
		Trans trans = transs.get(id);
		trans.getCondArray()[0].getText()
				.set(XmlString.Factory.newValue(value));

	}

	public void setResourcePlaceValue(String resourceString) {
		String resourcePlaceId = getResourcePlace();
		Place p = getPlace(resourcePlaceId);
		setPlaceValue(p.getId(), resourceString);

	}

	public void setPlaceValue(String place, String value) {
		Place p = getPlace(place);
		p.getInitmarkArray()[0].getText()
				.set(XmlString.Factory.newValue(value));

	}

	public void setTimeBetweenBundles(String timeBetweenBundles) {
		String value = "{dtype=specific, specificValue=" + timeBetweenBundles
				+ ", mean=0, std=0};";
		createOrUpdateDef("val timeBetweenBundles = ", value);

	}

	public static void doLayouting(Page page) throws IOException {

		FileWriter fstream = new FileWriter("./files/cpn/dot_input.txt");
		BufferedWriter out = new BufferedWriter(fstream);

		HashMap<String, String[]> layoutData = new HashMap<String, String[]>();

		out.write("digraph G {nodesep = 2; ranksep=0.5; \n");

		for (Arc arc : page.getArcArray()) {
			String source, target;
			if (arc.getOrientation().equals("PtoT")) {
				source = arc.getPlaceend().getIdref();
				target = arc.getTransend().getIdref();
			} else {
				source = arc.getTransend().getIdref();
				target = arc.getPlaceend().getIdref();
			}
			out.write(source + "->" + target + "\n");
		}
		out.write("}");
		out.close();

		Process pr = Runtime
				.getRuntime()
				.exec(
						"\"c:\\Program Files\\Graphviz2.26.3\\bin\\dot.exe\" .\\files\\cpn\\dot_input.txt");

		String line;
		BufferedReader input = new BufferedReader(new InputStreamReader(pr
				.getInputStream()));
		while ((line = input.readLine()) != null) {
			if (line.contains("[pos=\"") && !line.contains("->")) {
				int posIDEnd = line.indexOf("[");
				int posCoordStart = line.indexOf("\"");
				int posCoordEnd = line.indexOf("\"", posCoordStart + 1);
				String coords = line.substring(posCoordStart + 1, posCoordEnd)
						.trim();
				String tokenId = line.substring(0, posIDEnd).trim();
				layoutData.put(tokenId, new String[] { coords.split(",")[0],
						coords.split(",")[1] });
			}
		}
		input.close();

		for (Place p : page.getPlaceArray()) {
			if (layoutData.get(p.getId()) == null)
				continue;

			String xc = layoutData.get(p.getId())[0];
			String yc = layoutData.get(p.getId())[1];
			Posattr pos = Posattr.Factory.newInstance();
			pos.setX(xc);
			pos.setY(yc);
			p.setPosattr(pos);

			p.addNewEllipse().setH("25");
			p.getEllipse().setW("150");

			Posattr pos2 = Posattr.Factory.newInstance();

			pos2.setX(Double.toString(Double.parseDouble(xc) + 60));
			pos2.setY(Double.toString(Double.parseDouble(yc) + 20));
			p.getTypeArray(0).addNewPosattr().set(pos2);

		}
		for (Trans t : page.getTransArray()) {
			String xc = layoutData.get(t.getId())[0];
			String yc = layoutData.get(t.getId())[1];
			Posattr pos = Posattr.Factory.newInstance();
			pos.setX(xc);
			pos.setY(yc);
			t.setPosattr(pos);

			t.addNewBox().setH("25");
			t.getBox().setW("150");

			Posattr pos2 = Posattr.Factory.newInstance();
			pos2.setX(Double.toString(Double.parseDouble(xc) + 160));
			pos2.setY(Double.toString(Double.parseDouble(yc) + 20));
			if (t.getCodeArray(0) != null) {
				t.getCodeArray(0).addNewPosattr().set(pos2);
			}
		}

		for (Arc arc : page.getArcArray()) {
			String source, target;
			if (arc.getOrientation().equals("PtoT")) {
				source = arc.getPlaceend().getIdref();
				target = arc.getTransend().getIdref();
			} else {
				source = arc.getTransend().getIdref();
				target = arc.getPlaceend().getIdref();
			}
			Double xcSource = Double.parseDouble(layoutData.get(source)[0]);
			Double ycSource = Double.parseDouble(layoutData.get(source)[1]);

			Double xcTarget = Double.parseDouble(layoutData.get(target)[0]);
			Double ycTarget = Double.parseDouble(layoutData.get(target)[1]);

			double x = xcSource + 10 + Math.abs((xcSource - xcTarget) / 2.0);
			double y = ycSource - Math.abs((ycSource - ycTarget) / 2.0);

			if (arc.getAnnot() != null) {
				Posattr pos = Posattr.Factory.newInstance();
				pos.setX(Double.toString(x));
				pos.setY(Double.toString(y));
				arc.getAnnot().addNewPosattr().set(pos);
			}
		}

	}

}
