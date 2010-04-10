package ee.ut.model.cpn2;

import org.apache.xmlbeans.XmlString;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Place;
import noNamespace.Trans;
import ee.ut.model.xpdl2.Transition;

public class BPMNTransition extends BPMNElement {

	public BPMNTransition(Process process, Transition t) {
		super(process);

		Trans trans = process.getCpnet().addTrans();

		// Add a name
		trans.addNewText().set(
				XmlString.Factory.newValue("Transition_" + trans.getId()));

		String transId = trans.getId();

		Place toPlace = null;
		Place fromPlace = null;

		Object objectFrom = process.getElement(t.getFrom());
		Object objectTo = process.getElement(t.getTo());

		if (objectFrom instanceof BPMNTask) {
			fromPlace = ((BPMNTask) objectFrom).getOutputPlace();
		} else if (objectFrom instanceof BPMNGateway) {
			fromPlace = ((BPMNGateway) objectFrom).makeOutputPlace();
		}

		if (objectTo instanceof BPMNTask) {
			toPlace = ((BPMNTask) objectTo).makeInputPlace();
		} else if (objectTo instanceof BPMNGateway) {
			toPlace = ((BPMNGateway) objectTo).makeInputPlace();
		}

		Arc inArc = process.getCpnet().addArc(fromPlace.getId(), transId);

		Annot annot = inArc.addNewAnnot();
		annot.addNewText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectVariable()));

		Arc outArc = process.getCpnet().addArc(transId, toPlace.getId());
		annot = outArc.addNewAnnot();
		annot.addNewText().set(
				XmlString.Factory.newValue(process.getCpnet()
						.getFlowObjectVariable()));
	}

}
