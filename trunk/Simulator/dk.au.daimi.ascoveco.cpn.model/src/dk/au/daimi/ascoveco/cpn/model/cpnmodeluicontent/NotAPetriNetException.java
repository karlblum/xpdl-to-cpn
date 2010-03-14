package dk.au.daimi.ascoveco.cpn.model.cpnmodeluicontent;

import org.eclipse.emf.ecore.EObject;

/**
 * @author mw
 */
public class NotAPetriNetException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final EObject diagramRoot;

	/**
	 * @param message message
	 * @param diagramRoot root
	 */
	public NotAPetriNetException(final String message, final EObject diagramRoot) {
		super(message);
		this.diagramRoot = diagramRoot;
	}

	/**
	 * @return root
	 */
	public EObject getDiagramRoot() {
		return diagramRoot;
	}
}
