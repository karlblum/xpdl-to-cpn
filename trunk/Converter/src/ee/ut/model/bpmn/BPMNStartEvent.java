package ee.ut.model.bpmn;

import java.util.HashMap;

import noNamespace.Subst;
import noNamespace.Trans;
import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNStartEvent extends BPMNElement {

	private String outputPlaceId;
	private String transitionId;

	public BPMNStartEvent(BProcess pr, Parser p, Object o) throws Exception {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		Trans trans = process.getCpnet().addTrans(elementName);
		transitionId = trans.getId();

		// Activity can have only one output place, because it is like an
		// inclusive gateway
		outputPlaceId = process.getCpnet().addPlace().getId();
		process.getCpnet().addArc(transitionId, outputPlaceId);

		Subst subst = process.getCpnet().addSubst(trans, "PAGE_GENERATOR");
		subst.setPortsock(String.format("(%s,%s)", "ID1264234111",
				outputPlaceId)); // TODO: modify the place id in cpnet template
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		String startTokens = simDataParser.getTotalTokens();
		process.getCpnet().setTotalTokens(startTokens);

		String tokensPerBundle = simDataParser.getTokensPerBundle();
		process.getCpnet().setTokensPerBundle(tokensPerBundle);

		String startTime = simDataParser.getStartTime();
		process.getCpnet().setStartTime(startTime);

		String endTime = simDataParser.getEndTime();
		process.getCpnet().setEndTime(endTime);

		String timeBetweenBundles = simDataParser.getTimeBetweenBundles();
		process.getCpnet().setTimeBetweenBundles(timeBetweenBundles);

		String resourceString = "";
		HashMap<String, Integer> resources = simDataParser.getResourceData();
		for (String key : resources.keySet()) {
			process
					.getCpnet()
					.createOrUpdateDef(
							"val " + key + " = ",
							"{Name=\""
									+ key
									+ "\", Costs=[{Value=10000, CostPerDuration=3600, CostPerQuantity=0, CostApplicableTT=[]}], Roles=[\""
									+ key + "\"], Availability=[tt_week]};");
			resourceString += "++" + resources.get(key) + "`" + key;
		}
		if (resourceString.length() > 3)
			resourceString = resourceString.substring(2);

		process.getCpnet().setResourcePlaceValue(resourceString);

	}

	@Override
	public String getInputPlaceId() {
		return null;
	}

	@Override
	public String getOutputPlaceId(String ref) {
		return outputPlaceId;
	}

}
