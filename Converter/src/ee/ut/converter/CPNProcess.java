package ee.ut.converter;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ee.ut.converter.factory.AbstractElementFactory;

public class CPNProcess {

	private CPNet cpnet;
	private AbstractElementFactory elementFactory;
	private HashMap<String, Object> elements = new HashMap<String, Object>();

	public CPNProcess() {
		super();
	}

	public void saveToCPN() {
		cpnet
				.saveToFile("C:/Karl/Thesis/Source/Converter/files/cpn/TestCPNModel.cpn");
	}

	@SuppressWarnings("unchecked")
	protected JAXBElement unMasrhall(File file, String model) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(model);

			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement rootElement = (JAXBElement) u.unmarshal(file);
			return rootElement;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
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