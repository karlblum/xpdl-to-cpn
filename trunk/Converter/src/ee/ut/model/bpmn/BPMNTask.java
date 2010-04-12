package ee.ut.model.bpmn;

import noNamespace.Place;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ParserHelper;

public final class BPMNTask extends BPMNElement {

	private String midInputPlaceId;
	private String outputPlaceId;
	private String transitionId;

	public BPMNTask(CPNProcess cPNProcess, Object o, ParserHelper parserHelper) {
		super(cPNProcess);

		elementId = parserHelper.getId(o);
		elementName = parserHelper.getName(o);

		// We assume that we only need a transition, because all the inputs and
		// outputs can be generated dynamically.
		Trans trans = cPNProcess.getCpnet().addTrans(elementName);

		transitionId = trans.getId();

		// Activity can have only one output place, because it is like an
		// inclusive gateway
		outputPlaceId = cPNProcess.getCpnet().addPlace().getId();
		cPNProcess.getCpnet().addArc(transitionId, outputPlaceId);

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

}
