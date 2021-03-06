/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.graphics.impl;

import dk.au.daimi.ascoveco.cpn.model.graphics.Fill;
import dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage;
import dk.au.daimi.ascoveco.cpn.model.graphics.Rotation;

import java.net.URL;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fill</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.FillImpl#getColor <em>Color</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.FillImpl#getImage <em>Image</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.FillImpl#getGradientColor <em>Gradient Color</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.FillImpl#getGradientRotation <em>Gradient Rotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FillImpl extends EObjectImpl implements Fill {
	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final String COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected String color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final URL IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected URL image = IMAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGradientColor() <em>Gradient Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGradientColor()
	 * @generated
	 * @ordered
	 */
	protected static final String GRADIENT_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGradientColor() <em>Gradient Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGradientColor()
	 * @generated
	 * @ordered
	 */
	protected String gradientColor = GRADIENT_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getGradientRotation() <em>Gradient Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGradientRotation()
	 * @generated
	 * @ordered
	 */
	protected static final Rotation GRADIENT_ROTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGradientRotation() <em>Gradient Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGradientRotation()
	 * @generated
	 * @ordered
	 */
	protected Rotation gradientRotation = GRADIENT_ROTATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FillImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphicsPackage.Literals.FILL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(String newColor) {
		String oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicsPackage.FILL__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URL getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(URL newImage) {
		URL oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicsPackage.FILL__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGradientColor() {
		return gradientColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGradientColor(String newGradientColor) {
		String oldGradientColor = gradientColor;
		gradientColor = newGradientColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicsPackage.FILL__GRADIENT_COLOR, oldGradientColor, gradientColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rotation getGradientRotation() {
		return gradientRotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGradientRotation(Rotation newGradientRotation) {
		Rotation oldGradientRotation = gradientRotation;
		gradientRotation = newGradientRotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicsPackage.FILL__GRADIENT_ROTATION, oldGradientRotation, gradientRotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphicsPackage.FILL__COLOR:
				return getColor();
			case GraphicsPackage.FILL__IMAGE:
				return getImage();
			case GraphicsPackage.FILL__GRADIENT_COLOR:
				return getGradientColor();
			case GraphicsPackage.FILL__GRADIENT_ROTATION:
				return getGradientRotation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphicsPackage.FILL__COLOR:
				setColor((String)newValue);
				return;
			case GraphicsPackage.FILL__IMAGE:
				setImage((URL)newValue);
				return;
			case GraphicsPackage.FILL__GRADIENT_COLOR:
				setGradientColor((String)newValue);
				return;
			case GraphicsPackage.FILL__GRADIENT_ROTATION:
				setGradientRotation((Rotation)newValue);
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
			case GraphicsPackage.FILL__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case GraphicsPackage.FILL__IMAGE:
				setImage(IMAGE_EDEFAULT);
				return;
			case GraphicsPackage.FILL__GRADIENT_COLOR:
				setGradientColor(GRADIENT_COLOR_EDEFAULT);
				return;
			case GraphicsPackage.FILL__GRADIENT_ROTATION:
				setGradientRotation(GRADIENT_ROTATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphicsPackage.FILL__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case GraphicsPackage.FILL__IMAGE:
				return image != null;
			case GraphicsPackage.FILL__GRADIENT_COLOR:
				return GRADIENT_COLOR_EDEFAULT == null ? gradientColor != null : !GRADIENT_COLOR_EDEFAULT.equals(gradientColor);
			case GraphicsPackage.FILL__GRADIENT_ROTATION:
				return GRADIENT_ROTATION_EDEFAULT == null ? gradientRotation != null : !GRADIENT_ROTATION_EDEFAULT.equals(gradientRotation);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (color: ");
		result.append(color);
		result.append(", image: ");
		result.append(image);
		result.append(", gradientColor: ");
		result.append(gradientColor);
		result.append(", gradientRotation: ");
		result.append(gradientRotation);
		result.append(')');
		return result.toString();
	}

} //FillImpl
