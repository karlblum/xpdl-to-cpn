package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNElement;

public class BPMNRelayFactory extends RelayFactory {

	public BPMNRelayFactory() {
		super();
	}

	public BPMNRelayFactory(CPNProcess cPNProcess, ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	public void prepareFactory() {
		resetFactoryMap();
		registerFactory(BPMNElement.TASK, new BPMNTaskFactory(cPNProcess,
				elementParser));
		registerFactory(BPMNElement.GATEWAY, new BPMNGatewayFactory(cPNProcess,
				elementParser));
		registerFactory(BPMNElement.START, new BPMNStartEventFactory(
				cPNProcess, elementParser));
		registerFactory(BPMNElement.END, new BPMNEndEventFactory(cPNProcess,
				elementParser));
		registerFactory(BPMNElement.TRANSITION, new BPMNTransitionFactory(
				cPNProcess, elementParser));
		registerFactory(BPMNElement.INTERMEDIATE_MESSAGE_EVENT,
				new BPMNIntermediateMessageEventFactory(cPNProcess,
						elementParser));
		registerFactory(
				BPMNElement.INTERMEDIATE_TIMER_EVENT,
				new BPMNIntermediateTimerEventFactory(cPNProcess, elementParser));
		registerFactory(BPMNElement.BOUND_MESSAGE_EVENT,
				new BPMNBoundMessageEventFactory(cPNProcess, elementParser));
		registerFactory(BPMNElement.BOUND_TIMER_EVENT,
				new BPMNBoundTimerEventFactory(cPNProcess, elementParser));
		registerFactory(BPMNElement.SUB_PROCESS, new BPMNSubprocessFactory(
				cPNProcess, elementParser));
		registerFactory(BPMNElement.SUB_PROCESS_START,
				new BPMNSubprocessStartFactory(cPNProcess, elementParser));
		registerFactory(BPMNElement.SUB_PROCESS_END,
				new BPMNSubprocessEndFactory(cPNProcess, elementParser));
		registerFactory(BPMNElement.SUB_PROCESS_TIMER_EVENT,
				new BPMNSubprocessTimerFactory(cPNProcess, elementParser));

		registerConnectorFactory(new BPMNTransitionFactory(cPNProcess,
				elementParser));

	}

}
