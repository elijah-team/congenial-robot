package tripleo.elijah_congenial.deduce.t;

import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.stages.gen_fn.EvaClass;
import tripleo.elijah.stages.gen_fn.EvaNode;

public class TEvaClass implements EvaNode {
	private final EvaNode aClass;

	public TEvaClass(final EvaClass aClass) {
		this.aClass = aClass;
	}

	@Override
	public String identityString() {
		return aClass.identityString();
	}

	@Override
	public OS_Module module() {
		return aClass.module(); //
	}
}
