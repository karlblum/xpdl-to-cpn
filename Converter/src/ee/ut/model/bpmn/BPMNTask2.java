package ee.ut.model.bpmn;

import noNamespace.Place;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public final class BPMNTask2 extends BPMNElement {

	private String midInputPlaceId;
	private String midOutputTransitionId;
	private String midOutputArcId;
	private String transitionId;
	private boolean usesResources = false;

	public BPMNTask2(CPNProcess cPNProcess, Object o,
			ElementParser elementParser) {
		super(cPNProcess);

		elementId = elementParser.getId(o);
		elementName = elementParser.getName(o);

		// We assume that we only need a transition, because all the inputs and
		// outputs can be generated dynamically.
		Trans trans = cPNProcess.getCpnet().addTrans(elementName);

		transitionId = trans.getId();

		// This will be our central output where we can set the timing for simulation for example
		String midOutPlaceId = cPNProcess.getCpnet().addPlace(elementName+"_MID_OUT").getId();
		midOutputArcId = cPNProcess.getCpnet().addArc(transitionId, midOutPlaceId)
				.getId();
		midOutputTransitionId = cPNProcess.getCpnet().addTrans().getId();
		cPNProcess.getCpnet().addArc(midOutPlaceId, midOutputTransitionId);

		// This will be the mid-input place where we add input connections
		// to
		setMidInputPlaceId(cPNProcess.getCpnet().addPlace(elementName+"_MID_IN").getId());
		cPNProcess.getCpnet().addArc(getMidInputPlaceId(), transitionId);

	}

	/**
	 * Method generates an input place with an exclusive join to the task
	 * 
	 * @return input place for the task
	 */
	public Place makeInputPlace() {
		Place inputPlace = cPNProcess.getCpnet().addPlace();

		Trans trans = cPNProcess.getCpnet().addTrans(elementName+"_IN");

		// Here we connect the input to the mid-input place for Exclusive join
		cPNProcess.getCpnet().addArc(inputPlace.getId(), trans.getId());
		cPNProcess.getCpnet().addArc(trans.getId(), getMidInputPlaceId());

		return inputPlace;
	}

	public Place makeOutputPlace() {
		Place out = cPNProcess.getCpnet().addPlace(elementName+"_OUT");
		cPNProcess.getCpnet().addArc(midOutputTransitionId, out.getId());
		return out;
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

		// Add resource consumption data from here
		String resourceUsed = simDataParser.getResources(elementId);
		if (resourceUsed != null && resourceUsed.length()>0) {
			cPNProcess.getCpnet().setTransitionGuard(transitionId,
					"[check_roles(#Roles(r),[\"" + resourceUsed + "\"])]");

			String resourcePlaceId = cPNProcess.getCpnet().getResourcePlace();

			cPNProcess.getCpnet().addArc(transitionId, resourcePlaceId,
					"r @+pt");
			cPNProcess.getCpnet().addArc(resourcePlaceId, transitionId, "r");
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

		cPNProcess.getCpnet().setTransitionAction(transitionId, taskAction);

		// The simulation data has to be added to the output arc. The CPN
		// transition outputs the total time consumed and the arc uses it to
		// generate the proper delay.
		String arcAnnot = "CASE.set_ts c (pt+intTime()) @+pt";
		cPNProcess.getCpnet().setArcAnnot(midOutputArcId, arcAnnot);

	}

	private void setMidInputPlaceId(String midInputPlaceId) {
		this.midInputPlaceId = midInputPlaceId;
	}

	public String getMidInputPlaceId() {
		return midInputPlaceId;
	}

	public void addBoundaryEvent(BPMNBoundEvent bpmnBoundEvent) {
		String t = bpmnBoundEvent.getTransitionId();
		cPNProcess.getCpnet().addArc(midInputPlaceId, t);
	}

}
