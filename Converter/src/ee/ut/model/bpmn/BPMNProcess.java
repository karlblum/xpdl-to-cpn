package ee.ut.model.bpmn;

import java.io.File;
import java.util.ArrayList;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.CPNet;
import ee.ut.converter.Element;
import ee.ut.converter.factory.BPMNBoundMessageEventFactory;
import ee.ut.converter.factory.BPMNBoundTimerEventFactory;
import ee.ut.converter.factory.BPMNEndEventFactory;
import ee.ut.converter.factory.BPMNFactory;
import ee.ut.converter.factory.BPMNGatewayFactory;
import ee.ut.converter.factory.BPMNIntermediateMessageEventFactory;
import ee.ut.converter.factory.BPMNIntermediateTimerEventFactory;
import ee.ut.converter.factory.BPMNStartEventFactory;
import ee.ut.converter.factory.BPMNTask2Factory;
import ee.ut.converter.factory.BPMNTransition2Factory;
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

		elementFactory.registerActivityFactory(new BPMNTask2Factory(this,
				elementParser));

		elementFactory.registerTransitionFactory(new BPMNTransition2Factory(
				this, elementParser));

		elementFactory.registerGatewayFactory(new BPMNGatewayFactory(this,
				elementParser));

		elementFactory.registerPraserHelper(new XPDL2ElementParser());

		elementFactory.registerStartEventFactory(new BPMNStartEventFactory(
				this, elementParser));

		elementFactory
				.registerIntermediateTimerEventFactory(new BPMNIntermediateTimerEventFactory(
						this, elementParser));

		elementFactory
				.registerIntermediateMessageEventFactory(new BPMNIntermediateMessageEventFactory(
						this, elementParser));

		elementFactory.registerEndEventFactory(new BPMNEndEventFactory(this,
				elementParser));

		elementFactory
				.registerBoundMessageEventFactory(new BPMNBoundMessageEventFactory(
						this, elementParser));

		elementFactory
				.registerBoundTimerEventFactory(new BPMNBoundTimerEventFactory(
						this, elementParser));

		// Generate process model
		ArrayList<Object> allElements = elementParser
				.getAllElements(processFile);

		for (Object o : allElements) {
			try {
				Element element = elementFactory.create(o);
				if (element != null)
					addElement(element.getId(), element);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		for (Element element : elements.values()) {
			element.addSimulationData(simDataParser);
		}
	}
}
