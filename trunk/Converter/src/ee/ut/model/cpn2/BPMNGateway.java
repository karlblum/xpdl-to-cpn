package ee.ut.model.cpn2;

import java.util.List;

import ee.ut.model.xpdl2.Activity;

import noNamespace.Place;
import noNamespace.Trans;

/**
 * @author karl This class has the same implementation as the activity class at
 *         the moment!
 */
public class BPMNGateway extends BPMNElement {

	private List<String> inputPlaceIds;
	private List<String> outputPlaceIds;
	private String transitionId;

	public BPMNGateway(CPNet cpnet, Object obj) {
		super(cpnet);

		Activity xpdlActivity = ((Activity) obj);
		setId(xpdlActivity.getId());

		// We assume that we only need a transition, because all the inputs and
		// outputs can be generated dynamically.
		transitionId = cpnet.addTrans().getId();

	}

	/**
	 * We generate inputs dynamically. Every time we want to make a connection
	 * between the gateway input and activity, we make a new input Place to both
	 * ends. It generates kind of AND Joins.
	 * 
	 * @return
	 */
	public String makeInput() {
		Place p = cpnet.addPlace();
		inputPlaceIds.add(p.getId());
		cpnet.addArc(p.getId(), transitionId);
		return p.getId();
	}

	public String makeOutput() {
		Place p = cpnet.addPlace();
		outputPlaceIds.add(p.getId());
		cpnet.addArc(transitionId, p.getId());
		return p.getId();
	}

}
