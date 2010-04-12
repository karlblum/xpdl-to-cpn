package ee.ut.converter.parser;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ee.ut.model.bpmn.BPMNElement.BPMNElementType;
import ee.ut.model.bpmn.BPMNGateway.GatewayType;
import ee.ut.model.xpdl2.Activities;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Event;
import ee.ut.model.xpdl2.PackageType;
import ee.ut.model.xpdl2.ProcessType;
import ee.ut.model.xpdl2.Route;
import ee.ut.model.xpdl2.Transition;
import ee.ut.model.xpdl2.TransitionRestrictions;
import ee.ut.model.xpdl2.Transitions;

public class XPDL2ParserHelper implements ParserHelper {

	@Override
	public BPMNElementType getElementType(Object obj) {
		if (obj instanceof ee.ut.model.xpdl2.Activity)
			return getActivityType((Activity) obj);
		else if (obj instanceof ee.ut.model.xpdl2.Transition)
			return BPMNElementType.TRANSITION;
		else
			return null;
	}

	@Override
	public String getId(Object o) {
		if (o instanceof Activity) {
			return ((Activity) o).getId();
		}
		return null;
	}

	public static BPMNElementType getActivityType(Activity activity) {
		for (Object aContent : activity.getContent()) {
			if (aContent instanceof Event) {
				if (((Event) aContent).getStartEvent() != null) {
					return BPMNElementType.START;
				} else if (((Event) aContent).getEndEvent() != null) {
					return BPMNElementType.END;
				}
			} else if (aContent instanceof Route) {
				if (((Route) aContent).getGatewayType().equals("Exclusive")) {
					if (isSplit(activity)) {
						return BPMNElementType.GATEWAY;
					} else {
						return BPMNElementType.GATEWAY;
					}
				} else if (((Route) aContent).getGatewayType().equals(
						"Inclusive")) {
					if (isSplit(activity)) {
						return BPMNElementType.GATEWAY;
					} else {
						return BPMNElementType.GATEWAY;
					}
				}

			}
		}
		return BPMNElementType.TASK;
	}

	/**
	 * We assume that only split activity has transition restrictions. So this
	 * method determines whether the activity is split or join based on the
	 * existence of transistionrestriction elements
	 * 
	 * @param activity
	 * @return
	 */
	private static boolean isSplit(Activity activity) {
		for (Object aContent : activity.getContent()) {
			if (aContent instanceof TransitionRestrictions) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getTransitionFrom(Object object) {
		return ((Transition) object).getFrom();
	}

	@Override
	public String getTransitionTo(Object object) {
		return ((Transition) object).getTo();
	}

	@Override
	public GatewayType getGatewayType(Object obj) {
		String type = ((Route) ((Activity) obj).getContent().get(0))
				.getGatewayType();

		if (type.equals("Exclusive")) {
			return GatewayType.EXCLUSICE;
		} else if (type.equals("Inclusive")) {
			return GatewayType.INCLUSIVE;
		} else {
			System.err.println("Gateway type: " + type + " not implemented.");
			return null;
		}

	}

	@Override
	public String getName(Object o) {
		if (o instanceof Activity) {
			return ((Activity) o).getName();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Object> getAllElements(File file) {

		JAXBElement<PackageType> xpdlRoot = unMasrhall(file,
				"ee.ut.model.xpdl2");

		ProcessType xpdlProcess = xpdlRoot.getValue().getWorkflowProcesses()
				.getWorkflowProcess().get(0);

		ArrayList<Object> allObjects = new ArrayList<Object>();

		for (Object o : xpdlProcess.getContent()) {
			if (o instanceof Activities) {
				allObjects.addAll(((Activities) o).getActivity());
			} else if (o instanceof Transitions) {
				allObjects.addAll(((Transitions) o).getTransition());
			}
		}
		return allObjects;
	}

	@SuppressWarnings("unchecked")
	protected JAXBElement unMasrhall(File file, String model) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(model);

			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement rootElement = (JAXBElement) u.unmarshal(file);
			return rootElement;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
