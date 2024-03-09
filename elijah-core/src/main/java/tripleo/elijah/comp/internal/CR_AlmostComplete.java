package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.Eventual;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

public class CR_AlmostComplete implements CR_Action {
	private CompilationRunner compilationRunner;

	@Override
	public void attach(final @NotNull CompilationRunner cr) {
		compilationRunner = cr;
	}

	@Override
	public void execute(final CR_State st, final CB_Output aO, final Eventual<Operation<Ok>> eoo) {
		compilationRunner.cis.almostComplete();
		final Operation<Ok> success = Operation.success(Ok.instance());
		eoo.resolve(success);
	}

	@Override
	public @NotNull String name() {
		return "cis almostComplete";
	}
}
