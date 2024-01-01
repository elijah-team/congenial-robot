package tripleo.elijah.comp.i;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.internal.CB_Output;
import tripleo.elijah.comp.internal.CR_State;
import tripleo.elijah.comp.internal.CompilationRunner;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

public interface CR_Action {
	void attach(@NonNull CompilationRunner cr);

	@NonNull Operation<Ok> execute(@NonNull CR_State st, CB_Output aO);

	String name();
}
