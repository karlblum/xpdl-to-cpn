package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true" interface="true"
 * @author michael
 */
public interface HLPlaceAddin extends EObject {
	/**
	 * @model required="false"
	 * @return the type region of the place
	 */
	public Type getType();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin#getType <em>Type</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * @model required="false"
	 * @return the initial marking of the place
	 */
	public HLMarking getInitialMarking();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin#getInitialMarking <em>Initial Marking</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Marking</em>' reference.
	 * @see #getInitialMarking()
	 * @generated
	 */
	void setInitialMarking(HLMarking value);
}
