package ee.ut.old.model.bpmne;

import noNamespace.Cpnet;
import noNamespace.Instance;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Subpageinfo;
import noNamespace.Subst;
import noNamespace.Trans;

import org.apache.xmlbeans.XmlString;

public class BPMNeStartEvent {
	private Trans transition;
	protected Place outputPlace;

	/**
	 * We will put standard generator into start event. Only one start event
	 * allowed currently.
	 * 
	 * @param page
	 * @param cpnet
	 * @param instance
	 * @param rootPage
	 * @param caseVar
	 * @param caseType
	 */
	public BPMNeStartEvent(Page page, Cpnet cpnet, Instance instance,
			Page rootPage, XmlString caseVar, XmlString caseType) {

		Page generatorPage = null;
		for (Page p : cpnet.getPageArray()) {
			if (p.getId().equals("PAGE_GENERATOR")) {
				generatorPage = p;
			}
		}

		Trans transition = BPMNeUtil.createTrans(page, "Generator");

		Subst subst = transition.addNewSubst();
		subst.setSubpage(generatorPage.getId());
		Subpageinfo subpageinfo = subst.addNewSubpageinfo();
		subpageinfo.setId(BPMNeIdGen.createId());

		Instance i = instance.addNewInstance();
		i.setId(BPMNeIdGen.createId());
		i.setTrans(transition.getId());

		outputPlace = BPMNeUtil.createPlace(page, "new case");
		outputPlace.addNewPort().setType("Out");
		outputPlace.getTypeArray()[0].getText().set(caseType.copy());

		transition.getSubst()
				.setPortsock(
						String.format("(%s,%s)", "PAGE_GENERATOR", outputPlace
								.getId()));

		BPMNeUtil.createArc(page, transition, outputPlace, caseVar);

	}

	public Place getExitPlace() {
		return outputPlace;
	}

	public void setNumberOfCases(XmlString number) {
		transition.getCondArray(0).getText().set(number);
	}

	public void setTimeExpresion(XmlString expr) {
		transition.getTimeArray(0).getText().set(expr);
	}

}
