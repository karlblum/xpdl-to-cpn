/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.graphics.impl;

import dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate;
import dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage;
import dk.au.daimi.ascoveco.cpn.model.graphics.Line;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arc Graphics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.ArcGraphicsImpl#getLine <em>Line</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.ArcGraphicsImpl#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArcGraphicsImpl extends GraphicsImpl implements ArcGraphics {
	/**
	 * The cached value of the '{@link #getLine() <em>Line</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected Line line;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected EList<Coordinate> position;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArcGraphicsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphicsPackage.Literals.ARC_GRAPHICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Line getLine() {
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLine(Line newLine, NotificationChain msgs) {
		Line oldLine = line;
		line = newLine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicsPackage.ARC_GRAPHICS__LINE, oldLine, newLine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine(Line newLine) {
		if (newLine != line) {
			NotificationChain msgs = null;
			if (line != null)
				msgs = ((InternalEObject)line).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicsPackage.ARC_GRAPHICS__LINE, null, msgs);
			if (newLine != null)
				msgs = ((InternalEObject)newLine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicsPackage.ARC_GRAPHICS__LINE, null, msgs);
			msgs = basicSetLine(newLine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicsPackage.ARC_GRAPHICS__LINE, newLine, newLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Coordinate> getPosition() {
		if (position == null) {
			position = new EObjectContainmentEList<Coordinate>(Coordinate.class, this, GraphicsPackage.ARC_GRAPHICS__POSITION);
		}
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphicsPackage.ARC_GRAPHICS__LINE:
				return basicSetLine(null, msgs);
			case GraphicsPackage.ARC_GRAPHICS__POSITION:
				return ((InternalEList<?>)getPosition()).basicRemove(otherEnd, msgs);
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
			case GraphicsPackage.ARC_GRAPHICS__LINE:
				return getLine();
			case GraphicsPackage.ARC_GRAPHICS__POSITION:
				return getPosition();
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
			case GraphicsPackage.ARC_GRAPHICS__LINE:
				setLine((Line)newValue);
				return;
			case GraphicsPackage.ARC_GRAPHICS__POSITION:
				getPosition().clear();
				getPosition().addAll((Collection<? extends Coordinate>)newValue);
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
			case GraphicsPackage.ARC_GRAPHICS__LINE:
				setLine((Line)null);
				return;
			case GraphicsPackage.ARC_GRAPHICS__POSITION:
				getPosition().clear();
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
			case GraphicsPackage.ARC_GRAPHICS__LINE:
				return line != null;
			case GraphicsPackage.ARC_GRAPHICS__POSITION:
				return position != null && !position.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArcGraphicsImpl
