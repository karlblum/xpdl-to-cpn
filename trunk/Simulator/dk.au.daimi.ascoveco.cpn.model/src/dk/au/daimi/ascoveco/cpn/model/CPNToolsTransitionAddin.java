package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true" interface="true"
 * @author michael
 */
public interface CPNToolsTransitionAddin extends EObject {
	/**
	 * @model required="false"
	 * @return the code region
	 */
	public Code getCode();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin#getCode <em>Code</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' reference.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(Code value);

	/**
	 * @model required="false"
	 * @return the time region
	 */
	public Time getTime();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin#getTime <em>Time</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' reference.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(Time value);
}
