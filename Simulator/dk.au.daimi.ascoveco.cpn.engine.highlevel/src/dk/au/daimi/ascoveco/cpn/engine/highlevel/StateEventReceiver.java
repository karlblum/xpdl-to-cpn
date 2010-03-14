package dk.au.daimi.ascoveco.cpn.engine.highlevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.State;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.TransitionNode;

/**
 * @author michael
 */
public abstract class StateEventReceiver {
	private final Map<String, Page> pages;
	private final Map<String, PlaceNode> places;
	private final Map<String, TransitionNode> transitions;
	private final Map<String, dk.au.daimi.ascoveco.cpn.model.Instance> instances;

	private final Map<Instance<PlaceNode>, Instance<PlaceNode>> placeInstances;
	private final Map<Instance<TransitionNode>, Instance<TransitionNode>> transitionInstances;
	private final Map<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>, Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> instanceInstances;

	/**
	 * @param net
	 */
	public StateEventReceiver(final PetriNet net) {
		pages = new HashMap<String, Page>();
		places = new HashMap<String, PlaceNode>();
		transitions = new HashMap<String, TransitionNode>();
		instances = new HashMap<String, dk.au.daimi.ascoveco.cpn.model.Instance>();
		placeInstances = new HashMap<Instance<PlaceNode>, Instance<PlaceNode>>();
		transitionInstances = new HashMap<Instance<TransitionNode>, Instance<TransitionNode>>();
		instanceInstances = new HashMap<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>, Instance<dk.au.daimi.ascoveco.cpn.model.Instance>>();
		for (final Page p : net.getPage()) {
			pages.put(p.getId(), p);
			for (final Object o : p.getObject()) {
				if (o instanceof PlaceNode) {
					final PlaceNode place = (PlaceNode) o;
					places.put(place.getId(), place);
				}
				if (o instanceof TransitionNode) {
					final TransitionNode transition = (TransitionNode) o;
					transitions.put(transition.getId(), transition);
				}
				if (o instanceof dk.au.daimi.ascoveco.cpn.model.Instance) {
					final dk.au.daimi.ascoveco.cpn.model.Instance instance = (dk.au.daimi.ascoveco.cpn.model.Instance) o;
					instances.put(instance.getId(), instance);
				}
			}
		}
	}

	protected Binding parseBinding(final List<?> descriptor) {
		assert descriptor.size() >= 2;
		assert descriptor.get(0) instanceof List<?>;
		final Instance<TransitionNode> transition = parseTransitionInstance((List<?>) descriptor.get(0));
		assert descriptor.get(1) instanceof List<?>;
		final List<ValueAssignment> assignments = parseAssignments((List<?>) descriptor.get(1));
		return InstanceFactory.eINSTANCE.createBinding(transition, assignments);
	}

	private List<ValueAssignment> parseAssignments(final List<?> assignmentDescriptor) {
		final List<ValueAssignment> result = new ArrayList<ValueAssignment>(assignmentDescriptor.size());
		for (final Object entry : assignmentDescriptor) {
			assert entry instanceof List<?>;
			result.add(parseValueAssignment((List<?>) entry));
		}
		return result;
	}

	private ValueAssignment parseValueAssignment(final List<?> entry) {
		assert entry.size() >= 2;
		assert entry.get(0) instanceof String;
		assert entry.get(1) instanceof String;
		return InstanceFactory.eINSTANCE.createValueAssignment((String) entry.get(0), (String) entry.get(1));
	}

	private Instance<TransitionNode> parseTransitionInstance(final List<?> transitionInstanceDescriptor) {
		assert transitionInstanceDescriptor.size() >= 1;
		final TransitionNode t = transitions.get(transitionInstanceDescriptor.get(0));
		assert t != null;
		final List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionPath = parseTransitionPath(
		        transitionInstanceDescriptor, 1);
		final Instance<TransitionNode> instance = InstanceFactory.eINSTANCE.createInstance(t, transitionPath);
		final Instance<TransitionNode> oldInstance = transitionInstances.get(instance);
		if (oldInstance == null) {
			transitionInstances.put(instance, instance);
			return instance;
		}
		System.out.println();
		return oldInstance;
	}

	protected State parseState(final List<?> descriptor) {
		final List<Marking> markings = new ArrayList<Marking>(descriptor.size());
		for (final Object o : descriptor) {
			assert o instanceof List<?>;
			final List<?> markingDescriptor = (List<?>) o;
			markings.add(parseMarking(markingDescriptor));
		}
		return InstanceFactory.eINSTANCE.createState(markings);
	}

	private Marking parseMarking(final List<?> markingDescriptor) {
		assert markingDescriptor.size() >= 2;
		assert markingDescriptor.get(0) instanceof List<?>;
		final Instance<PlaceNode> placeInstance = parsePlaceInstance((List<?>) markingDescriptor.get(0));
		assert markingDescriptor.get(1) instanceof List<?>;
		final List<MultisetEntry> multiset = parseMultiset((List<?>) markingDescriptor.get(1));
		return InstanceFactory.eINSTANCE.createMarking(placeInstance, multiset);
	}

	private List<MultisetEntry> parseMultiset(final List<?> list) {
		final List<MultisetEntry> result = new ArrayList<MultisetEntry>(list.size());
		for (final Object entry : list) {
			assert entry instanceof List<?>;
			result.add(parseMultisetEntry((List<?>) entry));
		}
		return result;
	}

	private MultisetEntry parseMultisetEntry(final List<?> entry) {
		assert entry.size() >= 2;
		assert entry.get(0) instanceof Integer;
		assert entry.get(1) instanceof String;
		return InstanceFactory.eINSTANCE.createMultisetEntry((Integer) entry.get(0), (String) entry.get(1));
	}

	private Instance<PlaceNode> parsePlaceInstance(final List<?> placeInstanceDescriptor) {
		assert placeInstanceDescriptor.size() >= 1;
		final PlaceNode p = places.get(placeInstanceDescriptor.get(0));
		assert p != null;
		final List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionPath = parseTransitionPath(
		        placeInstanceDescriptor, 1);
		final Instance<PlaceNode> instance = InstanceFactory.eINSTANCE.createInstance(p, transitionPath);
		final Instance<PlaceNode> oldInstance = placeInstances.get(instance);
		if (oldInstance == null) {
			placeInstances.put(instance, instance);
			return instance;
		}
		return oldInstance;
	}

	private List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> parseTransitionPath(
	        final List<?> transitionPathDescriptor, final int first) {
		final List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> result = new ArrayList<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>>(
		        transitionPathDescriptor.size());
		if (first == transitionPathDescriptor.size()) { return result; }
		final dk.au.daimi.ascoveco.cpn.model.Instance i = instances.get(transitionPathDescriptor.get(first));
		assert i != null;
		final List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionPath = parseTransitionPath(
		        transitionPathDescriptor, first + 1);
		result.addAll(transitionPath);
		final Instance<dk.au.daimi.ascoveco.cpn.model.Instance> instance = InstanceFactory.eINSTANCE.createInstance(i,
		        transitionPath);
		final Instance<dk.au.daimi.ascoveco.cpn.model.Instance> oldInstance = instanceInstances.get(instance);
		if (oldInstance == null) {
			instanceInstances.put(instance, instance);
			result.add(instance);
		} else {
			result.add(oldInstance);
		}
		return result;
	}
}
