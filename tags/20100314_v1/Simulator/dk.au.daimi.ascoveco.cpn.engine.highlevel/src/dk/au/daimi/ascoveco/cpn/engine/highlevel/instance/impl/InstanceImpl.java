/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl;

import java.util.ArrayList;
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

import dk.au.daimi.ascoveco.cpn.engine.highlevel.checker.LocalChecker;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstancePackage;
import dk.au.daimi.ascoveco.cpn.model.Node;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Instance</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstanceImpl#getNode <em>Node</em>}</li>
 * <li>{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstanceImpl#getTransitionPath <em>Transition Path
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class InstanceImpl<T extends Node> extends EObjectImpl implements Instance<T> {
	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected T node;

	/**
	 * The cached value of the '{@link #getTransitionPath() <em>Transition Path</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTransitionPath()
	 * @generated
	 * @ordered
	 */
	protected EList<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionPath;

	int instanceNumber;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InstanceImpl() {
		super();
	}

	protected InstanceImpl(final T node, final int instanceNumber) {
		this(node, instanceNumber, new ArrayList<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>>());
	}

	/**
	 * @param node
	 * @param transitionList
	 */
	public InstanceImpl(final T node, final List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionList) {
		this(node, 0, transitionList);
	}

	/**
	 * @param node
	 * @param instanceNumber
	 * @param transitionList
	 */
	public InstanceImpl(final T node, final int instanceNumber,
	        final List<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> transitionList) {
		super();
		this.node = node;
		this.instanceNumber = instanceNumber;
		getTransitionPath().addAll(transitionList);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.INSTANCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public T getNode() {
		if (node != null && node.eIsProxy()) {
			final InternalEObject oldNode = (InternalEObject) node;
			node = (T) eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InstancePackage.INSTANCE__NODE, oldNode,
					        node));
				}
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public T basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNode(final T newNode) {
		final T oldNode = node;
		node = newNode;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.INSTANCE__NODE, oldNode, node));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> getTransitionPath() {
		if (transitionPath == null) {
			transitionPath = new EObjectContainmentEList<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>>(
			        Instance.class, this, InstancePackage.INSTANCE__TRANSITION_PATH);
		}
		return transitionPath;
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
		case InstancePackage.INSTANCE__TRANSITION_PATH:
			return ((InternalEList<?>) getTransitionPath()).basicRemove(otherEnd, msgs);
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
		case InstancePackage.INSTANCE__NODE:
			if (resolve) { return getNode(); }
			return basicGetNode();
		case InstancePackage.INSTANCE__TRANSITION_PATH:
			return getTransitionPath();
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
		case InstancePackage.INSTANCE__NODE:
			setNode((T) newValue);
			return;
		case InstancePackage.INSTANCE__TRANSITION_PATH:
			getTransitionPath().clear();
			getTransitionPath().addAll(
			        (Collection<? extends Instance<dk.au.daimi.ascoveco.cpn.model.Instance>>) newValue);
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
		case InstancePackage.INSTANCE__NODE:
			setNode((T) null);
			return;
		case InstancePackage.INSTANCE__TRANSITION_PATH:
			getTransitionPath().clear();
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
		case InstancePackage.INSTANCE__NODE:
			return node != null;
		case InstancePackage.INSTANCE__TRANSITION_PATH:
			return transitionPath != null && !transitionPath.isEmpty();
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
		if (getTransitionPath().isEmpty()) {
			sb.append(LocalChecker.getName(node.getPage()));
		} else {
			sb.append(getTransitionPath().get(getTransitionPath().size() - 1));
		}
		sb.append('.');
		sb.append(LocalChecker.getName(node));

		return sb.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance#getInstanceNumber()
	 */
	public int getInstanceNumber() {
		if (instanceNumber == 0) { return 1; // FIXME!!! HACK!!! Only works for hierarchical models with at most one
											 // instance of each page!
		}
		return instanceNumber;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int code = 23;
		if (getNode() != null) {
			code += getNode().hashCode();
		}
		if (getTransitionPath() != null) {
			// code += getTransitionPath().size(); // We do this instead of hashCode to avoid quadratic blowup; should
			// use
			// instance number
		}
		return code;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(final Object other) {
		if (other == this) { return true; }
		if (other == null || !(other instanceof Instance)) { return false; }
		final Instance<Node> o = (Instance<Node>) other;
		if (getNode() == null) { return o.getNode() == null; }
		if (!getNode().equals(o.getNode())) { return false; }
		if (getTransitionPath().size() != o.getTransitionPath().size()) { return false; }
		final Iterator<Instance<dk.au.daimi.ascoveco.cpn.model.Instance>> oi = o.getTransitionPath().iterator();
		// System.out.println(getNode().getName() + " me   : " + getTransitionPath());
		// System.out.println(o.getNode().getName() + " them : " + o.getTransitionPath());
		for (final Instance<dk.au.daimi.ascoveco.cpn.model.Instance> mine : getTransitionPath()) {
			final Instance<dk.au.daimi.ascoveco.cpn.model.Instance> theirs = oi.next();
			if (mine != theirs && (mine == null || !mine.equals(theirs))) { return false; }
		}
		return true;
	}
} // InstanceImpl
