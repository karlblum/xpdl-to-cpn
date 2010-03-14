/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>CPN Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNTypeImpl#getDeclares <em>Declares</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNTypeImpl#getTimed <em>Timed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CPNTypeImpl extends EObjectImpl implements CPNType {
	/**
	 * The cached value of the '{@link #getDeclares() <em>Declares</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDeclares()
	 * @generated
	 * @ordered
	 */
	protected EList<String> declares;
	/**
	 * The default value of the '{@link #getTimed() <em>Timed</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTimed()
	 * @generated NOT
	 * @ordered
	 */
	protected static final Boolean TIMED_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getTimed() <em>Timed</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getTimed()
	 * @generated
	 * @ordered
	 */
	protected Boolean timed = TIMED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CPNTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CpntypesPackage.Literals.CPN_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getDeclares() {
		if (declares == null) {
			declares = new EDataTypeUniqueEList<String>(String.class, this, CpntypesPackage.CPN_TYPE__DECLARES);
		}
		return declares;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getTimed() {
		return timed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimed(Boolean newTimed) {
		Boolean oldTimed = timed;
		timed = newTimed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_TYPE__TIMED, oldTimed, timed));
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#addDeclare(java.lang.String)
	 */
	public void addDeclare(final String declare) {
		getDeclares().add(declare);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CpntypesPackage.CPN_TYPE__DECLARES:
				return getDeclares();
			case CpntypesPackage.CPN_TYPE__TIMED:
				return getTimed();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CpntypesPackage.CPN_TYPE__DECLARES:
				getDeclares().clear();
				getDeclares().addAll((Collection<? extends String>)newValue);
				return;
			case CpntypesPackage.CPN_TYPE__TIMED:
				setTimed((Boolean)newValue);
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
			case CpntypesPackage.CPN_TYPE__DECLARES:
				getDeclares().clear();
				return;
			case CpntypesPackage.CPN_TYPE__TIMED:
				setTimed(TIMED_EDEFAULT);
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
			case CpntypesPackage.CPN_TYPE__DECLARES:
				return declares != null && !declares.isEmpty();
			case CpntypesPackage.CPN_TYPE__TIMED:
				return TIMED_EDEFAULT == null ? timed != null : !TIMED_EDEFAULT.equals(timed);
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
		result.append(" (declares: ");
		result.append(declares);
		result.append(", timed: ");
		result.append(timed);
		result.append(')');
		return result.toString();
	}

	protected String postFixAsString() {
		final StringBuilder sb = new StringBuilder();
		if (getTimed()) {
			sb.append(" timed");
		}
		final boolean kludge = false;
		for (final String declare : getDeclares()) {
			if (kludge) {
				sb.append(", ");
			} else {
				sb.append(" declare ");
			}
			sb.append(declare);
		}
		return sb.toString();
	}

} // CPNTypeImpl
