package ee.ut.converter.factory;

import java.util.HashMap;
import java.util.Map;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;

public abstract class RelayFactory extends AbstractElementFactory {

	/**
	 * Hashmap of factories to be used for element generation.
	 */
	protected Map<Object, AbstractElementFactory> factories = new HashMap<Object, AbstractElementFactory>();

	/**
	 * Factory for generating connections between different elements.
	 */
	protected AbstractElementFactory connectorFactory = null;

	public RelayFactory(Parser p) {
		super(p);
	}

	/**
	 * Method registers a new factory.
	 * 
	 * @param key
	 *            Element identifier.
	 * @param concrete
	 *            Concrete element factory.
	 */
	public void registerFactory(Object key, AbstractElementFactory concrete) {
		factories.put(key, concrete);
	}

	/**
	 * Method clears the list of element factories.
	 */
	public void resetFactoryMap() {
		factories.clear();
	}

	@Override
	public Element create(BProcess pr, Object obj) {
		Object key = parser.getElementParser().getElementType(obj);
		AbstractElementFactory concrete = factories.get(key);
		if (concrete == null)
			System.err.println("Factory missing for object: " + obj + ", type:"
					+ key);
		return concrete.create(pr, obj);
	}

	/**
	 * Method connects two elements.
	 * 
	 * @param pr
	 *            Process
	 * @param convertedElement
	 *            Element from.
	 * @param element
	 *            Element to.
	 */
	public void connectElements(BProcess pr, Element convertedElement,
			Element element) {
		try {
			if (connectorFactory == null)
				throw new Exception("Missing connector factory!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			connectorFactory.create(pr, new Object[] { convertedElement,
					element });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param concrete
	 */
	public void registerConnectorFactory(AbstractElementFactory concrete) {
		connectorFactory = concrete;

	}

	public abstract void prepareFactory();
}
