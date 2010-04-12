package ee.ut.model.cpn2;

import java.util.ArrayList;

import noNamespace.Place;
import noNamespace.Trans;

import org.apache.xmlbeans.XmlString;

import ee.ut.model.cpn2.BPMNGatewayType.GWType;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Route;

/**
 * @author karl This class has the same implementation as the activity class at
 *         the moment!
 */
public class BPMNGateway extends BPMNElement {

	private ArrayList<String> inputPlaceIds = new ArrayList<String>();
	private ArrayList<String> outputPlaceIds = new ArrayList<String>();
	private String gatewayTransitionId;
	private String gatewayPlaceId;
	private GWType gwType;

	public BPMNGateway(Process process, Object obj) {
		super(process);

		Activity xpdlActivity = ((Activity) obj);
		setId(xpdlActivity.getId());

		// Determine the type of the gateway
		String type = ((Route) xpdlActivity.getContent().get(0))
				.getGatewayType();

		if (type.equals("Exclusive")) {
			// If we have Exclusive gateway, then we need one central CPN Place
			// only
			gwType = GWType.EXCLUSICE;
			gatewayPlaceId = process.getCpnet()
					.addPlace(xpdlActivity.getName()).getId();

		} else if (type.equals("Inclusive")) {
			// If we have Inclusive gateway, then we need one central CPN
			// Transition only
			gwType = GWType.INCLUSIVE;
			gatewayTransitionId = process.getCpnet().addTrans(
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
		if (gwType == GWType.EXCLUSICE) {
			return process.getCpnet().getPlace(gatewayPlaceId);
		}

		Place p = process.getCpnet().addPlace();
		inputPlaceIds.add(p.getId());

		process.getCpnet().addArc(p.getId(), gatewayTransitionId);

		return p;
	}

	public Place makeOutputPlace() {
		// If we have exclusive gateway, then we don't need more outputs
		if (gwType == GWType.EXCLUSICE) {
			return process.getCpnet().getPlace(gatewayPlaceId);
		}
		Place p = process.getCpnet().addPlace();
		outputPlaceIds.add(p.getId());
		process.getCpnet().addArc(gatewayTransitionId, p.getId());
		return p;
	}

}
