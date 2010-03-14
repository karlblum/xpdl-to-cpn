package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import dk.au.daimi.ascoveco.cpn.model.TransitionNode;

/**
 * @model
 * @author michael
 */
public interface Binding extends EObject {
	/**
	 * @model containment="true"
	 * @return
	 */
	Instance<TransitionNode> getTransitionInstance();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding#getTransitionInstance <em>Transition Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition Instance</em>' containment reference.
	 * @see #getTransitionInstance()
	 * @generated
	 */
	void setTransitionInstance(Instance<TransitionNode> value);

	/**
	 * @param name
	 * @return
	 */
	ValueAssignment getValueAssignment(String name);

	/**
	 * @model containment="true"
	 * @return
	 */
	EList<ValueAssignment> getAllAssignments();
}
