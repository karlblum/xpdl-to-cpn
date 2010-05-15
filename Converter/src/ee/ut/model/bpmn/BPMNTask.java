package ee.ut.model.bpmn;

import java.util.HashMap;

import noNamespace.Place;
import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public final class BPMNTask extends BPMNElement {

	private String inputPlaceId;
	private String midOutputTransitionId;
	private String midOutputArcId;
	private String taskTransitionId;
	private String boundMessageEventTransitionId;
	private String boundMessageEventToTaskArcId;
	private String boundTimerEventArcInId;
	private String boundTimerEventArcOutId;
	private String boundTimerEventPlaceId;
	private String midOutPlaceId;
	private int boundTimerTime;

	// Event probabilities
	private int prevBoundMessageEventTreshold = 0;
	private HashMap<String, String> boundMessageEventArcs = new HashMap<String, String>();

	private boolean usesResources = false;

	public BPMNTask(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		taskTransitionId = process.getCpnet().addTrans(elementName).getId();

		// This will be our central output where we can set the timing for
		// simulation for example
		midOutPlaceId = process.getCpnet().addPlace().getId();
		midOutputArcId = process.getCpnet().addArc(taskTransitionId,
				midOutPlaceId).getId();
		midOutputTransitionId = process.getCpnet().addTrans().getId();
		process.getCpnet().addArc(midOutPlaceId, midOutputTransitionId);

		// This will be our task input. We only need one of these.
		inputPlaceId = process.getCpnet().addPlace(elementName + " IN").getId();

		// This is the event transition that generates exceptions based on
		// boundary event probabilities
		boundMessageEventTransitionId = process.getCpnet().addTrans(
				elementName + " MESSAGE EVENTS").getId();
		process
				.getCpnet()
				.setTransitionAction(boundMessageEventTransitionId,
						"input ();\noutput (p);\naction\n(round(uniform(0.0,100.0))\n);");

		process.getCpnet().addArc(inputPlaceId, boundMessageEventTransitionId);

		String tempPlace = process.getCpnet().addPlace().getId();
		boundMessageEventToTaskArcId = process.getCpnet().addArc(
				boundMessageEventTransitionId, tempPlace).getId();

		// Here we can add timer event in the future
		String boundTimerEventTransitionId = process.getCpnet().addTrans(
				elementName + " TIMER EVENTS").getId();
		process.getCpnet().addArc(tempPlace, boundTimerEventTransitionId)
				.getId();

		boundTimerEventPlaceId = process.getCpnet().addPlace().getId();
		boundTimerEventArcInId = process.getCpnet().addArc(
				boundTimerEventTransitionId, boundTimerEventPlaceId).getId();
		boundTimerEventArcOutId = process.getCpnet().addArc(
				boundTimerEventPlaceId, taskTransitionId).getId();

	}

	/**
	 * Method generates an input place with an exclusive join to the task
	 * 
	 * @return input place for the task
	 */
	public Place getInputPlace() {
		return process.getCpnet().getPlace(inputPlaceId);
	}

	public Place getOutputPlace() {
		Place out = process.getCpnet().addPlace(elementName + " OUT");
		process.getCpnet().addArc(midOutputTransitionId, out.getId());
		return out;
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

		// Add resource consumption data from here
		String resourceUsed = simDataParser.getResources(elementId);
		if (resourceUsed != null && resourceUsed.length() > 0) {
			process.getCpnet().setTransitionGuard(taskTransitionId,
					"[check_roles(#Roles(r),[\"" + resourceUsed + "\"])]");

			String resourcePlaceId = process.getCpnet().getResourcePlace();

			process.getCpnet().addArc(taskTransitionId, resourcePlaceId,
					"r @+pt");
			process.getCpnet().addArc(resourcePlaceId, taskTransitionId, "r");
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

		process.getCpnet().setTransitionAction(taskTransitionId, taskAction);

		// The simulation data has to be added to the output arc. The CPN
		// transition outputs the total time consumed and the arc uses it to
		// generate the proper delay.
		String arcAnnot = "CASE.set_ts c (pt+intTime()) @+pt";
		process.getCpnet().setArcAnnot(midOutputArcId, arcAnnot);

	}

	public void addBounMessageEvent(BPMNBoundMessageEvent bpmnBoundEvent) {
		String place = bpmnBoundEvent.getInputPlaceId();
		String eventArcId = process.getCpnet().addArc(
				boundMessageEventTransitionId, place).getId();
		boundMessageEventArcs.put(bpmnBoundEvent.getId(), eventArcId);
	}

	public void setBoundMessageEventProbability(String elementId,
			int probability) {
		process.getCpnet().setArcAnnot(
				boundMessageEventArcs.get(elementId),
				"if p>=" + prevBoundMessageEventTreshold + " andalso p<"
						+ (prevBoundMessageEventTreshold + probability)
						+ " then 1`c else empty");
		prevBoundMessageEventTreshold = prevBoundMessageEventTreshold
				+ probability;

		process.getCpnet().setArcAnnot(
				boundMessageEventToTaskArcId,
				"if p>= " + prevBoundMessageEventTreshold
						+ " then 1`c else empty");

	}

	public String getBoundTimerPlaceId() {
		return boundTimerEventPlaceId;
	}

	public void setBoundTimer(int timer) {
		process.getCpnet().setArcAnnot(boundTimerEventArcInId, "c@+" + timer);
		process.getCpnet().setArcAnnot(boundTimerEventArcOutId, "c@+" + timer);
	}

	public int getBoundTimer() {
		return boundTimerTime;
	}

	public void addSubprocessSkipper(String nokPlaceId, String okPlaceId) {

		// Create a skipper transition and connect it to the task and NOK place
		// in subprocess timer
		String skipTrans = process.getCpnet().addTrans(elementName + " SKIP")
				.getId();
		process.getCpnet().addArc(boundTimerEventPlaceId, skipTrans);
		process.getCpnet().addArc(skipTrans, midOutPlaceId);

		process.getCpnet().addArc(nokPlaceId, skipTrans);
		process.getCpnet().addArc(skipTrans, nokPlaceId);

		// Connect the transition to subprocess timer OK place.
		process.getCpnet().addArc(taskTransitionId, okPlaceId);
		process.getCpnet().addArc(okPlaceId, taskTransitionId);

	}

	@Override
	public String getInputPlaceId() {
		return inputPlaceId;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		String out = process.getCpnet().addPlace(elementName + " OUT").getId();
		process.getCpnet().addArc(midOutputTransitionId, out);
		return out;
	}

}
