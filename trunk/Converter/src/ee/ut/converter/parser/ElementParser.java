package ee.ut.converter.parser;

import java.util.ArrayList;

public interface ElementParser {

	public int getElementType(Object o);

	public String getId(Object o);

	public String getTransitionFrom(Object o);

	public String getTransitionTo(Object o);

	public Object getGatewayType(Object o);

	public String getName(Object o);

	public String getBoundaryEventTaskId(Object o);

	public int getEventTimer(Object o);

	public ArrayList<Object> getNextElements(Object element);

	public Object getSource(String process);

	public String getSubprocessId(Object o);
}
