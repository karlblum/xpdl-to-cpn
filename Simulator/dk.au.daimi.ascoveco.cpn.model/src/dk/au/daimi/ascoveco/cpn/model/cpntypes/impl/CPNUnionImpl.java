/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesFactory;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>CPN Union</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNUnionImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CPNUnionImpl extends CPNTypeImpl implements CPNUnion {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<NameTypePair> values;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CPNUnionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CpntypesPackage.Literals.CPN_UNION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NameTypePair> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<NameTypePair>(NameTypePair.class, this, CpntypesPackage.CPN_UNION__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CpntypesPackage.CPN_UNION__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CpntypesPackage.CPN_UNION__VALUES:
				return getValues();
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
			case CpntypesPackage.CPN_UNION__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends NameTypePair>)newValue);
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
			case CpntypesPackage.CPN_UNION__VALUES:
				getValues().clear();
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
			case CpntypesPackage.CPN_UNION__VALUES:
				return values != null && !values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#asString()
	 */
	public String asString() {
		final StringBuilder sb = new StringBuilder();
		boolean kludge = false;
		sb.append("union ");
		for (final NameTypePair value : getValues()) {
			if (kludge) {
				sb.append(" + ");
			}
			kludge = true;
			sb.append(value.getName());
			sb.append(": ");
			sb.append(value.getType());
		}
		sb.append(postFixAsString());
		return sb.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion#addValue(java.lang.String, java.lang.String)
	 */
	public void addValue(final String id, final String name) {
		final NameTypePair ntPair = CpntypesFactory.eINSTANCE.createNameTypePair();
		ntPair.setName(id);
		ntPair.setType(name);
		getValues().add(ntPair);
	}

} // CPNUnionImpl
