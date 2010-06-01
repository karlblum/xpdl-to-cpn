package ee.ut.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Block;
import noNamespace.Code;
import noNamespace.Cond;
import noNamespace.Cpnet;
import noNamespace.Initmark;
import noNamespace.Instance;
import noNamespace.Ml;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Posattr;
import noNamespace.Subpageinfo;
import noNamespace.Subst;
import noNamespace.Text;
import noNamespace.Time;
import noNamespace.Trans;
import noNamespace.Type;
import noNamespace.Var;
import noNamespace.WorkspaceElementsDocument;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlString;

/**
 * @author karl
 * 
 */
public class CPNet {

	private WorkspaceElementsDocument cpnWorkspace;
	private Cpnet cpnet;
	private Page page;
	private HashMap<String, Place> places = new HashMap<String, Place>();
	private HashMap<String, Arc> arcs = new HashMap<String, Arc>();
	private HashMap<String, Trans> transs = new HashMap<String, Trans>();
	private String resourcePlaceId;
	private int currentId = 1000;
	private List<Block> varBlocks = new ArrayList<Block>();
	private int numberOfVarBolcks = 3;
	private boolean cancelNaming = true;

	private String flowObjectType = "CASE";
	private String flowObjectVariable = "c";

	public CPNet() {
		File blankCPN = new File("./files/cpn/blank.cpn");

		try {
			cpnWorkspace = WorkspaceElementsDocument.Factory.parse(blankCPN);
		} catch (Exception e) {
			e.printStackTrace();
		}

		cpnet = cpnWorkspace.getWorkspaceElements().getCpnet();
		page = cpnet.getPageArray()[0];

		for (int i = 0; i < numberOfVarBolcks; i++) {
			varBlocks.add(cpnet.getGlobbox().addNewBlock());
		}

		initCPNetDeclarations();
	}

	private void initCPNetDeclarations() {
		addVar("p", "INT", "var p:INT;", 1);
		// createOrUpdateDef("colset TRIG_TOKEN = INT timed;", 1);
		addVar("tt", "TRIG_TOKEN", "var tt:TRIG_TOKEN;", 1);
		//createOrUpdateDef("val FILE = \"logs/logsCPN\"", 1);
		//createOrUpdateDef("val FILE_EXTENSION = \".cpnxml\"", 1);
		//createOrUpdateDef("use \"loggingFunctionsMultipleFiles.sml\";", 1);
		addVar("pt", "INT", "var pt:INT;", 1);
		createOrUpdateDef("fun et(mean:INT,stdD:INT)=\n" + "let\n"
				+ "val realMean = Real.fromInt mean\n"
				+ "val realStdD = Real.fromInt stdD\n" + "in\n"
				+ "round(uniform(realMean-realStdD, realMean+realStdD))\n"
				+ "end;", 1);
		// createOrUpdateDef("colset DTYPE = with specific | normal;", 1);
		// createOrUpdateDef("colset DISTRIBUTION = record dtype:DTYPE * specificValue:INT * mean:INT * std:INT;",
		// 1);
		createOrUpdateDef("fun intTime() = IntInf.toInt (time());", 1);
		createOrUpdateDef(
				"fun dateFromString(s:STRING) =\n"
						+ "let\n"
						+ "  val s1 = \"Sat Jan 01 10:51:07 2000\"\n"
						+ "  val dateSplit = String.tokens(fn(c) => c = #\" \") s\n"
						+ "  val timeStr = List.nth(dateSplit, 3)\n"
						+ "  val time = String.tokens(fn(c) => c = #\":\") timeStr\n"
						+ "  val day = Option.getOpt(Int.fromString(List.nth(dateSplit, 2)), 0)\n"
						+ "  val hour = Option.getOpt(Int.fromString(List.nth(time, 0)), 0)\n"
						+ "  val minute = Option.getOpt(Int.fromString(List.nth(time, 1)), 0)\n"
						+ "  val second = Option.getOpt(Int.fromString(List.nth(time, 2)), 0)\n"
						+ "  val year = Option.getOpt(Int.fromString(List.nth(dateSplit, 4)), 0)\n"
						+ "  val monthStr = List.nth(dateSplit, 1)\n"
						+ "  val month = case monthStr of\n"
						+ "      \"Jan\" => Date.Jan\n"
						+ "    | \"Feb\" => Date.Feb\n"
						+ "    | \"Mar\" => Date.Mar\n"
						+ "    | \"Apr\" => Date.Apr\n"
						+ "    | \"May\" => Date.May\n"
						+ "    | \"Jun\" => Date.Jun\n"
						+ "    | \"Jul\" => Date.Jul\n"
						+ "    | \"Aug\" => Date.Aug\n"
						+ "    | \"Sep\" => Date.Sep\n"
						+ "    | \"Oct\" => Date.Oct\n"
						+ "    | \"Nov\" => Date.Nov\n"
						+ "    | \"Dec\" => Date.Dec\n"
						+ "    | _     => Date.Jan;\n"
						+ "in\n"
						+ "  Date.date{day = day, hour = hour, minute = minute, month =month, offset = NONE, second = second, year = year}\n"
						+ "end", 1);
		// createOrUpdateDef("colset ID = int timed;", 1);
		addVar("i", "ID", "var i:ID;", 1);
		createOrUpdateDef("val OneTimeCostPerToken = 0;", 1);
		// createOrUpdateDef("colset CASE = record ID:INT * ats:INT * ts:INT timed;",
		// 1);
		addVar("c", "CASE", "var c:CASE;", 1);
		addVar("c1", "CASE", "var c1:CASE;", 1);
		createOrUpdateDef(
				"fun calcDisValue(value:DISTRIBUTION) =\r\n"
						+ "let\r\n"
						+ "  val dtype = #dtype(value)\r\n"
						+ "  val specificValue = #specificValue(value)\r\n"
						+ "  val mean = #mean(value)\r\n"
						+ "  val std = #std(value)\r\n"
						+ "in\r\n"
						+ "  case dtype of normal => et(mean, std) | specific => specificValue\r\n"
						+ "end;", 1);
		createOrUpdateDef(
				"fun add2StartDate(ts:INT) =\r\n"
						+ "let\r\n"
						+ "val day = Date.day(startDate)\r\n"
						+ "val second = Date.second(startDate)\r\n"
						+ "val hour = Date.hour (startDate)\r\n"
						+ "val minute = Date.minute(startDate)\r\n"
						+ "val month = Date.month (startDate)\r\n"
						+ "val offset = Date.offset (startDate)\r\n"
						+ "val second = Date.second(startDate)+ ts\r\n"
						+ "val year = Date.year (startDate)\r\n"
						+ "in\r\n"
						+ "Date.date{day = day, hour = hour, minute = minute, second = second, month = month, offset = offset, year = year}\r\n"
						+ "end;", 1);
		createOrUpdateDef(
				"fun generateCase(id:ID)=\r\n"
						+ "let\r\n"
						+ "\r\n"
						+ "val _ = createCaseFile(id);\r\n"
						+ "val curDate = add2StartDate(intTime()) ;\r\n"
						+ "val timestamp = (Date.fmt \"%Y-%m-%dT%H:%M:%S.000+01:00\" curDate);\r\n"
						+ "val data = [\"Cost\", Int.toString(OneTimeCostPerToken), \"ModelTimeStamp\", Int.toString(intTime())];\r\n"
						+ "val _ = addATE(id, \"Generated input\", [\"complete\"], timestamp, \"generator\", data);\r\n"
						+ "in\r\n"
						+ "  {ID=id, ts=intTime(), ats=intTime()}\r\n" + "end;",
				1);
		createOrUpdateDef(
				"fun generatorGuard(i:ID) =\r\n"
						+ "let\r\n"
						+ "val dateCompare = Date.compare(add2StartDate(intTime()), endDate) <> GREATER;\r\n"
						+ "in\r\n"
						+ "if i <= totalNoOfToken andalso dateCompare=true then true else false\r\n"
						+ "end;", 1);
		addVar("caseInfop", "CASE", "var caseInfop: CASE;", 1);
		addVar("path", "INT", "var path: INT;", 1);
		createOrUpdateDef(
				"fun initCaseInfo(id) = {Id=id,CaseStartTime=IntInf.toInt(time()),CaseEndTime=0};",
				1);
		// createOrUpdateDef("colset RECINT = record Name:STRING * StartTime:INT * Duration:INT;\r\n"
		// +
		// "(*All durations are in seconds*)", 1);
		// createOrUpdateDef("colset RECURRINGINTERVALS = list RECINT;", 1);
		// createOrUpdateDef("colset TTEXCEPTION = record Name:STRING * RepeatCount:INT * RepetitionDuration:INT * BeginDate:STRING * RecurringIntervals:RECURRINGINTERVALS;",
		// 1);
		// createOrUpdateDef("colset TTEXCEPTIONS = list TTEXCEPTION;", 1);
		// createOrUpdateDef("colset TIMETABLE = record Name:STRING * RepeatCount:INT * RepetitionDuration:INT * BeginDate:STRING * RecurringIntervals:RECURRINGINTERVALS * TTExceptions:TTEXCEPTIONS;",
		// 1);
		// createOrUpdateDef("colset TIMETABLES = list TIMETABLE;", 1);
		createOrUpdateDef(
				"fun isRole(roles:SLIST, required:STRING) = List.exists (fn x => x = required) roles;",
				1);
		createOrUpdateDef(
				"fun checkRoles [] [] = true\r\n"
						+ "| checkRoles _ [] = true\r\n"
						+ "| checkRoles roles (role::reqRoles) = List.exists (fn x => x = role) roles andalso checkRoles roles reqRoles ;",
				1);
		createOrUpdateDef(
				"fun check_roles(roles:SLIST, required:SLIST) = checkRoles roles required;",
				1);
		// createOrUpdateDef("colset RCOST = record Value:INT * CostPerDuration:INT * CostPerQuantity:INT * CostApplicableTT:TIMETABLES;",
		// 1);
		// createOrUpdateDef("colset RCOSTS = list RCOST;", 1);
		// createOrUpdateDef("colset RES = record Name:STRING * Costs:RCOSTS * Roles:SLIST * Availability:TIMETABLES timed;",
		// 1);
		createOrUpdateDef(
				"val recint_weekend = {Name=\"weekend\", StartTime=0, Duration=((60*60)*24*2)};",
				1);
		createOrUpdateDef(
				"val recint_dayShift = {Name=\"Day shift\", StartTime=((60*60)*9), Duration=((60*60)*9)};",
				1);
		createOrUpdateDef(
				"val recint_bulk = {Name=\"bulk\", StartDate=0, Duration=((60*60)*24)};",
				1);
		createOrUpdateDef(
				"val tte_weekend = {Name=\"weekend\", RepeatCount=0, RepetitionDuration=((60*60)*24*7), BeginDate=\"\", RecurringIntervals=[recint_weekend]};",
				1);
		createOrUpdateDef(
				"val tt_bulkweek = {Name=\"week\", RepeatCount=0, RepetitionDuration=((60*60)*24), BeginDate=\"\", RecurringIntervals=[recint_bulk], Exceptions=[tte_weekend]};",
				1);
		createOrUpdateDef(
				"val tt_week = {Name=\"week\", RepeatCount=0, RepetitionDuration=604800, BeginDate=\"dasdas\", RecurringIntervals=[recint_dayShift], TTExceptions=[tte_weekend]};",
				1);
		addVar("r", "RES", "var r:RES;", 1);
		// createOrUpdateDef("colset TRANSPARAMS  = record \r\n" +
		// "transitionName:STRING * pt: DISTRIBUTION * pCost:DISTRIBUTION * sCost:DISTRIBUTION * revenue:DISTRIBUTION * pWaitTimeDur:INT * pWaitTimeCost:INT * NoOfResources:INT;",
		// 1);
		createOrUpdateDef(
				"fun transitionAction (a:CASE, params:TRANSPARAMS) = \r\n"
						+ "let\r\n"
						+ "  val id = #ID(a)\r\n"
						+ "  val ts = #ts(a)\r\n"
						+ "  val ats = #ats(a)\r\n"
						+ "  val transitionName = #transitionName(params)\r\n"
						+ "  val noOr = #NoOfResources(params)\r\n"
						+ "  val waitTime = intTime() - ts\r\n"
						+ "  val waitTimeDur = #pWaitTimeDur(params)\r\n"
						+ "  val waitTimeDur = Real.fromInt waitTimeDur\r\n"
						+ "  val waitTimeCost = #pWaitTimeCost(params)\r\n"
						+ "  val waitTimeCost = Real.fromInt waitTimeCost\r\n"
						+ "  val waitTime_real = Real.fromInt waitTime\r\n"
						+ "  val waitTimeCost = if waitTimeDur > 0.0 then round((waitTime_real/waitTimeDur)*waitTimeCost) else 0;\r\n"
						+ "\r\n"
						+ "  val procTime = calcDisValue(#pt(params))\r\n"
						+ "  val procTime_real = Real.fromInt procTime\r\n"
						+ "\r\n"
						+ "  val processcost = calcDisValue(#pCost(params))\r\n"
						+ "  val scost = calcDisValue(#sCost(params))\r\n"
						+ "  val revenue = calcDisValue(#revenue(params))\r\n"
						+ "  val allcost = processcost + scost\r\n"
						+ "\r\n"
						+ "val curDate = add2StartDate(intTime()) ;\r\n"
						+ "val timestamp = (Date.fmt \"%Y-%m-%dT%H:%M:%S.000+01:00\" curDate);\r\n"
						+ "val data = [\"WaitingTime\", Int.toString(waitTime), \"WaitTimeCost\", Int.toString(waitTimeCost), \"ModelTimeStamp\", Int.toString(intTime())];\r\n"
						+ "val _ = addATE(id, transitionName, [\"start\"], timestamp, \"\", data);\r\n"
						+ "\r\n"
						+ "val curDate = add2StartDate(intTime() +procTime) ;\r\n"
						+ "val timestamp = (Date.fmt \"%Y-%m-%dT%H:%M:%S.000+01:00\" curDate);\r\n"
						+ "val data = [\"ProcessingTime\", Int.toString(procTime), \"Cost\", Int.toString(allcost), \"StartupCost\", Int.toString(scost)]\r\n"
						+ "val data = data ++ [\"Revenue\", Int.toString(revenue), \"NoOfResources\", Int.toString(#NoOfResources(params)), \"ModelTimeStamp\", Int.toString(intTime()+procTime)];\r\n"
						+ "val _ = addATE(id, transitionName, [\"complete\"], timestamp, \"\", data);\r\n"
						+ "in\r\n" + "  (procTime)\r\n" + "end", 1);
		createOrUpdateDef(
				"fun transitionActionR (a:CASE, r:RES, params:TRANSPARAMS) = \r\n"
						+ "let\r\n"
						+ "  val id = #ID(a)\r\n"
						+ "  val ts = #ts(a)\r\n"
						+ "  val ats = #ats(a)\r\n"
						+ "  val transitionName = #transitionName(params)\r\n"
						+ "  val resourceName = #Name(r)\r\n"
						+ "  val noOr = #NoOfResources(params)\r\n"
						+ "  val waitTime = intTime() - ts\r\n"
						+ "  val waitTimeDur = #pWaitTimeDur(params)\r\n"
						+ "  val waitTimeDur = Real.fromInt waitTimeDur\r\n"
						+ "  val waitTimeCost = #pWaitTimeCost(params)\r\n"
						+ "  val waitTimeCost = Real.fromInt waitTimeCost\r\n"
						+ "  val waitTime_real = Real.fromInt waitTime\r\n"
						+ "  val waitTimeCost = if waitTimeDur > 0.0 then round((waitTime_real/waitTimeDur)*waitTimeCost) else 0;\r\n"
						+ "\r\n"
						+ "  val procTime = calcDisValue(#pt(params))\r\n"
						+ "  val procTime_real = Real.fromInt procTime\r\n"
						+ "\r\n"
						+ "(*Sum up the costs of resources*)\r\n"
						+ "val rcosts = #Costs(r)\r\n"
						+ "(*TODO: to check the timetable*)\r\n"
						+ "fun calcResourceCost(n:RCOST) = \r\n"
						+ "let\r\n"
						+ "  val costDur = #CostPerDuration(n)\r\n"
						+ "  val costDur = Real.fromInt costDur \r\n"
						+ "  val value = #Value(n)\r\n"
						+ "  val value = Real.fromInt value\r\n"
						+ "in\r\n"
						+ "  if costDur > 0.0 then round((procTime_real/costDur)*value) else round(value)\r\n"
						+ "end;\r\n"
						+ "val rec rCost = fn ([]) => 0 | n::s => calcResourceCost(n) + rCost  s\r\n"
						+ "val resCost = rCost(rcosts)*noOr;\r\n"
						+ "(*end sum up*)\r\n"
						+ "\r\n"
						+ "  val processcost = calcDisValue(#pCost(params))\r\n"
						+ "  val scost = calcDisValue(#sCost(params))\r\n"
						+ "  val revenue = calcDisValue(#revenue(params))\r\n"
						+ "  val allcost = processcost + resCost + scost\r\n"
						+ "\r\n"
						+ "val curDate = add2StartDate(intTime()) ;\r\n"
						+ "val timestamp = (Date.fmt \"%Y-%m-%dT%H:%M:%S.000+01:00\" curDate);\r\n"
						+ "val data = [\"WaitingTime\", Int.toString(waitTime), \"WaitTimeCost\", Int.toString(waitTimeCost), \"ModelTimeStamp\", Int.toString(intTime())];\r\n"
						+ "val _ = addATE(id, transitionName, [\"start\"], timestamp, resourceName, data);\r\n"
						+ "\r\n"
						+ "val curDate = add2StartDate(intTime() +procTime) ;\r\n"
						+ "val timestamp = (Date.fmt \"%Y-%m-%dT%H:%M:%S.000+01:00\" curDate);\r\n"
						+ "val data = [\"ProcessingTime\", Int.toString(procTime), \"Cost\", Int.toString(allcost), \"StartupCost\", Int.toString(scost)]\r\n"
						+ "val data = data ++ [\"ResourceCost\", Int.toString(resCost), \"Revenue\", Int.toString(revenue), \"NoOfResources\", Int.toString(#NoOfResources(params)), \"ModelTimeStamp\", Int.toString(intTime()+procTime)];\r\n"
						+ "val _ = addATE(id, transitionName, [\"complete\"], timestamp, resourceName, data);\r\n"
						+ "in\r\n" + "  (procTime)\r\n" + "end", 1);
	}

	public Place addPlace() {
		return addPlace(flowObjectType, "");
	}

	public Place addPlace(String name) {
		return addPlace(flowObjectType, name);
	}

	/**
	 * Generates a new Place to the root page
	 * 
	 * @param placeType
	 *            Place type
	 * @param name
	 *            Place name
	 * @return
	 */
	public Place addPlace(String placeType, String name) {
		String id = createId();
		Place place = page.addNewPlace();
		place.setId(id);
		places.put(id, place);

		Type type = place.addNewType();
		type.addNewText().set(XmlString.Factory.newValue(placeType));

		name = name != null && name != "" ? name + " (" + id + ")" : "";
		if (cancelNaming) name = "";
		place.addNewText().set(XmlString.Factory.newValue(name));

		Initmark im = place.addNewInitmark();
		im.setId(createId());
		im.addNewText();

		return place;
	}

	/**
	 * Override method to generate a new transition to the process page with
	 * name = id
	 * 
	 * @return Created transition
	 */
	public Trans addTrans() {
		return addTrans("");
	}

	/**
	 * Creates a new transition to the process page.
	 * 
	 * @param name
	 *            Transition name
	 * @return Created transition
	 */
	public Trans addTrans(String name) {
		String id = createId();
		Trans trans = page.addNewTrans();
		trans.setId(id);
		name = name != null && name != "" ? name + " (" + id + ")" : "";
		if (cancelNaming) name = "";
		trans.addNewText().set(XmlString.Factory.newValue(name));

		Cond cond = trans.addNewCond();
		cond.setId(createId());
		cond.addNewText();

		Time time = trans.addNewTime();
		time.setId(createId());
		time.addNewText();

		Code code = trans.addNewCode();
		code.setId(createId());
		code.addNewText();

		transs.put(id, trans);
		return trans;
	}

	/**
	 * Override method that generates a new arc with the flow object variable
	 * between a Place and a Transition
	 * 
	 * @param sourceId
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	public Arc addArc(String sourceId, String targetId) throws Exception {
		return addArc(sourceId, targetId, flowObjectVariable);
	}

	/**
	 * Generates a new arc between a Place and a Transition. The type is
	 * determined by the objects the id's are referring.
	 * 
	 * @param sourceId
	 * @param targetId
	 * @param variable
	 * @return
	 * @throws Exception
	 */
	public Arc addArc(String sourceId, String targetId, String variable)
			throws Exception {
		String id = createId();
		Arc arc = page.addNewArc();
		arc.setId(id);

		if (places.get(sourceId) != null && transs.get(targetId) != null) {
			arc.addNewPlaceend().setIdref(sourceId);
			arc.addNewTransend().setIdref(targetId);
			arc.setOrientation("PtoT");
		} else if (transs.get(sourceId) != null && places.get(targetId) != null) {
			arc.addNewPlaceend().setIdref(targetId);
			arc.addNewTransend().setIdref(sourceId);
			arc.setOrientation("TtoP");
		} else {
			throw new Exception("ERROR in CPNet.addArc  source: " + sourceId
					+ " target: " + targetId);
		}

		Annot annot = arc.addNewAnnot();
		annot.addNewText().set(XmlString.Factory.newValue(variable));

		arcs.put(id, arc);
		return arc;

	}

	public void setArcAnnot(String arcId, String annotation) {
		Arc arc = arcs.get(arcId);
		arc.getAnnot().getText().set(XmlString.Factory.newValue(annotation));
	}

	/**
	 * Converts the transition to the sub-page connector.
	 * 
	 * @param trans
	 * @param pageId
	 * @return
	 */
	public Subst addSubst(Trans trans, String pageId) {
		Subst subst = trans.addNewSubst();
		subst.setSubpage(pageId);
		Subpageinfo subpageinfo = subst.addNewSubpageinfo();
		subpageinfo.setId(createId());

		Instance rootInstance = getRootInstance();
		Instance i = rootInstance.addNewInstance();
		i.setId(createId());
		i.setTrans(trans.getId());
		return subst;
	}

	public String createId() {
		return "ID" + (currentId++);
	};

	public void saveToFile(String file, Boolean layouting) {
		if (layouting) {
			for (Page p : cpnet.getPageArray()) {
				if (!p.getId().equals("PAGE_GENERATOR")) {
					try {
						doLayouting(p);
					} catch (Exception e) {
						System.err.println("LAYOUTING FAILED!");
					}
				}
			}

		}
		try {
			File convertedCPNFile = new File(file);
			cpnWorkspace.save(convertedCPNFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getFlowObjectType() {
		return flowObjectType;
	}

	public String getFlowObjectVariable() {
		return flowObjectVariable;
	}

	public Place getPlace(String id) {
		return places.get(id);
	}

	public Arc getArc(String id) {
		return arcs.get(id);
	}

	public Page getPage(String id) {
		for (Page p : cpnet.getPageArray()) {
			if (p.getId().equals(id))
				return p;
		}
		return null;
	}

	public Trans getTrans(String id) {
		return transs.get(id);
	}

	public Instance getRootInstance() {
		return cpnet.getInstances().getInstanceArray(0);
	}

	public void setTransitionTime(String id, String value) {
		Trans trans = transs.get(id);
		trans.getTimeArray()[0].getText()
				.set(XmlString.Factory.newValue(value));
	}

	public void setTransitionAction(String id, String value) {
		Trans trans = transs.get(id);
		trans.getCodeArray()[0].getText()
				.set(XmlString.Factory.newValue(value));

	}

	public void setTotalTokens(String startTokens) {
		createOrUpdateDef("val totalNoOfToken = " + startTokens + ";", 0);
	}

	public void setTokensPerBundle(String bundleTokens) {
		createOrUpdateDef("val noOfTokensPerBundle = " + bundleTokens + ";", 0);
	}

	public void createOrUpdateDef(String def, int order) {
		Ml ml = varBlocks.get(order).addNewMl();
		ml.setId(createId());
		ml.set(XmlString.Factory.newValue(def));
	}

	public void addVar(String var, String type, String layout, int order) {
		Var v = varBlocks.get(order).addNewVar();
		v.addNewType().addNewId().set(XmlString.Factory.newValue(type));
		v.addNewId().set(XmlString.Factory.newValue(var));
		v.addNewLayout().set(XmlString.Factory.newValue(layout));
		v.setId2(createId());
	}

	public void addColor(String name, String type, String layout, int order) {
		try {
			throw new Exception("Not implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setStartTime(String startTime) {
		String arg[] = startTime.split(",");
		String value = "Date.date{day = " + arg[2] + ", hour = " + arg[3]
				+ ", minute = " + arg[4]
				+ ", month = Date.Jan, offset = NONE, second = " + arg[5]
				+ ", year = " + arg[0] + "}";
		createOrUpdateDef("val startDate = " + value + ";", 0);
	}

	public void setEndTime(String endTime) {
		String arg[] = endTime.split(",");
		String value = "Date.date{day = " + arg[2] + ", hour = " + arg[3]
				+ ", minute = " + arg[4]
				+ ", month = Date.Jan, offset = NONE, second = " + arg[5]
				+ ", year = " + arg[0] + "}";
		createOrUpdateDef("val endDate = " + value + ";", 0);
	}

	public String getResourcePlace() {
		if (resourcePlaceId == null) {
			resourcePlaceId = addPlace("RES", "RESOURCES").getId();
		}
		return resourcePlaceId;
	}

	public void setTransitionGuard(String id, String value) {
		Trans trans = transs.get(id);
		trans.getCondArray()[0].getText()
				.set(XmlString.Factory.newValue(value));
	}

	public void setResourcePlaceValue(String resourceString) {
		String resourcePlaceId = getResourcePlace();
		Place p = getPlace(resourcePlaceId);
		setPlaceValue(p.getId(), resourceString);
	}

	public void setPlaceValue(String place, String value) {
		Place p = getPlace(place);
		p.getInitmarkArray()[0].getText()
				.set(XmlString.Factory.newValue(value));

	}

	public void setTimeBetweenBundles(String timeBetweenBundles) {
		String value = "{dtype=specific, specificValue=" + timeBetweenBundles
				+ ", mean=0, std=0};";
		createOrUpdateDef("val timeBetweenBundles = " + value + ";", 0);

	}

	public static void doLayouting(Page page) throws IOException {

		FileWriter fstream = new FileWriter("./files/cpn/dot_input.txt");
		BufferedWriter out = new BufferedWriter(fstream);

		HashMap<String, String[]> layoutData = new HashMap<String, String[]>();

		out.write("digraph G {nodesep = 2; ranksep=0.5; \n");

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

		Process pr = Runtime
				.getRuntime()
				.exec(
						"\"c:\\Program Files\\Graphviz2.26.3\\bin\\dot.exe\" .\\files\\cpn\\dot_input.txt");

		String line;
		BufferedReader input = new BufferedReader(new InputStreamReader(pr
				.getInputStream()));
		while ((line = input.readLine()) != null) {
			if (line.contains("[pos=\"") && !line.contains("->")) {
				int posIDEnd = line.indexOf("[");
				int posCoordStart = line.indexOf("\"");
				int posCoordEnd = line.indexOf("\"", posCoordStart + 1);
				String coords = line.substring(posCoordStart + 1, posCoordEnd)
						.trim();
				String tokenId = line.substring(0, posIDEnd).trim();
				layoutData.put(tokenId, new String[] { coords.split(",")[0],
						coords.split(",")[1] });
			}
		}
		input.close();

		for (Place p : page.getPlaceArray()) {
			if (layoutData.get(p.getId()) == null)
				continue;

			String xc = layoutData.get(p.getId())[0];
			String yc = layoutData.get(p.getId())[1];
			Posattr pos = Posattr.Factory.newInstance();
			pos.setX(xc);
			pos.setY(yc);
			p.setPosattr(pos);

			p.addNewEllipse().setH("25");
			p.getEllipse().setW("150");

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
			t.getBox().setW("150");

			Posattr pos2 = Posattr.Factory.newInstance();
			pos2.setX(Double.toString(Double.parseDouble(xc) + 160));
			pos2.setY(Double.toString(Double.parseDouble(yc) + 20));
			if (t.getCodeArray(0) != null) {
				t.getCodeArray(0).addNewPosattr().set(pos2);
			}
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
			Double xcSource = Double.parseDouble(layoutData.get(source)[0]);
			Double ycSource = Double.parseDouble(layoutData.get(source)[1]);

			Double xcTarget = Double.parseDouble(layoutData.get(target)[0]);
			Double ycTarget = Double.parseDouble(layoutData.get(target)[1]);

			double x = xcSource + 10 + Math.abs((xcSource - xcTarget) / 2.0);
			double y = ycSource - Math.abs((ycSource - ycTarget) / 2.0);

			if (arc.getAnnot() != null) {
				Posattr pos = Posattr.Factory.newInstance();
				pos.setX(Double.toString(x));
				pos.setY(Double.toString(y));
				arc.getAnnot().addNewPosattr().set(pos);
			}
		}
	}

	public String getTransitionGuard(String taskTransitionId) {
		Trans trans = transs.get(taskTransitionId);
		Text t = trans.getCondArray()[0].getText();
		XmlCursor c = t.newCursor();
		if (c.hasNextToken()){
			return c.getTextValue();
		}
		return "";
	}

}
