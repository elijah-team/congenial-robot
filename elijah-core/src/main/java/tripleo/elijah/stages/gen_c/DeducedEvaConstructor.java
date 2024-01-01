package tripleo.elijah.stages.gen_c;

import org.jspecify.annotations.NonNull;

public interface DeducedEvaConstructor extends DeducedEvaFunctionBase {
	WhyNotGarish_Constructor getWhyNotGarishFunction(final @NotNull GenerateC aGc);

	default WhyNotGarish_Constructor a_lookup(GenerateC aGc) {
		return getWhyNotGarishFunction(aGc);
	}
}
