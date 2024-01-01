package tripleo.elijah.stages.gen_fn;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.i.OS_Type;
import tripleo.elijah.stages.deduce.post_bytecode.setup_GenType_Action;
import tripleo.elijah.stages.deduce.post_bytecode.setup_GenType_Action_Arena;

public class SGTA_Set implements setup_GenType_Action {
	private final @NonNull OS_Type type;

	public SGTA_Set(final @NonNull OS_Type aType) {
		type = aType;
	}

	@Override
	public void run(final @NonNull GenType gt, final @NonNull setup_GenType_Action_Arena arena) {
		gt.set(type);
	}
}
