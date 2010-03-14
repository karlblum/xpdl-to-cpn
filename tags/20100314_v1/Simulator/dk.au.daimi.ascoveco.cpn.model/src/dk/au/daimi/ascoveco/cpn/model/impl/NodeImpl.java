/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import dk.au.daimi.ascoveco.cpn.model.Arc;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.Node;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Node</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.NodeImpl#getSourceArc <em>Source Arc</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.NodeImpl#getTargetArc <em>Target Arc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NodeImpl extends ObjectImpl implements Node {
	/**
	 * The cached value of the '{@link #getSourceArc() <em>Source Arc</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceArc()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> sourceArc;

	/**
	 * The cached value of the '{@link #getTargetArc() <em>Target Arc</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetArc()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> targetArc;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arc> getSourceArc() {
		if (sourceArc == null) {
			sourceArc = new EObjectWithInverseResolvingEList<Arc>(Arc.class, this, ModelPackage.NODE__SOURCE_ARC, ModelPackage.ARC__SOURCE);
		}
		return sourceArc;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arc> getTargetArc() {
		if (targetArc == null) {
			targetArc = new EObjectWithInverseResolvingEList<Arc>(Arc.class, this, ModelPackage.NODE__TARGET_ARC, ModelPackage.ARC__TARGET);
		}
		return targetArc;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.NODE__SOURCE_ARC:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceArc()).basicAdd(otherEnd, msgs);
			case ModelPackage.NODE__TARGET_ARC:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetArc()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.NODE__SOURCE_ARC:
				return ((InternalEList<?>)getSourceArc()).basicRemove(otherEnd, msgs);
			case ModelPackage.NODE__TARGET_ARC:
				return ((InternalEList<?>)getTargetArc()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.NODE__SOURCE_ARC:
				return getSourceArc();
			case ModelPackage.NODE__TARGET_ARC:
				return getTargetArc();
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
			case ModelPackage.NODE__SOURCE_ARC:
				getSourceArc().clear();
				getSourceArc().addAll((Collection<? extends Arc>)newValue);
				return;
			case ModelPackage.NODE__TARGET_ARC:
				getTargetArc().clear();
				getTargetArc().addAll((Collection<? extends Arc>)newValue);
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
			case ModelPackage.NODE__SOURCE_ARC:
				getSourceArc().clear();
				return;
			case ModelPackage.NODE__TARGET_ARC:
				getTargetArc().clear();
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
			case ModelPackage.NODE__SOURCE_ARC:
				return sourceArc != null && !sourceArc.isEmpty();
			case ModelPackage.NODE__TARGET_ARC:
				return targetArc != null && !targetArc.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin#isReady(boolean)
	 */
	public boolean isReady() {
		return getName().isReady(false);
	}
} // NodeImpl
