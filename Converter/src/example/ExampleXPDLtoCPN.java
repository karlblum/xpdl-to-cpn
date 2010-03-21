package example;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import noNamespace.Cpnet;
import noNamespace.Page;
import noNamespace.WorkspaceElementsDocument;

import org.apache.xmlbeans.XmlException;
import org.wfmc._2008.xpdl2.Activities;
import org.wfmc._2008.xpdl2.Activity;
import org.wfmc._2008.xpdl2.PackageType;
import org.wfmc._2008.xpdl2.ProcessType;
import org.wfmc._2008.xpdl2.Transition;
import org.wfmc._2008.xpdl2.Transitions;

import ee.ut.bpmnsim.Process;

public class ExampleXPDLtoCPN {
	public static void main(String[] args) throws IOException, XmlException {
		
		File f = new File("./files/New net.cpn");
		WorkspaceElementsDocument doc = WorkspaceElementsDocument.Factory.parse(f);
		Cpnet cpnet = doc.getWorkspaceElements().getCpnet();
		
		File fIn = new File("C:/Karl/Thesis/Source/Converter/files/models/simplest_xpdl.xpdl");									//specify the path of your input XML file
		try {	
			JAXBContext jc = JAXBContext.newInstance("org.wfmc._2008.xpdl2");	   		//this is the package name of your facade classes 
																			//e.g. for EPML is "de.epml.www"
			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement rootElement = (JAXBElement)u.unmarshal(fIn);		//creates the root element from XML file
																			//note: many input types can be used instead of File, e.g. if your XML is contained in a String,
																			//you can use "ByteArrayInputStream xmlBA = new ByteArrayInputStream(xml.getBytes());" where "xml" is your String
			
			PackageType root = (PackageType)rootElement.getValue();
			ProcessType proc = root.getWorkflowProcesses().getWorkflowProcess().get(0);
			
			
			System.out.println(proc.getName());
			
			Map<String, Activity> map = new HashMap<String, Activity>();
			
			for (Object o: proc.getContent()) {
				System.out.println(o);
				if (o instanceof Activities) {
					Activities acts = (Activities)o;
					for (Activity act : acts.getActivity()) {
						act.getContent();
						System.out.println(act + ": " + act.getName());
						map.put(act.getId(), act);
					}
				}
				if (o instanceof Transitions) {
					Transitions trans = (Transitions)o;
					for (Transition flow : trans.getTransition()) {
						System.out.printf("%s -> %s\n", map.get(flow.getFrom()), map.get(flow.getTo()));
					}
				}
			}
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		
						
		Process proc = new Process(cpnet, "process", "process");

		proc.addStartEvent("start", "Phone_Call");
		proc.addTask("task_a", "Enough_Information_Available");
		
		proc.setExit("task_a");
		proc.addEdge("start", "task_a");
		
		//proc.setTaskDDistribution("task_a", "normal(30.0,5.0)");
		
		proc.setNumberOfCases("start", "5");
		proc.setStartEventCDistribution("start", "round(erlang(10, 1.0))");
		
		
		f = new File("./files/ExampleXPDLtoCPN.cpn");

		doc.save(f);
		System.out.println("Done");
		
		
	}
}
