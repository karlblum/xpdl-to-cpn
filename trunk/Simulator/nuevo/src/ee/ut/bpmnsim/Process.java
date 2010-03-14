package ee.ut.bpmnsim;

import java.util.HashMap;
import java.util.Map;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

import ee.ut.bpmnsim.Gateway.GWType;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Color;
import noNamespace.Cpnet;
import noNamespace.Globbox;
import noNamespace.Id;
import noNamespace.Instance;
import noNamespace.Ml;
import noNamespace.Page;
import noNamespace.Pageattr;
import noNamespace.Place;
import noNamespace.Product;
import noNamespace.Record;
import noNamespace.Recordfield;
import noNamespace.Subpageinfo;
import noNamespace.Subst;
import noNamespace.Trans;
import noNamespace.Var;

public class Process {
	protected Cpnet cpnet;
	protected Page page;
	protected Instance rootInst;
	protected XmlString caseType;
	protected XmlString variable;
	protected Map<String, Object> map = new HashMap<String, Object>();
	protected Map<String, Trans> transitions = new HashMap<String, Trans>();
	protected Map<EBXORGateway, Place> ebxorgws = new HashMap<EBXORGateway, Place>();
	
	private XmlString caseIdType;
	private String caseId = "caseId";
	
	public Process() {}
	public Process(Cpnet cpnet, String id, String name) {
		this.cpnet = cpnet;
		page = cpnet.getPageArray(0);
		rootInst = cpnet.getInstances().getInstanceArray(0);
		
		Pageattr pattr = Pageattr.Factory.newInstance();
		pattr.setName(name);
		page.getPageattr().set(pattr);
		
		
		caseIdType = XmlString.Factory.newValue("CASEID");
		caseType = XmlString.Factory.newValue("CASE");
		variable = XmlString.Factory.newValue("caseInfo");
		
		Globbox globbox = cpnet.getGlobbox();
		
		Color c = globbox.addNewColor();
		c.setId2(IdGen.createId());
		c.addNewId().set(caseIdType.copy());
		c.addNewTimed();
		c.addNewAlias().addNewId().set(XmlString.Factory.newValue("INT"));

		
		c = globbox.addNewColor();
		c.setId2(IdGen.createId());
		c.addNewId().set(caseType.copy());
		c.addNewTimed();
		Record record = c.addNewRecord();
		Recordfield field = record.addNewRecordfield();
		field.addNewId().set(XmlString.Factory.newValue("Id"));
		field.addNewId().set(caseIdType.copy());
		field = record.addNewRecordfield();
		field.addNewId().set(XmlString.Factory.newValue("CaseStartTime"));
		field.addNewId().set(XmlString.Factory.newValue("INT"));
		field = record.addNewRecordfield();
		field.addNewId().set(XmlString.Factory.newValue("CaseEndTime"));
		field.addNewId().set(XmlString.Factory.newValue("INT"));
		
		Var v = globbox.addNewVar();
		v.setId2(IdGen.createId());
		v.addNewId().set(variable.copy());
		v.addNewType().addNewId().set(caseType.copy());

		c = globbox.addNewColor();
		c.setId2(IdGen.createId());
		c.addNewId().set(XmlString.Factory.newValue("CASExPATH"));
		c.addNewTimed();
		Product product = c.addNewProduct();
		product.addNewId().set(XmlString.Factory.newValue("CASE"));
		product.addNewId().set(XmlString.Factory.newValue("INT"));

		Var vp = globbox.addNewVar();
		vp.setId2(IdGen.createId());
		vp.addNewId().set(XmlString.Factory.newValue("caseInfop"));
		vp.addNewType().addNewId().set(caseType.copy());

		Var path = globbox.addNewVar();
		path.setId2(IdGen.createId());
		path.addNewId().set(XmlString.Factory.newValue("path"));
		path.addNewType().addNewId().set(XmlString.Factory.newValue("INT"));

		Var v2 = globbox.addNewVar();
		v2.setId2(IdGen.createId());
		v2.addNewId().set(XmlString.Factory.newValue(caseId));
		v2.addNewType().addNewId().set(caseIdType.copy());
		
		Ml ml = cpnet.getGlobbox().addNewMl();
		ml.setId(IdGen.createId());
		ml.set(XmlString.Factory.newValue(String.format("fun initCaseInfo(id) = {Id=id,CaseStartTime=IntInf.toInt(time()),CaseEndTime=0};")));
	}
	
	protected Trans createSubstTrans(String name, Page childpage) {		
		Trans trans = Util.createTrans(page, name);
		
		Subst subst = trans.addNewSubst();
		subst.setSubpage(childpage.getId());
		Subpageinfo subpageinfo = subst.addNewSubpageinfo();
		subpageinfo.setId(IdGen.createId());
		subpageinfo.setName(name);
		return trans;
	}
	
	protected Instance createInstance(Trans trans) {
		Instance instance = rootInst.addNewInstance();
		instance.setId(IdGen.createId());
		instance.setTrans(trans.getId());
		
		return instance;
	}

	protected Page createChildPage(String name) {
		Page childpage = cpnet.addNewPage();
		childpage.setId(IdGen.createId());
		childpage.addNewPageattr().setName(name);
		return childpage;
	}

	public void addTask(String id, String name) {
		Page childpage = createChildPage(name);		
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);
		
		Task task = new Task(childpage, name, caseType, variable);
		map.put(id, task);
		transitions.put(id, trans);
	}

	public void addXORGateway(String id, String name, GWType type) {
		Page childpage = createChildPage(name);		
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);

		XORGateway gw = new XORGateway(childpage, name, type, caseType, variable);
		map.put(id, gw);
		transitions.put(id, trans);
	}
	
	public void setTransitionProbabilities(String id, Object[] probs) {
		XORGateway gw = (XORGateway)map.get(id);
		gw.setTransitionProbabilities(probs);
	}
	
	public void addEBXORGateway(String id, String name, GWType type) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);

		EBXORGateway gw = new EBXORGateway(childpage, name, type, caseType, variable);
		map.put(id, gw);
		transitions.put(id, trans);
	}

	public void addANDGateway(String id, String name, GWType type) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);

		ANDGateway gw = new ANDGateway(childpage, name, type, caseType, variable);
		map.put(id, gw);
		transitions.put(id, trans);
	}
	
	public void addEdge(String sourceId, String targetId) {
		Object source = map.get(sourceId);
		Object target = map.get(targetId);
		Place place;
		boolean requiresArc = false;

		if (source instanceof EBXORGateway && ebxorgws.containsKey(source))
			place = ebxorgws.get(source);
		else {
			requiresArc = true;
			place = Util.createPlace(page, null);
			
			place.getTypeArray(0).getText().set(caseType.copy());
			
			place.addNewText().set(XmlString.Factory.newValue(place.getId()));
			if (source instanceof EBXORGateway)
				ebxorgws.put((EBXORGateway) source, place);
		}
		
		if (source != null) {
			// -- Source transition
			String psock = transitions.get(sourceId).getSubst().getPortsock();
			psock = psock == null ? "" : psock;
			
			if (source instanceof Task)
				psock += String.format("(%s,%s)", ((Task)source).getExitPlace().getId(), place.getId());
			else if (source instanceof ANDGateway)
				psock += String.format("(%s,%s)", ((ANDGateway)source).addExitPlace(targetId).getId(), place.getId());
			else if (source instanceof StartEvent)
				psock += String.format("(%s,%s)", ((StartEvent)source).getExitPlace().getId(), place.getId());				
			else if (source instanceof Subprocess)
				psock += String.format("(%s,%s)", ((Subprocess)source).getExitPlace().getId(), place.getId());				
			else if (source instanceof XORGateway) {
				Place p;
				if (source instanceof EBXORGateway)
					p = ((EBXORGateway)source).addExitPlace(targetId);
				else
					p = ((XORGateway)source).addExitPlace(targetId);
				psock += String.format("(%s,%s)", p.getId(), place.getId());
			}
			transitions.get(sourceId).getSubst().setPortsock(psock);
		}
		//
		
		if (requiresArc)
			Util.createArc(page, transitions.get(sourceId), place, null);
		
		if (target != null) {
			// -- Target transition
			String psock = transitions.get(targetId).getSubst().getPortsock();
			psock = psock == null ? "" : psock;

			if (target instanceof Task)
				psock += String.format("(%s,%s)", ((Task) target)
						.getEntryPlace().getId(), place.getId());
			else if (target instanceof Subprocess)
				psock += String.format("(%s,%s)", ((Subprocess) target)
						.getEntryPlace().getId(), place.getId());
			else if (target instanceof ANDGateway)
				psock += String.format("(%s,%s)", ((ANDGateway) target)
						.addEntryPlace(sourceId).getId(), place.getId());
			else if (target instanceof XORGateway) {
				Place p = ((XORGateway) target).addEntryPlace(sourceId);
				psock += String.format("(%s,%s)", p.getId(), place.getId());
			}
			transitions.get(targetId).getSubst().setPortsock(psock);
		}
		//
		
		Util.createArc(page, place, transitions.get(targetId), null);
	}
	
	public void setExit(String exitId) {
		Object exit = map.get(exitId);
		
		
		Place place = Util.createPlace(page, null);
		place.getTypeArray(0).getText().set(caseType.copy());

		// -- exit transition
		String psock = transitions.get(exitId).getSubst().getPortsock();
		psock = psock == null ? "" : psock;
		if (exit instanceof Task)
			psock += String.format("(%s,%s)", ((Task)exit).getExitPlace().getId(), place.getId());
		else if (exit instanceof XORGateway) {
			Place exitPlace = ((XORGateway)exit).addExitPlace("exit");
			psock += String.format("(%s,%s)", exitPlace.getId(), place.getId());
		}
		
		transitions.get(exitId).getSubst().setPortsock(psock);
		//
		
		Util.createArc(page, transitions.get(exitId), place, null);
	}

	public void addStartEvent(String id, String name) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);

		StartEvent se = new StartEvent(childpage, name, caseType, variable, caseIdType, caseId);
		map.put(id, se);
		transitions.put(id, trans);		
	}

	public void setNumberOfCases(String id, String number) {
		Object event = map.get(id);

		if (!(event instanceof StartEvent))
			return;

		((StartEvent)event).setNumberOfCases(XmlString.Factory.newValue("["+caseId+"<"+number+"]"));
	}

	public void setStartEventCDistribution(String id, String expr) {
		Object event = map.get(id);

		if (!(event instanceof StartEvent))
			return;
		
		((StartEvent)event).setTimeExpresion(XmlString.Factory.newValue("@+"+expr));
	}

	public void setTaskDDistribution(String id, String expr) {
		Object task = map.get(id);

		if (!(task instanceof Task))
			return;
		
		String name = ((Task)task).getName();
		
		Ml ml = cpnet.getGlobbox().addNewMl();
		ml.setId(IdGen.createId());
		ml.set(XmlString.Factory.newValue(String.format("fun Delay_%s() = %s;", name, expr)));
		((Task)task).setTimeExpresion(XmlString.Factory.newValue("@+Delay_" + name + "()"));
	}
	
	public Subprocess addSubprocess(String id, String name) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		Instance instance = createInstance(trans);
		
		Subprocess sub = new Subprocess(cpnet, childpage, instance, caseType, variable);
		map.put(id, sub);
		transitions.put(id, trans);
		return sub;
	}

}
