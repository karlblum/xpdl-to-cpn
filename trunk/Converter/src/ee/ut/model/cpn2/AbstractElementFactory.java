package ee.ut.model.cpn2;

public abstract class AbstractElementFactory {

	protected Process process;

	public AbstractElementFactory(Process process) {
		this.process = process;
	}

	abstract Object create(Object obj);

}
