package ee.ut.converter.factory;

import java.util.HashMap;
import java.util.Map;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;

public abstract class RelayFactory extends AbstractElementFactory {

	protected Map<Object, AbstractElementFactory> factories = new HashMap<Object, AbstractElementFactory>();
	protected AbstractElementFactory connectorFactory = null;

	public RelayFactory() {
		super();
	}

	public RelayFactory(CPNProcess cPNProcess, ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	public void registerFactory(Object key, AbstractElementFactory concrete) {
		factories.put(key, concrete);
	}

	public void resetFactoryMap() {
		factories.clear();
	}

	@Override
	public Element create(Object obj) throws Exception {
		Object key = elementParser.getElementType(obj);
		AbstractElementFactory concrete = factories.get(key);
		if (concrete == null)
			throw new Exception("Factory missing for object: " + obj);
		return concrete.create(obj);
	}

	public void connectElements(Element convertedElement, Element element)
			throws Exception {
		if (connectorFactory == null)
			throw new Exception("Missing connector factory!");

		connectorFactory.create(new Object[] { convertedElement, element });
	}

	public void registerConnectorFactory(AbstractElementFactory concrete) {
		connectorFactory = concrete;

	}

	public abstract void prepareFactory();
}
