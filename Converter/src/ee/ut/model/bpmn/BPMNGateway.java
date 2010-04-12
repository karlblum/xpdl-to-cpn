package ee.ut.model.bpmn;

import java.util.ArrayList;

import noNamespace.Place;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ParserHelper;

/**
 * @author
 */
public class BPMNGateway extends BPMNElement {

	private ArrayList<String> inputPlaceIds = new ArrayList<String>();
	private ArrayList<String> outputPlaceIds = new ArrayList<String>();
	private String gatewayTransitionId;
	private String gatewayPlaceId;
	private GatewayType gwType;

	public BPMNGateway(CPNProcess cPNProcess, Object obj,
			ParserHelper parserHelper) {
		super(cPNProcess);

		elementId = parserHelper.getId(obj);
		elementName = parserHelper.getName(obj);
		gwType = parserHelper.getGatewayType(obj);

		if (gwType == GatewayType.EXCLUSICE) {
			// If we have Exclusive gateway, then we need one central CPN Place
			// only
			gatewayPlaceId = cPNProcess.getCpnet().addPlace(elementName)
					.getId();

		} else if (gwType == GatewayType.INCLUSIVE) {
			// If we have Inclusive gateway, then we need one central CPN
			// Transition only
			gatewayTransitionId = cPNProcess.getCpnet().addTrans(elementName)
					.getId();
		} else {
			System.err.println("Gateway type: " + gwType + " not implemented.");
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
