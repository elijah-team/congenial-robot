package tripleo.elijah.stages.deduce.post_bytecode;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.stages.deduce.NamespaceInvocation;
import tripleo.elijah.stages.gen_fn.GenType;

public class SGTA_SetNamespaceInvocation implements setup_GenType_Action {
	@Override
	public void run(final @NonNull GenType gt, final @NonNull setup_GenType_Action_Arena arena) {
		final NamespaceInvocation nsi = arena.get("nsi");

		gt.setCi(nsi);
	}
}
