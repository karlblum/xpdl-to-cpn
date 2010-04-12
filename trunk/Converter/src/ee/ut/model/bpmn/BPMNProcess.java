package ee.ut.model.bpmn;

import java.io.File;
import java.util.ArrayList;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.CPNet;
import ee.ut.converter.factory.BPMNFactory;
import ee.ut.converter.factory.BPMNGatewayFactory;
import ee.ut.converter.factory.BPMNStartEventFactory;
import ee.ut.converter.factory.BPMNTaskFactory;
import ee.ut.converter.factory.BPMNTransitionFactory;
import ee.ut.converter.parser.ParserHelper;
import ee.ut.converter.parser.XPDL2ParserHelper;

public class BPMNProcess extends CPNProcess {

	public BPMNProcess(File file) {

		this.setCpnet(new CPNet());
		ParserHelper parserHelper = new XPDL2ParserHelper();
		BPMNFactory elementFactory = new BPMNFactory(this, parserHelper);
		elementFactory.registerActivityFactory(new BPMNTaskFactory(this,
				parserHelper));
		elementFactory.registerTransitionFactory(new BPMNTransitionFactory(
				this, parserHelper));

		elementFactory.registerGatewayFactory(new BPMNGatewayFactory(this,
				parserHelper));
		elementFactory.registerPraserHelper(new XPDL2ParserHelper());

		elementFactory.registerStartEventFactory(new BPMNStartEventFactory(
				this, parserHelper));

		ArrayList<Object> allElements = parserHelper.getAllElements(file);

		for (Object o : allElements) {
			BPMNElement element = (BPMNElement) elementFactory.create(o);
			if (element != null)
				addElement(element.getId(), element);
		}
	}
}
