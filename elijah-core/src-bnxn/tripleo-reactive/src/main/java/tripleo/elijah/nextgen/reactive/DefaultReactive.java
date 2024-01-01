package tripleo.elijah.nextgen.reactive;

import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class DefaultReactive implements Reactive {
	private final @NonNull List<Reactivable> ables = new ArrayList<>();

	@Override
	public void add(final Reactivable aReactivable) {
		ables.add(aReactivable);
	}

	@Override
	public abstract <T> void addListener(final Consumer<T> t);

	@Override
	public void join(final ReactiveDimension aDimension) {
		for (Reactivable reactivable : ables) {
			reactivable.respondTo(aDimension);
		}
	}
}
