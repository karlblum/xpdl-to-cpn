package dk.au.daimi.ascoveco.cpn.model.importer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dk.au.daimi.ascoveco.cpn.model.Arc;
import dk.au.daimi.ascoveco.cpn.model.Code;
import dk.au.daimi.ascoveco.cpn.model.Condition;
import dk.au.daimi.ascoveco.cpn.model.FusionGroup;
import dk.au.daimi.ascoveco.cpn.model.HLAnnotation;
import dk.au.daimi.ascoveco.cpn.model.HLArcType;
import dk.au.daimi.ascoveco.cpn.model.HLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.HLMarking;
import dk.au.daimi.ascoveco.cpn.model.Instance;
import dk.au.daimi.ascoveco.cpn.model.Label;
import dk.au.daimi.ascoveco.cpn.model.ModelFactory;
import dk.au.daimi.ascoveco.cpn.model.Name;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.ParameterAssignment;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.Place;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.RefPlace;
import dk.au.daimi.ascoveco.cpn.model.Time;
import dk.au.daimi.ascoveco.cpn.model.Transition;
import dk.au.daimi.ascoveco.cpn.model.Type;
import dk.au.daimi.ascoveco.cpn.model.declaration.DeclarationStructure;
import dk.au.daimi.ascoveco.util.ParserUtil;

/**
 * @author mw
 */
public class DOMParser {

	/**
	 * 
	 */
	public static final String annotNode = "annot";
	/**
	 * 
	 */
	public static final String arcNode = "arc";
	/**
	 * 
	 */
	public static final String codeNode = "code";
	/**
	 * 
	 */
	public static final String condNode = "cond";

	/**
	 * 
	 */
	public static final String cpnetNode = "cpnet";
	private static final ModelFactory factory = ModelFactory.eINSTANCE;
	/**
	 * 
	 */
	public static final String fusioninfoNode = "fusioninfo";
	/**
	 * 
	 */
	public static final String fusionNode = "fusion";
	/**
	 * 
	 */
	public static final String generatorNode = "generator";
	/**
	 * 
	 */
	public static final String globboxNode = "globbox";
	/**
	 * 
	 */
	public static final String initmarkNode = "initmark";
	/**
	 * 
	 */
	public static final String pageattrNode = "pageattr";
	/**
	 * 
	 */
	public static final String pageNode = "page";
	/**
	 * 
	 */
	public static final String placeendNode = "placeend";
	/**
	 * 
	 */
	public static final String placeNode = "place";
	/**
	 * 
	 */
	public static final String portNode = "port";
	/**
	 * 
	 */
	public static final String subpageinfoNode = "subpageinfo";
	/**
	 * 
	 */
	public static final String substNode = "subst";
	/**
	 * 
	 */
	public static final String textNode = "text";
	/**
	 * 
	 */
	public static final String timeNode = "time";
	/**
	 * 
	 */
	public static final String transendNode = "transend";
	/**
	 * 
	 */
	public static final String transNode = "trans";
	/**
	 * 
	 */
	public static final String typeNode = "type";
	/**
	 * 
	 */
	public static final String workspaceElementsNode = "workspaceElements";

	/**
	 * @return a document builder
	 * @throws ParserConfigurationException if the parserconfiguration is invalid
	 */
	public static DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
		final DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
		docfactory.setValidating(false);

		final DocumentBuilder documentBuilder = docfactory.newDocumentBuilder();
		// FIXME Why is this commented out? It should not be!
		/*
		 * documentBuilder.setEntityResolver(new EntityResolver() { public InputSource resolveEntity(final String
		 * publicId, final String systemId) { if (systemId .startsWith("http://www.daimi.au.dk/~cpntools/bin/DTD")) {
		 * //$NON-NLS-1$ final String system = systemId.substring(40); return new
		 * InputSource(getClass().getResourceAsStream( "/resources" + system)); //$NON-NLS-1$ } return null; } });
		 */

		return documentBuilder;
	}

	/**
	 * @param ds structure
	 * @param n node
	 * @return declaration
	 */
	public static HLDeclaration getHLDeclaration(final DeclarationStructure ds, final Node n) {
		final HLDeclaration decl = DOMParser.factory.createHLDeclaration();
		decl.setStructure(ds);
		decl.setId(ParserUtil.getAttr(n, "id"));

		return decl;
	}

	/**
	 * @param inputStream input
	 * @param modelName
	 * @return parsed net
	 * @throws NetCheckException net is invalid
	 * @throws SAXException XML is not correct
	 * @throws IOException IO error occurred
	 * @throws ParserConfigurationException parser is invalid
	 */
	public static PetriNet parse(final InputStream inputStream, final String modelName) throws NetCheckException,
	        SAXException, IOException, ParserConfigurationException {
		final DOMParser parser = new DOMParser();

		final Document doc = DOMParser.getDocumentBuilder().parse(inputStream);
		final PetriNet petriNet = parser.processingPertiNet(doc);
		final Name name = factory.createName();
		name.setText(modelName);
		petriNet.setName(name);

		return petriNet;
	}

	/**
	 * @param uri location of model
	 * @return parsed net
	 * @throws NetCheckException net is invalid
	 * @throws SAXException XML is not correct
	 * @throws IOException IO error occurred
	 * @throws ParserConfigurationException parser is invalid
	 */
	public static PetriNet parse(final URL uri) throws NetCheckException, SAXException, IOException,
	        ParserConfigurationException {
		return DOMParser.parse(uri.openStream(), uri.getPath().replaceFirst(".*/", ""));
	}

	private final HashMap<String, PlaceNode> idToNodePlaceMap;

	/*
	 * public void processGenerator(Node n) { }
	 */

	private final HashMap<String, dk.au.daimi.ascoveco.cpn.model.Node> idToTransitionMap;

	private final HashMap<String, FusionGroup> nameToFusionGroupMap;

	private DOMParser() {
		idToNodePlaceMap = new HashMap<String, PlaceNode>();
		nameToFusionGroupMap = new HashMap<String, FusionGroup>();
		idToTransitionMap = new HashMap<String, dk.au.daimi.ascoveco.cpn.model.Node>();
	}

	/**
	 * @param name name as string
	 * @return structured name
	 */
	public Name getName(final String name) {
		final Name nameObject = DOMParser.factory.createName();
		nameObject.setText(name);
		return nameObject;
	}

	/**
	 * @param n node
	 * @return annotation
	 */
	public HLAnnotation processAnnot(final Node n) {
		final HLAnnotation annot = DOMParser.factory.createHLAnnotation();
		annot.setText(ParserUtil.getTextFromChild(n, DOMParser.textNode));

		return annot;
	}

	/**
	 * @param n node
	 * @return arc
	 * @throws NetCheckException error occurred
	 */
	public Arc processArc(final Node n) throws NetCheckException {
		final Arc arc = DOMParser.factory.createArc();
		arc.setId(ParserUtil.getAttr(n, "id"));
		final String orientation = ParserUtil.getAttr(n, "orientation");
		String transIdref = "";
		String placeIdref = "";

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.transendNode)) {
				transIdref = ParserUtil.getAttr(currentNode, "idref");
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.placeendNode)) {
				placeIdref = ParserUtil.getAttr(currentNode, "idref");
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.annotNode)) {
				final HLAnnotation annot = processAnnot(currentNode);
				arc.setHlinscription(annot);
			}
		}

		if (orientation.equalsIgnoreCase("bothdir")) {
			arc.setSource(idToNodePlaceMap.get(placeIdref));
			arc.setTarget(idToTransitionMap.get(transIdref));
			arc.setType(HLArcType.TEST);
		} else if (orientation.equalsIgnoreCase("ptot")) {
			arc.setSource(idToNodePlaceMap.get(placeIdref));
			arc.setTarget(idToTransitionMap.get(transIdref));
			arc.setType(HLArcType.NORMAL);
		} else if (orientation.equalsIgnoreCase("ttop")) {
			arc.setSource(idToTransitionMap.get(transIdref));
			arc.setTarget(idToNodePlaceMap.get(placeIdref));
			arc.setType(HLArcType.NORMAL);
		} else {
			throw new NetStructureException("Unknown arc orientation", n);
		}

		return arc;
	}

	/**
	 * @param n node
	 * @return code
	 */
	public Code processCode(final Node n) {
		final Code code = DOMParser.factory.createCode();
		code.setText(ParserUtil.getTextFromChild(n, DOMParser.textNode));

		return code;
	}

	/**
	 * @param n node
	 * @return guard
	 */
	public Condition processCond(final Node n) {
		final Condition cond = DOMParser.factory.createCondition();
		cond.setText(ParserUtil.getTextFromChild(n, DOMParser.textNode));

		return cond;
	}

	/**
	 * @param n node
	 * @return net
	 * @throws NetCheckException error occurred
	 */
	public PetriNet processCpnet(final Node n) throws NetCheckException {
		final PetriNet petriNet = DOMParser.factory.createPetriNet();

		final NodeList nl = n.getChildNodes();

		// 1st we parse the declarations
		ArrayList<Label> labels = new ArrayList<Label>();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.globboxNode)) {
				labels = processGlobbox(currentNode);
			}
		}
		for (final Label label : labels) {
			label.setParent(petriNet);
		}

		// 2nd we parse the fusion groups
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.fusionNode)) {
				final FusionGroup fusionGroup = processFusion(currentNode);
				fusionGroup.setPetriNet(petriNet);
			}
		}

		// 3th we parse the pages
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.pageNode)) {
				final Page page = processPage(currentNode);
				page.setPetriNet(petriNet);
			}
		}

		return petriNet;
	}

	private FusionGroup processFusion(final Node n) {
		final FusionGroup fusionGroup = DOMParser.factory.createFusionGroup();
		fusionGroup.setId(ParserUtil.getAttr(n, "id"));
		final String name = ParserUtil.getAttr(n, "name");
		fusionGroup.setName(getName(name));
		nameToFusionGroupMap.put(name, fusionGroup);

		return fusionGroup;
	}

	/**
	 * @param n node
	 * @return list of decls
	 * @throws NetDeclarationException error occurred
	 */
	public ArrayList<Label> processGlobbox(final Node n) throws NetDeclarationException {
		return DeclarationParser.processDecls(n);
	}

	/**
	 * @param n node
	 * @return net
	 * @throws NetCheckException error occurred
	 */
	public PetriNet processingPertiNet(final Node n) throws NetCheckException {
		PetriNet petriNet = null;

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.workspaceElementsNode)) {
				petriNet = processWorkspaceElements(currentNode);
			}
		}

		return petriNet;
	}

	/**
	 * @param n node
	 * @return initmark
	 */
	public HLMarking processInitmark(final Node n) {
		final HLMarking initmark = DOMParser.factory.createHLMarking();
		initmark.setText(ParserUtil.getTextFromChild(n, DOMParser.textNode));

		return initmark;
	}

	/**
	 * @param n node
	 * @return page
	 * @throws NetCheckException error occurred
	 */
	public Page processPage(final Node n) throws NetCheckException {
		final Page page = DOMParser.factory.createPage();
		page.setId(ParserUtil.getAttr(n, "id"));

		final NodeList nl = n.getChildNodes();

		// 1st we parse the page name, places and transitions
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.pageattrNode)) {
				page.setName(getName(ParserUtil.getAttr(currentNode, "name")));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.placeNode)) {
				final PlaceNode place = processPlace(currentNode);
				place.setPage(page);
				/*
				 * if (placeNode instanceof RefPlace && ((RefPlace) placeNode).isPort()) {
				 * page.addImportPlace((RefPlace) placeNode); }
				 */
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.transNode)) {
				if (ParserUtil.containsChild(currentNode, DOMParser.substNode)) {
					final Instance instance = processSubst(currentNode);
					instance.setPage(page);
				} else {
					final Transition transition = processTrans(currentNode);
					transition.setPage(page);
				}
			}
		}

		// 2nd we parse the arcs
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.arcNode)) {
				final Arc arc = processArc(currentNode);
				arc.setPage(page);
			}
		}

		return page;
	}

	/**
	 * @param n node
	 * @return place
	 */
	public PlaceNode processPlace(final Node n) {
		Name name = null;
		Type type = null;
		HLMarking initmark = null;
		boolean isFusionPlace = false;
		String fusionGroupName = null;
		boolean isPort = false;

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.textNode)) {
				name = getName(ParserUtil.getTextFromElement(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.typeNode)) {
				type = processType(currentNode);
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.initmarkNode)) {
				initmark = processInitmark(currentNode);
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.fusioninfoNode)) {
				isFusionPlace = true;
				fusionGroupName = ParserUtil.getAttr(currentNode, "name");
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.portNode)) {
				isPort = true;
			}
		}

		if (isFusionPlace || isPort) {
			final RefPlace refPlace = DOMParser.factory.createRefPlace();
			final String id = ParserUtil.getAttr(n, "id");
			refPlace.setId(id);
			refPlace.setName(name);
			refPlace.setType(type);
			refPlace.setInitialMarking(initmark);

			if (isPort) {
				refPlace.setRef(null);
			} else {
				refPlace.setRef(nameToFusionGroupMap.get(fusionGroupName));
			}
			idToNodePlaceMap.put(id, refPlace);

			return refPlace;
		} else {
			final Place place = DOMParser.factory.createPlace();
			final String id = ParserUtil.getAttr(n, "id");
			place.setId(id);
			place.setName(name);
			place.setType(type);
			place.setInitialMarking(initmark);
			idToNodePlaceMap.put(id, place);

			return place;
		}
	}

	/**
	 * @param n node
	 * @return instance
	 */
	public Instance processSubst(final Node n) {
		final Instance instance = DOMParser.factory.createInstance();
		final String id = ParserUtil.getAttr(n, "id");
		instance.setId(id);

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.textNode)) {
				instance.setName(getName(ParserUtil.getTextFromElement(currentNode)));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.substNode)) {
				instance.setSubPageID(ParserUtil.getAttr(currentNode, "subpage"));

				final String portsock = ParserUtil.getAttr(currentNode, "portsock");
				final String[] pairs = portsock.split("\\(");
				/*
				 * The first element in the pair is the id of RefPlace (port) The second element in the pair is the id
				 * of Place parameter (socket)
				 */
				String[] elements;
				for (int j = 1; j < pairs.length; j++) {
					elements = pairs[j].split("[,]");

					final ParameterAssignment pa = DOMParser.factory.createParameterAssignment();
					pa.setValue(elements[0]);
					pa.setParameter(elements[1].replaceAll("\\)", ""));
					pa.setInstance(instance);
				}
			}
		}
		idToTransitionMap.put(id, instance);

		return instance;
	}

	/**
	 * @param n node
	 * @return time region
	 */
	public Time processTime(final Node n) {
		final Time time = DOMParser.factory.createTime();
		time.setText(ParserUtil.getTextFromChild(n, DOMParser.textNode));

		return time;
	}

	/**
	 * @param n node
	 * @return transition
	 */
	public Transition processTrans(final Node n) {
		final Transition transition = DOMParser.factory.createTransition();
		final String id = ParserUtil.getAttr(n, "id");
		transition.setId(id);

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.textNode)) {
				transition.setName(getName(ParserUtil.getTextFromElement(currentNode)));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.condNode)) {
				final Condition cond = processCond(currentNode);
				transition.setCondition(cond);
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.timeNode)) {
				final Time time = processTime(currentNode);
				transition.setTime(time);
			} else if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.codeNode)) {
				final Code code = processCode(currentNode);
				transition.setCode(code);
			}
		}

		idToTransitionMap.put(id, transition);

		return transition;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public Type processType(final Node n) {
		final Type type = DOMParser.factory.createType();
		type.setText(ParserUtil.getTextFromChild(n, DOMParser.textNode));

		return type;
	}

	/**
	 * @param n node
	 * @return net
	 * @throws NetCheckException error occurred
	 */
	public PetriNet processWorkspaceElements(final Node n) throws NetCheckException {
		PetriNet petriNet = null;

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DOMParser.cpnetNode)) {
				petriNet = processCpnet(currentNode);
				// else if (isElementNodeOfType(currentNode, generatorNode))
				// processGenerator(currentNode);
			}
		}

		return petriNet;
	}

}
