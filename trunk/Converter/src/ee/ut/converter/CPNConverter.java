package ee.ut.converter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import noNamespace.Cpnet;
import noNamespace.Page;
import noNamespace.WorkspaceElementsDocument;
import ee.ut.model.bpmne.BPMNeProcess;
import ee.ut.model.bpmne.BPMNeGateway.GWType;
import ee.ut.model.sim.GateRef;
import ee.ut.model.sim.Gateway;
import ee.ut.model.sim.SimulationData;
import ee.ut.model.sim.Task;
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
 * This class provides high level access to the conversion and 
 * merging process. Process model in XPDL and simulation data 
 * in customized xml format are both needed to complete conversion.
 * 
 * @author karl
 * 
 */
/**
 * @author karl
 *
 */
public class CPNConverter {

	// Input XPDL file with process data
	File xpdlFile;
	
	// Input simulation data file
	File simDataFile;
	
	// Generate blank CPN workspace
	WorkspaceElementsDocument cpnWorkspace;
	
	// Generate blank CPN
	Cpnet cpnet;
	
	// New wrapped BPMN process
	BPMNeProcess process;
	
	
	/**
	 * Converter initializer
	 * 
	 * @param xpdlFile Input XPDL file
	 * @param simDataFile Input simulation data XML file
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
	 * Runs the conversion process. Modifies the CPN workspace as the end result.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void convert() {

		JAXBElement<PackageType> xpdlRoot = unMasrhall(xpdlFile,
				"ee.ut.model.xpdl2");
		JAXBElement<SimulationData> simDataRoot = unMasrhall(simDataFile,
				"ee.ut.model.sim");
		createBPMNeModel(xpdlRoot.getValue());
		addSimulationData(simDataRoot.getValue());
	}
	
	
	/**
	 * Adds simulation data to the in-memory process model
	 *  
	 * @param simulationData Simulation data model root element
	 */
	private void addSimulationData(SimulationData simulationData) {
		
		// add simulation profile data

		
		// if gateway data is available
		if(simulationData.getGateways() != null){
			for(Gateway gateway : simulationData.getGateways().getGateway()){
				
				List<GateRef> gatewayReferences = gateway.getGateRefs().getGateRef();
				
				Object[] transitionProbabilities = new Object[gatewayReferences.size()*2];
				
				int i = 0;
				for(GateRef gatewayReference : gatewayReferences){
					transitionProbabilities[i++] = gatewayReference.getIdRef();
					transitionProbabilities[i++] = gatewayReference.getProbability();
				}
				
				process.setTransitionProbabilities(gateway.getId(),transitionProbabilities );
			}
		}
		
		// if task data is available
		if(simulationData.getTasks() != null){
			for(Task task : simulationData.getTasks().getTask()){
				
				process.setTaskDDistribution(task.getId(), task.getProcessingTime());
			}
		}
	}
	

	/**
	 * Creates a new BPMN process model from the XPDL data
	 * 
	 * @param packageType XPDL model root element
	 * @return
	 */
	private void createBPMNeModel(PackageType packageType) {

		ProcessType xpdlProcess = packageType.getWorkflowProcesses()
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

	}
	

	/**
	 * Method adds an activity to a process. Activities can be in various types.
	 * Gatways are also types here.
	 * 
	 * @param activity Activity to add to the BPMN process
	 * @param process BPMN process
	 */
	private void addActivity(Activity activity, BPMNeProcess process) {

		ActivityType type = getActivityType(activity);
		String name = activity.getName();
		String id = activity.getId();

		if (type == ActivityType.START) { // Start activity
			process.addStartEvent(id, name);
		} else if (type == ActivityType.END) { // End activity
			process.addTask(id, name);
			process.setExit(id);
		} else if (type == ActivityType.SPLIT_XOR) { // XOR splitting
			process.addXORGateway(id, name, GWType.SPLIT);
		} else if (type == ActivityType.SPLIT_INC) { // AND splitting
			process.addANDGateway(id, name, GWType.SPLIT);
		} else if (type == ActivityType.JOIN_XOR) { // XOR join
			process.addXORGateway(id, name, GWType.JOIN);
		} else if (type == ActivityType.JOIN_INC) { // AND JOIN
			process.addANDGateway(id, name, GWType.JOIN);
		} else { // Intermediate activity (TASK)
			process.addTask(id, name);
		}

	}

	
	/**
	 * Adds a transition between two elements
	 * 
	 * @param transition Transition to be added
	 * @param process Process where to add transition
	 */
	private void addTransition(Transition transition, BPMNeProcess process) {
		process.addEdge(transition.getFrom(), transition.getTo());
		System.out.println("DEBUG: Found transition (?)");

	}

	
	/**
	 * Determines the type of an activity. Activity can be start, end, 
	 * intermediate task and join or split gateway
	 * 
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
				if (((Route) aContent).getGatewayType().equals("Exclusive")) {
					if (isSplit(activity)) {
						return ActivityType.SPLIT_XOR;
					} else {
						return ActivityType.JOIN_XOR;
					}
				} else if (((Route) aContent).getGatewayType().equals(
						"Inclusive")) {
					if (isSplit(activity)) {
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
	 * on the existence of transistionrestriction elements 
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
		START, 
		END, 
		TASK, 
		SPLIT_XOR, 
		SPLIT_INC, 
		JOIN_XOR, 
		JOIN_INC
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

	
	/**
	 * Saves current CPN workspace to the defined file.
	 * 
	 * @param convertedCPNFile
	 */
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
