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
	AbstractElementFactory intermediateTimerEventFactory = null;
	AbstractElementFactory intermediateMessageEventFactory = null;
	AbstractElementFactory subProcessFactory = null;
	AbstractElementFactory boundMessageEventFactory = null;
	AbstractElementFactory boundTimerEventFactory = null;
	AbstractElementFactory subProcessStartFactory = null;
	AbstractElementFactory subProcessEndFactory = null;

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

	public void registerIntermediateTimerEventFactory(AbstractElementFactory f) {
		this.intermediateTimerEventFactory = f;
	}

	public void registerIntermediateMessageEventFactory(AbstractElementFactory f) {
		this.intermediateMessageEventFactory = f;
	}

	public void registerBoundMessageEventFactory(AbstractElementFactory f) {
		this.boundMessageEventFactory = f;
	}

	public void registerBoundTimerEventFactory(AbstractElementFactory f) {
		this.boundTimerEventFactory = f;
	}

	public void registerSubProcessFactory(AbstractElementFactory f) {
		this.subProcessFactory = f;
	}
	
	public void registerSubProcessStartFactory(AbstractElementFactory f) {
		this.subProcessStartFactory = f;
	}
	
	public void registerSubProcessEndFactory(AbstractElementFactory f) {
		this.subProcessEndFactory = f;
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
		case BPMNElement.INTERMEDIATE_TIMER_EVENT:
			return intermediateTimerEventFactory.create(obj);
		case BPMNElement.INTERMEDIATE_MESSAGE_EVENT:
			return intermediateMessageEventFactory.create(obj);
		case BPMNElement.BOUND_MESSAGE_EVENT:
			return boundMessageEventFactory.create(obj);
		case BPMNElement.BOUND_TIMER_EVENT:
			return boundTimerEventFactory.create(obj);
		case BPMNElement.SUB_PROCESS:
			return subProcessFactory.create(obj);
		case BPMNElement.SUB_PROCESS_START:
			return subProcessStartFactory.create(obj);
		case BPMNElement.SUB_PROCESS_END:
			return subProcessEndFactory.create(obj);
		default:
			throw new Exception("Unknown BPMNElement type");
		}
	}

}
