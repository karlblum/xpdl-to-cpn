package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.common.util.EList;

/**
 * @model abstract="true"
 * @author michael
 */
public interface Node extends dk.au.daimi.ascoveco.cpn.model.Object {
	/**
	 * @model containment="false" type="Arc"
	 * @return get all arcs where this node is source
	 */
	public EList<Arc> getSourceArc();

	/**
	 * @model containment="false" type="Arc"
	 * @return get all arcs where this node is target
	 */
	public EList<Arc> getTargetArc();

	/**
	 * @return whether this node is ready to be transmitted to the simulator
	 */
	public boolean isReady();
}
