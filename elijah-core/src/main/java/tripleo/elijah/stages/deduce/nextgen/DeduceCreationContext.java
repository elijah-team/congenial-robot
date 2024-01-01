package tripleo.elijah.stages.deduce.nextgen;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.Eventual;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.deduce.FunctionInvocation;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.stages.gen_fn.GeneratePhase;

public interface DeduceCreationContext {

	Eventual<BaseEvaFunction> makeGenerated_fi__Eventual(FunctionInvocation aFunctionInvocation);

	DeduceTypes2 getDeduceTypes2();

	@NonNull DeducePhase getDeducePhase();

	@NonNull GeneratePhase getGeneratePhase();
}
