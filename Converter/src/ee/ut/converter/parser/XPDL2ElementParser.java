package ee.ut.converter.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ee.ut.converter.Element;
import ee.ut.model.bpmn.BPMNElement;
import ee.ut.model.bpmn.BPMNGateway.GatewayType;
import ee.ut.model.xpdl2.Activities;
import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.ActivitySet;
import ee.ut.model.xpdl2.ActivitySets;
import ee.ut.model.xpdl2.BlockActivity;
import ee.ut.model.xpdl2.Event;
import ee.ut.model.xpdl2.PackageType;
import ee.ut.model.xpdl2.ProcessType;
import ee.ut.model.xpdl2.Route;
import ee.ut.model.xpdl2.Transition;
import ee.ut.model.xpdl2.TransitionRestrictions;
import ee.ut.model.xpdl2.Transitions;

/**
 * @author karl
 * 
 */
public class XPDL2ElementParser implements ElementParser {

	ProcessType xpdlProcess;
	HashMap<String, Activity> allActivities = new HashMap<String, Activity>();
	ArrayList<Transition> allTransitions = new ArrayList<Transition>();
	protected Map<Activity, List<Activity>> adjList = new HashMap<Activity, List<Activity>>();

	public void addEdge(Activity v1, Activity v2) {
		if (!adjList.containsKey(v1))
			adjList.put(v1, new LinkedList<Activity>());
		adjList.get(v1).add(v2);
	}

	public XPDL2ElementParser(File processFile) {

		JAXBElement<PackageType> xpdlRoot = unMasrhall(processFile,
				"ee.ut.model.xpdl2");

		xpdlProcess = xpdlRoot.getValue().getWorkflowProcesses()
				.getWorkflowProcess().get(0);

		for (Object o : xpdlProcess.getContent()) {
			if (o instanceof Activities) {
				for (Activity a : ((Activities) o).getActivity()) {
					allActivities.put(a.getId(), a);
				}
			} else if (o instanceof Transitions) {
				allTransitions.addAll(((Transitions) o).getTransition());
			} else if (o instanceof ActivitySets) {
				for (ActivitySet aset : ((ActivitySets) o).getActivitySet()) {
					for (Activity a : aset.getActivities().getActivity()) {
						allActivities.put(a.getId(), a);
					}
					allTransitions
							.addAll(aset.getTransitions().getTransition());
				}

			}
		}

		for (Transition t : allTransitions) {
			addEdge(allActivities.get(t.getFrom()), allActivities
					.get(t.getTo()));
		}
	}

	@Override
	public int getElementType(Object obj) {
		if (obj instanceof ee.ut.model.xpdl2.Activity)
			return getActivityType((Activity) obj);
		else if (obj instanceof ee.ut.model.xpdl2.Transition)
			return BPMNElement.TRANSITION;
		else
			System.err.println("Element type: " + obj + " not implemented.");
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
			if (aContent instanceof BlockActivity) {
				return BPMNElement.SUB_PROCESS;
			}
			if (aContent instanceof Event) {
				if (((Event) aContent).getStartEvent() != null) {
					if (((Event) aContent).getStartEvent().getTrigger().equals(
							"Timer")) {
						return BPMNElement.SUB_PROCESS_START;
					} else {
						return BPMNElement.START;
					}
				} else if (((Event) aContent).getEndEvent() != null) {
					if (((Event) aContent).getEndEvent()
							.getTriggerResultSignal() != null) {
						return BPMNElement.SUB_PROCESS_END;
					} else {
						return BPMNElement.END;
					}
				} else if (((Event) aContent).getIntermediateEvent() != null) {
					String target = ((Event) aContent).getIntermediateEvent()
							.getTarget();
					if (target != null && target.length() > 0) {
						String trigger = ((Event) aContent)
								.getIntermediateEvent().getTrigger();
						if (trigger.equals("Timer")) {
							// TODO: We don't know if it is a timer for task or
							// a subprocess!
							// return BPMNElement.BOUND_TIMER_EVENT;
							return BPMNElement.SUB_PROCESS_TIMER_EVENT;
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
	protected JAXBElement<PackageType> unMasrhall(File file, String model) {
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

	@Override
	public String getSubprocessId(Object obj) {
		String toParent = "";
		String isParent = "";

		try {
			toParent = ((Activity) obj).getStatus();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			isParent = ((BlockActivity) ((Activity) obj).getContent().get(0))
					.getActivitySetId();
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (toParent.length() > 0 && !toParent.equals("None")) {
			System.out.println("Found child: " + ((Activity) obj).getId()
					+ ", to parent: " + toParent + ".");
			return toParent;
		} else if (isParent.length() > 0) {
			System.out.println("Found parent: " + ((Activity) obj).getId()
					+ ", to child: " + isParent + ". ");
			return isParent;
		}
		return null;
	}

	/**
	 * Method searches for the first starting node.
	 * 
	 * @return process starting node
	 */
	public Object getStartElement() {
		for (Object o : xpdlProcess.getContent()) {
			if (o instanceof Activities) {
				for (Activity a : ((Activities) o).getActivity()) {
					for (Object o2 : a.getContent()) {
						if (o2 instanceof Event
								&& ((Event) o2).getStartEvent() != null) {
							return a;
						}
					}
				}

			}

		}
		return null;
	}

	/*
	 * Method returns the list of all the connected elements.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * ee.ut.converter.parser.ElementParser#getNextElements(java.lang.Object)
	 */
	@Override
	public ArrayList<Object> getNextElements(Object element) {
		ArrayList<Object> nextElems = new ArrayList<Object>();

		if (adjList.get(element) != null) {
			nextElems.addAll(adjList.get(element));
		}
		nextElems.addAll(getBoundElements((Activity) element));

		return nextElems;
	}

	private ArrayList<Object> getBoundElements(Activity element) {
		ArrayList<Object> nextElems = new ArrayList<Object>();
		return nextElems;
	}

}
