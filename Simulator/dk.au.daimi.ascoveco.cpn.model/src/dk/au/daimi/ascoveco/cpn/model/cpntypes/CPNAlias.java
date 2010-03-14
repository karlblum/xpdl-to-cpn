package dk.au.daimi.ascoveco.cpn.model.cpntypes;

/**
 * @model
 * @author michael
 */
public interface CPNAlias extends CPNType {
	/**
	 * @return type type we are alias for
	 * @model required="true"
	 */
	public String getType();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);
}
