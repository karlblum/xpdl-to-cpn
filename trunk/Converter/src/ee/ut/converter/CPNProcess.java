package ee.ut.converter;

import java.util.HashMap;

import ee.ut.converter.factory.AbstractElementFactory;

public class CPNProcess {

	private CPNet cpnet;
	private AbstractElementFactory elementFactory;
	protected HashMap<String, Element> elements = new HashMap<String, Element>();

	public CPNProcess() {
		super();
	}

	public void saveToCPN(String location) {
		cpnet.saveToFile(location);
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

	public Element getElement(String key) {
		return elements.get(key);
	}

	public void addConvertedElement(String key, Element value) {
		this.elements.put(key, value);
	}

	public HashMap<String, Element> getElelments() {
		return elements;
	}

}