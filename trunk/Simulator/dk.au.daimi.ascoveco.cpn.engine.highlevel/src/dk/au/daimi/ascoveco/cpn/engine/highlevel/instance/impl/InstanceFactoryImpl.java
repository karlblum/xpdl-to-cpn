/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstancePackage;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.State;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment;
import dk.au.daimi.ascoveco.cpn.model.Node;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.TransitionNode;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class InstanceFactoryImpl extends EFactoryImpl implements InstanceFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static InstanceFactory init() {
		try {
			final InstanceFactory theInstanceFactory = (InstanceFactory) EPackage.Registry.INSTANCE
			        .getEFactory("http:///dk/au/daimi/ascoveco/cpn/engine/highlevel/instance.ecore");
			if (theInstanceFactory != null) { return theInstanceFactory; }
		} catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InstanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(final EClass eClass) {
		switch (eClass.getClassifierID()) {
		case InstancePackage.INSTANCE:
			return createInstance();
		case InstancePackage.MARKING:
			return createMarking();
		case InstancePackage.STATE:
			return createState();
		case InstancePackage.MULTISET_ENTRY:
			return createMultisetEntry();
		case InstancePackage.BINDING:
			return createBinding();
		case InstancePackage.VALUE_ASSIGNMENT:
			return createValueAssignment();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public <T extends Node> Instance<T> createInstance() {
		final InstanceImpl<T> instance = new InstanceImpl<T>();
		return instance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Marking createMarking() {
		final MarkingImpl marking = new MarkingImpl();
		return marking;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public State createState() {
		final StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultisetEntry createMultisetEntry() {
		final MultisetEntryImpl multisetEntry = new MultisetEntryImpl();
		return multisetEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Binding createBinding() {
		final BindingImpl binding = new BindingImpl();
		return binding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ValueAssignment createValueAssignment() {
		final ValueAssignmentImpl valueAssignment = new ValueAssignmentImpl();
		return valueAssignment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstancePackage getInstancePackage() {
		return (InstancePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InstancePackage getPackage() {
		return InstancePackage.eINSTANCE;
	}

	/**
	 * @param node
	 * @param instanceNumber
	 * @param <T>
	 * @return
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory#createInstance(dk.au.daimi.ascoveco.cpn.model.Node,
	 *      int)
	 */
	public <T extends Node> Instance<T> createInstance(final T node, final int instanceNumber) {
		return new InstanceImpl<T>(node, instanceNumber);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory#createMarking(java.lang.String)
	 */
	public Marking createMarking(final String marking) {
		return new MarkingImpl(-1, marking);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory#createMarking(int, java.lang.String)
	 */
	public Marking createMarking(final int tokens, final String marking) {
		return new MarkingImpl(tokens, marking);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory#createState(java.util.List)
	 */
	public State createState(final List<Marking> markings) {
		final StateImpl state = new StateImpl(markings);
		return state;
	}

	/**
	 * @param <T>
	 * @param node
	 * @param transitionList
	 * @return
	 */
	public <T extends Node> Instance<T> createInstance(final T node,
	        final List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionList) {
		return new InstanceImpl<T>(node, transitionList);
	}

	/**
	 * @param <T>
	 * @param node
	 * @param instanceNumber
	 * @param transitionList
	 * @return
	 */
	public <T extends Node> Instance<T> createInstance(final T node, final int instanceNumber,
	        final List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionList) {
		return new InstanceImpl<T>(node, instanceNumber, transitionList);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory#createMarking(dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance,
	 *      java.util.List)
	 */
	public Marking createMarking(final Instance<PlaceNode> placeInstance, final List<MultisetEntry> marking) {
		return new MarkingImpl(placeInstance, marking);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory#createMarking(dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance,
	 *      java.util.List)
	 */
	public Marking createMarking(final Instance<PlaceNode> placeInstance) {
		return new MarkingImpl(placeInstance);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory#createMultisetEntry(int,
	 *      java.lang.String)
	 */
	public MultisetEntry createMultisetEntry(final int coefficient, final String value) {
		return new MultisetEntryImpl(coefficient, value);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory#createBinding(dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance,
	 *      java.util.List)
	 */
	public Binding createBinding(final Instance<TransitionNode> transition, final List<ValueAssignment> assignements) {
		return new BindingImpl(transition, assignements);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory#createValueAssignment(java.lang.String,
	 *      java.lang.String)
	 */
	public ValueAssignment createValueAssignment(final String name, final String value) {
		return new ValueAssignmentImpl(name, value);
	}

} // InstanceFactoryImpl
