/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import dk.au.daimi.ascoveco.cpn.model.Arc;
import dk.au.daimi.ascoveco.cpn.model.HLAnnotation;
import dk.au.daimi.ascoveco.cpn.model.HLArcType;
import dk.au.daimi.ascoveco.cpn.model.HasId;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.Node;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.Transition;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Arc</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl#getType <em>Type</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl#getHlinscription <em>Hlinscription</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl#getId <em>Id</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl#getSource <em>Source</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl#getPage <em>Page</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArcImpl extends EObjectImpl implements Arc {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final HLArcType TYPE_EDEFAULT = HLArcType.NORMAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected HLArcType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHlinscription() <em>Hlinscription</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHlinscription()
	 * @generated
	 * @ordered
	 */
	protected HLAnnotation hlinscription;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ArcImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ARC;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HLArcType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(HLArcType newType) {
		HLArcType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ARC__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HLAnnotation getHlinscription() {
		return hlinscription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHlinscription(HLAnnotation newHlinscription, NotificationChain msgs) {
		HLAnnotation oldHlinscription = hlinscription;
		hlinscription = newHlinscription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ARC__HLINSCRIPTION, oldHlinscription, newHlinscription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHlinscription(HLAnnotation newHlinscription) {
		if (newHlinscription != hlinscription) {
			NotificationChain msgs = null;
			if (hlinscription != null)
				msgs = ((InternalEObject)hlinscription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ARC__HLINSCRIPTION, null, msgs);
			if (newHlinscription != null)
				msgs = ((InternalEObject)newHlinscription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ARC__HLINSCRIPTION, null, msgs);
			msgs = basicSetHlinscription(newHlinscription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ARC__HLINSCRIPTION, newHlinscription, newHlinscription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ARC__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Node)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ARC__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Node newSource, NotificationChain msgs) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ARC__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Node newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, ModelPackage.NODE__SOURCE_ARC, Node.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, ModelPackage.NODE__SOURCE_ARC, Node.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ARC__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Node)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ARC__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Node newTarget, NotificationChain msgs) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ARC__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, ModelPackage.NODE__TARGET_ARC, Node.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, ModelPackage.NODE__TARGET_ARC, Node.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ARC__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Page getPage() {
		if (eContainerFeatureID() != ModelPackage.ARC__PAGE) return null;
		return (Page)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPage(Page newPage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPage, ModelPackage.ARC__PAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPage(Page newPage) {
		if (newPage != eInternalContainer() || (eContainerFeatureID() != ModelPackage.ARC__PAGE && newPage != null)) {
			if (EcoreUtil.isAncestor(this, newPage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPage != null)
				msgs = ((InternalEObject)newPage).eInverseAdd(this, ModelPackage.PAGE__ARC, Page.class, msgs);
			msgs = basicSetPage(newPage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ARC__PAGE, newPage, newPage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ARC__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, ModelPackage.NODE__SOURCE_ARC, Node.class, msgs);
				return basicSetSource((Node)otherEnd, msgs);
			case ModelPackage.ARC__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, ModelPackage.NODE__TARGET_ARC, Node.class, msgs);
				return basicSetTarget((Node)otherEnd, msgs);
			case ModelPackage.ARC__PAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPage((Page)otherEnd, msgs);
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
			case ModelPackage.ARC__HLINSCRIPTION:
				return basicSetHlinscription(null, msgs);
			case ModelPackage.ARC__SOURCE:
				return basicSetSource(null, msgs);
			case ModelPackage.ARC__TARGET:
				return basicSetTarget(null, msgs);
			case ModelPackage.ARC__PAGE:
				return basicSetPage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.ARC__PAGE:
				return eInternalContainer().eInverseRemove(this, ModelPackage.PAGE__ARC, Page.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ARC__TYPE:
				return getType();
			case ModelPackage.ARC__HLINSCRIPTION:
				return getHlinscription();
			case ModelPackage.ARC__ID:
				return getId();
			case ModelPackage.ARC__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ModelPackage.ARC__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ModelPackage.ARC__PAGE:
				return getPage();
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
			case ModelPackage.ARC__TYPE:
				setType((HLArcType)newValue);
				return;
			case ModelPackage.ARC__HLINSCRIPTION:
				setHlinscription((HLAnnotation)newValue);
				return;
			case ModelPackage.ARC__ID:
				setId((String)newValue);
				return;
			case ModelPackage.ARC__SOURCE:
				setSource((Node)newValue);
				return;
			case ModelPackage.ARC__TARGET:
				setTarget((Node)newValue);
				return;
			case ModelPackage.ARC__PAGE:
				setPage((Page)newValue);
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
			case ModelPackage.ARC__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.ARC__HLINSCRIPTION:
				setHlinscription((HLAnnotation)null);
				return;
			case ModelPackage.ARC__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.ARC__SOURCE:
				setSource((Node)null);
				return;
			case ModelPackage.ARC__TARGET:
				setTarget((Node)null);
				return;
			case ModelPackage.ARC__PAGE:
				setPage((Page)null);
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
			case ModelPackage.ARC__TYPE:
				return type != TYPE_EDEFAULT;
			case ModelPackage.ARC__HLINSCRIPTION:
				return hlinscription != null;
			case ModelPackage.ARC__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.ARC__SOURCE:
				return source != null;
			case ModelPackage.ARC__TARGET:
				return target != null;
			case ModelPackage.ARC__PAGE:
				return getPage() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == HasId.class) {
			switch (derivedFeatureID) {
				case ModelPackage.ARC__ID: return ModelPackage.HAS_ID__ID;
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
		if (baseClass == HasId.class) {
			switch (baseFeatureID) {
				case ModelPackage.HAS_ID__ID: return ModelPackage.ARC__ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Arc#getOtherEnd(dk.au.daimi.ascoveco.cpn.model.Node)
	 */
	public Node getOtherEnd(final Node n) {
		if (getSource() == n) { return getTarget(); }
		if (getTarget() == n) { return getSource(); }
		return null;
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Arc#getPlaceNode()
	 */
	public PlaceNode getPlaceNode() {
		if (getSource() != null && getSource() instanceof PlaceNode) { return (PlaceNode) getSource(); }
		if (getTarget() != null && getTarget() instanceof PlaceNode) { return (PlaceNode) getTarget(); }
		throw new IllegalStateException("Arc (" + getId() + ") is not connected to a place");
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Arc#getTransition()
	 */
	public Transition getTransition() {
		if (getSource() != null && getSource() instanceof Transition) { return (Transition) getSource(); }
		if (getTarget() != null && getTarget() instanceof Transition) { return (Transition) getTarget(); }
		throw new IllegalStateException("Arc is not connected to a transition");
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin#isReady(boolean)
	 */
	public boolean isReady() {
		try {
			return getHlinscription().isReady(false) && getPlaceNode().isReady();
		} catch (final NullPointerException e) {
			return false;
		}
	}

} // ArcImpl
