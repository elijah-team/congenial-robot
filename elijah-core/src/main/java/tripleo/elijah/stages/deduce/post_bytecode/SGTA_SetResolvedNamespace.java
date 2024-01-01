package tripleo.elijah.stages.deduce.post_bytecode;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.i.NamespaceStatement;
import tripleo.elijah.stages.gen_fn.GenType;

public class SGTA_SetResolvedNamespace implements setup_GenType_Action {
	private final NamespaceStatement namespaceStatement;

	@Contract(pure = true)
	public SGTA_SetResolvedNamespace(final NamespaceStatement aNamespaceStatement) {
		namespaceStatement = aNamespaceStatement;
	}

	@Override
	public void run(final @NonNull GenType gt, final @NonNull setup_GenType_Action_Arena arena) {
		gt.setResolvedn(namespaceStatement);
	}
}
