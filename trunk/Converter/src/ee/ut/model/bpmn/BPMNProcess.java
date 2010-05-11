package ee.ut.model.bpmn;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.CPNet;
import ee.ut.converter.Element;
import ee.ut.converter.factory.BPMNBoundMessageEventFactory;
import ee.ut.converter.factory.BPMNBoundTimerEventFactory;
import ee.ut.converter.factory.BPMNEndEventFactory;
import ee.ut.converter.factory.BPMNGatewayFactory;
import ee.ut.converter.factory.BPMNIntermediateMessageEventFactory;
import ee.ut.converter.factory.BPMNIntermediateTimerEventFactory;
import ee.ut.converter.factory.BPMNStartEventFactory;
import ee.ut.converter.factory.BPMNSubprocessEndFactory;
import ee.ut.converter.factory.BPMNSubprocessFactory;
import ee.ut.converter.factory.BPMNSubprocessStartFactory;
import ee.ut.converter.factory.BPMNSubprocessTimerFactory;
import ee.ut.converter.factory.BPMNTaskFactory;
import ee.ut.converter.factory.BPMNTransitionFactory;
import ee.ut.converter.factory.RelayFactory;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.KBSimDataParser;
import ee.ut.converter.parser.SimDataParser;
import ee.ut.converter.parser.XPDL2ElementParser;
import ee.ut.model.xpdl2.Activity;

public class BPMNProcess extends CPNProcess {
	ElementParser elementParser;
	SimDataParser simDataParser;
	RelayFactory elementFactory;

	public BPMNProcess(File processFile, File simulationDataFile) throws Exception {

		this.setCpnet(new CPNet());
		simDataParser = new KBSimDataParser(simulationDataFile);
		elementParser = new XPDL2ElementParser(processFile);
		prepareFactory();
				
		Stack<Object> elementsToParse = new Stack<Object>();
		Object startElement = elementParser.getStartElement();
		elementsToParse.push(startElement);
				
		HashMap<Object,Element> parsedElements = new HashMap<Object,Element>();
		Stack<String> prevElems = new Stack<String>();
			
		while(!elementsToParse.empty()){
			Element convertedElement = null;
			String prevElem = null;
			
			Object element = elementsToParse.pop();
			if (!prevElems.empty())
				prevElem = prevElems.pop();
			
			ArrayList<Object> nextElements = elementParser.getNextElements(element);
				
			if(!parsedElements.containsKey(element)){
				convertedElement = elementFactory.create(element);
				addConvertedElement(convertedElement.getId(), convertedElement);
				parsedElements.put(element,convertedElement);
			}

			if(convertedElement != null)
			System.out.println("Converted elem:" + ((Activity)element).getId() + " to: " + convertedElement);
			
			// Here we connect the two object
			if(prevElem != null){
					elementFactory.connectElements(parsedElements.get(element) ,getElement(prevElem));
					System.out.println("Transition: " + parsedElements.get(element).getId() + " -> " + getElement(prevElem).getId());
			} 
			
			for(Object e : nextElements){
				elementsToParse.push(e);
				prevElems.push(convertedElement.getId());
			}
		}

		
		/*
		// Generate process model
		ArrayList<Object> allElements = elementParser
				.getAllElements(processFile);

		for (Object o : allElements) {
			System.out.println("Starting to convert: " + o);
			try {
				Element element = elementFactory.create(o);
				System.out.println("Converted to:" + element + "\n");
				if (element != null)
					addElement(element.getId(), element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (Element element : elements.values()) {
			element.addSimulationData(simDataParser);
		}
		
		*/
	}


	private void prepareFactory() {
		elementFactory = new RelayFactory(this, elementParser);

		elementFactory.resetFactoryMap();
		elementFactory.registerFactory(BPMNElement.TASK, new BPMNTaskFactory(
				this, elementParser));
		elementFactory.registerFactory(BPMNElement.GATEWAY,
				new BPMNGatewayFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.START,
				new BPMNStartEventFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.END,
				new BPMNEndEventFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.TRANSITION,
				new BPMNTransitionFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.INTERMEDIATE_MESSAGE_EVENT,
				new BPMNIntermediateMessageEventFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.INTERMEDIATE_TIMER_EVENT,
				new BPMNIntermediateTimerEventFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.BOUND_MESSAGE_EVENT,
				new BPMNBoundMessageEventFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.BOUND_TIMER_EVENT,
				new BPMNBoundTimerEventFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.SUB_PROCESS,
				new BPMNSubprocessFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.SUB_PROCESS_START,
				new BPMNSubprocessStartFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.SUB_PROCESS_END,
				new BPMNSubprocessEndFactory(this, elementParser));
		elementFactory.registerFactory(BPMNElement.SUB_PROCESS_TIMER_EVENT,
				new BPMNSubprocessTimerFactory(this, elementParser));
		
		elementFactory.registerConnectorFactory(new BPMNTransitionFactory(this, elementParser));
		
	}
}
