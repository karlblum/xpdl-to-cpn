package ee.ut.model.cpn2;

import java.io.File;

import javax.xml.bind.JAXBElement;

import ee.ut.model.cpn2.BPMNActivityFactory;
import ee.ut.model.cpn2.BPMNFactory;
import ee.ut.model.cpn2.BPMNTransitionFactory;
import ee.ut.model.xpdl2.Activities;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.PackageType;
import ee.ut.model.xpdl2.ProcessType;
import ee.ut.model.xpdl2.Transition;
import ee.ut.model.xpdl2.Transitions;

public class BPMNProcess extends Process {

	public BPMNProcess() {

		this.setCpnet(new CPNet());
		
		BPMNFactory elementFactory =  new BPMNFactory(this);
		elementFactory.registerActivityFactory(new BPMNActivityFactory(this));
		elementFactory.registerTransitionFactory(new BPMNTransitionFactory(this));

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
