package tripleo.elijah.stages.deduce;

import tripleo.elijah_fluffy.util.UnintendedUseException;
import tripleo.elijah_fluffy.util.Ok;
import tripleo.elijah_fluffy.util.Operation;

class Times {
	public static class Once implements T {
		@Override
		public Operation<Ok> call() {
			throw new UnintendedUseException();
			//return null;
		}
	}

	public interface T {
		Operation<Ok> call(); // ??
	}
}
