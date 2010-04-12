package ee.ut.converter;

import ee.ut.model.bpmn.BPMNElement.BPMNElementType;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Event;
import ee.ut.model.xpdl2.Route;
import ee.ut.model.xpdl2.TransitionRestrictions;

public class XPDL2ParserHelper implements ParserHelper {

	@Override
	public BPMNElementType getElementType(Object obj) {
		if (obj instanceof ee.ut.model.xpdl2.Activity)
			return getActivityType((Activity)obj);
		else if (obj instanceof ee.ut.model.xpdl2.Transition)
			return BPMNElementType.TRANSITION;
		else
			return null;
	}

	@Override
	public String getId(Object o) {
		// TODO Auto-generated method stub
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
}
