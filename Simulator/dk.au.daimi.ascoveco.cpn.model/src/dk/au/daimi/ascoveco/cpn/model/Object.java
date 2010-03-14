package dk.au.daimi.ascoveco.cpn.model;

import dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * @model abstract="true"
 * @author michael
 */
@SuppressWarnings("NM_SAME_SIMPLE_NAME_AS_SUPERCLASS")
public interface Object extends HasToolInfo, HasGraphics, HasId, HasLabel, HasName {
	/**
	 * @model required="true" opposite="object"
	 * @return page this object resides on
	 */
	public Page getPage();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.Object#getPage <em>Page</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page</em>' container reference.
	 * @see #getPage()
	 * @generated
	 */
	void setPage(Page value);
}
