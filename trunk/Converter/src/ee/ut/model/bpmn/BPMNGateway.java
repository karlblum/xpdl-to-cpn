package ee.ut.model.bpmn;

import java.util.HashMap;

import noNamespace.Place;
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
				cPNProcess.getCpnet().addArc(gatewayPlaceId,
						gatewayTransitionId);
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
		String arcId = cPNProcess.getCpnet().addArc(gatewayTransitionId,
				p.getId()).getId();
		if (gwType == GatewayType.EXCLUSICE) {
			String arcAnnotation = "(if path=" + id + " then 1`"
					+ cPNProcess.getCpnet().getFlowObjectVariable()
					+ " else empty)";
			cPNProcess.getCpnet().setArcAnnot(arcId, arcAnnotation);

			// We set the default route for the gateway to the latest output
			// created. This is needed if we have only one output
			String function = "input ();\noutput (path);\naction\n(\n" + id
					+ "\n);";
			cPNProcess.getCpnet().setTransitionAction(gatewayTransitionId,
					function);
		}

		return p;
	}

	public enum GatewayType {
		EXCLUSICE, INCLUSIVE, COMPLEX, PARALLEL
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		HashMap<String, String> distribution = simDataParser
				.getDistribution(elementId);

		if (distribution.size() > 1) {
			String function = "input ();\noutput (path);\naction\n(\n  let\n    val p = discrete(0, 99);\n  in";

			int lowerLimit = 0;
			boolean first = true;

			for (String ref : distribution.keySet()) {
				int percentage = Integer.parseInt(distribution.get(ref));
				int upperLimit = percentage + lowerLimit;
				if (first) {
					function += "\n if p>" + lowerLimit + " andalso p<"
							+ upperLimit + " then " + ref;
				} else {
					function += "\n else if p>" + lowerLimit + " andalso p<"
							+ upperLimit + " then " + ref;
				}
				first = false;
				lowerLimit = upperLimit;
			}
			function += "\nend\n);";

			int idxLastIf = function.lastIndexOf(" if ");
			int idxLastThen = function.lastIndexOf(" then ");
			function = function.subSequence(0, idxLastIf) + ""
					+ function.subSequence(idxLastThen + 5, function.length());

			cPNProcess.getCpnet().setTransitionAction(gatewayTransitionId,
					function);
		}

	};

}
