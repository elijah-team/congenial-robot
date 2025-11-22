package tripleo.elijah.comp.diagnostic;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_fluffy.diagnostic.ElDiagnostic;
import tripleo.elijah_fluffy.diagnostic.ElLocatable;
import tripleo.elijah_fluffy.util.Operation2;
import tripleo.elijah.world.i.WorldModule;

import java.io.PrintStream;
import java.util.List;

public class UnknownExceptionDiagnostic implements ElDiagnostic {
	private final Operation2<WorldModule> m;

	public UnknownExceptionDiagnostic(final Operation2<WorldModule> aM) {
		m = aM;
	}

	@Override
	public @NotNull String code() {
		return "9002";
	}

	@Override
	public @NotNull ElLocatable primary() {
		return null/*m*/;
	}

	@Override
	public void report(final @NotNull PrintStream stream) {
		stream.printf("%s Some error %s%n", code(), m.failure());
	}

	@Override
	public @NotNull List<ElLocatable> secondary() {
		return null;
	}

	@Override
	public @NotNull Severity severity() {
		return Severity.ERROR;
	}
}
