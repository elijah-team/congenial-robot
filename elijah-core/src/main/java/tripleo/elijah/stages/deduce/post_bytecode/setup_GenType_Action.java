package tripleo.elijah.stages.deduce.post_bytecode;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.stages.gen_fn.GenType;

public interface setup_GenType_Action {
	void run(final @NonNull GenType gt, final @NonNull setup_GenType_Action_Arena arena);
}
