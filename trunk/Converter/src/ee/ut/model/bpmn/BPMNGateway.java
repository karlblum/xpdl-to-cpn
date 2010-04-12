package ee.ut.model.bpmn;

import java.util.ArrayList;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Route;

/**
 * @author 
 */
public class BPMNGateway extends BPMNElement {

	private ArrayList<String> inputPlaceIds = new ArrayList<String>();
	private ArrayList<String> outputPlaceIds = new ArrayList<String>();
	private String gatewayTransitionId;
	private String gatewayPlaceId;
	private GatewayType gwType;

	public BPMNGateway(CPNProcess cPNProcess, Object obj) {
		super(cPNProcess);

		//TODO: get rid of xpdl dependencies
		Activity xpdlActivity = ((Activity) obj);
		setId(xpdlActivity.getId());

		// Determine the type of the gateway
		String type = ((Route) xpdlActivity.getContent().get(0))
				.getGatewayType();

		if (type.equals("Exclusive")) {
			// If we have Exclusive gateway, then we need one central CPN Place
			// only
			gwType = GatewayType.EXCLUSICE;
			gatewayPlaceId = cPNProcess.getCpnet()
					.addPlace(xpdlActivity.getName()).getId();

		} else if (type.equals("Inclusive")) {
			// If we have Inclusive gateway, then we need one central CPN
			// Transition only
			gwType = GatewayType.INCLUSIVE;
			gatewayTransitionId = cPNProcess.getCpnet().addTrans(
					xpdlActivity.getName()).getId();
		} else {
			System.err.println("Gateway type: " + type + " not implemented.");
		}

	}

	/**
	 * We generate inputs dynamically. Every time we want to make a connection
	 * between the gateway input and activity, we make a new input Place to both
	 * ends. It generates kind of AND Joins.
	 * 
	 * @return
	 */
	public Place makeInputPlace() {
		// If we have exclusive gateway, then we don't need more inputs
		if (gwType == GatewayType.EXCLUSICE) {
			return cPNProcess.getCpnet().getPlace(gatewayPlaceId);
		}

		Place p = cPNProcess.getCpnet().addPlace();
		inputPlaceIds.add(p.getId());

		cPNProcess.getCpnet().addArc(p.getId(), gatewayTransitionId);

		return p;
	}

	public Place makeOutputPlace() {
		// If we have exclusive gateway, then we don't need more outputs
		if (gwType == GatewayType.EXCLUSICE) {
			return cPNProcess.getCpnet().getPlace(gatewayPlaceId);
		}
		Place p = cPNProcess.getCpnet().addPlace();
		outputPlaceIds.add(p.getId());
		cPNProcess.getCpnet().addArc(gatewayTransitionId, p.getId());
		return p;
	}

	public enum GatewayType {
		EXCLUSICE, INCLUSIVE, COMPLEX, PARALLEL
	};

}
