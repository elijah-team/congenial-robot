package tripleo.elijah.stateful;

import org.jspecify.annotations.NonNull;

public interface Stateful {
	void mvState(State aO, @NotNull State aState);

	void setState(final State aState);
}
