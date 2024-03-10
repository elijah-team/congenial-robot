package tripleo.elijah_congenial.deduce.umbrella;

import tripleo.elijah.lang.i.FunctionDef;
import tripleo.elijah.stages.deduce.FunctionInvocation;
import tripleo.elijah.stages.gen_fn.IBaseEvaFunction;


/**
 * This is a callback for resolveWith.
 * <p>
 * It should be prepared with a {@link DS_Rider}
 * </p>
 */
public interface DS_FunctionDef extends DS_Base {
	void accept(FunctionDef fd);
	void accept(IBaseEvaFunction gf);
	void accept(FunctionInvocation aFunctionInvocation);
}
