package test;

import java.io.File;

import ee.ut.converter.CPNProcess;
import ee.ut.model.bpmn.BPMNProcess;

public class TestCPNModel {

	public static void main(String[] args) {

		// XPDL process model file
		File xpdlFile = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/gateways_sketchpad.xpdl");

		// Simulation data to the corresponding XPDL simulation model
		File simDataFile = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/simulationData.xml");
		
		CPNProcess p = new BPMNProcess(xpdlFile,simDataFile);

		//OUTPUT FILE
		p.saveToCPN("C:/Karl/Thesis/Source/Converter/files/cpn/test.cpn");
	}
}
