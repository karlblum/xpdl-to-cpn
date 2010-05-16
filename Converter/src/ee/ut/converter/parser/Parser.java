package ee.ut.converter.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.factory.RelayFactory;
import ee.ut.model.xpdl2.Activity;

public class Parser {

	private ElementParser elementParser;
	private SimDataParser simDataParser;
	private RelayFactory relayFactory;
	private BProcess rootProcess = new BProcess(null, "0");

	public void setElementParser(ElementParser p) {
		elementParser = p;
	}

	public void setSimDataParser(SimDataParser p) {
		simDataParser = p;
	}

	public void setElementFactory(RelayFactory f) {
		relayFactory = f;
	}

	public BProcess parse() throws Exception {
		return parse(rootProcess);
	}

	public BProcess parse(BProcess p) throws Exception {
		System.out.println("\n\n===== STARTING TO CONVERT PROCESS: "
				+ p.getId() + " =====");

		Object startElement = elementParser.getSource(p.getId());
		Stack<Object> elementsToParse = new Stack<Object>();
		elementsToParse.push(startElement);

		HashMap<Object, Element> parsedElements = new HashMap<Object, Element>();
		Stack<String> prevElems = new Stack<String>();

		while (!elementsToParse.empty()) {
			Element convertedElement = null;
			String prevElem = null;

			Object element = elementsToParse.pop();
			if (!prevElems.empty())
				prevElem = prevElems.pop();

			ArrayList<Object> nextElements = elementParser
					.getNextElements(element);

			if (!parsedElements.containsKey(element)) {
				convertedElement = relayFactory.create(p, element);
				p.addElement(convertedElement.getId(), convertedElement);
				parsedElements.put(element, convertedElement);
			}

			if (convertedElement != null) {
				System.out.println("Converted elem:"
						+ ((Activity) element).getId() + " to: "
						+ convertedElement);

				for (Object e : nextElements) {
					elementsToParse.push(e);
					prevElems.push(convertedElement.getId());
				}
			}

			// Here we connect the two object
			if (prevElem != null) {
				relayFactory.connectElements(p, parsedElements.get(element), p
						.getElement(prevElem));
				System.out.println("Transition: "
						+ p.getElement(prevElem).getId() + " -> "
						+ parsedElements.get(element).getId());

			}
		}

		p.printAdjList();
		p.findSinks();
		p.findSource();
		
		for(Element e: p.getElements().values()){
			e.addSimulationData(simDataParser);
		}
		return p;
	}

	public void save(String s) {
		rootProcess.saveToCPN(s);
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
