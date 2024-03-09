package tripleo.elijah.comp.internal;

import tripleo.elijah.comp.AccessBus;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.i.ICompilationAccess2;
import tripleo.elijah.comp.i.IPipelineAccess;

public record CSS_RunEnv(
		ICompilationAccess2 access,
		CompilationEnclosure ce,
		IPipelineAccess pa,
		CompilationRunner cr,
		CompilerDriver cd,
		AccessBus ab

) {
}
