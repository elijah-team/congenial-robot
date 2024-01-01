package tripleo.elijah.stages.gen_fn;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.i.NamespaceStatement;
import tripleo.elijah.stages.deduce.post_bytecode.setup_GenType_Action;
import tripleo.elijah.stages.deduce.post_bytecode.setup_GenType_Action_Arena;

public class SGTA_RestReolvedn implements setup_GenType_Action {
	private final NamespaceStatement parent;

	public SGTA_RestReolvedn(final NamespaceStatement aParent) {
		parent = aParent;
	}

	@Override
	public void run(final @NonNull GenType gt, final @NonNull setup_GenType_Action_Arena arena) {
		gt.setResolvedn(parent);
	}
}
