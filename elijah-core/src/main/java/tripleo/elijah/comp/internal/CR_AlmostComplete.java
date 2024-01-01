package tripleo.elijah.comp.internal;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

public class CR_AlmostComplete implements CR_Action {
	private CompilationRunner compilationRunner;

	@Override
	public void attach(final @NonNull CompilationRunner cr) {
		compilationRunner = cr;
	}

	@Override
	public @NonNull Operation<Ok> execute(final CR_State st, final CB_Output aO) {
		compilationRunner.cis.almostComplete();
		return Operation.success(Ok.instance());
	}

	@Override
	public @NonNull String name() {
		return "cis almostComplete";
	}
}
