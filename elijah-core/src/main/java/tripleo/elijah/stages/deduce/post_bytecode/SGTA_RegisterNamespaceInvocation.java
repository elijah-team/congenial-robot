package tripleo.elijah.stages.deduce.post_bytecode;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.i.NamespaceStatement;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.NamespaceInvocation;
import tripleo.elijah.stages.gen_fn.GenType;

public class SGTA_RegisterNamespaceInvocation implements setup_GenType_Action {
	private final NamespaceStatement namespaceStatement;
	private final DeducePhase        phase;

	@Contract(pure = true)
	public SGTA_RegisterNamespaceInvocation(final NamespaceStatement aNamespaceStatement, final DeducePhase aPhase) {
		namespaceStatement = aNamespaceStatement;
		phase              = aPhase;
	}

	@Override
	public void run(final @NonNull GenType gt, final @NonNull setup_GenType_Action_Arena arena) {
		final NamespaceInvocation nsi = phase.registerNamespaceInvocation(namespaceStatement);
		arena.put("nsi", nsi);
	}
}
