package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true" interface="true"
 * @author michael Addition compared to HLPN standard. Added to make reverse references for toolInfo.
 */
public interface HasToolInfo extends EObject {
	/**
	 * @model containment="true" opposite="parent" type="ToolInfo"
	 * @return the toolinfo of the object
	 */
	public EList<ToolInfo> getToolinfo();
}
