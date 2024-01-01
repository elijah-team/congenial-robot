package tripleo.elijah.comp.diagnostic;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.diagnostic.Locatable;

import java.io.PrintStream;
import java.util.List;

public class TooManyEz_ActuallyNone implements Diagnostic {
	final String message = "No .ez files found.";

	@Override
	public @NonNull String code() {
		return "9999";
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
		return Severity.ERROR;
	}
}
