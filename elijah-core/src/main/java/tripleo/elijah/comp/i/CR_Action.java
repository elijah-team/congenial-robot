package tripleo.elijah.comp.i;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.Eventual;
import tripleo.elijah.comp.internal.CB_Output;
import tripleo.elijah.comp.internal.CR_State;
import tripleo.elijah.comp.internal.CompilationRunner;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

public interface CR_Action {
	void attach(@NotNull CompilationRunner cr);

	void execute(@NotNull CR_State st, CB_Output aO, final Eventual<Operation<Ok>> eoo);

	String name();
}
