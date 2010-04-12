package ee.ut.old;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.io.File;
import java.util.HashMap;

import javax.swing.JFrame;

import noNamespace.Arc;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Posattr;
import noNamespace.Trans;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

import EDU.auburn.VGJ.algorithm.GraphUpdate;
import EDU.auburn.VGJ.algorithm.cgd.CGDAlgorithm;
import EDU.auburn.VGJ.graph.Graph;
import EDU.auburn.VGJ.graph.Node;
import EDU.auburn.VGJ.util.DDimension;
import EDU.auburn.VGJ.util.DRect;

public class Main {

	public static void doLayouting(Page page) {
		Graph graph = new Graph(true);
		HashMap<String, Node> map = new HashMap<String, Node>();

		JFrame f = new JFrame();
		Font font = new Font("Serif", Font.PLAIN, 12);
		FontMetrics fm = f.getFontMetrics(font);
		for (Place p : page.getPlaceArray()) {
			System.out.println("Place: " + p.getId());
			Node n = graph.createNode();
			n.setLabel(p.getId());
			n.setLabelPosition("IN");
			n.setShape(Node.OVAL);
			n.setBoundingBox(new DDimension(fm.stringWidth(n.getLabel()) + 60,
					fm.getHeight() + 15));
			map.put(p.getId(), n);
		}

		for (Trans t : page.getTransArray()) {
			System.out.println("Transitions: " + t.getId() + "  "
					+ t.getText().copy());
			Node n = graph.createNode();
			n.setLabel(t.getId());
			n.setLabelPosition("IN");
			n.setShape(Node.RECTANGLE);
			n.setBoundingBox(new DDimension(fm.stringWidth(n.getLabel()) + 60,
					fm.getHeight() + 15));
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

		// TreeAlgorithm layouter = new TreeAlgorithm('l');
		CGDAlgorithm layouter = new CGDAlgorithm();

		layouter.compute(graph, new GraphUpdate() {
			double hSpacing = 30, vSpacing = 80;
			double scale_ = 1.0;

			public void center() {
			}

			public Frame getFrame() {
				return null;
			}

			public double getHSpacing() {
				return 1 / scale_ * hSpacing;
			}

			public double getVSpacing() {
				return 1 / scale_ * vSpacing;
			}

			public Node getSelectedNode() {
				return null;
			}

			public void scale(double scaleval) {
			}

			public void update(boolean adjust_bounds) {
			}

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
			pos2.setX(Double.toString(n.getPosition().x
					+ n.getBoundingBox().width / 2));
			pos2.setY(Double.toString(n.getPosition().y
					- n.getBoundingBox().height / 2));
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

			double x = s.getPosition().x + 10
					+ Math.abs((s.getPosition().x - t.getPosition().x) / 2.0);
			double y = s.getPosition().y
					- Math.abs((s.getPosition().y - t.getPosition().y) / 2.0);

			if (arc.getAnnot() != null) {
				Posattr pos = Posattr.Factory.newInstance();
				pos.setX(Double.toString(x));
				pos.setY(Double.toString(y));
				arc.getAnnot().addNewPosattr().set(pos);
			}
		}
	}

	public static void printNode(Node n) {
		System.out.printf("(%f, %f): [%f, %f]\n", n.getPosition().x, n
				.getPosition().y, n.getBoundingBox().height,
				n.getBoundingBox().width);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * File f = new File("./files/New net.cpn"); WorkspaceElementsDocument
		 * doc = WorkspaceElementsDocument.Factory.parse(f); Cpnet cpnet =
		 * doc.getWorkspaceElements().getCpnet();
		 * 
		 * Process proc = new Process(cpnet, "SimpleProcess", "SimpleProcess");
		 * 
		 * proc.addStartEvent("start", "Phone_Call"); proc.addTask("task",
		 * "Register_Claim"); proc.setExit("task");
		 * 
		 * proc.addEdge("start", "task");
		 * 
		 * proc.setNumberOfCases("start", "10");
		 * proc.setStartEventCDistribution("start", "round(erlang(10, 1.0))");
		 * 
		 * 
		 * proc.addStartEvent("start", "Phone_Call"); proc.addTask("task_a",
		 * "Enough_Information_Available"); proc.addXORGateway("gw1", "Split_1",
		 * GWType.SPLIT); proc.addTask("task_b", "Register_Claim");
		 * proc.addTask("task_c", "Determine_Likelihood_of_Claim");
		 * proc.addXORGateway("gw2", "Split_2", GWType.SPLIT);
		 * proc.addTask("task_d", "Assess_Claim"); proc.addXORGateway("gw3",
		 * "Split_3", GWType.SPLIT); proc.addANDGateway("gw4", "Split_4",
		 * GWType.SPLIT); proc.addTask("task_e", "Initialize_Payment");
		 * proc.addTask("task_f", "Advise_Claimant_on_Reimbursement");
		 * proc.addANDGateway("gw5", "AndJoin", GWType.JOIN);
		 * proc.addTask("task_g", "Close_Claim"); proc.addXORGateway("gw6",
		 * "XorJoin", GWType.JOIN); proc.setExit("gw6");
		 * 
		 * proc.addEdge("start", "task_a"); proc.addEdge("task_a", "gw1");
		 * proc.addEdge("gw1", "task_b"); proc.addEdge("gw1", "gw6");
		 * proc.addEdge("task_b", "task_c"); proc.addEdge("task_c", "gw2");
		 * proc.addEdge("gw2", "task_d"); proc.addEdge("gw2", "gw6");
		 * proc.addEdge("task_d", "gw3"); proc.addEdge("gw3", "gw4");
		 * proc.addEdge("gw3", "gw6"); proc.addEdge("gw4", "task_e");
		 * proc.addEdge("gw4", "task_f"); proc.addEdge("task_e", "gw5");
		 * proc.addEdge("task_f", "gw5"); proc.addEdge("gw5", "task_g");
		 * proc.addEdge("task_g", "gw6");
		 * 
		 * proc.setTaskDDistribution("task_a", "normal(30.0,5.0)");
		 * proc.setTaskDDistribution("task_b", "normal(520.0,60.0)");
		 * proc.setTaskDDistribution("task_c", "normal(20.0,5.0)");
		 * proc.setTaskDDistribution("task_d", "normal(660.0,60.0)");
		 * proc.setTaskDDistribution("task_e", "normal(180.0,25.0)");
		 * proc.setTaskDDistribution("task_f", "normal(120.0,20.0)");
		 * proc.setTaskDDistribution("task_g", "normal(30.0,5.0)");
		 * 
		 * proc.setTransitionProbabilities("gw1", new Object[] {"task_b", 90,
		 * "gw6", 10}); proc.setTransitionProbabilities("gw2", new Object[]
		 * {"task_d", 85, "gw6", 15}); proc.setTransitionProbabilities("gw3",
		 * new Object[] {"gw4", 80, "gw6", 20}); proc.setNumberOfCases("start",
		 * "5"); proc.setStartEventCDistribution("start",
		 * "round(erlang(10, 1.0))");
		 * 
		 * for (Page p : cpnet.getPageArray()) doLayouting(p);
		 * 
		 * f = new File("./files/Newnet.cpn");
		 * 
		 * doc.save(f); System.out.println("Done");
		 */

		System.out.println("Initializing simulator...");

		File f = new File("./files/simple.cpn");

		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost method = new HttpPost("http://localhost:9080/bpmnsim");
		MultipartEntity entity = new MultipartEntity();
		FileBody fileBody = new FileBody(f);
		entity.addPart("file", fileBody);
		method.setEntity(entity);

		HttpResponse response = httpclient.execute(method);

		System.out.println(response.getStatusLine());
	}

}
