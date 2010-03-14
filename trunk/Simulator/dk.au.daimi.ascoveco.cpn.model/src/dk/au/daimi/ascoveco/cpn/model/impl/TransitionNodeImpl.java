/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import dk.au.daimi.ascoveco.cpn.model.Arc;
import dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin;
import dk.au.daimi.ascoveco.cpn.model.Code;
import dk.au.daimi.ascoveco.cpn.model.Condition;
import dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.Time;
import dk.au.daimi.ascoveco.cpn.model.TransitionNode;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Transition Node</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.TransitionNodeImpl#getCondition <em>Condition</em>}</li>
 * <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.TransitionNodeImpl#getCode <em>Code</em>}</li>
 * <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.TransitionNodeImpl#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class TransitionNodeImpl extends NodeImpl implements TransitionNode {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition condition;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected Code code;
	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected Time time;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TRANSITION_NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getCondition() {
		if (condition != null && condition.eIsProxy()) {
			InternalEObject oldCondition = (InternalEObject)condition;
			condition = (Condition)eResolveProxy(oldCondition);
			if (condition != oldCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.TRANSITION_NODE__CONDITION, oldCondition, condition));
			}
		}
		return condition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetCondition() {
		return condition;
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin#setCondition(dk.au.daimi.ascoveco.cpn.model.Condition)
	 */
	public void setCondition(final Condition newCondition) {
		if (condition != null) {
			condition.setParent(null);
		}
		setConditionGen(newCondition);
		if (newCondition != null) {
			newCondition.setParent(this);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionGen(Condition newCondition) {
		Condition oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION_NODE__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Code getCode() {
		if (code != null && code.eIsProxy()) {
			InternalEObject oldCode = (InternalEObject)code;
			code = (Code)eResolveProxy(oldCode);
			if (code != oldCode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.TRANSITION_NODE__CODE, oldCode, code));
			}
		}
		return code;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Code basicGetCode() {
		return code;
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin#setCode(dk.au.daimi.ascoveco.cpn.model.Code)
	 */
	public void setCode(final Code newCode) {
		if (code != null) {
			code.setParent(null);
		}
		setCodeGen(newCode);
		if (newCode != null) {
			code.setParent(this);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodeGen(Code newCode) {
		Code oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION_NODE__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Time getTime() {
		if (time != null && time.eIsProxy()) {
			InternalEObject oldTime = (InternalEObject)time;
			time = (Time)eResolveProxy(oldTime);
			if (time != oldTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.TRANSITION_NODE__TIME, oldTime, time));
			}
		}
		return time;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Time basicGetTime() {
		return time;
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin#setTime(dk.au.daimi.ascoveco.cpn.model.Time)
	 */
	public void setTime(final Time newTime) {
		if (time != null) {
			time.setParent(null);
		}
		setTimeGen(newTime);
		if (newTime != null) {
			newTime.setParent(this);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeGen(Time newTime) {
		Time oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION_NODE__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TRANSITION_NODE__CONDITION:
				if (resolve) return getCondition();
				return basicGetCondition();
			case ModelPackage.TRANSITION_NODE__CODE:
				if (resolve) return getCode();
				return basicGetCode();
			case ModelPackage.TRANSITION_NODE__TIME:
				if (resolve) return getTime();
				return basicGetTime();
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
			case ModelPackage.TRANSITION_NODE__CONDITION:
				setCondition((Condition)newValue);
				return;
			case ModelPackage.TRANSITION_NODE__CODE:
				setCode((Code)newValue);
				return;
			case ModelPackage.TRANSITION_NODE__TIME:
				setTime((Time)newValue);
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
			case ModelPackage.TRANSITION_NODE__CONDITION:
				setCondition((Condition)null);
				return;
			case ModelPackage.TRANSITION_NODE__CODE:
				setCode((Code)null);
				return;
			case ModelPackage.TRANSITION_NODE__TIME:
				setTime((Time)null);
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
			case ModelPackage.TRANSITION_NODE__CONDITION:
				return condition != null;
			case ModelPackage.TRANSITION_NODE__CODE:
				return code != null;
			case ModelPackage.TRANSITION_NODE__TIME:
				return time != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == HLTransitionAddin.class) {
			switch (derivedFeatureID) {
				case ModelPackage.TRANSITION_NODE__CONDITION: return ModelPackage.HL_TRANSITION_ADDIN__CONDITION;
				default: return -1;
			}
		}
		if (baseClass == CPNToolsTransitionAddin.class) {
			switch (derivedFeatureID) {
				case ModelPackage.TRANSITION_NODE__CODE: return ModelPackage.CPN_TOOLS_TRANSITION_ADDIN__CODE;
				case ModelPackage.TRANSITION_NODE__TIME: return ModelPackage.CPN_TOOLS_TRANSITION_ADDIN__TIME;
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
		if (baseClass == HLTransitionAddin.class) {
			switch (baseFeatureID) {
				case ModelPackage.HL_TRANSITION_ADDIN__CONDITION: return ModelPackage.TRANSITION_NODE__CONDITION;
				default: return -1;
			}
		}
		if (baseClass == CPNToolsTransitionAddin.class) {
			switch (baseFeatureID) {
				case ModelPackage.CPN_TOOLS_TRANSITION_ADDIN__CODE: return ModelPackage.TRANSITION_NODE__CODE;
				case ModelPackage.CPN_TOOLS_TRANSITION_ADDIN__TIME: return ModelPackage.TRANSITION_NODE__TIME;
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
			if (super.isReady()) {
				for (final Arc arc : getSourceArc()) {
					if (!arc.isReady()) { return false; }
				}
				for (final Arc arc : getTargetArc()) {
					if (!arc.isReady()) { return false; }
				}
				return true;
			}
			return false;
		} catch (final NullPointerException e) {
			return false;
		}
	}
} // TransitionNodeImpl
