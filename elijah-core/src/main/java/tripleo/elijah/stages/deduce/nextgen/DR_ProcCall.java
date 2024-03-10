package tripleo.elijah.stages.deduce.nextgen;

import tripleo.elijah.lang.i.IExpression;
import tripleo.elijah.stages.deduce.FunctionInvocation;

import tripleo.elijah.stages.gen_fn.IBaseEvaFunction;
import tripleo.elijah.stages.gen_fn.ProcTableEntry;

public class DR_ProcCall implements DR_Item {
	private final IExpression      z;
	private final ProcTableEntry   pte;
	private final IBaseEvaFunction evaFunction;

	public DR_ProcCall(final IExpression aZ, final ProcTableEntry aPte, final IBaseEvaFunction aIBaseEvaFunction) {
		z           = aZ;
		pte         = aPte;
		evaFunction = aIBaseEvaFunction;
	}

	public FunctionInvocation getFunctionInvocation() {
		return pte.getFunctionInvocation();
	}
}
