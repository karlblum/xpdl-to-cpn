package ee.ut.converter.parser;

import java.util.ArrayList;

public interface ElementParser {

	/**
	 * Method returns the element type identifier.
	 * 
	 * @param o
	 *            Object to be identified.
	 * @return element type identifier
	 */
	public int getElementType(Object o);

	/**
	 * Method returns the id of the element.
	 * 
	 * @param o
	 *            Object to be identified.
	 * @return element identifier.
	 */
	public String getId(Object o);

	/**
	 * Method returns the type of gateway.
	 * 
	 * @param o
	 *            Gateway object to be identified.
	 * @return gateway identifier.
	 */
	public Object getGatewayType(Object o);

	/**
	 * Method returns the name of the object.
	 * 
	 * @param o
	 *            Object to be identified.
	 * @return Element name.
	 */
	public String getName(Object o);

	/**
	 * Method returns the task identifier for a boundary event.
	 * 
	 * @param o
	 *            Boundary event.
	 * @return Task identifier where the event belongs.
	 */
	public String getBoundaryEventTaskId(Object o);

	/**
	 * Returns the timing expression for event.
	 * 
	 * @param o
	 *            Event.
	 * @return Timing expression.
	 */
	public int getEventTimer(Object o);

	/**
	 * Next elements from a given element.
	 * 
	 * @param element
	 *            Current element.
	 * @return Next elements.
	 */
	public ArrayList<Object> getNextElements(Object element);

	/**
	 * Method finds the entry point for a given process.
	 * 
	 * @param process
	 *            Process.
	 * @return Process start activity/event.
	 */
	public Object getSource(String process);

	/**
	 * Method returns the sub-process identifier.
	 * 
	 * @param o
	 *            Sub-process.
	 * @return Sub-process identifier.
	 */
	public String getSubprocessId(Object o);

	/**
	 * Gets the XOR gateway output identifier
	 * 
	 * @param from
	 *            From object.
	 * @param to
	 *            To object.
	 * @return Gateway identifier.
	 */
	public String getXorGWOutputIdentifier(String from, String to);

	/**
	 * Finds out if a given element type is next in the adjacency list for a
	 * given element.
	 * 
	 * @param o
	 *            Element.
	 * @param elementType
	 *            Next element type.
	 * @return
	 */
	public boolean isNext(Object o, int elementType);
}
