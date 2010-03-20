package test;

import java.io.File;

import noNamespace.Cpnet;
import noNamespace.Page;
import noNamespace.WorkspaceElementsDocument;
import ee.ut.bpmnsim.Process;

public class Simple {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File f = new File("./files/New net.cpn");
		WorkspaceElementsDocument doc = WorkspaceElementsDocument.Factory.parse(f);
		Cpnet cpnet = doc.getWorkspaceElements().getCpnet();
						
		Process proc = new Process(cpnet, "process", "process");

		proc.addStartEvent("start", "Phone_Call");
		proc.addTask("task_a", "Enough_Information_Available");
		
		proc.setExit("task_a");
		proc.addEdge("start", "task_a");
		
		//proc.setTaskDDistribution("task_a", "normal(30.0,5.0)");
		
		proc.setNumberOfCases("start", "5");
		proc.setStartEventCDistribution("start", "round(erlang(10, 1.0))");
		
		for (Page p : cpnet.getPageArray())
			Main.doLayouting(p);
		
		f = new File("./files/simple.cpn");

		doc.save(f);
		System.out.println("Done");
	}

}
