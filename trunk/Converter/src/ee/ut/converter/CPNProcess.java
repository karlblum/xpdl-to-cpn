package ee.ut.converter;

import java.util.HashMap;

import ee.ut.converter.factory.AbstractElementFactory;

public class CPNProcess {

	private CPNet cpnet;
	private AbstractElementFactory elementFactory;
	private HashMap<String, Object> elements = new HashMap<String, Object>();

	public CPNProcess() {
		super();
	}

	public void saveToCPN(String location) {
		cpnet
				.saveToFile(location);
	}

	public CPNet getCpnet() {
		return cpnet;
	}

	public void setCpnet(CPNet cpnet) {
		this.cpnet = cpnet;
	}

	public AbstractElementFactory getElementFactory() {
		return elementFactory;
	}

	public void setElementFactory(AbstractElementFactory elementFactory) {
		this.elementFactory = elementFactory;
	}

	public Object getElement(String key) {
		return elements.get(key);
	}

	public void addElement(String key, Object value) {
		this.elements.put(key, value);
	}
}