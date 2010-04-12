package test;

import java.io.File;

import ee.ut.converter.CPNProcess;
import ee.ut.model.bpmn.BPMNProcess;

public class TestCPNModel {

	public static void main(String[] args) {

		//INPUT FILE
		File xpdlFile = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/complex.xpdl");
		
		CPNProcess p = new BPMNProcess(xpdlFile);

		//OUTPUT FILE
		p.saveToCPN("C:/Karl/Thesis/Source/Converter/files/cpn/complex.cpn");
	}
}
