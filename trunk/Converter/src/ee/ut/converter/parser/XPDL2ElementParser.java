package ee.ut.converter.parser;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ee.ut.model.bpmn.BPMNElement;
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

public class XPDL2ElementParser implements ElementParser {

	@Override
	public int getElementType(Object obj) {
		if (obj instanceof ee.ut.model.xpdl2.Activity)
			return getActivityType((Activity) obj);
		else if (obj instanceof ee.ut.model.xpdl2.Transition)
			return BPMNElement.TRANSITION;
		else
			return -1;
	}

	@Override
	public String getId(Object o) {
		if (o instanceof Activity) {
			return ((Activity) o).getId();
		} else if (o instanceof Transition) {
			return ((Transition) o).getId();
		}
		return null;
	}

	public static int getActivityType(Activity activity) {
		for (Object aContent : activity.getContent()) {
			if (aContent instanceof Event) {
				if (((Event) aContent).getStartEvent() != null) {
					return BPMNElement.START;
				} else if (((Event) aContent).getEndEvent() != null) {
					return BPMNElement.END;
				} else if (((Event) aContent).getIntermediateEvent() != null) {
					String target = ((Event) aContent).getIntermediateEvent()
							.getTarget();
					if (target != null && target.length() > 0) {
						String trigger = ((Event) aContent)
								.getIntermediateEvent().getTrigger();
						if (trigger.equals("Timer")) {
							return BPMNElement.BOUND_TIMER_EVENT;
						} else {
							return BPMNElement.BOUND_MESSAGE_EVENT;
						}
					} else {
						Object o = ((Event) aContent).getIntermediateEvent()
								.getTriggerTimer();
						if (o != null) {
							return BPMNElement.INTERMEDIATE_TIMER_EVENT;
						} else {
							return BPMNElement.INTERMEDIATE_MESSAGE_EVENT;
						}
					}

				}
			} else if (aContent instanceof Route) {
				if (((Route) aContent).getGatewayType().equals("Exclusive")) {
					if (isSplit(activity)) {
						return BPMNElement.GATEWAY;
					} else {
						return BPMNElement.GATEWAY;
					}
				} else if (((Route) aContent).getGatewayType().equals(
						"Inclusive")) {
					if (isSplit(activity)) {
						return BPMNElement.GATEWAY;
					} else {
						return BPMNElement.GATEWAY;
					}
				}

			}
		}
		return BPMNElement.TASK;
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
			return GatewayType.EXCLUSIVE;
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

	@Override
	public String getBoundaryEventTaskId(Object obj) {
		// TODO: The EVENT object does not have to be the first one always
		return ((Event) ((Activity) obj).getContent().get(0))
				.getIntermediateEvent().getTarget();
	}

	@Override
	public int getEventTimer(Object obj) {
		String timer = ((Event) ((Activity) obj).getContent().get(0))
				.getIntermediateEvent().getTriggerTimer().getTimeDate()
				.getContent().get(0).toString();
		return Integer.valueOf(timer).intValue();
	}
}
