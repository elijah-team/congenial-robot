package tripleo.elijah.stages.deduce.calculate.rider;

import org.jetbrains.annotations.NotNull;

import tripleo.elijah.stages.gen_fn.ProcTableEntry;
import tripleo.elijah.stages.instructions.Instruction;
import tripleo.elijah.stages.instructions.InstructionArgument;

public class __Rider__Implement_construct {
	private final          InstructionArgument expression;
	private final          tripleo.elijah.stages.gen_fn.IBaseEvaFunction     generatedFunction;
	private final          Instruction         instruction;
	private final @NotNull ProcTableEntry      pte;

	public __Rider__Implement_construct(tripleo.elijah.stages.gen_fn.IBaseEvaFunction generatedFunction2, Instruction instruction2,
										InstructionArgument expression2, @NotNull ProcTableEntry pte2) {
		generatedFunction = generatedFunction2;
		instruction       = instruction2;
		expression        = expression2;
		pte               = pte2;
	}

	public InstructionArgument getExpression() {
		return expression;
	}

	public tripleo.elijah.stages.gen_fn.IBaseEvaFunction getGeneratedFunction() {
		return generatedFunction;
	}

	public Instruction getInstruction() {
		return instruction;
	}

	public @NotNull ProcTableEntry getPte() {
		return pte;
	}
}