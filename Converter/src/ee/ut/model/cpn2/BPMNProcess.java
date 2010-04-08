package ee.ut.model.cpn2;

import ee.ut.model.cpn2.BPMNActivityFactory;
import ee.ut.model.cpn2.BPMNFactory;
import ee.ut.model.cpn2.BPMNTransitionFactory;

public class BPMNProcess {

	private CPNet cpnet;
	private BPMNFactory elementFactory;

	public BPMNProcess() {
		this.cpnet = new CPNet();
		this.elementFactory = new BPMNFactory();
		elementFactory.registerActivityFactory(new BPMNActivityFactory());
		elementFactory.registerTransitionFactory(new BPMNTransitionFactory());

		BPMNActivity a = (BPMNActivity) elementFactory.create(
				new ee.ut.model.xpdl2.Activity(), cpnet, "A1");
		BPMNActivity b = (BPMNActivity) elementFactory.create(
				new ee.ut.model.xpdl2.Activity(), cpnet, "A2");

		BPMNTransition t = (BPMNTransition) elementFactory.create(
				new ee.ut.model.xpdl2.Transition(), cpnet, "T1");
		
		t.setFrom(a.getOutputPlaceId());
		t.setTo(b.getInputPlaceId());

	}

	public void saveToCPN() {
		cpnet
				.saveToFile("C:/Karl/Thesis/Source/Converter/files/cpn/TestCPNModel.cpn");
	}

}
