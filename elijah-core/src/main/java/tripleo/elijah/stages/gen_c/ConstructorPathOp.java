package tripleo.elijah.stages.gen_c;

import org.jspecify.annotations.Nullable;
import tripleo.elijah.stages.gen_fn.EvaNode;

interface ConstructorPathOp {
	@Nullable String getCtorName();

	@Nullable EvaNode getResolved();
}
