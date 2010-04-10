package example;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.io.File;
import java.util.HashMap;

import javax.swing.JFrame;

import EDU.auburn.VGJ.algorithm.GraphUpdate;
import EDU.auburn.VGJ.algorithm.cgd.CGDAlgorithm;
import EDU.auburn.VGJ.graph.Graph;
import EDU.auburn.VGJ.graph.Node;
import EDU.auburn.VGJ.util.DDimension;
import EDU.auburn.VGJ.util.DRect;

import noNamespace.Arc;
import noNamespace.Cpnet;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Posattr;
import noNamespace.Trans;
import noNamespace.WorkspaceElementsDocument;
import ee.ut.model.bpmne.BPMNeProcess;

public class ExLucianoWrapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File f = new File("./files/cpn/blank.cpn");
		WorkspaceElementsDocument doc = WorkspaceElementsDocument.Factory.parse(f);
		Cpnet cpnet = doc.getWorkspaceElements().getCpnet();
						
		BPMNeProcess proc = new BPMNeProcess(cpnet, "process", "process");

		proc.addStartEvent("start", "Phone_Call");
		proc.addTask("task_a", "Enough_Information_Available");
		
		proc.setExit("task_a");
		proc.addEdge("start", "task_a");
		
		//proc.setTaskDDistribution("task_a", "normal(30.0,5.0)");
		
		proc.setNumberOfCases("start", "5");
		proc.setStartEventCDistribution("start", "round(erlang(10, 1.0))");
		
		for (Page p : cpnet.getPageArray())
			doLayouting(p);
		
		f = new File("./files/cpn/ExLucianoWrapper.cpn");

		doc.save(f);
		System.out.println("Done");
	}
	
	public static void printNode(Node n) {
		//System.out.printf("(%f, %f): [%f, %f]\n", n.getPosition().x, n.getPosition().y, n.getBoundingBox().height, n.getBoundingBox().width);
	}

	public static void doLayouting(Page page) {
		Graph graph = new Graph(true);
		HashMap<String, Node> map = new HashMap<String, Node>();
		
		JFrame f = new JFrame();
		Font font = new Font("Serif", Font.PLAIN, 12);
		FontMetrics fm = f.getFontMetrics(font);
		for (Place p : page.getPlaceArray()) {
			
			//System.out.println("Place: " + p.getId());
			Node n = graph.createNode();
			n.setLabel(p.getId()); n.setLabelPosition("IN"); n.setShape(Node.OVAL);
			n.setBoundingBox(new DDimension(fm.stringWidth(n.getLabel())+60, fm.getHeight()+15));
			map.put(p.getId(), n);
		}

		for (Trans t : page.getTransArray()) {
			//System.out.println("Transitions: " + t.getId() + "  " + t.getText().copy());
			Node n = graph.createNode();
			n.setLabel(t.getId()); n.setLabelPosition("IN"); n.setShape(Node.RECTANGLE);
			n.setBoundingBox(new DDimension(fm.stringWidth(n.getLabel())+60, fm.getHeight()+15));
			map.put(t.getId(), n);
		}
		
		for (Arc arc : page.getArcArray()) {
			String source, target;
			if (arc.getOrientation().equals("PtoT")) {
				source = arc.getPlaceend().getIdref();
				target = arc.getTransend().getIdref();
			} else {
				source = arc.getTransend().getIdref();
				target = arc.getPlaceend().getIdref();
			}
			System.out.printf("%s -> %s\n", source, target);
			
			graph.insertEdge(map.get(source), map.get(target));
		}
		
		//TreeAlgorithm layouter = new TreeAlgorithm('l');
		CGDAlgorithm layouter = new CGDAlgorithm();
		
		layouter.compute(graph, new GraphUpdate() {
		    double hSpacing = 20, vSpacing = 40;
		    double scale_ = 1.0;

			public void center() {}

			public Frame getFrame() {
				return null;
			}

		      public double getHSpacing()
		      {
		         return 1/scale_ * hSpacing;
		      }
		   
		      public double getVSpacing()
		      {
		         return 1/scale_ * vSpacing;
		      }
		 
			public Node getSelectedNode() {
				return null;
			}

			public void scale(double scaleval) {}

			public void update(boolean adjust_bounds) {}

			public DRect windowRect() {
				return null;
			}
			
		});
		
		for (Node n : map.values())
			printNode(n);
		
		for (Place p : page.getPlaceArray()) {
			Node n = map.get(p.getId());			
			Posattr pos = Posattr.Factory.newInstance();			
			pos.setX(Double.toString(n.getPosition().x));
			pos.setY(Double.toString(n.getPosition().y));
			p.setPosattr(pos);
			p.addNewEllipse().setH(Double.toString(n.getBoundingBox().height));
			p.getEllipse().setW(Double.toString(n.getBoundingBox().width));
			
			Posattr pos2 = Posattr.Factory.newInstance();
			pos2.setX(Double.toString(n.getPosition().x + n.getBoundingBox().width/2));
			pos2.setY(Double.toString(n.getPosition().y - n.getBoundingBox().height/2));
			p.getTypeArray(0).addNewPosattr().set(pos2);
		}
		for (Trans t : page.getTransArray()) {
			Node n = map.get(t.getId());			
			Posattr pos = Posattr.Factory.newInstance();			
			pos.setX(Double.toString(n.getPosition().x));
			pos.setY(Double.toString(n.getPosition().y));
			t.setPosattr(pos);
			t.addNewBox().setH(Double.toString(n.getBoundingBox().height));
			t.getBox().setW(Double.toString(n.getBoundingBox().width));
		}
		
		for (Arc arc : page.getArcArray()) {
			String source, target;
			if (arc.getOrientation().equals("PtoT")) {
				source = arc.getPlaceend().getIdref();
				target = arc.getTransend().getIdref();
			} else {
				source = arc.getTransend().getIdref();
				target = arc.getPlaceend().getIdref();
			}
			Node s = map.get(source), t = map.get(target);
			
			double x = s.getPosition().x + 10 + Math.abs((s.getPosition().x - t.getPosition().x) / 2.0);
			double y = s.getPosition().y - Math.abs((s.getPosition().y - t.getPosition().y) / 2.0);
			
			if (arc.getAnnot() != null) {
				Posattr pos = Posattr.Factory.newInstance();
				pos.setX(Double.toString(x)); pos.setY(Double.toString(y));
				arc.getAnnot().addNewPosattr().set(pos);
			}
		}
	}
	

}
