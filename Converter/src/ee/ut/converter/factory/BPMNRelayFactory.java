package ee.ut.converter.factory;

import ee.ut.converter.parser.Parser;
import ee.ut.model.bpmn.BPMNElement;

public class BPMNRelayFactory extends RelayFactory {

	public BPMNRelayFactory(Parser p) {
		super(p);
		prepareFactory();
	}

	@Override
	public void prepareFactory() {
		resetFactoryMap();
		registerFactory(BPMNElement.TASK, new BPMNTaskFactory(parser));
		registerFactory(BPMNElement.GATEWAY, new BPMNGatewayFactory(parser));
		registerFactory(BPMNElement.START, new BPMNStartEventFactory(parser));
		registerFactory(BPMNElement.END, new BPMNEndEventFactory(parser));
		registerFactory(BPMNElement.TRANSITION, new BPMNTransitionFactory(
				parser));
		registerFactory(BPMNElement.INTERMEDIATE_MESSAGE_EVENT,
				new BPMNIntermediateMessageEventFactory(parser));
		registerFactory(BPMNElement.INTERMEDIATE_TIMER_EVENT,
				new BPMNIntermediateTimerEventFactory(parser));
		registerFactory(BPMNElement.BOUND_MESSAGE_EVENT,
				new BPMNBoundMessageEventFactory(parser));
		registerFactory(BPMNElement.BOUND_TIMER_EVENT,
				new BPMNBoundTimerEventFactory(parser));
		registerFactory(BPMNElement.SUB_PROCESS_TIMER_EVENT,
				new BPMNSubprocessTimerFactory(parser));
		registerFactory(BPMNElement.SUB_PROCESS, new BPMNSubprocessFactory(
				parser));

		registerConnectorFactory(new BPMNTransitionFactory(parser));

	}

}
