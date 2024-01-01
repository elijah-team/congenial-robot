package tripleo.elijah.stages.gen_fn;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.stages.deduce.FunctionInvocation;
import tripleo.elijah.stages.deduce.post_bytecode.setup_GenType_Action;
import tripleo.elijah.stages.deduce.post_bytecode.setup_GenType_Action_Arena;

public class SGTA_SetFunctionInvocation implements setup_GenType_Action {
	private final FunctionInvocation fi;

	public SGTA_SetFunctionInvocation(final FunctionInvocation aFi) {
		fi = aFi;
	}

	@Override
	public void run(final @NonNull GenType gt, final @NonNull setup_GenType_Action_Arena arena) {
		gt.setFunctionInvocation(fi);

	}
}
