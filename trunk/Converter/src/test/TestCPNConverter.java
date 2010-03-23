package test;

import java.io.File;
import java.io.IOException;

import noNamespace.Cpnet;

import ee.ut.converter.CPNConverter;

public class TestCPNConverter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// XPDL process model file
		File xpdlFile = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/simplest_xpdl.xpdl");

		// Simulation data to the corresponding XPDL simulation model
		File simDataFile = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/simulationData.xml");

		// Conversion output file
		File convertedCPNFile = new File("C:/Karl/Thesis/Source/Converter/files/cpn/TestCPNConverterOut.cpn");
		
		CPNConverter converter = new CPNConverter(xpdlFile,simDataFile);
		Cpnet result = converter.convert();	
		
		try {
			result.save(convertedCPNFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
