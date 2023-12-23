package tripleo.elijah.stages.pp;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.UnintendedUseException;
import tripleo.elijah.stages.gen_c.DeducedBaseEvaFunction;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;

import java.util.function.Consumer;

public class PP_Function implements IPP_Function {
	private final BaseEvaFunction carrier;

	public PP_Function(final @NotNull DeducedBaseEvaFunction aGf) {
		carrier = (BaseEvaFunction) aGf.getCarrier();
	}

	public PP_Function(final DeducedBaseEvaFunction aDeduced, final Consumer<DeducedBaseEvaFunction> aO) {
		throw new UnintendedUseException();
	}

	public BaseEvaFunction getCarrier() {
		return carrier;
	}

	@Override
	public DeducedBaseEvaFunction get2Carrier() {
		//return null
		throw new UnintendedUseException();
	}
}
