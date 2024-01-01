package tripleo.elijah.comp.diagnostic;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.diagnostic.Locatable;

import java.io.PrintStream;
import java.util.List;

class TooManyEz_UseFirst implements Diagnostic {
	final String message = "Too many .ez files, using first.";

	@Override
	public @NonNull String code() {
		return "9998";
	}

	@Override
	public @NonNull Locatable primary() {
		return null;
	}

	@Override
	public void report(@NonNull PrintStream stream) {
		stream.println(String.format("%s %s", code(), message));
	}

	@Override
	public @NonNull List<Locatable> secondary() {
		return null;
	}

	@Override
	public @NonNull Severity severity() {
		return Severity.WARN;
	}
}
