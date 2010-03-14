/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance;

import java.util.List;

import org.eclipse.emf.ecore.EFactory;

import dk.au.daimi.ascoveco.cpn.model.Node;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.TransitionNode;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstancePackage
 * @generated
 */
public interface InstanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	InstanceFactory eINSTANCE = dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Instance</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Instance</em>'.
	 * @generated
	 */
	<T extends Node> Instance<T> createInstance();

	/**
	 * @param <T>
	 *            type of node
	 * @param node
	 *            node
	 * @param instanceNumber
	 *            instance number
	 * @return an instance of the given node and instance number
	 */
	<T extends Node> Instance<T> createInstance(T node, int instanceNumber);

	/**
	 * @param <T>
	 * @param node
	 * @param transitionList
	 * @return
	 */
	<T extends Node> Instance<T> createInstance(T node,
	        List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionList);

	/**
	 * @param <T>
	 * @param node
	 * @param instanceNumber
	 * @param transitionList
	 * @return
	 */
	<T extends Node> Instance<T> createInstance(T node, int instanceNumber,
	        List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionList);

	/**
	 * Returns a new object of class '<em>Marking</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Marking</em>'.
	 * @generated
	 */
	Marking createMarking();

	/**
	 * @param placeInstance
	 * @param marking
	 * @return
	 */
	Marking createMarking(Instance<PlaceNode> placeInstance, List<MultisetEntry> marking);

	/**
	 * Returns a new object of class '<em>State</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Multiset Entry</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Multiset Entry</em>'.
	 * @generated
	 */
	MultisetEntry createMultisetEntry();

	/**
	 * Returns a new object of class '<em>Binding</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Binding</em>'.
	 * @generated
	 */
	Binding createBinding();

	/**
	 * @param transition
	 * @param assignments
	 * @return
	 */
	Binding createBinding(Instance<TransitionNode> transition, List<ValueAssignment> assignments);

	/**
	 * Returns a new object of class '<em>Value Assignment</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Value Assignment</em>'.
	 * @generated
	 */
	ValueAssignment createValueAssignment();

	/**
	 * @param name
	 * @param value
	 * @return
	 */
	ValueAssignment createValueAssignment(String name, String value);

	/**
	 * @param coefficient
	 * @param value
	 * @return
	 */
	MultisetEntry createMultisetEntry(int coefficient, String value);

	/**
	 * @param markings
	 * @return
	 */
	State createState(List<Marking> markings);

	/**
	 * @param marking
	 *            the marking
	 * @return a marking with the given marking (useful for setting the marking of a place)
	 */
	Marking createMarking(String marking);

	/**
	 * @param tokens
	 *            number of tokens
	 * @param marking
	 *            the marking
	 * @return a marking with the given number of tokens and marking
	 */
	Marking createMarking(int tokens, String marking);

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	InstancePackage getInstancePackage();

	/**
	 * @param pi
	 * @return
	 */
	Marking createMarking(Instance<PlaceNode> pi);

} // InstanceFactory
