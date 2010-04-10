package ee.ut.model.cpn2;

public abstract class AbstractElementFactory {

	protected CPNet cpnet;
	protected Process process;

	public AbstractElementFactory(CPNet cpnet, Process process) {
		this.cpnet = cpnet;
		this.process = process;
	}

	abstract Object create(Object obj);

}
