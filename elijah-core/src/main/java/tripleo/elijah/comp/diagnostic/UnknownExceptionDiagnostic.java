package tripleo.elijah.comp.diagnostic;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.diagnostic.Locatable;
import tripleo.elijah.util.Operation2;
import tripleo.elijah.world.i.WorldModule;

import java.io.PrintStream;
import java.util.List;

public class UnknownExceptionDiagnostic implements Diagnostic {
	private final Operation2<WorldModule> m;

	public UnknownExceptionDiagnostic(final Operation2<WorldModule> aM) {
		m = aM;
	}

	@Override
	public @NonNull String code() {
		return "9002";
	}

	@Override
	public @NonNull Locatable primary() {
		return null/*m*/;
	}

	@Override
	public void report(final @NonNull PrintStream stream) {
		stream.printf("%s Some error %s%n", code(), m.failure());
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
