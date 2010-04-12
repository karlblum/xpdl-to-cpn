package ee.ut.old;

import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import noNamespace.Cpnet;

public class TestCPNConverter {

	/**
	 * @param args
	 * @throws IOException
	 * @throws XmlException
	 */
	public static void main(String[] args) throws XmlException, IOException {

		// XPDL process model file
		File xpdlFile = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/gateways_sketchpad.xpdl");

		// Simulation data to the corresponding XPDL simulation model
		File simDataFile = new File(
				"C:/Karl/Thesis/Source/Converter/files/models/simulationData.xml");

		// Conversion output file
		File convertedCPNFile = new File(
				"C:/Karl/Thesis/Source/Converter/files/cpn/TestCPNConverterOut.cpn");

		CPNConverter converter = new CPNConverter(xpdlFile, simDataFile);
		converter.convert();
		converter.saveToFile(convertedCPNFile);

	}

}
