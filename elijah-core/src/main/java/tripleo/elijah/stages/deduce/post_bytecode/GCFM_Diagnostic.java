package tripleo.elijah.stages.deduce.post_bytecode;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.diagnostic.Locatable;

import java.io.PrintStream;
import java.util.List;

public interface GCFM_Diagnostic extends Diagnostic {
	static @NonNull GCFM_Diagnostic forThis(final @NonNull String aMessage, final @NonNull String aCode, final @NonNull Severity aSeverity) {
		return new GCFM_Diagnostic() {
			@Override
			public String _message() {
				return aMessage;
			}

			@Override
			public String code() {
				return aCode;
			}

			@Override
			public @NonNull Locatable primary() {
				return null;
			}

			@Override
			public void report(final @NonNull PrintStream stream) {
				stream.printf("%s %s%n", code(), _message());
			}

			@Override
			public @NonNull List<Locatable> secondary() {
				return null;
			}

			@Override
			public Severity severity() {
				return aSeverity;
			}
		};
	}

	String _message();
}
