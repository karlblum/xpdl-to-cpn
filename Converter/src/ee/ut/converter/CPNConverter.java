package ee.ut.converter;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import noNamespace.Cpnet;
import noNamespace.Page;
import noNamespace.WorkspaceElementsDocument;
import ee.ut.model.bpmne.BPMNeProcess;
import ee.ut.model.bpmne.BPMNeGateway.GWType;
import ee.ut.model.sim.SimulationData;
import ee.ut.model.xpdl2.Activities;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Event;
import ee.ut.model.xpdl2.PackageType;
import ee.ut.model.xpdl2.ProcessType;
import ee.ut.model.xpdl2.Route;
import ee.ut.model.xpdl2.Transition;
import ee.ut.model.xpdl2.TransitionRestrictions;
import ee.ut.model.xpdl2.Transitions;
import example.ExLucianoWrapper;

/**
 * @author karl
 * 
 */
public class CPNConverter {

	File xpdlFile;
	File simDataFile;
	WorkspaceElementsDocument cpnWorkspace;
	Cpnet cpnet;
	BPMNeProcess process;

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
	public void convert() {

		JAXBElement<PackageType> xpdlRoot = unMasrhall(xpdlFile,
				"ee.ut.model.xpdl2");
		JAXBElement<SimulationData> simDataRoot = unMasrhall(simDataFile,
				"ee.ut.model.sim");
		createBPMNeModel(xpdlRoot);

	}

	/**
	 * @param xpdlRoot
	 * @return
	 */
	private void createBPMNeModel(JAXBElement<PackageType> xpdlRoot) {

		ProcessType xpdlProcess = xpdlRoot.getValue().getWorkflowProcesses()
				.getWorkflowProcess().get(0);

		process = new BPMNeProcess(cpnet, xpdlProcess.getName(),
				xpdlProcess.getName());
		process.setNumberOfCases("start", "5"); //TODO: MANUAL

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

		//process.setTransitionProbabilities("39", new Object[] {"5", 90, "41", 10}); //TODO: MANUAL
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
			process.setExit(activity.getId());
			System.out.println("DEBUG: Found end event (?)");
		} else if (type == ActivityType.SPLIT_XOR){
			process.addXORGateway(activity.getId(), activity.getName(), GWType.SPLIT);
			System.out.println("DEBUG: Found XOR split (?)");
		} else if (type == ActivityType.SPLIT_INC){
			process.addANDGateway(activity.getId(), activity.getName(), GWType.SPLIT);
			System.out.println("DEBUG: Found AND split (?)");
		} else if (type == ActivityType.JOIN_INC){
			process.addXORGateway(activity.getId(), activity.getName(), GWType.JOIN);
			System.out.println("DEBUG: Found XOR join (?)");
		} else if (type == ActivityType.JOIN_INC){
			process.addANDGateway(activity.getId(), activity.getName(), GWType.JOIN);
			System.out.println("DEBUG: Found AND join (?)");
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
			} else if (aContent instanceof Route) {
				if (((Route) aContent).getGatewayType().equals("Exclusive")){
					if (isSplit(activity)){
					return ActivityType.SPLIT_XOR;
					} else {
						return ActivityType.JOIN_XOR;
					}
				} else if (((Route) aContent).getGatewayType().equals("Inclusive")){
					if (isSplit(activity)){
						return ActivityType.SPLIT_INC;
						} else {
							return ActivityType.JOIN_INC;
						}
				}
				
			}
		}
		return ActivityType.TASK;
	}

	
	/**
	 * We assume that only split activity has transition restrictions. 
	 * So this method determines whether the activity is split or join based 
	 * on the existence of transistinrestriction elements 
	 * 
	 * @param activity
	 * @return
	 */
	private static boolean isSplit(Activity activity){
		for (Object aContent : activity.getContent()){
			if( aContent instanceof TransitionRestrictions){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * @author karl
	 * 
	 */
	public enum ActivityType {
		START, END, TASK, SPLIT_XOR, SPLIT_INC, JOIN_XOR, JOIN_INC
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

	public void saveToFile(File convertedCPNFile) {
		for (Page p : cpnet.getPageArray())
			ExLucianoWrapper.doLayouting(p);
		
		try {
			cpnWorkspace.save(convertedCPNFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
