package ee.ut.bpmnsim;

import java.util.HashMap;
import java.util.Map;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

import ee.ut.bpmnsim.BPMNGateway.GWType;

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

public class BPMNProcess {
	protected Cpnet cpnet;
	protected Page page;
	protected Instance rootInst;
	protected XmlString caseType;
	protected XmlString variable;
	protected Map<String, Object> map = new HashMap<String, Object>();
	protected Map<String, Trans> transitions = new HashMap<String, Trans>();
	protected Map<BPMNEBXORGateway, Place> ebxorgws = new HashMap<BPMNEBXORGateway, Place>();

	private XmlString caseIdType;
	private String caseId = "caseId";

	public BPMNProcess() {
	}

	public BPMNProcess(Cpnet cpnet, String id, String name) {
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
		c.setId2(BPMNIdGen.createId());
		c.addNewId().set(caseIdType.copy());
		c.addNewTimed();
		c.addNewAlias().addNewId().set(XmlString.Factory.newValue("INT"));

		c = globbox.addNewColor();
		c.setId2(BPMNIdGen.createId());
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
		v.setId2(BPMNIdGen.createId());
		v.addNewId().set(variable.copy());
		v.addNewType().addNewId().set(caseType.copy());

		c = globbox.addNewColor();
		c.setId2(BPMNIdGen.createId());
		c.addNewId().set(XmlString.Factory.newValue("CASExPATH"));
		c.addNewTimed();
		Product product = c.addNewProduct();
		product.addNewId().set(XmlString.Factory.newValue("CASE"));
		product.addNewId().set(XmlString.Factory.newValue("INT"));

		Var vp = globbox.addNewVar();
		vp.setId2(BPMNIdGen.createId());
		vp.addNewId().set(XmlString.Factory.newValue("caseInfop"));
		vp.addNewType().addNewId().set(caseType.copy());

		Var path = globbox.addNewVar();
		path.setId2(BPMNIdGen.createId());
		path.addNewId().set(XmlString.Factory.newValue("path"));
		path.addNewType().addNewId().set(XmlString.Factory.newValue("INT"));

		Var v2 = globbox.addNewVar();
		v2.setId2(BPMNIdGen.createId());
		v2.addNewId().set(XmlString.Factory.newValue(caseId));
		v2.addNewType().addNewId().set(caseIdType.copy());

		Ml ml = cpnet.getGlobbox().addNewMl();
		ml.setId(BPMNIdGen.createId());
		ml
				.set(XmlString.Factory
						.newValue(String
								.format("fun initCaseInfo(id) = {Id=id,CaseStartTime=IntInf.toInt(time()),CaseEndTime=0};")));
	}

	protected Trans createSubstTrans(String name, Page childpage) {
		Trans trans = BPMNUtil.createTrans(page, name);

		Subst subst = trans.addNewSubst();
		subst.setSubpage(childpage.getId());
		Subpageinfo subpageinfo = subst.addNewSubpageinfo();
		subpageinfo.setId(BPMNIdGen.createId());
		subpageinfo.setName(name);
		return trans;
	}

	protected Instance createInstance(Trans trans) {
		Instance instance = rootInst.addNewInstance();
		instance.setId(BPMNIdGen.createId());
		instance.setTrans(trans.getId());

		return instance;
	}

	protected Page createChildPage(String name) {
		Page childpage = cpnet.addNewPage();
		childpage.setId(BPMNIdGen.createId());
		childpage.addNewPageattr().setName(name);
		return childpage;
	}

	public void addTask(String id, String name) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);

		BPMNTask bPMNTask = new BPMNTask(childpage, name, caseType, variable);
		map.put(id, bPMNTask);
		transitions.put(id, trans);
	}

	public void addXORGateway(String id, String name, GWType type) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);

		BPMNXORGateway gw = new BPMNXORGateway(childpage, name, type, caseType,
				variable);
		map.put(id, gw);
		transitions.put(id, trans);
	}

	public void setTransitionProbabilities(String id, Object[] probs) {
		BPMNXORGateway gw = (BPMNXORGateway) map.get(id);
		gw.setTransitionProbabilities(probs);
	}

	public void addEBXORGateway(String id, String name, GWType type) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);

		BPMNEBXORGateway gw = new BPMNEBXORGateway(childpage, name, type,
				caseType, variable);
		map.put(id, gw);
		transitions.put(id, trans);
	}

	public void addANDGateway(String id, String name, GWType type) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);

		BPMNANDGateway gw = new BPMNANDGateway(childpage, name, type, caseType,
				variable);
		map.put(id, gw);
		transitions.put(id, trans);
	}

	public void addEdge(String sourceId, String targetId) {
		Object source = map.get(sourceId);
		Object target = map.get(targetId);
		Place place;
		boolean requiresArc = false;

		if (source instanceof BPMNEBXORGateway && ebxorgws.containsKey(source))
			place = ebxorgws.get(source);
		else {
			requiresArc = true;
			place = BPMNUtil.createPlace(page, null);

			place.getTypeArray(0).getText().set(caseType.copy());

			place.addNewText().set(XmlString.Factory.newValue(place.getId()));
			if (source instanceof BPMNEBXORGateway)
				ebxorgws.put((BPMNEBXORGateway) source, place);
		}

		if (source != null) {
			// -- Source transition
			String psock = transitions.get(sourceId).getSubst().getPortsock();
			psock = psock == null ? "" : psock;

			if (source instanceof BPMNTask)
				psock += String.format("(%s,%s)", ((BPMNTask) source)
						.getExitPlace().getId(), place.getId());
			else if (source instanceof BPMNANDGateway)
				psock += String.format("(%s,%s)", ((BPMNANDGateway) source)
						.addExitPlace(targetId).getId(), place.getId());
			else if (source instanceof BPMNStartEvent)
				psock += String.format("(%s,%s)", ((BPMNStartEvent) source)
						.getExitPlace().getId(), place.getId());
			else if (source instanceof BPMNSubprocess)
				psock += String.format("(%s,%s)", ((BPMNSubprocess) source)
						.getExitPlace().getId(), place.getId());
			else if (source instanceof BPMNXORGateway) {
				Place p;
				if (source instanceof BPMNEBXORGateway)
					p = ((BPMNEBXORGateway) source).addExitPlace(targetId);
				else
					p = ((BPMNXORGateway) source).addExitPlace(targetId);
				psock += String.format("(%s,%s)", p.getId(), place.getId());
			}
			transitions.get(sourceId).getSubst().setPortsock(psock);
		}
		//

		if (requiresArc)
			BPMNUtil.createArc(page, transitions.get(sourceId), place, null);

		if (target != null) {
			// -- Target transition
			String psock = transitions.get(targetId).getSubst().getPortsock();
			psock = psock == null ? "" : psock;

			if (target instanceof BPMNTask)
				psock += String.format("(%s,%s)", ((BPMNTask) target)
						.getEntryPlace().getId(), place.getId());
			else if (target instanceof BPMNSubprocess)
				psock += String.format("(%s,%s)", ((BPMNSubprocess) target)
						.getEntryPlace().getId(), place.getId());
			else if (target instanceof BPMNANDGateway)
				psock += String.format("(%s,%s)", ((BPMNANDGateway) target)
						.addEntryPlace(sourceId).getId(), place.getId());
			else if (target instanceof BPMNXORGateway) {
				Place p = ((BPMNXORGateway) target).addEntryPlace(sourceId);
				psock += String.format("(%s,%s)", p.getId(), place.getId());
			}
			transitions.get(targetId).getSubst().setPortsock(psock);
		}
		//

		BPMNUtil.createArc(page, place, transitions.get(targetId), null);
	}

	public void setExit(String exitId) {
		Object exit = map.get(exitId);

		Place place = BPMNUtil.createPlace(page, null);
		place.getTypeArray(0).getText().set(caseType.copy());

		// -- exit transition
		String psock = transitions.get(exitId).getSubst().getPortsock();
		psock = psock == null ? "" : psock;
		if (exit instanceof BPMNTask)
			psock += String.format("(%s,%s)", ((BPMNTask) exit).getExitPlace()
					.getId(), place.getId());
		else if (exit instanceof BPMNXORGateway) {
			Place exitPlace = ((BPMNXORGateway) exit).addExitPlace("exit");
			psock += String.format("(%s,%s)", exitPlace.getId(), place.getId());
		}

		transitions.get(exitId).getSubst().setPortsock(psock);
		//

		BPMNUtil.createArc(page, transitions.get(exitId), place, null);
	}

	public void addStartEvent(String id) {
		addStartEvent(id, id);
	}

	public void addStartEvent(String id, String name) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		createInstance(trans);

		BPMNStartEvent se = new BPMNStartEvent(childpage, name, caseType,
				variable, caseIdType, caseId);
		map.put(id, se);
		transitions.put(id, trans);
	}

	public void setNumberOfCases(String id, String number) {
		Object event = map.get(id);

		if (!(event instanceof BPMNStartEvent))
			return;

		((BPMNStartEvent) event).setNumberOfCases(XmlString.Factory
				.newValue("[" + caseId + "<" + number + "]"));
	}

	public void setStartEventCDistribution(String id, String expr) {
		Object event = map.get(id);

		if (!(event instanceof BPMNStartEvent))
			return;

		((BPMNStartEvent) event).setTimeExpresion(XmlString.Factory
				.newValue("@+" + expr));
	}

	public void setTaskDDistribution(String id, String expr) {
		Object task = map.get(id);

		if (!(task instanceof BPMNTask))
			return;

		String name = ((BPMNTask) task).getName();

		Ml ml = cpnet.getGlobbox().addNewMl();
		ml.setId(BPMNIdGen.createId());
		ml.set(XmlString.Factory.newValue(String.format("fun Delay_%s() = %s;",
				name, expr)));
		((BPMNTask) task).setTimeExpresion(XmlString.Factory
				.newValue("@+Delay_" + name + "()"));
	}

	public BPMNSubprocess addSubprocess(String id, String name) {
		Page childpage = createChildPage(name);
		Trans trans = createSubstTrans(name, childpage);
		Instance instance = createInstance(trans);

		BPMNSubprocess sub = new BPMNSubprocess(cpnet, childpage, instance,
				caseType, variable);
		map.put(id, sub);
		transitions.put(id, trans);
		return sub;
	}

}
