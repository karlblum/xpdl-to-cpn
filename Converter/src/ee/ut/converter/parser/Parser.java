package ee.ut.converter.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.factory.RelayFactory;
import ee.ut.model.xpdl2.Activity;

public class Parser {

	// Process model file parser
	private ElementParser elementParser;

	// Simulation data file parser
	private SimDataParser simDataParser;

	// RelayFactory for handling the element mappings
	private RelayFactory relayFactory;

	// Root process instance with id=0
	private BProcess rootProcess;

	public void setElementParser(ElementParser p) {
		elementParser = p;
	}

	public void setSimDataParser(SimDataParser p) {
		simDataParser = p;
	}

	public void setElementFactory(RelayFactory f) {
		relayFactory = f;
	}

	public Parser(String cpn_template){
		rootProcess = new BProcess(null, "0",cpn_template,null);
	}
	/**
	 * Method starts parsing from the root process.
	 * 
	 * @return Root process.
	 */
	public BProcess parse() {
		return parse(rootProcess);
	}

	/**
	 * Method converts a given process instance.
	 * 
	 * @param p
	 *            In-memory empty process instance.
	 * @return Created process.
	 */
	public BProcess parse(BProcess p) {
		System.out.println("\n\n===== STARTING TO CONVERT PROCESS: "
				+ p.getId() + " =====");

		// Initial source (only one supported)
		Object startElement = elementParser.getSource(p.getId());

		// Stack containing the elements that need to be converted
		Stack<Object> elementsToConvert = new Stack<Object>();
		elementsToConvert.push(startElement);

		// HashMap of already parsed elements
		HashMap<Object, Element> convertedElements = new HashMap<Object, Element>();
		Stack<String> prevElems = new Stack<String>();

		// Loop while there is no element to convert
		while (!elementsToConvert.empty()) {
			Element convertedElement = null;
			String prevElem = null;

			Object element = elementsToConvert.pop();
			if (!prevElems.empty())
				prevElem = prevElems.pop();

			ArrayList<Object> nextElements = elementParser
					.getNextElements(element);

			if (!convertedElements.containsKey(element)) {
				try {
					convertedElement = relayFactory.create(p, element);
				} catch (Exception e) {
					e.printStackTrace();
				}
				p.addElement(convertedElement.getId(), convertedElement);
				convertedElements.put(element, convertedElement);
			}

			if (convertedElement != null) {
				System.out.println("Converted elem:"
						+ ((Activity) element).getId() + " to: "
						+ convertedElement);

				for (Object e : nextElements) {
					elementsToConvert.push(e);
					prevElems.push(convertedElement.getId());
				}
			}

			// Here we connect the two object
			if (prevElem != null) {
				relayFactory.connectElements(p, convertedElements.get(element),
						p.getElement(prevElem));
				System.out.println("Transition: "
						+ p.getElement(prevElem).getId() + " -> "
						+ convertedElements.get(element).getId());

			}
		}

		p.printAdjList();
		p.findSinks();
		p.findSource();

		if (simDataParser.hasData()) {
			for (Element e : p.getElements().values()) {
				try {
					e.addSimulationData(simDataParser);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return p;
	}

	public void save(String s, Boolean layouting, String layouter) {
		rootProcess.saveToCPN(s, layouting,layouter);
	}

	public ElementParser getElementParser() {
		return elementParser;
	}

	public SimDataParser getSimDataParser() {
		return simDataParser;
	}

	public RelayFactory getRelayFactory() {
		return relayFactory;
	}

	public BProcess getRootProcess() {
		return rootProcess;
	}

}
