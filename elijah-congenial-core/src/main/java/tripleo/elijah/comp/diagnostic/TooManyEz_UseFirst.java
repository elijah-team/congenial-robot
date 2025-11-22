package tripleo.elijah.comp.diagnostic;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_fluffy.diagnostic.ElDiagnostic;
import tripleo.elijah_fluffy.diagnostic.ElLocatable;

import java.io.PrintStream;
import java.util.List;

class TooManyEz_UseFirst implements ElDiagnostic {
	final String message = "Too many .ez files, using first.";

	@Override
	public @NotNull String code() {
		return "9998";
	}

	@Override
	public @NotNull ElLocatable primary() {
		return null;
	}

	@Override
	public void report(@NotNull PrintStream stream) {
		stream.println(String.format("%s %s", code(), message));
	}

	@Override
	public @NotNull List<ElLocatable> secondary() {
		return null;
	}

	@Override
	public @NotNull Severity severity() {
		return Severity.WARN;
	}
}
