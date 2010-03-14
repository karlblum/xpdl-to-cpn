package test;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.HashMap;

import javax.swing.JFrame;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

import ee.ut.bpmnsim.Process;
import ee.ut.bpmnsim.Subprocess;
import ee.ut.bpmnsim.Task;
import ee.ut.bpmnsim.XORGateway;
import ee.ut.bpmnsim.Gateway.GWType;

import EDU.auburn.VGJ.algorithm.GraphUpdate;
import EDU.auburn.VGJ.algorithm.cgd.CGDAlgorithm;
import EDU.auburn.VGJ.algorithm.shawn.Spring;
import EDU.auburn.VGJ.algorithm.tree.TreeAlgorithm;
import EDU.auburn.VGJ.graph.Edge;
import EDU.auburn.VGJ.graph.Graph;
import EDU.auburn.VGJ.graph.Node;
import EDU.auburn.VGJ.util.DDimension;
import EDU.auburn.VGJ.util.DRect;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Cpnet;
import noNamespace.Globbox;
import noNamespace.Id;
import noNamespace.Instance;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Posattr;
import noNamespace.Text;
import noNamespace.Trans;
import noNamespace.Type;
import noNamespace.Var;
import noNamespace.WorkspaceElementsDocument;

public class Simple {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File f = new File("./files/New net.cpn");
		WorkspaceElementsDocument doc = WorkspaceElementsDocument.Factory.parse(f);
		Cpnet cpnet = doc.getWorkspaceElements().getCpnet();
						
		Process proc = new Process(cpnet, "proceso", "proceso");

		proc.addStartEvent("start", "Phone_Call");
		proc.addTask("task_a", "Enough_Information_Available");
		
		proc.setExit("task_a");
		proc.addEdge("start", "task_a");
		
		proc.setTaskDDistribution("task_a", "normal(30.0,5.0)");
		
		proc.setNumberOfCases("start", "5");
		proc.setStartEventCDistribution("start", "round(erlang(10, 1.0))");
		
		for (Page p : cpnet.getPageArray())
			Main.doLayouting(p);
		
		f = new File("./files/simple.cpn");

		doc.save(f);
		System.out.println("Done");
	}

}
