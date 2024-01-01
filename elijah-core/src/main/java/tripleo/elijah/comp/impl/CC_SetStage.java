package tripleo.elijah.comp.impl;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.Stages;
import tripleo.elijah.comp.i.CompilationChange;

public class CC_SetStage implements CompilationChange {
	private final String s;

	@Contract(pure = true)
	public CC_SetStage(final String aS) {
		s = aS;
	}

	@Override
	public void apply(final @NonNull Compilation c) {
		c.cfg().stage = Stages.valueOf(s);
	}
}
