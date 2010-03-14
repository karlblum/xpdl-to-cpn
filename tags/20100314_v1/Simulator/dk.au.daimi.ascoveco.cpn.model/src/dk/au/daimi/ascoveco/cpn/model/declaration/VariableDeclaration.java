package dk.au.daimi.ascoveco.cpn.model.declaration;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author michael
 */
public interface VariableDeclaration extends DeclarationStructure {
	/**
	 * @model required="true"
	 * @return type of variables
	 */
	public String getTypeName();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.VariableDeclaration#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);

	/**
	 * @model required="true" type="String"
	 * @return names of variables
	 */
	public EList<String> getVariables();

	/**
	 * @param var new variable to add to decl
	 */
	public void addVariable(String var);
}
