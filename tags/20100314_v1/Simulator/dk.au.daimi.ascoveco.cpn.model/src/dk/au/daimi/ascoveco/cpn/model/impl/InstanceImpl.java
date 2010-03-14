/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.impl;

import dk.au.daimi.ascoveco.cpn.model.Instance;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.ParameterAssignment;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.InstanceImpl#getParameterAssignment <em>Parameter Assignment</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.InstanceImpl#getSubPageID <em>Sub Page ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceImpl extends NodeImpl implements Instance {
	/**
	 * The cached value of the '{@link #getParameterAssignment() <em>Parameter Assignment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterAssignment()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterAssignment> parameterAssignment;

	/**
	 * The default value of the '{@link #getSubPageID() <em>Sub Page ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPageID()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_PAGE_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSubPageID() <em>Sub Page ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPageID()
	 * @generated
	 * @ordered
	 */
	protected String subPageID = SUB_PAGE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterAssignment> getParameterAssignment() {
		if (parameterAssignment == null) {
			parameterAssignment = new EObjectContainmentWithInverseEList<ParameterAssignment>(ParameterAssignment.class, this, ModelPackage.INSTANCE__PARAMETER_ASSIGNMENT, ModelPackage.PARAMETER_ASSIGNMENT__INSTANCE);
		}
		return parameterAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubPageID() {
		return subPageID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubPageID(String newSubPageID) {
		String oldSubPageID = subPageID;
		subPageID = newSubPageID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INSTANCE__SUB_PAGE_ID, oldSubPageID, subPageID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.INSTANCE__PARAMETER_ASSIGNMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterAssignment()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.INSTANCE__PARAMETER_ASSIGNMENT:
				return ((InternalEList<?>)getParameterAssignment()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.INSTANCE__PARAMETER_ASSIGNMENT:
				return getParameterAssignment();
			case ModelPackage.INSTANCE__SUB_PAGE_ID:
				return getSubPageID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.INSTANCE__PARAMETER_ASSIGNMENT:
				getParameterAssignment().clear();
				getParameterAssignment().addAll((Collection<? extends ParameterAssignment>)newValue);
				return;
			case ModelPackage.INSTANCE__SUB_PAGE_ID:
				setSubPageID((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.INSTANCE__PARAMETER_ASSIGNMENT:
				getParameterAssignment().clear();
				return;
			case ModelPackage.INSTANCE__SUB_PAGE_ID:
				setSubPageID(SUB_PAGE_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.INSTANCE__PARAMETER_ASSIGNMENT:
				return parameterAssignment != null && !parameterAssignment.isEmpty();
			case ModelPackage.INSTANCE__SUB_PAGE_ID:
				return SUB_PAGE_ID_EDEFAULT == null ? subPageID != null : !SUB_PAGE_ID_EDEFAULT.equals(subPageID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (subPageID: ");
		result.append(subPageID);
		result.append(')');
		return result.toString();
	}

} //InstanceImpl
