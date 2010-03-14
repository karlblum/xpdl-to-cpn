package dk.au.daimi.ascoveco.cpn.model.cpntypes;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true"
 * @author michael
 */
public interface CPNType extends EObject {
	/**
	 * @model is the type timed
	 * @return whether the type id timed
	 */
	public Boolean getTimed();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#getTimed <em>Timed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timed</em>' attribute.
	 * @see #getTimed()
	 * @generated
	 */
	void setTimed(Boolean value);

	/**
	 * @return get all declares
	 * @model type="String"
	 */
	public EList<String> getDeclares();

	/**
	 * @param declare declare to add
	 */
	public void addDeclare(String declare);

	/**
	 * @return string rep of type
	 */
	public String asString();
}
