package ee.ut.model.bpmn;

import java.util.HashMap;

import noNamespace.Place;
import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

/**
 * @author
 */
public class BPMNGateway extends BPMNElement {

	private String gatewayTransitionId;
	private String gatewayPlaceId;
	private GatewayType gwType;
	private int ebXORTimerDelay;

	public BPMNGateway(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		setGwType((GatewayType) parser.getElementParser().getGatewayType(o));

		gatewayTransitionId = process.getCpnet().addTrans(elementName).getId();

	}

	/**
	 * We generate inputs dynamically. Every time we want to make a connection
	 * between the gateway input and activity, we make a new input Place to both
	 * ends. It generates kind of AND Joins.
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getInputPID() {
		Place p = null;

		if (getGwType() == GatewayType.EXCLUSIVE) {
			if (gatewayPlaceId == null) {
				gatewayPlaceId = process.getCpnet().addPlace().getId();
				process.getCpnet().addArc(gatewayPlaceId, gatewayTransitionId);
			}
			p = process.getCpnet().getPlace(gatewayPlaceId);
		} else {
			p = process.getCpnet().addPlace();
			process.getCpnet().addArc(p.getId(), gatewayTransitionId);
		}
		return p.getId();
	}

	@Override
	public String getOutputPID(String id) {

		Place p = process.getCpnet().addPlace();
		String arcId = process.getCpnet()
				.addArc(gatewayTransitionId, p.getId()).getId();

		if (getGwType() == GatewayType.EXCLUSIVE) {
			if (id == null) {
				System.err.println("Exclusive gateway output not defined!");
			}

			String arcAnnotation = "(if path=" + id + " then 1`"
					+ process.getCpnet().getFlowObjectVariable()
					+ " else empty)";
			process.getCpnet().setArcAnnot(arcId, arcAnnotation);

			// We set the default route for the gateway to the latest output
			// created. This is needed if we have only one output
			String function = "input ();\noutput (path);\naction\n(\n" + id
					+ "\n);";
			process.getCpnet().setTransitionAction(gatewayTransitionId,
					function);
		}

		return p.getId();
	}

	public enum GatewayType {
		EXCLUSIVE, INCLUSIVE, COMPLEX, PARALLEL
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		if (getGwType() == GatewayType.EXCLUSIVE) {

			HashMap<String, String> distribution = simDataParser
					.getDistribution(elementId);
			if (distribution == null)
				return;
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
						function += "\n else if p>" + lowerLimit
								+ " andalso p<" + upperLimit + " then " + ref;
					}
					first = false;
					lowerLimit = upperLimit;
				}
				function += "\nend\n);";

				int idxLastIf = function.lastIndexOf(" if ");
				int idxLastThen = function.lastIndexOf(" then ");
				function = function.subSequence(0, idxLastIf)
						+ ""
						+ function.subSequence(idxLastThen + 5, function
								.length());

				process.getCpnet().setTransitionAction(gatewayTransitionId,
						function);
			}
		}

	}

	private void setGwType(GatewayType gwType) {
		this.gwType = gwType;
	}

	public GatewayType getGwType() {
		return gwType;
	}

	public void setEBXORTimerDelay(int timerDelay) {
		ebXORTimerDelay = timerDelay;
	};

	public int getEBXORTimerDelay() {
		return ebXORTimerDelay;
	}

	@Override
	public String getOutputPID() {
		return null;
	}

}
