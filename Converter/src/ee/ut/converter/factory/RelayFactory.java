package ee.ut.converter.factory;

import java.util.HashMap;
import java.util.Map;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;

public abstract class RelayFactory extends AbstractElementFactory {

	protected Map<Object, AbstractElementFactory> factories = new HashMap<Object, AbstractElementFactory>();
	protected AbstractElementFactory connectorFactory = null;

	public RelayFactory(Parser p) {
		super(p);
	}

	public void registerFactory(Object key, AbstractElementFactory concrete) {
		factories.put(key, concrete);
	}

	public void resetFactoryMap() {
		factories.clear();
	}

	@Override
	public Element create(BProcess pr, Object obj) throws Exception {
		Object key = parser.getElementParser().getElementType(obj);
		AbstractElementFactory concrete = factories.get(key);
		if (concrete == null)
			throw new Exception("Factory missing for object: " + obj
					+ ", type:" + key);
		return concrete.create(pr, obj);
	}

	public void connectElements(BProcess pr, Element convertedElement,
			Element element) throws Exception {
		if (connectorFactory == null)
			throw new Exception("Missing connector factory!");

		connectorFactory.create(pr, new Object[] { convertedElement, element });
	}

	public void registerConnectorFactory(AbstractElementFactory concrete) {
		connectorFactory = concrete;

	}

	public abstract void prepareFactory();
}
