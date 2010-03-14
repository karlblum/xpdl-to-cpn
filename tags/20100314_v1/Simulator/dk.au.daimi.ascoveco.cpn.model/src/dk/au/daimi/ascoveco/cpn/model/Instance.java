package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author michael
 */
public interface Instance extends Node {
	/**
	 * @model type="ParameterAssignment" opposite="instance" containment="true"
	 * @return the parameter assignement of the instance/subst. transition
	 */
	EList<ParameterAssignment> getParameterAssignment();

	/**
	 * @model
	 * @return the id of the sub-page
	 */
	String getSubPageID();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.Instance#getSubPageID <em>Sub Page ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Page ID</em>' attribute.
	 * @see #getSubPageID()
	 * @generated
	 */
	void setSubPageID(String value);
}
