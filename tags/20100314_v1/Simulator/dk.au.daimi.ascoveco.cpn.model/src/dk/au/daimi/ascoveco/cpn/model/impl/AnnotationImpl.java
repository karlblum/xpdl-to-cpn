/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import dk.au.daimi.ascoveco.cpn.model.Annotation;
import dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.graphics.Graphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage;
import dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Annotation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.AnnotationImpl#getGraphics <em>Graphics</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.AnnotationImpl#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AnnotationImpl extends LabelImpl implements Annotation {
	/**
	 * The cached value of the '{@link #getGraphics() <em>Graphics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphics()
	 * @generated
	 * @ordered
	 */
	protected Graphics graphics;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Graphics getGraphics() {
		return graphics;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraphics(Graphics newGraphics, NotificationChain msgs) {
		Graphics oldGraphics = graphics;
		graphics = newGraphics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ANNOTATION__GRAPHICS, oldGraphics, newGraphics);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphics(Graphics newGraphics) {
		if (newGraphics != graphics) {
			NotificationChain msgs = null;
			if (graphics != null)
				msgs = ((InternalEObject)graphics).eInverseRemove(this, GraphicsPackage.GRAPHICS__PARENT, Graphics.class, msgs);
			if (newGraphics != null)
				msgs = ((InternalEObject)newGraphics).eInverseAdd(this, GraphicsPackage.GRAPHICS__PARENT, Graphics.class, msgs);
			msgs = basicSetGraphics(newGraphics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ANNOTATION__GRAPHICS, newGraphics, newGraphics));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ANNOTATION__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ANNOTATION__GRAPHICS:
				if (graphics != null)
					msgs = ((InternalEObject)graphics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ANNOTATION__GRAPHICS, null, msgs);
				return basicSetGraphics((Graphics)otherEnd, msgs);
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
			case ModelPackage.ANNOTATION__GRAPHICS:
				return basicSetGraphics(null, msgs);
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
			case ModelPackage.ANNOTATION__GRAPHICS:
				return getGraphics();
			case ModelPackage.ANNOTATION__TEXT:
				return getText();
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
			case ModelPackage.ANNOTATION__GRAPHICS:
				setGraphics((Graphics)newValue);
				return;
			case ModelPackage.ANNOTATION__TEXT:
				setText((String)newValue);
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
			case ModelPackage.ANNOTATION__GRAPHICS:
				setGraphics((Graphics)null);
				return;
			case ModelPackage.ANNOTATION__TEXT:
				setText(TEXT_EDEFAULT);
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
			case ModelPackage.ANNOTATION__GRAPHICS:
				return graphics != null;
			case ModelPackage.ANNOTATION__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == HasGraphics.class) {
			switch (derivedFeatureID) {
				case ModelPackage.ANNOTATION__GRAPHICS: return GraphicsPackage.HAS_GRAPHICS__GRAPHICS;
				default: return -1;
			}
		}
		if (baseClass == HLAnnotationAddin.class) {
			switch (derivedFeatureID) {
				case ModelPackage.ANNOTATION__TEXT: return ModelPackage.HL_ANNOTATION_ADDIN__TEXT;
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
		if (baseClass == HasGraphics.class) {
			switch (baseFeatureID) {
				case GraphicsPackage.HAS_GRAPHICS__GRAPHICS: return ModelPackage.ANNOTATION__GRAPHICS;
				default: return -1;
			}
		}
		if (baseClass == HLAnnotationAddin.class) {
			switch (baseFeatureID) {
				case ModelPackage.HL_ANNOTATION_ADDIN__TEXT: return ModelPackage.ANNOTATION__TEXT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) { return super.toString(); }

		final StringBuffer result = new StringBuffer(getClass().getSimpleName().replaceFirst("Impl$", "").toLowerCase());
		result.append(": ");
		if (text == null) {
			result.append(text);
		} else {
			result.append(text.replaceAll("\n", "\\\\n"));
		}
		return result.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.LabelImpl#asString()
	 */
	@Override
	public String asString() {
		return getText();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin#isReady(boolean)
	 */
	public boolean isReady(final boolean mayBeEmpty) {
		return mayBeEmpty || getText() != null && !"".equals(getText());
	}

} // AnnotationImpl
