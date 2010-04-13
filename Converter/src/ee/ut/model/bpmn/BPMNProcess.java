package ee.ut.model.bpmn;

import java.io.File;
import java.util.ArrayList;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.CPNet;
import ee.ut.converter.Element;
import ee.ut.converter.factory.BPMNFactory;
import ee.ut.converter.factory.BPMNGatewayFactory;
import ee.ut.converter.factory.BPMNStartEventFactory;
import ee.ut.converter.factory.BPMNTaskFactory;
import ee.ut.converter.factory.BPMNTransitionFactory;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.KBSimDataParser;
import ee.ut.converter.parser.SimDataParser;
import ee.ut.converter.parser.XPDL2ElementParser;

public class BPMNProcess extends CPNProcess {

	public BPMNProcess(File processFile, File simulationDataFile) {

		this.setCpnet(new CPNet());
		
		ElementParser elementParser = new XPDL2ElementParser();
		SimDataParser simDataParser = new KBSimDataParser(simulationDataFile);
		
		BPMNFactory elementFactory = new BPMNFactory(this, elementParser);
		elementFactory.registerActivityFactory(new BPMNTaskFactory(this,
				elementParser));
		elementFactory.registerTransitionFactory(new BPMNTransitionFactory(
				this, elementParser));

		elementFactory.registerGatewayFactory(new BPMNGatewayFactory(this,
				elementParser));
		elementFactory.registerPraserHelper(new XPDL2ElementParser());

		elementFactory.registerStartEventFactory(new BPMNStartEventFactory(
				this, elementParser));	
		
		
		// Generate process model
		ArrayList<Object> allElements = elementParser.getAllElements(processFile);

		for (Object o : allElements) {
			Element element = elementFactory.create(o);
			if (element != null)
				addElement(element.getId(), element);
		}
		
		for(Element element: elements.values()){
			element.addSimulationData(simDataParser);
		}
	}
}
