package ee.ut.converter.parser;

import ee.ut.model.bpmn.BPMNElement.BPMNElementType;

public interface ParserHelper {

	public BPMNElementType getElementType(Object o);

	public String getId(Object o);
}
