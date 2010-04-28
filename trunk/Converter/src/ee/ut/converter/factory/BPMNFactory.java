package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNElement;

public final class BPMNFactory extends AbstractElementFactory {

	public BPMNFactory(CPNProcess cPNProcess, ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	AbstractElementFactory activityFactory = null;
	AbstractElementFactory transitionFactory = null;
	AbstractElementFactory gatewayFactory = null;
	AbstractElementFactory startEventFactory = null;
	AbstractElementFactory endEventFactory = null;
	AbstractElementFactory eventFactory = null;
	AbstractElementFactory boundEventFactory = null;

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
	
	public void registerEventFactory(AbstractElementFactory f) {
		this.eventFactory = f;
	}
	
	public void registerBoundEventFactory(AbstractElementFactory f) {
		this.boundEventFactory = f;
	}

	public void registerPraserHelper(ElementParser h) {
		this.elementParser = h;
	}

	@Override
	public Element create(Object obj) throws Exception {
		switch (elementParser.getElementType(obj)) {
		case BPMNElement.TASK:
			return activityFactory.create(obj);
		case BPMNElement.GATEWAY:
			return gatewayFactory.create(obj);
		case BPMNElement.START:
			return startEventFactory.create(obj);
		case BPMNElement.END:
			return endEventFactory.create(obj);
		case BPMNElement.TRANSITION:
			return transitionFactory.create(obj);
		case BPMNElement.EVENT:
			return eventFactory.create(obj);
		case BPMNElement.BOUND_EVENT:
			return boundEventFactory.create(obj);	
		default:
			throw new Exception("Unknown BPMNElement type");
		}
	}

}
