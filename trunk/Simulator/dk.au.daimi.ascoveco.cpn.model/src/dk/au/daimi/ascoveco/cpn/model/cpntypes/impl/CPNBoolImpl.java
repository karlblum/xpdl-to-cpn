/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>CPN Bool</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNBoolImpl#getTrueValue <em>True Value</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNBoolImpl#getFalseValue <em>False Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CPNBoolImpl extends CPNTypeImpl implements CPNBool {
	/**
	 * The default value of the '{@link #getTrueValue() <em>True Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTrueValue()
	 * @generated
	 * @ordered
	 */
	protected static final String TRUE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrueValue() <em>True Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTrueValue()
	 * @generated
	 * @ordered
	 */
	protected String trueValue = TRUE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFalseValue() <em>False Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFalseValue()
	 * @generated
	 * @ordered
	 */
	protected static final String FALSE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFalseValue() <em>False Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFalseValue()
	 * @generated
	 * @ordered
	 */
	protected String falseValue = FALSE_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CPNBoolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CpntypesPackage.Literals.CPN_BOOL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTrueValue() {
		return trueValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueValue(String newTrueValue) {
		String oldTrueValue = trueValue;
		trueValue = newTrueValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_BOOL__TRUE_VALUE, oldTrueValue, trueValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFalseValue() {
		return falseValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFalseValue(String newFalseValue) {
		String oldFalseValue = falseValue;
		falseValue = newFalseValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_BOOL__FALSE_VALUE, oldFalseValue, falseValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CpntypesPackage.CPN_BOOL__TRUE_VALUE:
				return getTrueValue();
			case CpntypesPackage.CPN_BOOL__FALSE_VALUE:
				return getFalseValue();
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
			case CpntypesPackage.CPN_BOOL__TRUE_VALUE:
				setTrueValue((String)newValue);
				return;
			case CpntypesPackage.CPN_BOOL__FALSE_VALUE:
				setFalseValue((String)newValue);
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
			case CpntypesPackage.CPN_BOOL__TRUE_VALUE:
				setTrueValue(TRUE_VALUE_EDEFAULT);
				return;
			case CpntypesPackage.CPN_BOOL__FALSE_VALUE:
				setFalseValue(FALSE_VALUE_EDEFAULT);
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
			case CpntypesPackage.CPN_BOOL__TRUE_VALUE:
				return TRUE_VALUE_EDEFAULT == null ? trueValue != null : !TRUE_VALUE_EDEFAULT.equals(trueValue);
			case CpntypesPackage.CPN_BOOL__FALSE_VALUE:
				return FALSE_VALUE_EDEFAULT == null ? falseValue != null : !FALSE_VALUE_EDEFAULT.equals(falseValue);
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
		result.append(" (trueValue: ");
		result.append(trueValue);
		result.append(", falseValue: ");
		result.append(falseValue);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#asString()
	 */
	public String asString() {
		String appendString = "";
		if (getFalseValue() != null) {
			appendString = " with (" + getFalseValue() + ", " + getTrueValue() + ')';
		}
		return "bool" + postFixAsString() + appendString;
	}

} // CPNBoolImpl
