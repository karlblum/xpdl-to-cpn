package example;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import noNamespace.Cpnet;
import noNamespace.Page;
import noNamespace.WorkspaceElementsDocument;

import org.apache.xmlbeans.XmlException;

import ee.ut.model.bpmne.BPMNeProcess;
import ee.ut.model.sim.Tasks;
import ee.ut.model.xpdl2.Activities;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Event;
import ee.ut.model.xpdl2.PackageType;
import ee.ut.model.xpdl2.ProcessType;
import ee.ut.model.xpdl2.Transition;
import ee.ut.model.xpdl2.Transitions;

public class ExXPDLtoCPN_SimData {
	public static void main(String[] args) throws IOException, XmlException,
			JAXBException {

		File f = new File("./files/blank.cpn");
		WorkspaceElementsDocument doc = WorkspaceElementsDocument.Factory
				.parse(f);
		Cpnet cpnet = doc.getWorkspaceElements().getCpnet();

		File xpdlFileIn = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/simplest_xpdl.xpdl");

		JAXBContext jc = JAXBContext.newInstance("ee.ut.model.xpdl2");
		Unmarshaller u = jc.createUnmarshaller();
		JAXBElement rootElement = (JAXBElement) u.unmarshal(xpdlFileIn);
		
		File simFileIn = new File("C:/Karl/Thesis/Source/Converter/files/models/simulationData.xml");

		JAXBContext jc2 = JAXBContext.newInstance("ee.ut.model.sim");
		Unmarshaller u2 = jc2.createUnmarshaller();
		JAXBElement rootElementSim = (JAXBElement) u2.unmarshal(simFileIn);
		Tasks t = (Tasks)rootElementSim.getValue();
		System.out.println(t.toString());
		
		PackageType root = (PackageType) rootElement.getValue();
		ProcessType proc = root.getWorkflowProcesses().getWorkflowProcess()
				.get(0);

		BPMNeProcess bpmnProc = new BPMNeProcess(cpnet, proc.getName(), proc
				.getName());

		Map<String, Activity> map = new HashMap<String, Activity>();

		for (Object o : proc.getContent()) {

			if (o instanceof Activities) {
				Activities acts = (Activities) o;

				// Find the start event
				Activity startActivity = getStartActivity(acts.getActivity());
				bpmnProc.addStartEvent(startActivity.getId(), startActivity
						.getName());
				System.out.println("Start activity: " + startActivity.getName()
						+ "(" + startActivity.getId() + ")");

				// Find the exit event
				Activity endActivity = getEndActivity(acts.getActivity());
				bpmnProc.addTask(endActivity.getId(), endActivity.getName());
				bpmnProc.setExit(endActivity.getId());

				System.out.println("End activity: " + endActivity.getName()
						+ " (" + endActivity.getId() + ")");

				// Find all intermediate events
				for (Activity act : acts.getActivity()) {
					act.getContent();
					if (getActivityType(act) == ActivityType.INTERMEDIATE) {
						bpmnProc.addTask(act.getId(), act.getName());

						System.out.println("Intermediate activity: "
								+ act.getName() + " (" + act.getId() + ")");
					}
					map.put(act.getId(), act);
				}
			}
			if (o instanceof Transitions) {
				Transitions trans = (Transitions) o;
				for (Transition flow : trans.getTransition()) {
					System.out.println("Transition: " + flow.getName() + " ("
							+ flow.getFrom() + " -> " + flow.getTo() + ")");

					bpmnProc.addEdge(flow.getFrom(), flow.getTo());
				}
			}
		}

		for (Page p : cpnet.getPageArray())
			ExLucianoWrapper.doLayouting(p);
		f = new File("./files/ExampleXPDLtoCPN.cpn");

		doc.save(f);
		System.out.println("Done");

	}

	public static Activity getStartActivity(List<Activity> activities) {
		for (Activity activity : activities) {
			if (getActivityType(activity) == ActivityType.START)
				return activity;
		}
		return null;
	}

	public static Activity getEndActivity(List<Activity> activities) {
		for (Activity activity : activities) {
			if (getActivityType(activity) == ActivityType.END)
				return activity;
		}
		return null;
	}

	public static ActivityType getActivityType(Activity activity) {
		for (Object aContent : activity.getContent()) {
			if (aContent instanceof Event) {
				if (((Event) aContent).getStartEvent() != null) {
					return ActivityType.START;
				} else if (((Event) aContent).getEndEvent() != null) {
					return ActivityType.END;
				}
			}
		}
		return ActivityType.INTERMEDIATE;
	}

	public enum ActivityType {
		START, END, INTERMEDIATE
	}
}
