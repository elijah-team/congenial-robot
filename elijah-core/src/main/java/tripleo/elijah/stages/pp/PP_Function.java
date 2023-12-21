package tripleo.elijah.stages.pp;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.stages.gen_c.DeducedBaseEvaFunction;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;

public class PP_Function implements IPP_Function {
	private final BaseEvaFunction carrier;

	public PP_Function(final @NotNull DeducedBaseEvaFunction aGf) {
		carrier = (BaseEvaFunction) aGf.getCarrier();
	}

	public BaseEvaFunction getCarrier() {
		return carrier;
	}
}
