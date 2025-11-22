package tripleo.elijah.comp.diagnostic;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_fluffy.diagnostic.ElDiagnostic;
import tripleo.elijah_fluffy.diagnostic.ElLocatable;

import java.io.PrintStream;
import java.util.List;

public class ExceptionDiagnostic implements ElDiagnostic {
	private final Exception e;

	public ExceptionDiagnostic(final Exception aE) {
		e = aE;
	}

	@Override
	public @NotNull String code() {
		return "9003";
	}

	@Override
	public @NotNull ElLocatable primary() {
		return null;
	}

	@Override
	public void report(final @NotNull PrintStream stream) {
		stream.println(code() + " Some exception " + e);
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
