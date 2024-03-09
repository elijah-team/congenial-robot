package tripleo.elijah.comp.internal;

import tripleo.elijah.comp.AccessBus;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.i.IPipelineAccess;

public record CSS_RunEnv(
		CompilationAccess2Impl access,
		CompilationEnclosure ce,
		IPipelineAccess pa,
		CompilationRunner cr,
		CompilerDriver cd,
		AccessBus ab

) {
}
