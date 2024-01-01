package tripleo.elijah.stateful;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public abstract class DefaultStateful implements Stateful {
	private State _state;

	@Override
	public void mvState(final @Nullable State aO, @NonNull final State aState) {
		assert aO == null;

		if (!aState.checkState(this)) {
			//throw new BadState();
			return;
		}

		aState.apply(this);
		this.setState(aState);
	}

	@Override
	public void setState(final State aState) {
		_state = aState;
	}
}