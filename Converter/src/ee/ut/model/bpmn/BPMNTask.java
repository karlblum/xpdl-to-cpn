package ee.ut.model.bpmn;

import java.util.ArrayList;
import java.util.HashMap;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public final class BPMNTask extends BPMNElement {

	private String inputPID;
	private String midOutputTID;
	private String outputAID;
	private String taskTID;
	private String boundMessageEventTID;
	private String boundMessageToTaskAID;
	private String boundTimerInAID;
	private String taskInAID;
	private String boundTimerPID;
	private String outPID;
	private String skipperFunctionPID;
	private int boundTimerTime;

	// Event probabilities
	private int prevBoundMessageEventTreshold = 0;
	private HashMap<String, String> boundMessageEventArcs = new HashMap<String, String>();

	private boolean usesResources = false;
	private boolean multipleOutputs = false;

	public BPMNTask(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);
		// Main input
		inputPID = process.getCpnet().addPlace(elementName + " IN").getId();

		String lastPlaceId = inputPID;

		// Bound message events support
		if (parser.getElementParser()
				.isNext(o, BPMNElement.BOUND_MESSAGE_EVENT))
			lastPlaceId = addBoundMessageSupport(lastPlaceId);

		// Bound timer event support
		if (parser.getElementParser().isNext(o, BPMNElement.BOUND_TIMER_EVENT))
			lastPlaceId = addBoundTimerSupport(lastPlaceId);

		skipperFunctionPID = lastPlaceId;

		taskTID = process.getCpnet().addTrans(elementName).getId();

		taskInAID = process.getCpnet().addArc(lastPlaceId, taskTID).getId();

		// Support for multiple outputs
		ArrayList<Object> next = parser.getElementParser().getNextElements(o);
		int nextElementCount = 0;
		for (Object n : next) {
			if (parser.getElementParser().getElementType(n) != BPMNElement.BOUND_MESSAGE_EVENT
					&& parser.getElementParser().getElementType(n) != BPMNElement.BOUND_TIMER_EVENT)
				nextElementCount++;
		}
		if (nextElementCount > 1) {
			multipleOutputs = true;
			// MID output
			outPID = process.getCpnet().addPlace(elementName + " MID_OUT_P")
					.getId();
			outputAID = process.getCpnet().addArc(taskTID, outPID).getId();
			midOutputTID = process.getCpnet().addTrans(
					elementName + " MID_OUT_T").getId();
			process.getCpnet().addArc(outPID, midOutputTID);
		} else {
			outPID = process.getCpnet().addPlace(elementName + " OUT_P")
					.getId();
			outputAID = process.getCpnet().addArc(taskTID, outPID).getId();
		}

	}

	/**
	 * @param lastPlaceId
	 */
	private String addBoundTimerSupport(String lastPlaceId) {
		// Here we can add timer event
		String boundTimerTID = process.getCpnet().addTrans(
				elementName + " TIMER EVENTS").getId();
		process.getCpnet().addArc(lastPlaceId, boundTimerTID).getId();

		boundTimerPID = process.getCpnet().addPlace().getId();
		boundTimerInAID = process.getCpnet().addArc(boundTimerTID,
				boundTimerPID).getId();
		skipperFunctionPID = boundTimerPID;
		return boundTimerPID;
	}

	/**
	 * @param lastPlaceId
	 */
	private String addBoundMessageSupport(String lastPlaceId) {
		// This is the event transition that generates exceptions based on
		// boundary event probabilities
		boundMessageEventTID = process.getCpnet().addTrans(
				elementName + " MESSAGE EVENTS").getId();
		process
				.getCpnet()
				.setTransitionAction(boundMessageEventTID,
						"input ();\noutput (p);\naction\n(round(uniform(0.0,100.0))\n);");

		process.getCpnet().addArc(lastPlaceId, boundMessageEventTID);

		String tempPlace = process.getCpnet().addPlace().getId();
		boundMessageToTaskAID = process.getCpnet().addArc(boundMessageEventTID,
				tempPlace).getId();

		return tempPlace;
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

		// Add resource consumption data from here
		String resourceUsed = simDataParser.getResources(elementId);
		if (resourceUsed != null && resourceUsed.length() > 0) {
			process.getCpnet().setTransitionGuard(taskTID,
					"[check_roles(#Roles(r),[\"" + resourceUsed + "\"])]");

			String resourcePlaceId = process.getCpnet().getResourcePlace();

			process.getCpnet().addArc(taskTID, resourcePlaceId, "r @+pt");
			process.getCpnet().addArc(resourcePlaceId, taskTID, "r");
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
				+ "    pWaitTimeDur=0," + "    pWaitTimeCost=0,\n"
				+ "    transitionName=\"" + elementName + "\",\n"
				+ "    NoOfResources=1}\n" + "in\n" + taskActionf + "\n"
				+ "end);";

		process.getCpnet().setTransitionAction(taskTID, taskAction);

		// The simulation data has to be added to the output arc. The CPN
		// transition outputs the total time consumed and the arc uses it to
		// generate the proper delay.
		String arcAnnot = "CASE.set_ts c (pt+intTime()) @+pt";
		process.getCpnet().setArcAnnot(outputAID, arcAnnot);

	}

	public void addBounMessageEvent(BPMNBoundMessageEvent bpmnBoundEvent) {
		String place = bpmnBoundEvent.getInputPID();
		String eventArcId = process.getCpnet().addArc(boundMessageEventTID,
				place).getId();
		boundMessageEventArcs.put(bpmnBoundEvent.getId(), eventArcId);
	}

	public void setBoundMessageEventProbability(String elementId,
			String p) {
		int probability = Integer.parseInt(p);
		process.getCpnet().setArcAnnot(
				boundMessageEventArcs.get(elementId),
				"if p>=" + prevBoundMessageEventTreshold + " andalso p<"
						+ (prevBoundMessageEventTreshold + probability)
						+ " then 1`c else empty");
		prevBoundMessageEventTreshold = prevBoundMessageEventTreshold
				+ probability;

		process.getCpnet().setArcAnnot(
				boundMessageToTaskAID,
				"if p>= " + prevBoundMessageEventTreshold
						+ " then 1`c else empty");

	}

	public String getBoundTimerPID() {
		return boundTimerPID;
	}

	public void setBoundTimer(int timer) {
		process.getCpnet().setArcAnnot(boundTimerInAID, "c@+" + timer);
		process.getCpnet().setArcAnnot(taskInAID, "c@+" + timer);
	}

	public int getBoundTimer() {
		return boundTimerTime;
	}

	public void addSubprocessSkipper(String nokPlaceId, String okPlaceId,
			String pID) {
		// Create a skipper transition and connect it to the task and NOK place
		// in subprocess timer
		String skipTrans = process.getCpnet().addTrans(elementName + " SKIP")
				.getId();
		process.getCpnet().setTransitionGuard(skipTrans,
				"[#ID c = (#ID (#pr cp))]");

		process.getCpnet().addArc(skipperFunctionPID, skipTrans);
		boolean bothDir = false;
		if (pID == null) {
			pID = outPID;
			bothDir = true;
		}
		process.getCpnet().addArc(skipTrans, pID);

		process.getCpnet().addArc(nokPlaceId, skipTrans, "cp", true);

		// Connect the transition to subprocess timer OK place.
		process.getCpnet().addArc(okPlaceId, taskTID, "cp", bothDir);

		String currentGuard = process.getCpnet().getTransitionGuard(taskTID);
		if (currentGuard.length() > 3) {
			currentGuard = currentGuard.substring(0, currentGuard.length() - 1)
					+ " andalso ";
		} else currentGuard = "[";

		process.getCpnet().setTransitionGuard(taskTID,
				currentGuard + "(#ID c = (#ID (#pr cp)))]");

	}

	@Override
	public String getInputPID() {
		return inputPID;
	}

	@Override
	public String getOutputPID(String ref) {

		if (multipleOutputs) {
			String out = process.getCpnet().addPlace(elementName + " OUT")
					.getId();
			process.getCpnet().addArc(midOutputTID, out);
			return out;
		} else {
			return outPID;
		}

	}

	@Override
	public String getOutputPID() {
		return getOutputPID(null);
	}

}
