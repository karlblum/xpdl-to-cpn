/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>CPN Real</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRealImpl#getHigh <em>High</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRealImpl#getLow <em>Low</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CPNRealImpl extends CPNTypeImpl implements CPNReal {
	/**
	 * The default value of the '{@link #getHigh() <em>High</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getHigh()
	 * @generated
	 * @ordered
	 */
	protected static final double HIGH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHigh() <em>High</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getHigh()
	 * @generated
	 * @ordered
	 */
	protected double high = HIGH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLow() <em>Low</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getLow()
	 * @generated
	 * @ordered
	 */
	protected static final double LOW_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLow() <em>Low</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLow()
	 * @generated
	 * @ordered
	 */
	protected double low = LOW_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CPNRealImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CpntypesPackage.Literals.CPN_REAL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getHigh() {
		return high;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHigh(double newHigh) {
		double oldHigh = high;
		high = newHigh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_REAL__HIGH, oldHigh, high));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getLow() {
		return low;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLow(double newLow) {
		double oldLow = low;
		low = newLow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_REAL__LOW, oldLow, low));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CpntypesPackage.CPN_REAL__HIGH:
				return getHigh();
			case CpntypesPackage.CPN_REAL__LOW:
				return getLow();
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
			case CpntypesPackage.CPN_REAL__HIGH:
				setHigh((Double)newValue);
				return;
			case CpntypesPackage.CPN_REAL__LOW:
				setLow((Double)newValue);
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
			case CpntypesPackage.CPN_REAL__HIGH:
				setHigh(HIGH_EDEFAULT);
				return;
			case CpntypesPackage.CPN_REAL__LOW:
				setLow(LOW_EDEFAULT);
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
			case CpntypesPackage.CPN_REAL__HIGH:
				return high != HIGH_EDEFAULT;
			case CpntypesPackage.CPN_REAL__LOW:
				return low != LOW_EDEFAULT;
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
		result.append(" (high: ");
		result.append(high);
		result.append(", low: ");
		result.append(low);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#asString()
	 */
	public String asString() {
		if (getHigh() == 0.0 && getLow() == 0.0) { return "real" + postFixAsString(); }
		return "real with " + getLow() + ".." + getHigh() + postFixAsString();
	}

} // CPNRealImpl
