package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.Eventual;
import tripleo.elijah.ci.CompilerInstructionsImpl;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

public class CR_ProcessInitialAction implements CR_Action {
	private final @NotNull CompilerInstructionsImpl ci;
	private                CompilationRunner        compilationRunner;
	private final          boolean                  do_out;

	@Contract(pure = true)
	public CR_ProcessInitialAction(final @NotNull CompilerBeginning beginning) {
		this((CompilerInstructionsImpl) beginning.compilerInstructions(), beginning.cfg().do_out);
	}

	@Contract(pure = true)
	public CR_ProcessInitialAction(final @NotNull CompilerInstructionsImpl aCi,
								   final boolean aDo_out) {
		ci     = aCi;
		do_out = aDo_out;
	}

	@Override
	public void attach(final @NotNull CompilationRunner cr) {
		compilationRunner = cr;
	}

	@Override
	public void execute(final @NotNull CR_State st, final CB_Output aO, final Eventual<Operation<Ok>> eoo) {
		compilationRunner = st.runner();

		try {
			compilationRunner._accessCompilation().use(ci, do_out);
			final Operation<Ok> success = Operation.success(Ok.instance());
			eoo.resolve(success);

		} catch (final Exception aE) {
			eoo.fail(aE);
		}
	}

	@Override
	public @NotNull String name() {
		return "process initial";
	}
}
