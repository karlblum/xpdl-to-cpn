package ee.ut.model.cpn2;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ee.ut.model.cpn2.BPMNActivityFactory;
import ee.ut.model.cpn2.BPMNFactory;
import ee.ut.model.cpn2.BPMNTransitionFactory;
import ee.ut.model.xpdl2.Activities;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.PackageType;
import ee.ut.model.xpdl2.ProcessType;
import ee.ut.model.xpdl2.Transition;
import ee.ut.model.xpdl2.Transitions;

public class BPMNProcess {

	private CPNet cpnet;
	private BPMNFactory elementFactory;
	private HashMap<String, Object> elements = new HashMap<String, Object>();

	public BPMNProcess() {
		// This is our main class at the moment. It should be the point where
		// the model starts to grow. At the moment here is a list of BPMN
		// elements although I do not know how it could be usable. The problem
		// is that every BPMN object has to be aware of this class to connect
		// with another object... Should I pass this class as a reference to the
		// factory??

		// So we build the factories here
		this.cpnet = new CPNet();
		this.elementFactory = new BPMNFactory();
		elementFactory.registerActivityFactory(new BPMNActivityFactory());
		elementFactory.registerTransitionFactory(new BPMNTransitionFactory());

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
					BPMNElement element = (BPMNElement) elementFactory.create(
							activity, cpnet);
					if (element != null)
						elements.put(element.getId(), element);
				}
			} else if (o instanceof Transitions) {
				for (Transition transition : ((Transitions) o).getTransition()) {
					BPMNElement element = (BPMNElement) elementFactory.create(
							transition, cpnet);
					if (element != null)
						elements.put(element.getId(), element);
				}
			}
		}
	}

	public void saveToCPN() {
		cpnet
				.saveToFile("C:/Karl/Thesis/Source/Converter/files/cpn/TestCPNModel.cpn");
	}

	@SuppressWarnings("unchecked")
	private JAXBElement unMasrhall(File file, String model) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(model);

			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement rootElement = (JAXBElement) u.unmarshal(file);
			return rootElement;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
