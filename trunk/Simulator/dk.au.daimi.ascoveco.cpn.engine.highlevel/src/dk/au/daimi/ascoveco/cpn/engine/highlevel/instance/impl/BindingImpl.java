/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstancePackage;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment;
import dk.au.daimi.ascoveco.cpn.model.TransitionNode;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Binding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.BindingImpl#getTransitionInstance <em>Transition Instance</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.BindingImpl#getAllAssignments <em>All Assignments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingImpl extends EObjectImpl implements Binding {
	/**
	 * The cached value of the '{@link #getTransitionInstance() <em>Transition Instance</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTransitionInstance()
	 * @generated
	 * @ordered
	 */
	protected Instance<TransitionNode> transitionInstance;

	/**
	 * The cached value of the '{@link #getAllAssignments() <em>All Assignments</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueAssignment> allAssignments;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingImpl() {
		super();
	}

	protected BindingImpl(final Instance<TransitionNode> transition, final List<ValueAssignment> allAssignments) {
		super();
		transitionInstance = transition;
		getAllAssignments().addAll(allAssignments);
		recalculateValueMap();
	}

	private void recalculateValueMap() {
		valueMap = new HashMap<String, ValueAssignment>();
		for (final ValueAssignment assignment : getAllAssignments()) {
			valueMap.put(assignment.getName(), assignment);
		}
	}

	Map<String, ValueAssignment> valueMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.BINDING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Instance<TransitionNode> getTransitionInstance() {
		return transitionInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransitionInstance(Instance<TransitionNode> newTransitionInstance, NotificationChain msgs) {
		Instance<TransitionNode> oldTransitionInstance = transitionInstance;
		transitionInstance = newTransitionInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InstancePackage.BINDING__TRANSITION_INSTANCE, oldTransitionInstance, newTransitionInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionInstance(Instance<TransitionNode> newTransitionInstance) {
		if (newTransitionInstance != transitionInstance) {
			NotificationChain msgs = null;
			if (transitionInstance != null)
				msgs = ((InternalEObject)transitionInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InstancePackage.BINDING__TRANSITION_INSTANCE, null, msgs);
			if (newTransitionInstance != null)
				msgs = ((InternalEObject)newTransitionInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InstancePackage.BINDING__TRANSITION_INSTANCE, null, msgs);
			msgs = basicSetTransitionInstance(newTransitionInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.BINDING__TRANSITION_INSTANCE, newTransitionInstance, newTransitionInstance));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValueAssignment> getAllAssignments() {
		if (allAssignments == null) {
			allAssignments = new EObjectContainmentEList<ValueAssignment>(ValueAssignment.class, this, InstancePackage.BINDING__ALL_ASSIGNMENTS);
		}
		return allAssignments;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (valueMap == null) {
			recalculateValueMap();
		}
		return super.hashCode();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InstancePackage.BINDING__TRANSITION_INSTANCE:
				return basicSetTransitionInstance(null, msgs);
			case InstancePackage.BINDING__ALL_ASSIGNMENTS:
				return ((InternalEList<?>)getAllAssignments()).basicRemove(otherEnd, msgs);
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
			case InstancePackage.BINDING__TRANSITION_INSTANCE:
				return getTransitionInstance();
			case InstancePackage.BINDING__ALL_ASSIGNMENTS:
				return getAllAssignments();
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
			case InstancePackage.BINDING__TRANSITION_INSTANCE:
				setTransitionInstance((Instance<TransitionNode>)newValue);
				return;
			case InstancePackage.BINDING__ALL_ASSIGNMENTS:
				getAllAssignments().clear();
				getAllAssignments().addAll((Collection<? extends ValueAssignment>)newValue);
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
			case InstancePackage.BINDING__TRANSITION_INSTANCE:
				setTransitionInstance((Instance<TransitionNode>)null);
				return;
			case InstancePackage.BINDING__ALL_ASSIGNMENTS:
				getAllAssignments().clear();
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
			case InstancePackage.BINDING__TRANSITION_INSTANCE:
				return transitionInstance != null;
			case InstancePackage.BINDING__ALL_ASSIGNMENTS:
				return allAssignments != null && !allAssignments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding#getValueAssignment(java.lang.String)
	 */
	public ValueAssignment getValueAssignment(final String name) {
		if (valueMap != null) { return valueMap.get(name); }
		return null;
	}

	/**
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		if (transitionInstance != null) {
			sb.append(transitionInstance);
		}
		if (!getAllAssignments().isEmpty()) {
			sb.append("{ ");
			final SortedSet<String> values = new TreeSet<String>();
			for (final ValueAssignment valueAssignment : getAllAssignments()) {
				values.add(valueAssignment.toString());
			}
			boolean first = true;
			for (final String valueAssignment : values) {
				if (first) {
					first = false;
				} else {
					sb.append(", ");
				}
				sb.append(valueAssignment);
			}
			sb.append(" }");
		}
		return sb.toString();
	}
} // BindingImpl
