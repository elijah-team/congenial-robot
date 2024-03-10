package tripleo.elijah.stages.deduce.tastic;

import tripleo.elijah.lang.i.Context;
import tripleo.elijah.lang.i.OS_Element;

import tripleo.elijah.stages.gen_fn.IBaseEvaFunction;
import tripleo.elijah.stages.gen_fn.IdentTableEntry;
import tripleo.elijah.stages.gen_fn.VariableTableEntry;
import tripleo.elijah.stages.instructions.Instruction;

public interface ITastic {
	void do_assign_call(IBaseEvaFunction aGeneratedFunction, Context aFdCtx, IdentTableEntry aIdte, int aIndex);

	void do_assign_call(IBaseEvaFunction aGeneratedFunction, Context aContext, VariableTableEntry aVte, Instruction aInstruction, final OS_Element aName);
}
