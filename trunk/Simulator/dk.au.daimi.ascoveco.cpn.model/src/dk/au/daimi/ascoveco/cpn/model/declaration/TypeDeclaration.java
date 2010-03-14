package dk.au.daimi.ascoveco.cpn.model.declaration;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType;

/**
 * @model
 * @author michael
 */
public interface TypeDeclaration extends DeclarationStructure {
	/**
	 * @model required="true"
	 * @return name of declared type
	 */
	public String getTypeName();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);

	/**
	 * @model containment="true"
	 * @return type of declared type
	 */
	public CPNType getType();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(CPNType value);
}
