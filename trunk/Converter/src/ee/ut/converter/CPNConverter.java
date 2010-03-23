package ee.ut.converter;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import noNamespace.Cpnet;

public class CPNConverter {
	
	File xpdlFile;
	File simDataFile;

	public CPNConverter(File xpdlFile, File simDataFile) {
		this.xpdlFile = xpdlFile;
		this.simDataFile = simDataFile;
	}


	public Cpnet convert() {

		JAXBElement xpdlRoot = unMasrhall(xpdlFile, "ee.ut.model.xpdl2");
		JAXBElement simDataRoot = unMasrhall(simDataFile, "ee.ut.model.sim");

		return null;
	}

	
	// Method makes an in-memory representation of an input xml file 
	@SuppressWarnings("unchecked")
	private JAXBElement unMasrhall(File file, String model) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(model);

			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement rootElement = (JAXBElement) u.unmarshal(file);
			return rootElement;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
