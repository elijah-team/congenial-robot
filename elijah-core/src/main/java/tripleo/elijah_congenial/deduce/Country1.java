package tripleo.elijah_congenial.deduce;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.gen_fn.EvaNode;

import java.util.List;
import java.util.function.Consumer;

public class Country1 implements DeducePhase.Country {
	private final DeducePhase d;

	public Country1(final DeducePhase aD) {
		d = aD;
	}

	@Override
	public void sendClasses(final @NotNull Consumer<List<EvaNode>> ces) {
		ces.accept(d.generatedClasses.copy());
	}
}
