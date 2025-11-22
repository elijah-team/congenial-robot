package tripleo.elijah_fluffy.util;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_fluffy.diagnostic.ElDiagnostic;

/**
 * An emulation of Rust's Result type
 *
 * @param <T> the success type
 */
public class Operation2<T> {
	private final Mode mode;
	private final T    succ;

	private final ElDiagnostic exc;

	public static <T> @NotNull Operation2<T> failure(final ElDiagnostic aException) {
		final Operation2<T> op = new Operation2<>(null, aException, Mode.FAILURE);
		return op;
	}

	public static <T> @NotNull Operation2<T> success(final T aSuccess) {
		final Operation2<T> op = new Operation2<>(aSuccess, null, Mode.SUCCESS);
		return op;
	}

	public Operation2(final T aSuccess, final ElDiagnostic aException, final Mode aMode) {
		succ = aSuccess;
		exc  = aException;
		mode = aMode;

		if (succ == exc)
			throw new AssertionError();
	}

	public ElDiagnostic failure() {
		return exc;
	}

	public Mode mode() {
		return mode;
	}

	public T success() {
		return succ;
	}
}
