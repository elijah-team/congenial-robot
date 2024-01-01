package tripleo.elijah;

import org.jspecify.annotations.NonNull;

import java.util.Objects;

public class ReadySupplier_1<T> implements ReadySupplier<T> {
	private final T t;

	public ReadySupplier_1(final @NonNull T aT) {
		// README why supply a NULL??
		t = Objects.requireNonNull(aT);
	}

	@Override
	public T get() {
		if (!ready()) {
			throw new IllegalStateException("not ready"); // FIXME move this
		}
		return t;
	}

	@Override
	public boolean ready() {
		return t != null;
	}
}
