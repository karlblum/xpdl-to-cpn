package dk.au.daimi.ascoveco.cpn.model;

import dk.au.daimi.ascoveco.cpn.model.declaration.DeclarationStructure;

/**
 * @model
 * @author michael Renamed from the standard to not collide
 */
public interface HLDeclaration extends Annotation, HasId {
	/**
	 * @model containment="true" required="false"
	 * @return a structured representation of the decl
	 */
	public DeclarationStructure getStructure();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.HLDeclaration#getStructure <em>Structure</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structure</em>' containment reference.
	 * @see #getStructure()
	 * @generated
	 */
	void setStructure(DeclarationStructure value);
}
