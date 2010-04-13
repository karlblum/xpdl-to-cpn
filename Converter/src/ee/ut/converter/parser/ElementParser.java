package ee.ut.converter.parser;

import java.io.File;
import java.util.ArrayList;

import ee.ut.model.bpmn.BPMNElement.BPMNElementType;
import ee.ut.model.bpmn.BPMNGateway.GatewayType;

public interface ElementParser {

	public Object getElementType(Object o);

	public String getId(Object o);

	public String getTransitionFrom(Object object);

	public String getTransitionTo(Object object);

	public Object getGatewayType(Object obj);

	public String getName(Object obj);

	public ArrayList<Object> getAllElements(File file);
}
