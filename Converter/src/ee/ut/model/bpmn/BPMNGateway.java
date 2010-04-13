package ee.ut.model.bpmn;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.xmlbeans.XmlString;

import noNamespace.Arc;
import noNamespace.Place;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

/**
 * @author
 */
public class BPMNGateway extends BPMNElement {

	private String gatewayTransitionId;
	private String gatewayPlaceId;
	private GatewayType gwType;

	public BPMNGateway(CPNProcess cPNProcess, Object obj,
			ElementParser elementParser) {
		super(cPNProcess);

		elementId = elementParser.getId(obj);
		elementName = elementParser.getName(obj);

		gwType = (GatewayType) elementParser.getGatewayType(obj);

		gatewayTransitionId = cPNProcess.getCpnet().addTrans(elementName)
				.getId();

	}

	/**
	 * We generate inputs dynamically. Every time we want to make a connection
	 * between the gateway input and activity, we make a new input Place to both
	 * ends. It generates kind of AND Joins.
	 * 
	 * @return
	 */
	public Place makeInputPlace() {
		Place p = null;

		if (gwType == GatewayType.EXCLUSICE) {
			if (gatewayPlaceId == null) {
				gatewayPlaceId = cPNProcess.getCpnet().addPlace().getId();
				cPNProcess.getCpnet().addArc(gatewayPlaceId, gatewayTransitionId);
			}
			p = cPNProcess.getCpnet().getPlace(gatewayPlaceId);
		} else {

			p = cPNProcess.getCpnet().addPlace();
			cPNProcess.getCpnet().addArc(p.getId(), gatewayTransitionId);
		}
		return p;
	}

	public Place makeOutputPlace(String id) {

		Place p = cPNProcess.getCpnet().addPlace();
		Arc arc = cPNProcess.getCpnet().addArc(gatewayTransitionId, p.getId());
		if (gwType == GatewayType.EXCLUSICE) {
			arc.getAnnot().getText().set(
					XmlString.Factory.newValue("(if path=" + id + " then 1`"
							+ cPNProcess.getCpnet().getFlowObjectVariable()
							+ " else empty)"));
		}
		return p;
	}

	public enum GatewayType {
		EXCLUSICE, INCLUSIVE, COMPLEX, PARALLEL
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		System.out.println("Adding gateway simulation data");
		HashMap<String, String> distribution = simDataParser
				.getDistribution(elementId);
		
		String func = "";
		int lowerLimit = 0; 
		for(String ref :distribution.keySet()){
			int percentage = Integer.parseInt(distribution.get(ref));
			int upperLimit = percentage+lowerLimit;
			func += "\n if p>" + lowerLimit + " and p<" + upperLimit;
			lowerLimit = upperLimit;
		}
		System.out.println(func);
		//cPNProcess.getCpnet().setTransitionTime(transitionId,"@+" + duration);

	};

}
