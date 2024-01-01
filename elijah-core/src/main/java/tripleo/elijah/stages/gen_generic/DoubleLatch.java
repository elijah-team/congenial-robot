package tripleo.elijah.stages.gen_generic;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public class DoubleLatch<T> {
	private final @NonNull Consumer<T> action;
	private                boolean     simple;
	private                T           tt;

	//private IincInsnNode action;

	@Contract(pure = true)
	public DoubleLatch(final @NonNull Consumer<T> aAction) {
		action = aAction;
	}

	public void notifyData(T att) {
		tt = att;
		if (simple && tt != null) {
			action.accept(tt);
		}
	}

	public void notifyLatch(boolean ass) {
		simple = ass;
		if (simple && tt != null) {
			action.accept(tt);
		}
	}
}
