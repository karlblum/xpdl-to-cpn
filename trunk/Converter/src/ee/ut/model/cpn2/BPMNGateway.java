package ee.ut.model.cpn2;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.XmlString;

import ee.ut.model.cpn2.BPMNGatewayType.GWType;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Route;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Place;
import noNamespace.Trans;

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

	private String xorPlaceId;

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
			Place gwPlace = process.getCpnet().addPlace();
			gwPlace.addNewText().set(
					XmlString.Factory.newValue(xpdlActivity.getName()));
			gwPlace.getTypeArray()[0].getText().set(
					XmlString.Factory.newValue(process.getCpnet()
							.getFlowObjectType()));
			gatewayPlaceId = gwPlace.getId();

		} else if (type.equals("Inclusive")) {
			// If we have Inclusive gateway, then we need one central CPN
			// Transition only
			gwType = GWType.INCLUSIVE;
			Trans gwTrans = process.getCpnet().addTrans();
			gatewayTransitionId = gwTrans.getId();
			gwTrans.addNewText().set(
					XmlString.Factory.newValue(xpdlActivity.getName()));
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
		p.getTypeArray()[0].getText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectType()));
		
		Arc arc = process.getCpnet().addArc(p.getId(), gatewayTransitionId);
		Annot annot = arc.addNewAnnot();
		annot.addNewText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectVariable()));
		return p;
	}

	public Place makeOutputPlace() {
		// If we have exclusive gateway, then we don't need more outputs
		if (gwType == GWType.EXCLUSICE) {
			return process.getCpnet().getPlace(gatewayPlaceId);
		}
		Place p = process.getCpnet().addPlace();
		p.getTypeArray()[0].getText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectType()));
		outputPlaceIds.add(p.getId());
		Arc arc = process.getCpnet().addArc(gatewayTransitionId, p.getId());
		Annot annot = arc.addNewAnnot();
		annot.addNewText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectVariable()));
		return p;
	}

}
