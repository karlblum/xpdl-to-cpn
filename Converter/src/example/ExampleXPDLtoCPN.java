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
import org.wfmc._2008.xpdl2.Activities;
import org.wfmc._2008.xpdl2.Activity;
import org.wfmc._2008.xpdl2.Event;
import org.wfmc._2008.xpdl2.PackageType;
import org.wfmc._2008.xpdl2.ProcessType;
import org.wfmc._2008.xpdl2.Transition;
import org.wfmc._2008.xpdl2.Transitions;

import ee.ut.bpmnsim.BPMNProcess;

public class ExampleXPDLtoCPN {
	public static void main(String[] args) throws IOException, XmlException,
			JAXBException {

		File f = new File("./files/New net.cpn");
		WorkspaceElementsDocument doc = WorkspaceElementsDocument.Factory
				.parse(f);
		Cpnet cpnet = doc.getWorkspaceElements().getCpnet();

		File fIn = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/simplest_xpdl.xpdl");

		JAXBContext jc = JAXBContext.newInstance("org.wfmc._2008.xpdl2");
		Unmarshaller u = jc.createUnmarshaller();
		JAXBElement rootElement = (JAXBElement) u.unmarshal(fIn);

		PackageType root = (PackageType) rootElement.getValue();
		ProcessType proc = root.getWorkflowProcesses().getWorkflowProcess()
				.get(0);

		BPMNProcess bpmnProc = new BPMNProcess(cpnet, proc.getName(), proc
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
			ExampleLucianoWrapper.doLayouting(p);
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
