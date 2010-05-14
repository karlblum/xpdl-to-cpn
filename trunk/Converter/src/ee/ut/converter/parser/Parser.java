package ee.ut.converter.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.factory.RelayFactory;
import ee.ut.model.xpdl2.Activity;

public class Parser {

	ElementParser elementParser;
	SimDataParser simDataParser;
	RelayFactory relayFactory;
	CPNProcess process = new CPNProcess();
	

	public void setElementParser(ElementParser p) {
		elementParser = p;
		prepare();
	}

	public void setSimDataParser(SimDataParser p) {
		simDataParser = p;
	}

	public void setElementFactory(RelayFactory f) {
		relayFactory = f;

	}

	public CPNProcess parse() throws Exception {

		Stack<Object> elementsToParse = new Stack<Object>();
		Object startElement = elementParser.getStartElement();
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
				convertedElement = relayFactory.create(element);
				process.addElement(convertedElement.getId(),
						convertedElement);
				parsedElements.put(element, convertedElement);
			}

			if (convertedElement != null){
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
				relayFactory.connectElements(parsedElements.get(element),
						process.getElement(prevElem));
				System.out.println("Transition: "
						+ parsedElements.get(element).getId() + " -> "
						+ process.getElement(prevElem).getId());
				
			}
		}

		return process;
	}

	private void prepare() {
		relayFactory.setcPNProcess(process);
		relayFactory.setElementParser(elementParser);
		relayFactory.prepareFactory();

	}

	public void save() {
		process.saveToCPN("newArchitecture.cpn");
	}

	public void printAdjList() {
		process.printAdjList();
	}

}
