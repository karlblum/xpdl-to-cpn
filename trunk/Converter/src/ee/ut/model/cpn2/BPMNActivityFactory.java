package ee.ut.model.cpn2;

import ee.ut.model.xpdl2.Activity;
import ee.ut.model.xpdl2.Route;

public class BPMNActivityFactory implements AbstractElementFactory {

	@Override
	public Object create(Object obj, CPNet cpnet) {
		Activity xpdlActivity = ((Activity) obj);

		// If we have routing element inside, then it is a gateway... Should
		// this logic even be here?
		if (xpdlActivity.getContent().get(0) instanceof Route) {
			return new BPMNGateway(cpnet, obj);
		}
		return new BPMNActivity(cpnet, obj);
	}

}
