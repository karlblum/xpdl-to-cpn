package ee.ut.model.bpmn;

import java.util.ArrayList;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNSubprocess extends BPMNElement {

	private String startPlaceId;
	private String endPlaceId;
	private String exceptionInputTID;
	private BProcess subProcess;
	private boolean skippingFunctionsPresent = false;
	private String skipperFinalPlace;

	private String okPID;
	private String nokPID;
	private String timerTokenPID;
	private String exceptionRelayTID;

	public BPMNSubprocess(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);
		String pid = parser.getElementParser().getSubprocessId(o);

		subProcess = process.createSubprocess(pid);

		// Here we will recursively parse the subprocess.
		parser.parse(subProcess);

		startPlaceId = subProcess.getSource().getInputPID();

		exceptionInputTID = ((BPMNSubprocessStart) subProcess.getSource())
				.getExceptionTID();

		endPlaceId = subProcess.getDefaultSink().getOutputPID(null);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		// TODO Auto-generated method stub
	}

	public void setOutputPlace(String id) {
		endPlaceId = id;
	}

	public void setInputPlace(String id) {
		startPlaceId = id;
	}

	public String getSubProcessId() {
		return subProcess.getId();
	}

	private void addExceptionPath(String path, String timerFunction) {
		String s = process.getCpnet().getTransitionAction(exceptionRelayTID);

		boolean isFirst = s.contains("paths = []");

		int posPaths = s.indexOf("val paths = [");
		String s2 = s.substring(0, posPaths + 13) + path + (isFirst ? "" : ",")
				+ s.substring(posPaths + 13);

		int posTimer = s2.indexOf("val timings = [");
		String s3 = s2.substring(0, posTimer + 15) + timerFunction
				+ (isFirst ? "" : ",") + s2.substring(posTimer + 15);

		process.getCpnet().setTransitionAction(exceptionRelayTID, s3);
	}

	public void addSkippingFunctions() {
		skippingFunctionsPresent = true;
		String s = process.getCpnet().addPlace().getId();
		process.getCpnet().addArc(exceptionInputTID, s);

		exceptionRelayTID = process.getCpnet().addTrans("EXCEPTION_RELAY")
				.getId();

		process
				.getCpnet()
				.setTransitionAction(
						exceptionRelayTID,
						"input (c);\r\n"
								+ "output (cp,dl);\r\n"
								+ "action\r\n"
								+ "(\r\n"
								+ "let\r\n"
								+ "  val paths = []  \r\n"
								+ "  val timings = []\r\n"
								+ "\r\n"
								+ "   val delay = minFromList(timings,[])\r\n"
								+ "   val p = List.nth(paths, locInList(timings,delay,0))\r\n"
								+ "   val result : CASExEXPATH = {pr=c,path=p}\r\n"
								+ "in\r\n" + "   (result,delay)\r\n"
								+ "end\r\n" + ");");

		process.getCpnet().addArc(s, exceptionRelayTID);

		timerTokenPID = process.getCpnet().addPlace("CASExEXPATH",
				elementName + "TIMER").getId();

		String arcId = process.getCpnet().addArc(exceptionRelayTID,
				timerTokenPID, "cp").getId();
		process.getCpnet().setArcAnnot(arcId, "cp@+dl");

		String exeptionTransId = process.getCpnet().addTrans(
				elementName + "EXCEPTION").getId();

		process.getCpnet().addArc(timerTokenPID, exeptionTransId, "cp");

		okPID = process.getCpnet().addPlace("CASExEXPATH", elementName + "OK")
				.getId();
		process.getCpnet().addArc(okPID, exeptionTransId, "cp");
		process.getCpnet().addArc(exceptionRelayTID, okPID, "cp");

		nokPID = process.getCpnet()
				.addPlace("CASExEXPATH", elementName + "NOK").getId();
		process.getCpnet().addArc(exeptionTransId, nokPID, "cp");

		ArrayList<Element> lastTasks = subProcess.getLastBeforeSink();

		skipperFinalPlace = process.getCpnet().addPlace().getId();
		for (Element e : subProcess.getElements().values()) {
			if (e instanceof BPMNTask) {
				BPMNTask task = (BPMNTask) e;
				if (!lastTasks.contains(task)) {
					task.addSubprocessSkipper(nokPID, okPID, null);
				} else {
					task.addSubprocessSkipper(nokPID, okPID, skipperFinalPlace);
				}
			}
		}

	}

	public void setBoundMessage(BPMNSubprocessMessage messageEvent) {
		if (!skippingFunctionsPresent)
			addSkippingFunctions();

		// update exception relay function

		addExceptionPath(messageEvent.getId(), messageEvent.getTimeFunction());
		String t = process.getCpnet().addTrans("OUT" + messageEvent.getId())
				.getId();

		process.getCpnet().addArc(skipperFinalPlace, t);
		process.getCpnet().addArc(t, messageEvent.getInputPID());
		process.getCpnet().addArc(nokPID, t, "cp");

		process.getCpnet().setTransitionGuard(
				t,
				"[#ID c= (#ID (#pr cp)), (#path cp) = " + messageEvent.getId()
						+ "]");
	}

	public void setBoundTimer(BPMNSubprocessTimer bpmnSubprocessTimer) {
		if (!skippingFunctionsPresent)
			addSkippingFunctions();

		addExceptionPath(bpmnSubprocessTimer.getId(), String
				.valueOf(bpmnSubprocessTimer.getTimerTime()));

		String t = process.getCpnet().addTrans(
				"OUT" + bpmnSubprocessTimer.getId()).getId();
		process.getCpnet().addArc(skipperFinalPlace, t);
		process.getCpnet().addArc(t, bpmnSubprocessTimer.getInputPID());
		process.getCpnet().addArc(nokPID, t, "cp");

		process.getCpnet().setTransitionGuard(
				t,
				"[#ID c= (#ID (#pr cp)), (#path cp) = "
						+ bpmnSubprocessTimer.getId() + "]");
	}

	@Override
	public String getInputPID() {
		return startPlaceId;
	}

	@Override
	public String getOutputPID(String ref) {
		return endPlaceId;
	}

	public void addExceptionHandler(String handlerId) {
		for (Element e : subProcess.getSinks()) {
			if (e instanceof BPMNThrowExceptionEvent) {
				String t = process.getCpnet().addTrans().getId();
				process.getCpnet().addArc(e.getOutputPID(null), t);
				process.getCpnet().addArc(t, handlerId);
			}
		}
	}

	@Override
	public String getOutputPID() {
		// TODO Auto-generated method stub
		return null;
	}

}
