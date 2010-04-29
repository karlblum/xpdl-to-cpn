package test;

import java.io.File;

import ee.ut.converter.CPNProcess;
import ee.ut.model.bpmn.BPMNProcess;

public class TestCPNModel {

	public static void main(String[] args) {

		// XPDL process model file
		File xpdlFile = new File("./files/models/4 tasks.xpdl");

		// Simulation data to the corresponding XPDL simulation model
		File simDataFile = new File(
				"./files/models/Empty simulation data.xml");

		CPNProcess p = new BPMNProcess(xpdlFile, simDataFile);

		// OUTPUT FILE
		p.saveToCPN("./files/cpn/test4.cpn");
	}
}
