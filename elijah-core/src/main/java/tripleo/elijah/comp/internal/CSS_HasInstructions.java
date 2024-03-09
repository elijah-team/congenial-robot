package tripleo.elijah.comp.internal;

import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.util.ProgramIsWrongIfYouAreHere;

public record CSS_HasInstructions(CompilerInstructions rootCI) implements CSS_SimpleSignal {
	@Override
	public boolean canRun() {
		return false;
	}

	@Override
	public void simpleSignalRun(final CSS_RunEnv aRunEnv) {
		throw new ProgramIsWrongIfYouAreHere("never called. canRun is false.");
	}
}
