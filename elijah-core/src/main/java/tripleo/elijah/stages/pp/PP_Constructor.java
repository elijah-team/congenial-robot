package tripleo.elijah.stages.pp;

import tripleo.elijah.stages.gen_fn.EvaConstructor;

public class PP_Constructor implements IPP_Function {
	private final EvaConstructor carrier;

	public PP_Constructor(final EvaConstructor aGf) {
		carrier = aGf;
	}
}
