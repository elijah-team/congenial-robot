package tripleo.elijah.stages.gen_fn;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.lang.i.OS_Element;
import tripleo.elijah.stages.deduce.FunctionInvocation;
import tripleo.elijah.stages.instructions.InstructionArgument;

public interface DT_Resolvable {
	static @NonNull DT_Resolvable from(@NonNull InstructionArgument aInstructionArgument, /*@NonNull*/ OS_Element aElement, FunctionInvocation aFunctionInvocation) {
		return new DT_Resolvable() {
			@Override
			public Object deduceItem() {
				return aFunctionInvocation;
			}

			@Override
			public OS_Element element() {
				return aElement;
			}

			@Override
			public InstructionArgument instructionArgument() {
				return aInstructionArgument;
			}
		};
	}

	static @NonNull DT_Resolvable from(@NonNull InstructionArgument ia) {
		return new DT_Resolvable() {
			@Override
			public @Nullable Object deduceItem() {
				return null;
			}

			@Override
			public @Nullable OS_Element element() {
				return null;
			}

			@Override
			public InstructionArgument instructionArgument() {
				return ia;
			}
		};
	}

	@Nullable Object deduceItem();

	InstructionArgument instructionArgument();

	@Nullable OS_Element element();
}
