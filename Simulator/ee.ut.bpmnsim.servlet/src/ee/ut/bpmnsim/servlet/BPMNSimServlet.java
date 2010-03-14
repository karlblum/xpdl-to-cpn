package ee.ut.bpmnsim.servlet;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dk.au.daimi.ascoveco.cpn.engine.Simulator;
import dk.au.daimi.ascoveco.cpn.engine.daemon.DaemonSimulator;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.HighLevelSimulator;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.checker.CheckerJob;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.importer.DOMParser;

public class BPMNSimServlet extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 5554352666620471990L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().println("Service is working...");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		try {
			List /* FileItem */ items = upload.parseRequest(req);
			System.out.println("Parsing request");

			FileItem fileItem = (FileItem)items.get(0);
			System.out.println("Received file: " + fileItem.getName() + ", size:" + fileItem.getSize());
			PetriNet pnet = DOMParser.parse(fileItem.getInputStream(), "Example");
			
			System.out.println("Initializing simulator...");
			HighLevelSimulator s = HighLevelSimulator.getHighLevelSimulator(
					new Simulator(new DaemonSimulator(InetAddress.getLocalHost(), 23456, new File("cpn.ML"))),pnet);
			
			try {
				CheckerJob checkerJob = new CheckerJob("Example", pnet, null, s);
				checkerJob.schedule();
				checkerJob.join();

				s.setModelNameModelDirOutputDir("Example",
						"C:/Karl/Thesis/Source/Simulator/ee.ut.bpmnsim.servlet/tmp",
						"C:/Karl/Thesis/Source/Simulator/ee.ut.bpmnsim.servlet/tmp/output");
				s.setSimulationReportOptions(true, true, "");
				s.saveSimulationReport(new File("C:/Karl/Thesis/Source/Simulator/ee.ut.bpmnsim.servlet/tmp/test.txt"));
				s.initialState();
				System.out.println("Executing steps...");
				System.out.println(s.executeSteps(1000));
				System.out.println("Petri Net: " + pnet.getPage() );
			} finally {
				s.destroy();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}