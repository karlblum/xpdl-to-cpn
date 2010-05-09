package ee.ut.model.bpmn;

import java.util.HashMap;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public final class BPMNTask2 extends BPMNElement {

	private String inputPlaceId;
	private String midOutputTransitionId;
	private String midOutputArcId;
	private String taskTransitionId;
	private String boundMessageEventTransitionId;
	private String boundMessageEventToTaskArcId;
	private String boundTimerEventArcInId;
	private String boundTimerEventArcOutId;
	private String boundTimerEventPlaceId;
	private int boundTimerTime;

	// Event probabilities
	private int prevBoundMessageEventTreshold = 0;
	private HashMap<String, String> boundMessageEventArcs = new HashMap<String, String>();

	private boolean usesResources = false;

	public BPMNTask2(CPNProcess cPNProcess, Object o,
			ElementParser elementParser) {
		super(cPNProcess);

		elementId = elementParser.getId(o);
		elementName = elementParser.getName(o);

		taskTransitionId = cPNProcess.getCpnet().addTrans(elementName).getId();

		// This will be our central output where we can set the timing for
		// simulation for example
		String midOutPlaceId = cPNProcess.getCpnet().addPlace().getId();
		midOutputArcId = cPNProcess.getCpnet().addArc(taskTransitionId,
				midOutPlaceId).getId();
		midOutputTransitionId = cPNProcess.getCpnet().addTrans().getId();
		cPNProcess.getCpnet().addArc(midOutPlaceId, midOutputTransitionId);

		// This will be our task input. We only need one of these.
		inputPlaceId = cPNProcess.getCpnet().addPlace(elementName + " IN")
				.getId();

		// This is the event transition that generates exceptions based on
		// boundary event probabilities
		boundMessageEventTransitionId = cPNProcess.getCpnet().addTrans(
				elementName + " MESSAGE EVENTS").getId();
		cPNProcess
				.getCpnet()
				.setTransitionAction(boundMessageEventTransitionId,
						"input ();\noutput (p);\naction\n(round(uniform(0.0,100.0))\n);");

		cPNProcess.getCpnet().addArc(inputPlaceId,
				boundMessageEventTransitionId);

		String tempPlace = cPNProcess.getCpnet().addPlace().getId();
		boundMessageEventToTaskArcId = cPNProcess.getCpnet().addArc(
				boundMessageEventTransitionId, tempPlace).getId();

		// Here we can add timer event in the future
		String boundTimerEventTransitionId = cPNProcess.getCpnet().addTrans(
				elementName + " TIMER EVENTS").getId();
		cPNProcess.getCpnet().addArc(tempPlace, boundTimerEventTransitionId)
				.getId();

		boundTimerEventPlaceId = cPNProcess.getCpnet().addPlace().getId();
		boundTimerEventArcInId = cPNProcess.getCpnet().addArc(
				boundTimerEventTransitionId, boundTimerEventPlaceId).getId();
		boundTimerEventArcOutId = cPNProcess.getCpnet().addArc(
				boundTimerEventPlaceId, taskTransitionId).getId();

		
		//TODO: This is hack at the moment. We collect the data about subprocess activities in the subprocess element
		String parentProcessId = elementParser.getSubprocessId(o);
		boolean connectedToParent = false;
		for (Object obj : cPNProcess.getElelments().values()) {
			if (o instanceof BPMNSubprocess
					&& ((BPMNSubprocess) obj).getSubProcessId().equals(
							parentProcessId)) {
				((BPMNSubprocess) obj).addChildTransition(this);
				connectedToParent = true;
			}
		}

		if (connectedToParent) {
			System.out.println("Task parent connected");
		} else if (parentProcessId.length() > 0) {
			System.out.println("Task parent connection failed");
		}
		
	}

	/**
	 * Method generates an input place with an exclusive join to the task
	 * 
	 * @return input place for the task
	 */
	public Place getInputPlace() {
		return cPNProcess.getCpnet().getPlace(inputPlaceId);
	}

	public Place getOutputPlace() {
		Place out = cPNProcess.getCpnet().addPlace(elementName + " OUT");
		cPNProcess.getCpnet().addArc(midOutputTransitionId, out.getId());
		return out;
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

		// Add resource consumption data from here
		String resourceUsed = simDataParser.getResources(elementId);
		if (resourceUsed != null && resourceUsed.length() > 0) {
			cPNProcess.getCpnet().setTransitionGuard(taskTransitionId,
					"[check_roles(#Roles(r),[\"" + resourceUsed + "\"])]");

			String resourcePlaceId = cPNProcess.getCpnet().getResourcePlace();

			cPNProcess.getCpnet().addArc(taskTransitionId, resourcePlaceId,
					"r @+pt");
			cPNProcess.getCpnet()
					.addArc(resourcePlaceId, taskTransitionId, "r");
			usesResources = true;
		}

		String taskActionInput = "(c)";
		String taskActionf = "transitionAction(c, transParams)";
		if (usesResources) {
			taskActionInput = "(c,r)";
			taskActionf = "transitionActionR(c,r, transParams)";
		}

		String taskAction = "input "
				+ taskActionInput
				+ ";\n"
				+ "output (pt);\n"
				+ "action\n"
				+ "(let\n  "
				+ "val transParams = {\n"
				+ "    pt={dtype=specific, specificValue="
				+ simDataParser.getTaskDuration(elementId)
				+ ", mean=0, std=0},\n"
				+ "    pCost={dtype=specific, specificValue=0, mean=0,std=0},\n"
				+ "    sCost={dtype=specific, specificValue=0, mean=0,std=0},\n"
				+ "    revenue={dtype=specific, specificValue=0, mean=0,std=0},\n"
				+ "    pWaitTimeDur="
				+ simDataParser.getWaitTimeDuration(elementId) + ",\n"
				+ "    pWaitTimeCost=0,\n" + "    transitionName=\""
				+ elementName + "\",\n" + "    NoOfResources=1}\n" + "in\n"
				+ taskActionf + "\n" + "end);";

		cPNProcess.getCpnet().setTransitionAction(taskTransitionId, taskAction);

		// The simulation data has to be added to the output arc. The CPN
		// transition outputs the total time consumed and the arc uses it to
		// generate the proper delay.
		String arcAnnot = "CASE.set_ts c (pt+intTime()) @+pt";
		cPNProcess.getCpnet().setArcAnnot(midOutputArcId, arcAnnot);

	}

	public void addBounMessageEvent(BPMNBoundMessageEvent bpmnBoundEvent) {
		String place = bpmnBoundEvent.getInputPlace().getId();
		String eventArcId = cPNProcess.getCpnet().addArc(
				boundMessageEventTransitionId, place).getId();
		boundMessageEventArcs.put(bpmnBoundEvent.getId(), eventArcId);
	}

	public void setBoundMessageEventProbability(String elementId,
			int probability) {
		cPNProcess.getCpnet().setArcAnnot(
				boundMessageEventArcs.get(elementId),
				"if p>=" + prevBoundMessageEventTreshold + " andalso p<"
						+ (prevBoundMessageEventTreshold + probability)
						+ " then 1`c else empty");
		prevBoundMessageEventTreshold = prevBoundMessageEventTreshold
				+ probability;

		cPNProcess.getCpnet().setArcAnnot(
				boundMessageEventToTaskArcId,
				"if p>= " + prevBoundMessageEventTreshold
						+ " then 1`c else empty");

	}

	public String getBoundTimerPlaceId() {
		return boundTimerEventPlaceId;
	}

	public void setBoundTimer(int timer) {
		cPNProcess.getCpnet()
				.setArcAnnot(boundTimerEventArcInId, "c@+" + timer);
		cPNProcess.getCpnet().setArcAnnot(boundTimerEventArcOutId,
				"c@+" + timer);
	}

	public int getBoundTimer() {
		return boundTimerTime;
	}

}
