/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import dk.au.daimi.ascoveco.cpn.model.HLMarking;
import dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.Type;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Place Node</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PlaceNodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PlaceNodeImpl#getInitialMarking <em>Initial Marking</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PlaceNodeImpl extends NodeImpl implements PlaceNode {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;
	/**
	 * The cached value of the '{@link #getInitialMarking() <em>Initial Marking</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getInitialMarking()
	 * @generated
	 * @ordered
	 */
	protected HLMarking initialMarking;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PLACE_NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PLACE_NODE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin#setType(dk.au.daimi.ascoveco.cpn.model.Type)
	 */
	public void setType(final Type newType) {
		if (type != null) {
			type.setParent(null);
		}
		setTypeGen(newType);
		if (newType != null) {
			newType.setParent(this);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeGen(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PLACE_NODE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HLMarking getInitialMarking() {
		if (initialMarking != null && initialMarking.eIsProxy()) {
			InternalEObject oldInitialMarking = (InternalEObject)initialMarking;
			initialMarking = (HLMarking)eResolveProxy(oldInitialMarking);
			if (initialMarking != oldInitialMarking) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PLACE_NODE__INITIAL_MARKING, oldInitialMarking, initialMarking));
			}
		}
		return initialMarking;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HLMarking basicGetInitialMarking() {
		return initialMarking;
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin#setInitialMarking(dk.au.daimi.ascoveco.cpn.model.HLMarking)
	 */
	public void setInitialMarking(final HLMarking newInitialMarking) {
		if (initialMarking != null) {
			initialMarking.setParent(null);
		}
		setInitialMarkingGen(newInitialMarking);
		if (newInitialMarking != null) {
			newInitialMarking.setParent(this);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialMarkingGen(HLMarking newInitialMarking) {
		HLMarking oldInitialMarking = initialMarking;
		initialMarking = newInitialMarking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PLACE_NODE__INITIAL_MARKING, oldInitialMarking, initialMarking));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PLACE_NODE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ModelPackage.PLACE_NODE__INITIAL_MARKING:
				if (resolve) return getInitialMarking();
				return basicGetInitialMarking();
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
			case ModelPackage.PLACE_NODE__TYPE:
				setType((Type)newValue);
				return;
			case ModelPackage.PLACE_NODE__INITIAL_MARKING:
				setInitialMarking((HLMarking)newValue);
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
			case ModelPackage.PLACE_NODE__TYPE:
				setType((Type)null);
				return;
			case ModelPackage.PLACE_NODE__INITIAL_MARKING:
				setInitialMarking((HLMarking)null);
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
			case ModelPackage.PLACE_NODE__TYPE:
				return type != null;
			case ModelPackage.PLACE_NODE__INITIAL_MARKING:
				return initialMarking != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == HLPlaceAddin.class) {
			switch (derivedFeatureID) {
				case ModelPackage.PLACE_NODE__TYPE: return ModelPackage.HL_PLACE_ADDIN__TYPE;
				case ModelPackage.PLACE_NODE__INITIAL_MARKING: return ModelPackage.HL_PLACE_ADDIN__INITIAL_MARKING;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == HLPlaceAddin.class) {
			switch (baseFeatureID) {
				case ModelPackage.HL_PLACE_ADDIN__TYPE: return ModelPackage.PLACE_NODE__TYPE;
				case ModelPackage.HL_PLACE_ADDIN__INITIAL_MARKING: return ModelPackage.PLACE_NODE__INITIAL_MARKING;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin#isReady(boolean)
	 */
	@Override
	public boolean isReady() {
		try {
			return super.isReady() && getType().isReady(false) && getInitialMarking().isReady(true);
		} catch (final NullPointerException e) {
			return false;
		}
	}
} // PlaceNodeImpl
