package tripleo.elijah.stages.gen_c;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.diagnostic.Locatable;
import tripleo.elijah.stages.deduce.post_bytecode.GCFM_Diagnostic;

import java.io.PrintStream;
import java.util.List;

class Diagnostic_8886 implements GCFM_Diagnostic {
	final int _code = 8886;

	@Override
	public @NonNull String code() {
		return "" + _code;
	}

	@Override
	public @NonNull Locatable primary() {
		return null;
	}

	@Override
	public void report(final @NonNull PrintStream stream) {
		stream.println(_message());
	}

	@Override
	public String _message() {
		return String.format("%d y is null (No typename specified)", _code);
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
