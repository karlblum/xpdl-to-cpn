package ee.ut.model.cpn2;

import ee.ut.converter.CPNConverter.ActivityType;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Event;
import ee.ut.model.xpdl2.Route;
import ee.ut.model.xpdl2.TransitionRestrictions;

public class BPMNActivityFactory extends AbstractElementFactory {

	public BPMNActivityFactory(Process process) {
		super(process);
	}

	@Override
	public Object create(Object obj) {
		Activity xpdlActivity = ((Activity) obj);


ActivityType type = getActivityType(xpdlActivity);


		if (type == ActivityType.START || type == ActivityType.END || type == ActivityType.TASK) {
			return new BPMNTask(process, obj);
		} else {
			return new BPMNGateway(process, obj);
		}
		
	}
	
	public static ActivityType getActivityType(Activity activity) {
		for (Object aContent : activity.getContent()) {
			if (aContent instanceof Event) {
				if (((Event) aContent).getStartEvent() != null) {
					return ActivityType.START;
				} else if (((Event) aContent).getEndEvent() != null) {
					return ActivityType.END;
				}
			} else if (aContent instanceof Route) {
				if (((Route) aContent).getGatewayType().equals("Exclusive")) {
					if (isSplit(activity)) {
						return ActivityType.SPLIT_XOR;
					} else {
						return ActivityType.JOIN_XOR;
					}
				} else if (((Route) aContent).getGatewayType().equals(
						"Inclusive")) {
					if (isSplit(activity)) {
						return ActivityType.SPLIT_INC;
					} else {
						return ActivityType.JOIN_INC;
					}
				}

			}
		}
		return ActivityType.TASK;
	}
	
	/**
	 * We assume that only split activity has transition restrictions. 
	 * So this method determines whether the activity is split or join based 
	 * on the existence of transistionrestriction elements 
	 * 
	 * @param activity
	 * @return
	 */
	private static boolean isSplit(Activity activity){
		for (Object aContent : activity.getContent()){
			if( aContent instanceof TransitionRestrictions){
				return true;
			}
		}
		return false;
	}
}
