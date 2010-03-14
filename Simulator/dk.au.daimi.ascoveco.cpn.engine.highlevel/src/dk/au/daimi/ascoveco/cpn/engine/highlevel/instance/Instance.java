package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import dk.au.daimi.ascoveco.cpn.model.Node;

/**
 * @model
 * @author mw
 * @param <T>
 *            (Node) type this is an instance of
 */
public interface Instance<T extends Node> extends EObject {
	/**
	 * @model containment="false"
	 * @return the node
	 */
	public T getNode();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(T value);

	/**
	 * @return
	 */
	public int getInstanceNumber();

	/**
	 * @model many="true" type="Instance<dk.au.daimi.ascoveco.cpn.model.Instance>" containment="true"
	 * @return
	 */
	public EList<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> getTransitionPath();
}
