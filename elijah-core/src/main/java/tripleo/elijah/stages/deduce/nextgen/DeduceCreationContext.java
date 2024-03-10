package tripleo.elijah.stages.deduce.nextgen;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.util.Eventual;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.deduce.FunctionInvocation;

import tripleo.elijah.stages.gen_fn.GeneratePhase;

public interface DeduceCreationContext {
	Eventual<tripleo.elijah.stages.gen_fn.IBaseEvaFunction> makeGenerated_fi__Eventual(FunctionInvocation aFunctionInvocation);

	DeduceTypes2 getDeduceTypes2();

	@NotNull DeducePhase getDeducePhase();

	@NotNull GeneratePhase getGeneratePhase();
}
