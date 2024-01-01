package tripleo.elijah.comp.diagnostic;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.diagnostic.Locatable;

import java.io.File;
import java.io.PrintStream;
import java.util.List;

public class FileNotFoundDiagnostic implements Diagnostic {
	private final File f;

	public FileNotFoundDiagnostic(final File aLocal_prelude) {
		f = aLocal_prelude;
	}

	@Override
	public @NonNull String code() {
		return "9004";
	}

	@Override
	public @NonNull Locatable primary() {
		return null;
	}

	@Override
	public void report(final @NonNull PrintStream stream) {
		stream.println(code() + " File not found " + f.toString());
	}

	@Override
	public @NonNull List<Locatable> secondary() {
		return null;
	}

	@Override
	public @NonNull Severity severity() {
		return Severity.INFO;
	}
}
