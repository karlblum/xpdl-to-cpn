package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 * @author michael
 */
public interface ParameterAssignment extends EObject {
	/**
	 * @model
	 * @return id of Place parameter (socket)
	 */
	String getParameter();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment#getParameter <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' attribute.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(String value);

	/**
	 * @model
	 * @return id of RefPlace (port)
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * @return the instance owning this parameter assignment
	 * @model containment="false"
	 */
	Instance getInstance();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment#getInstance <em>Instance</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' container reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(Instance value);
}
