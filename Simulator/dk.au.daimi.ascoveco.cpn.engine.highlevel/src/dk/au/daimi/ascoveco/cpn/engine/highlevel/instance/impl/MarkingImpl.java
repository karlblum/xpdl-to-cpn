/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstancePackage;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Marking</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MarkingImpl#getTokenCount <em>Token Count</em>}</li>
 * <li>{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MarkingImpl#getMarking <em>Marking</em>}</li>
 * <li>{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MarkingImpl#getPlaceInstance <em>Place Instance
 * </em>}</li>
 * <li>{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MarkingImpl#getStructuredMarking <em>Structured
 * Marking</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MarkingImpl extends EObjectImpl implements Marking {
	/**
	 * The default value of the '{@link #getTokenCount() <em>Token Count</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTokenCount()
	 * @generated
	 * @ordered
	 */
	protected static final int TOKEN_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTokenCount() <em>Token Count</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTokenCount()
	 * @generated
	 * @ordered
	 */
	protected int tokenCount = TOKEN_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMarking() <em>Marking</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getMarking()
	 * @generated
	 * @ordered
	 */
	protected static final String MARKING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMarking() <em>Marking</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getMarking()
	 * @generated
	 * @ordered
	 */
	protected String marking = MARKING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPlaceInstance() <em>Place Instance</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPlaceInstance()
	 * @generated
	 * @ordered
	 */
	protected Instance<PlaceNode> placeInstance;

	/**
	 * The cached value of the '{@link #getStructuredMarking() <em>Structured Marking</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStructuredMarking()
	 * @generated
	 * @ordered
	 */
	protected EList<MultisetEntry> structuredMarking;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MarkingImpl() {
		super();
	}

	protected MarkingImpl(final int tokens, final String marking) {
		super();
		tokenCount = tokens;
		this.marking = marking;
	}

	/**
	 * @param placeInstance
	 * @param marking
	 */
	public MarkingImpl(final Instance<PlaceNode> placeInstance, final List<MultisetEntry> marking) {
		this.placeInstance = placeInstance;
		getStructuredMarking().addAll(marking);
		updateTokenCount();
		updateUnstructuredMarking();
	}

	/**
	 * @param placeInstance
	 * @param marking
	 */
	public MarkingImpl(final Instance<PlaceNode> placeInstance) {
		this.placeInstance = placeInstance;
		getStructuredMarking();
		updateTokenCount();
		updateUnstructuredMarking();
	}

	private void updateUnstructuredMarking() {
		final StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (final MultisetEntry entry : getStructuredMarking()) {
			if (first) {
				first = false;
			} else {
				sb.append("++");
			}
			sb.append(entry);
		}
		marking = sb.toString();
	}

	private void updateTokenCount() {
		tokenCount = 0;
		for (final MultisetEntry entry : getStructuredMarking()) {
			tokenCount += entry.getCoefficient();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.MARKING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getTokenCount() {
		return tokenCount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTokenCount(final int newTokenCount) {
		final int oldTokenCount = tokenCount;
		tokenCount = newTokenCount;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MARKING__TOKEN_COUNT, oldTokenCount,
			        tokenCount));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getMarking() {
		return marking;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Instance<PlaceNode> getPlaceInstance() {
		return placeInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPlaceInstance(final Instance<PlaceNode> newPlaceInstance, NotificationChain msgs) {
		final Instance<PlaceNode> oldPlaceInstance = placeInstance;
		placeInstance = newPlaceInstance;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			        InstancePackage.MARKING__PLACE_INSTANCE, oldPlaceInstance, newPlaceInstance);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPlaceInstance(final Instance<PlaceNode> newPlaceInstance) {
		if (newPlaceInstance != placeInstance) {
			NotificationChain msgs = null;
			if (placeInstance != null) {
				msgs = ((InternalEObject) placeInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				        - InstancePackage.MARKING__PLACE_INSTANCE, null, msgs);
			}
			if (newPlaceInstance != null) {
				msgs = ((InternalEObject) newPlaceInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				        - InstancePackage.MARKING__PLACE_INSTANCE, null, msgs);
			}
			msgs = basicSetPlaceInstance(newPlaceInstance, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MARKING__PLACE_INSTANCE,
			        newPlaceInstance, newPlaceInstance));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<MultisetEntry> getStructuredMarking() {
		if (structuredMarking == null) {
			structuredMarking = new EObjectContainmentEList<MultisetEntry>(MultisetEntry.class, this,
			        InstancePackage.MARKING__STRUCTURED_MARKING);
		}
		return structuredMarking;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
	        final NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.MARKING__PLACE_INSTANCE:
			return basicSetPlaceInstance(null, msgs);
		case InstancePackage.MARKING__STRUCTURED_MARKING:
			return ((InternalEList<?>) getStructuredMarking()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
		case InstancePackage.MARKING__TOKEN_COUNT:
			return getTokenCount();
		case InstancePackage.MARKING__MARKING:
			return getMarking();
		case InstancePackage.MARKING__PLACE_INSTANCE:
			return getPlaceInstance();
		case InstancePackage.MARKING__STRUCTURED_MARKING:
			return getStructuredMarking();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
		case InstancePackage.MARKING__TOKEN_COUNT:
			setTokenCount((Integer) newValue);
			return;
		case InstancePackage.MARKING__PLACE_INSTANCE:
			setPlaceInstance((Instance<PlaceNode>) newValue);
			return;
		case InstancePackage.MARKING__STRUCTURED_MARKING:
			getStructuredMarking().clear();
			getStructuredMarking().addAll((Collection<? extends MultisetEntry>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(final int featureID) {
		switch (featureID) {
		case InstancePackage.MARKING__TOKEN_COUNT:
			setTokenCount(TOKEN_COUNT_EDEFAULT);
			return;
		case InstancePackage.MARKING__PLACE_INSTANCE:
			setPlaceInstance((Instance<PlaceNode>) null);
			return;
		case InstancePackage.MARKING__STRUCTURED_MARKING:
			getStructuredMarking().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(final int featureID) {
		switch (featureID) {
		case InstancePackage.MARKING__TOKEN_COUNT:
			return tokenCount != TOKEN_COUNT_EDEFAULT;
		case InstancePackage.MARKING__MARKING:
			return MARKING_EDEFAULT == null ? marking != null : !MARKING_EDEFAULT.equals(marking);
		case InstancePackage.MARKING__PLACE_INSTANCE:
			return placeInstance != null;
		case InstancePackage.MARKING__STRUCTURED_MARKING:
			return structuredMarking != null && !structuredMarking.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) { return super.toString(); }

		final StringBuilder sb = new StringBuilder();
		if (placeInstance != null) {
			sb.append(placeInstance);
		}
		sb.append(": ");
		if (getStructuredMarking() != null) {
			if (getStructuredMarking().size() == 0) {
				sb.append("empty");
			} else {
				boolean first = true;
				for (final MultisetEntry entry : getStructuredMarking()) {
					if (first) {
						first = false;
					} else {
						sb.append(" ++ ");
					}
					sb.append(entry);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int code = placeInstance.hashCode();
		if (getStructuredMarking() != null) {
			for (final MultisetEntry entry : getStructuredMarking()) {
				code = entry.hashCode() + 5 * code;
			}
		}
		return code;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object other) {
		if (other == null || !(other instanceof Marking)) { return false; }
		if (other == this) { return true; }
		final Marking o = (Marking) other;
		if (getStructuredMarking() == o.getStructuredMarking()) { return true; }
		if (getStructuredMarking() == null || o.getStructuredMarking() == null) { return false; }
		if (getStructuredMarking().size() != o.getStructuredMarking().size()) { return false; }
		final Iterator<MultisetEntry> it = o.getStructuredMarking().iterator();
		for (final MultisetEntry mine : getStructuredMarking()) {
			final MultisetEntry others = it.next();
			if (mine != others && (mine == null || !mine.equals(others))) { return false; }
		}
		return placeInstance == getPlaceInstance() || placeInstance != null
		        && placeInstance.equals(o.getPlaceInstance());
	}
} // MarkingImpl
