package tripleo.elijah.comp.diagnostic;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.diagnostic.Locatable;

import java.io.PrintStream;
import java.util.List;

public class ExceptionDiagnostic implements Diagnostic {
	private final Exception e;

	public ExceptionDiagnostic(final Exception aE) {
		e = aE;
	}

	@Override
	public @NonNull String code() {
		return "9003";
	}

	@Override
	public @NonNull Locatable primary() {
		return null;
	}

	@Override
	public void report(final @NonNull PrintStream stream) {
		stream.println(code() + " Some exception " + e);
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
