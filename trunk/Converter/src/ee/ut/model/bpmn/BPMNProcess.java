package ee.ut.model.bpmn;

import java.io.File;

import javax.xml.bind.JAXBElement;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.CPNet;
import ee.ut.converter.factory.BPMNTaskFactory;
import ee.ut.converter.factory.BPMNFactory;
import ee.ut.converter.factory.BPMNGatewayFactory;
import ee.ut.converter.factory.BPMNTransitionFactory;
import ee.ut.converter.parser.ParserHelper;
import ee.ut.converter.parser.XPDL2ParserHelper;
import ee.ut.model.xpdl2.Activities;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.PackageType;
import ee.ut.model.xpdl2.ProcessType;
import ee.ut.model.xpdl2.Transition;
import ee.ut.model.xpdl2.Transitions;

public class BPMNProcess extends CPNProcess {

	public BPMNProcess() {

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

		// Here we read in the XPDL file
		File xpdlFile = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/complex.xpdl");

		JAXBElement<PackageType> xpdlRoot = unMasrhall(xpdlFile,
				"ee.ut.model.xpdl2");

		// Start looking through the XPDL elements.
		ProcessType xpdlProcess = xpdlRoot.getValue().getWorkflowProcesses()
				.getWorkflowProcess().get(0);

		for (Object o : xpdlProcess.getContent()) {
			if (o instanceof Activities) {
				for (Activity activity : ((Activities) o).getActivity()) {
					BPMNElement element = (BPMNElement) elementFactory
							.create(activity);
					if (element != null)
						addElement(element.getId(), element);
				}
			} else if (o instanceof Transitions) {
				for (Transition transition : ((Transitions) o).getTransition()) {
					BPMNElement element = (BPMNElement) elementFactory
							.create(transition);
					if (element != null)
						addElement(element.getId(), element);
				}
			}
		}
	}
}
