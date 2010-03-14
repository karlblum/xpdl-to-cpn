/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>CPN List</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNListImpl#getType <em>Type</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNListImpl#getLow <em>Low</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNListImpl#getHigh <em>High</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CPNListImpl extends CPNTypeImpl implements CPNList {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;
	/**
	 * The default value of the '{@link #getLow() <em>Low</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getLow()
	 * @generated
	 * @ordered
	 */
	protected static final String LOW_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLow() <em>Low</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLow()
	 * @generated
	 * @ordered
	 */
	protected String low = LOW_EDEFAULT;
	/**
	 * The default value of the '{@link #getHigh() <em>High</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getHigh()
	 * @generated
	 * @ordered
	 */
	protected static final String HIGH_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getHigh() <em>High</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getHigh()
	 * @generated
	 * @ordered
	 */
	protected String high = HIGH_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CPNListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CpntypesPackage.Literals.CPN_LIST;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_LIST__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLow() {
		return low;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLow(String newLow) {
		String oldLow = low;
		low = newLow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_LIST__LOW, oldLow, low));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHigh() {
		return high;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHigh(String newHigh) {
		String oldHigh = high;
		high = newHigh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_LIST__HIGH, oldHigh, high));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CpntypesPackage.CPN_LIST__TYPE:
				return getType();
			case CpntypesPackage.CPN_LIST__LOW:
				return getLow();
			case CpntypesPackage.CPN_LIST__HIGH:
				return getHigh();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CpntypesPackage.CPN_LIST__TYPE:
				setType((String)newValue);
				return;
			case CpntypesPackage.CPN_LIST__LOW:
				setLow((String)newValue);
				return;
			case CpntypesPackage.CPN_LIST__HIGH:
				setHigh((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CpntypesPackage.CPN_LIST__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CpntypesPackage.CPN_LIST__LOW:
				setLow(LOW_EDEFAULT);
				return;
			case CpntypesPackage.CPN_LIST__HIGH:
				setHigh(HIGH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CpntypesPackage.CPN_LIST__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case CpntypesPackage.CPN_LIST__LOW:
				return LOW_EDEFAULT == null ? low != null : !LOW_EDEFAULT.equals(low);
			case CpntypesPackage.CPN_LIST__HIGH:
				return HIGH_EDEFAULT == null ? high != null : !HIGH_EDEFAULT.equals(high);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(", low: ");
		result.append(low);
		result.append(", high: ");
		result.append(high);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#asString()
	 */
	public String asString() {
		return "list " + getType() + postFixAsString();
	}

} // CPNListImpl
