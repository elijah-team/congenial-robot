package tripleo.elijah.stages.deduce;

import tripleo.elijah.stages.gen_fn.IEvaClass;

@FunctionalInterface
public interface OnGenClass {
	void accept(final IEvaClass aGeneratedClass);
}
