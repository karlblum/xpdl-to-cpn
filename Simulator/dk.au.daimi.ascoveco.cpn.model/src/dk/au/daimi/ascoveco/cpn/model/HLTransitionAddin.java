package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true" interface="true"
 * @author michael
 */
public interface HLTransitionAddin extends EObject {
	/**
	 * @model required="false"
	 * @return the condifition/guard region of the transition
	 */
	public Condition getCondition();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Condition value);
}
