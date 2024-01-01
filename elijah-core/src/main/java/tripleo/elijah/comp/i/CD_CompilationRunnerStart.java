package tripleo.elijah.comp.i;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.comp.internal.CB_Output;
import tripleo.elijah.comp.internal.CR_State;

public interface CD_CompilationRunnerStart extends CompilerDriven {

	void start(final @NonNull CompilerInstructions aCompilerInstructions,
			   final @NonNull CR_State crState,
			   final @NonNull CB_Output out);
}
