package dk.au.daimi.ascoveco.cpn.model.declaration;

import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true"
 * @author michael
 */
public interface DeclarationStructure extends EObject {
	/**
	 * @return string rep of decl structure
	 */
	public String asString();

	/**
	 * @return short string rep of decl structure
	 */
	public String asShortString();
}
