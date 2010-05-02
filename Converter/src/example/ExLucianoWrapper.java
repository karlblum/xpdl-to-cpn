package example;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;

import noNamespace.Arc;
import noNamespace.Cpnet;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Posattr;
import noNamespace.Trans;
import noNamespace.WorkspaceElementsDocument;
import EDU.auburn.VGJ.algorithm.GraphUpdate;
import EDU.auburn.VGJ.algorithm.tree.TreeAlgorithm;
import EDU.auburn.VGJ.graph.Graph;
import EDU.auburn.VGJ.graph.Node;
import EDU.auburn.VGJ.util.DDimension;
import EDU.auburn.VGJ.util.DRect;
import ee.ut.old.model.bpmne.BPMNeProcess;

public class ExLucianoWrapper {

	
	public static void doLayouting(Page page) throws IOException {

		FileWriter fstream = new FileWriter("./files/cpn/dot_input.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		HashMap<String, String[]> layoutData = new HashMap<String, String[]>();
		
		out.write("digraph G {nodesep = 1.75; ranksep=0.75; \n");

		for (Arc arc : page.getArcArray()) {
			String source, target;
			if (arc.getOrientation().equals("PtoT")) {
				source = arc.getPlaceend().getIdref();
				target = arc.getTransend().getIdref();
			} else {
				source = arc.getTransend().getIdref();
				target = arc.getPlaceend().getIdref();
			}
			out.write(source + "->" + target + "\n");	
		}
			out.write("}");
			out.close();
		
		Process pr = Runtime.getRuntime().exec("\"c:\\Program Files\\Graphviz2.26.3\\bin\\dot.exe\" .\\files\\cpn\\dot_input.txt");
		
		String line;
		int lineNr = 0;
		BufferedReader input =
	        new BufferedReader
	          (new InputStreamReader(pr.getInputStream()));
	      while ((line = input.readLine()) != null) {
	    	  lineNr++;
	    	  if(lineNr>3 && !line.contains("->") && line.length() > 10){
	  	        int posIDEnd = line.indexOf("[");
	  	        int posCoordStart = line.indexOf("\"");
	  	        int posCoordEnd = line.indexOf("\"", posCoordStart+1);
	  	        String coords = line.substring(posCoordStart+1, posCoordEnd).trim();
	  	        String tokenId = line.substring(0,posIDEnd).trim();
	  	        layoutData.put(tokenId, new String[]{coords.split(",")[0],coords.split(",")[1]});
	  	        System.out.println(tokenId);
	    	  }
	      }
	      input.close();
		
		for (Place p : page.getPlaceArray()) {
			if (layoutData.get(p.getId()) == null) continue;
			
			String xc = layoutData.get(p.getId())[0];
			String yc = layoutData.get(p.getId())[1];
			Posattr pos = Posattr.Factory.newInstance();
			pos.setX(xc);
			pos.setY(yc);
			p.setPosattr(pos);
			
			p.addNewEllipse().setH("25");
			p.getEllipse().setW("120");
						
			Posattr pos2 = Posattr.Factory.newInstance();
			
			pos2.setX(Double.toString(Double.parseDouble(xc) + 60));
			pos2.setY(Double.toString(Double.parseDouble(yc) + 20));
			p.getTypeArray(0).addNewPosattr().set(pos2);
		
		}
		for (Trans t : page.getTransArray()) {
			String xc = layoutData.get(t.getId())[0];
			String yc = layoutData.get(t.getId())[1];
			Posattr pos = Posattr.Factory.newInstance();
			pos.setX(xc);
			pos.setY(yc);
			t.setPosattr(pos);

			t.addNewBox().setH("25");
			t.getBox().setW("120");
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
			Double xcSource =  Double.parseDouble(layoutData.get(source)[0]);
			Double ycSource = Double.parseDouble(layoutData.get(source)[1]);
			
			Double xcTarget= Double.parseDouble(layoutData.get(target)[0]);
			Double ycTarget = Double.parseDouble(layoutData.get(target)[1]);

			double x = xcSource + 10
					+ Math.abs((xcSource - xcTarget) / 2.0);
			double y = ycSource
					- Math.abs((ycSource - ycTarget) / 2.0);

			if (arc.getAnnot() != null) {
				Posattr pos = Posattr.Factory.newInstance();
				pos.setX(Double.toString(x));
				pos.setY(Double.toString(y));
				arc.getAnnot().addNewPosattr().set(pos);
			}
		}
		
	}

	public static double getRandom(int max) {
		return new Random().nextInt(max);
	}
}
