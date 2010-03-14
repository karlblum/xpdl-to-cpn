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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstancePackage;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.State;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>State</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.StateImpl#getAllMarkings <em>All Markings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends EObjectImpl implements State {
	/**
	 * The cached value of the '{@link #getAllMarkings() <em>All Markings</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllMarkings()
	 * @generated
	 * @ordered
	 */
	protected EList<Marking> allMarkings;
	private Map<Instance<PlaceNode>, Marking> markingMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	protected StateImpl(final List<Marking> allMarkings) {
		super();
		getAllMarkings().addAll(allMarkings);
		recalculateMarkingMap();
	}

	private void recalculateMarkingMap() {
		markingMap = new HashMap<Instance<PlaceNode>, Marking>();
		for (final Marking marking : getAllMarkings()) {
			markingMap.put(marking.getPlaceInstance(), marking);
		}
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.State#getMarking(dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance)
	 */
	public Marking getMarking(final Instance<PlaceNode> instance) {
		if (markingMap == null) { return null; }
		return markingMap.get(instance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Marking> getAllMarkings() {
		if (allMarkings == null) {
			allMarkings = new EObjectContainmentEList<Marking>(Marking.class, this, InstancePackage.STATE__ALL_MARKINGS);
		}
		return allMarkings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InstancePackage.STATE__ALL_MARKINGS:
				return ((InternalEList<?>)getAllMarkings()).basicRemove(otherEnd, msgs);
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
			case InstancePackage.STATE__ALL_MARKINGS:
				return getAllMarkings();
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
			case InstancePackage.STATE__ALL_MARKINGS:
				getAllMarkings().clear();
				getAllMarkings().addAll((Collection<? extends Marking>)newValue);
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
			case InstancePackage.STATE__ALL_MARKINGS:
				getAllMarkings().clear();
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
			case InstancePackage.STATE__ALL_MARKINGS:
				return allMarkings != null && !allMarkings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int code = 17;
		if (markingMap == null) {
			recalculateMarkingMap();
		}
		code += markingMap.hashCode();

		return code;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object other) {
		if (other == this) { return true; }
		if (other == null || !(other instanceof StateImpl)) { return false; }
		final StateImpl o = (StateImpl) other;
		if (markingMap == null) {
			recalculateMarkingMap();
		}
		if (o.markingMap == null) {
			o.recalculateMarkingMap();
		}
		return markingMap.equals(o.markingMap);
	}

	/**
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		final SortedSet<String> markings = new TreeSet<String>();

		for (final Marking marking : getAllMarkings()) {
			if (marking.getTokenCount() > 0) {
				markings.add(marking.toString());
			}
		}

		boolean first = true;
		for (final String marking : markings) {
			if (first) {
				first = false;
			} else {
				sb.append('\n');
			}
			sb.append(marking);
		}
		return sb.toString();
	}
} // StateImpl
