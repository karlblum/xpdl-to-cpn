package dk.au.daimi.ascoveco.cpn.model.cpntypes;

/**
 * @model
 * @author keblov
 */
public interface CPNSubset extends CPNType {

	/**
	 * @return type we subset
	 * @model required="false"
	 */
	public String getType();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * @return function to test values
	 * @model required="false"
	 */
	public String getBy();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset#getBy <em>By</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>By</em>' attribute.
	 * @see #getBy()
	 * @generated
	 */
	void setBy(String value);

	/**
	 * @return list of allowed values
	 * @model required="false"
	 */
	public String getWith();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset#getWith <em>With</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>With</em>' attribute.
	 * @see #getWith()
	 * @generated
	 */
	void setWith(String value);
}
