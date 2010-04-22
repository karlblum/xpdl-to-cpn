package ee.ut.model.bpmn;

import noNamespace.Place;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public final class BPMNTask2 extends BPMNElement {

	private String midInputPlaceId;
	private String outputPlaceId;
	private String outputArcId;
	private String transitionId;
	private boolean usesResources = false;

	public BPMNTask2(CPNProcess cPNProcess, Object o, ElementParser elementParser) {
		super(cPNProcess);

		elementId = elementParser.getId(o);
		elementName = elementParser.getName(o);

		// We assume that we only need a transition, because all the inputs and
		// outputs can be generated dynamically.
		Trans trans = cPNProcess.getCpnet().addTrans(elementName);

		transitionId = trans.getId();

		// Activity can have only one output place, because it is like an
		// inclusive gateway
		outputPlaceId = cPNProcess.getCpnet().addPlace().getId();
		outputArcId = cPNProcess.getCpnet().addArc(transitionId, outputPlaceId)
				.getId();

		// This will be the mid-input place where we add input connections
		// to
		midInputPlaceId = cPNProcess.getCpnet().addPlace().getId();
		cPNProcess.getCpnet().addArc(midInputPlaceId, transitionId);

	}

	/**
	 * Method generates an input place with an exclusive join to the task
	 * 
	 * @return input place for the task
	 */
	public Place makeInputPlace() {
		Place inputPlace = cPNProcess.getCpnet().addPlace();

		// TODO: if a token is coming from two inputs, then it generates 2x
		// output!
		Trans trans = cPNProcess.getCpnet().addTrans("XOR_JOIN");

		// Here we connect the input to the mid-input place for Exclusive join
		cPNProcess.getCpnet().addArc(inputPlace.getId(), trans.getId());
		cPNProcess.getCpnet().addArc(trans.getId(), midInputPlaceId);

		return inputPlace;
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {

		// Add resource consumption data from here
		String resourceUsed = simDataParser.getResources(elementId);
		if(resourceUsed != null){
			cPNProcess.getCpnet().setTransitionGuard(transitionId,"[check_roles(#Roles(r),[\""+ resourceUsed +"\"])]");
			
			String resourcePlaceId = cPNProcess.getCpnet().getResourcePlace();
			
			cPNProcess.getCpnet().addArc(transitionId, resourcePlaceId,"r @+pt");
			cPNProcess.getCpnet().addArc(resourcePlaceId, transitionId,"r"); 
			usesResources = true;
		}
		
		
		String taskActionInput = "(c)";
		String taskActionf = "transitionAction(c, transParams)";
		if(usesResources) {
			taskActionInput = "(c,r)";
			taskActionf = "transitionActionR(c,r, transParams)";
		}
		
		String taskAction = "input " + taskActionInput + ";\n"+
		"output (pt);\n"+
		"action\n"+
		"(let\n  "+
		"val transParams = {\n"+
		"    pt={dtype=specific, specificValue="+ simDataParser.getTaskDuration(elementId) +", mean=0, std=0},\n"+
		"    pCost={dtype=specific, specificValue=0, mean=0,std=0},\n"+
		"    sCost={dtype=specific, specificValue=0, mean=0,std=0},\n"+
		"    revenue={dtype=specific, specificValue=0, mean=0,std=0},\n"+
		"    pWaitTimeDur="+ simDataParser.getWaitTimeDuration(elementId) +",\n"+
		"    pWaitTimeCost=0,\n"+
		"    transitionName=\"" + elementName + "\",\n"+
		"    NoOfResources=1}\n"+
		"in\n"+
		taskActionf + "\n"+
		"end);";
		
		cPNProcess.getCpnet().setTransitionAction(transitionId, taskAction);
		
		// The simulation data has to be added to the output arc. The CPN
		// transition outputs the total time consumed and the arc uses it to
		// generate the proper delay.
		String arcAnnot = "CASE.set_ts c (pt+intTime()) @+pt";
		cPNProcess.getCpnet().setArcAnnot(outputArcId, arcAnnot);
		
		

	}

}
