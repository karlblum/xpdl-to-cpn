package dk.au.daimi.ascoveco.cpn.model.cpntypes;

/**
 * @model
 * @author michael
 */
public interface CPNList extends CPNType {
	/**
	 * @return type we are list over
	 * @model required="true"
	 */
	public String getType();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * @return lower value
	 * @model required="false"
	 */
	public String getLow();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList#getLow <em>Low</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Low</em>' attribute.
	 * @see #getLow()
	 * @generated
	 */
	void setLow(String value);

	/**
	 * @return higher value
	 * @model required="false"
	 */
	public String getHigh();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList#getHigh <em>High</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>High</em>' attribute.
	 * @see #getHigh()
	 * @generated
	 */
	void setHigh(String value);

}
