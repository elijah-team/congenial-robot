package tripleo.elijah.stages.deduce.post_bytecode;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.stages.deduce.ClassInvocation;
import tripleo.elijah.stages.gen_fn.GenType;

public class SGTA_SetClassInvocation implements setup_GenType_Action {
	@Override
	public void run(final @NonNull GenType gt, final @NonNull setup_GenType_Action_Arena arena) {
		final ClassInvocation ci = arena.get("ci");
		gt.setCi(ci);
	}
}
