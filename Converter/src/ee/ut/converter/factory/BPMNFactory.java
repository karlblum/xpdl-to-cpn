package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNElement.BPMNElementType;

public final class BPMNFactory extends AbstractElementFactory {

	public BPMNFactory(CPNProcess cPNProcess, ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	AbstractElementFactory activityFactory = null;
	AbstractElementFactory transitionFactory = null;
	AbstractElementFactory gatewayFactory = null;
	AbstractElementFactory startEventFactory = null;
	AbstractElementFactory endEventFactory = null;

	public void registerActivityFactory(AbstractElementFactory f) {
		this.activityFactory = f;
	}

	public void registerTransitionFactory(AbstractElementFactory f) {
		this.transitionFactory = f;
	}

	public void registerGatewayFactory(AbstractElementFactory f) {
		this.gatewayFactory = f;
	}

	public void registerStartEventFactory(AbstractElementFactory f) {
		this.startEventFactory = f;
	}
	
	public void registerEndEventFactory(AbstractElementFactory f) {
		this.endEventFactory = f;
	}

	public void registerPraserHelper(ElementParser h) {
		this.elementParser = h;
	}

	@Override
	public Element create(Object obj) {
		BPMNElementType elementType = (BPMNElementType) elementParser.getElementType(obj);
		if (elementType == BPMNElementType.TASK) {
			return activityFactory.create(obj);
		} else if (elementType == BPMNElementType.GATEWAY) {
			return gatewayFactory.create(obj);
		} else if (elementType == BPMNElementType.START) {
			return startEventFactory.create(obj);
		} else if (elementType == BPMNElementType.END) {
			return endEventFactory.create(obj);
		} else if (elementType == BPMNElementType.TRANSITION) {
			return transitionFactory.create(obj);
		}
		return null;
	}

}
