package tripleo.elijah.stages.pp;

import tripleo.elijah.stages.gen_c.DeducedEvaConstructor;

public class PP_Constructor implements IPP_Constructor {
	private final DeducedEvaConstructor carrier;

	public PP_Constructor(final DeducedEvaConstructor aGf) {
		carrier = aGf;
	}

	@Override
	public DeducedEvaConstructor get2Carrier() {
		return carrier;
	}
}
