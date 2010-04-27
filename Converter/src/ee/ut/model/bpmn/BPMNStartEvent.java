package ee.ut.model.bpmn;

import java.util.HashMap;

import noNamespace.Place;
import noNamespace.Subst;
import noNamespace.Trans;
import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNStartEvent extends BPMNElement {

	private String outputPlaceId;
	private String transitionId;

	public BPMNStartEvent(CPNProcess cPNProcess, Object o,
			ElementParser elementParser) {
		super(cPNProcess);

		elementId = elementParser.getId(o);
		elementName = elementParser.getName(o);

		Trans trans = cPNProcess.getCpnet().addTrans(elementName);
		transitionId = trans.getId();

		// Activity can have only one output place, because it is like an
		// inclusive gateway
		outputPlaceId = cPNProcess.getCpnet().addPlace().getId();
		cPNProcess.getCpnet().addArc(transitionId, outputPlaceId);

		Subst subst = cPNProcess.getCpnet().addSubst(trans, "PAGE_GENERATOR");
		subst.setPortsock(String.format("(%s,%s)", "ID1264234111",
				outputPlaceId)); // TODO: modify the place id in cpnet template
	}

	public Place getOutputPlace() {
		return cPNProcess.getCpnet().getPlace(outputPlaceId);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		String startTokens = simDataParser.getTotalTokens();
		cPNProcess.getCpnet().setTotalTokens(startTokens);

		String tokensPerBundle = simDataParser.getTokensPerBundle();
		cPNProcess.getCpnet().setTokensPerBundle(tokensPerBundle);

		String startTime = simDataParser.getStartTime();
		cPNProcess.getCpnet().setStartTime(startTime);

		String endTime = simDataParser.getEndTime();
		cPNProcess.getCpnet().setEndTime(endTime);

		String timeBetweenBundles = simDataParser.getTimeBetweenBundles();
		cPNProcess.getCpnet().setTimeBetweenBundles(timeBetweenBundles);

		String resourceString = "";
		HashMap<String, Integer> resources = simDataParser.getResourceData();
		for (String key : resources.keySet()) {
			cPNProcess
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

		cPNProcess.getCpnet().setResourcePlaceValue(resourceString);

	}

}
