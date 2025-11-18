package tripleo.elijah_durable_congenial.comp.diagnostic;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_fluffy_congenial.diagnostic.Diagnostic;
import tripleo.elijah_fluffy_congenial.diagnostic.Locatable;

import java.io.PrintStream;
import java.util.List;

public class ExceptionDiagnostic implements Diagnostic {
	private final Throwable e;

	public ExceptionDiagnostic(final Exception aE) {
		e = aE;
	}
	public ExceptionDiagnostic(final Throwable aE) {
		e = aE;
	}

	@Override
	public @NotNull String code() {
		return "9003";
	}

	@Override
	public @NotNull Locatable primary() {
		return null;
	}

	@Override
	public void report(final @NotNull PrintStream stream) {
		stream.println(code() + " Some exception " + e);
	}

	@Override
	public @NotNull List<Locatable> secondary() {
		return null;
	}

	@Override
	public @NotNull Severity severity() {
		return Severity.ERROR;
	}
}
