package tripleo.elijah.stages.pp;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.UnintendedUseException;
import tripleo.elijah.stages.gen_c.DeducedBaseEvaFunction;
import tripleo.elijah.stages.gen_fn.IBaseEvaFunction;

import java.util.function.Consumer;

public class PP_Function implements IPP_Function {
	private final DeducedBaseEvaFunction carrier;

	public PP_Function(final @NotNull DeducedBaseEvaFunction aGf) {
		carrier = aGf;
	}

	public PP_Function(final DeducedBaseEvaFunction aDeduced, final Consumer<DeducedBaseEvaFunction> aO) {
		throw new UnintendedUseException();
	}

	public IBaseEvaFunction getCarrier() {
		return (IBaseEvaFunction) carrier.getCarrier();
	}

	@Override
	public DeducedBaseEvaFunction get2Carrier() {
		return carrier;
	}
}
