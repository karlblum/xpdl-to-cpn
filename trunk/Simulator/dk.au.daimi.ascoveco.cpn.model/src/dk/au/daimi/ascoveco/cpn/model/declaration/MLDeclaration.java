package dk.au.daimi.ascoveco.cpn.model.declaration;

/**
 * @model
 * @author michael
 */
public interface MLDeclaration extends DeclarationStructure {
	/**
	 * @model required="true"
	 * @return code
	 */
	public String getCode();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.MLDeclaration#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);
}
