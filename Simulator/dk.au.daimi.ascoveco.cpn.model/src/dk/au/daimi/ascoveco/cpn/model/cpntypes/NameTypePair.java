package dk.au.daimi.ascoveco.cpn.model.cpntypes;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 * @author keblov
 */
public interface NameTypePair extends EObject {

	/**
	 * @return type name
	 * @model
	 */
	public String getName();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * @return id of type
	 * @model
	 */
	public String getType();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

}
