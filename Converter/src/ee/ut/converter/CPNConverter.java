package ee.ut.converter;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import noNamespace.Cpnet;
import noNamespace.WorkspaceElementsDocument;
import ee.ut.model.bpmne.BPMNeProcess;
import ee.ut.model.sim.SimulationData;
import ee.ut.model.xpdl2.Activities;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Event;
import ee.ut.model.xpdl2.PackageType;
import ee.ut.model.xpdl2.ProcessType;
import ee.ut.model.xpdl2.Transition;
import ee.ut.model.xpdl2.Transitions;

/**
 * @author karl
 * 
 */
public class CPNConverter {

	File xpdlFile;
	File simDataFile;
	WorkspaceElementsDocument cpnWorkspace;
	Cpnet cpnet;

	/**
	 * @param xpdlFile
	 * @param simDataFile
	 */
	public CPNConverter(File xpdlFile, File simDataFile) {
		this.xpdlFile = xpdlFile;
		this.simDataFile = simDataFile;

		File blankCPN = new File("./files/blank.cpn");

		try {
			cpnWorkspace = WorkspaceElementsDocument.Factory.parse(blankCPN);
		} catch (Exception e) {
			e.printStackTrace();
		}

		cpnet = cpnWorkspace.getWorkspaceElements().getCpnet();
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Cpnet convert() {

		JAXBElement<PackageType> xpdlRoot = unMasrhall(xpdlFile,
				"ee.ut.model.xpdl2");
		JAXBElement<SimulationData> simDataRoot = unMasrhall(simDataFile,
				"ee.ut.model.sim");

		BPMNeProcess process = createBPMNeModel(xpdlRoot);

		return cpnet;
	}

	/**
	 * @param xpdlRoot
	 * @return
	 */
	private BPMNeProcess createBPMNeModel(JAXBElement<PackageType> xpdlRoot) {

		ProcessType xpdlProcess = xpdlRoot.getValue().getWorkflowProcesses()
				.getWorkflowProcess().get(0);

		BPMNeProcess process = new BPMNeProcess(cpnet, xpdlProcess.getName(),
				xpdlProcess.getName());

		for (Object co : xpdlProcess.getContent()) {
			if (co instanceof Activities) {
				for (Activity activity : ((Activities) co).getActivity()) {
					addActivity(activity, process);
				}
			} else if (co instanceof Transitions) {
				for (Transition transition : ((Transitions) co).getTransition()) {
					addTransition(transition, process);
				}
			}
		}

		return process;
	}

	/**
	 * @param activity
	 * @param process
	 */
	private void addActivity(Activity activity, BPMNeProcess process) {

		ActivityType type = getActivityType(activity);

		if (type == ActivityType.START) {
			process.addStartEvent(activity.getId(), activity.getName());
			System.out.println("DEBUG: Found start event (?)");
		} else if (type == ActivityType.END) {
			process.addTask(activity.getId(), activity.getName());
			System.out.println("DEBUG: Found end event (?)");
		} else {
			process.addTask(activity.getId(), activity.getName());
			System.out.println("DEBUG: Found intermediate event (?)");
		}

	}

	/**
	 * @param transition
	 * @param process
	 */
	private void addTransition(Transition transition, BPMNeProcess process) {
		process.addEdge(transition.getFrom(), transition.getTo());
		System.out.println("DEBUG: Found transition (?)");

	}

	/**
	 * @param activity
	 * @return
	 */
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

	/**
	 * @author karl
	 * 
	 */
	public enum ActivityType {
		START, END, INTERMEDIATE
	}

	/**
	 * Method makes an in-memory representation of an input xml file
	 * 
	 * @param file
	 * @param model
	 * @return
	 */
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
