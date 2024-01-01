package tripleo.elijah.comp.notation;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.i.OS_Module;

import tripleo.elijah.stages.gen_generic.GenerateFiles;
import tripleo.elijah.stages.gen_generic.GenerateResultEnv;
import tripleo.elijah.stages.gen_generic.OutputFileFactoryParams;

import java.util.function.Supplier;

public record GM_GenerateModuleRequest(@NonNull GN_GenerateNodesIntoSink generateNodesIntoSink,
									   @NonNull OS_Module mod,
									   @NonNull GN_GenerateNodesIntoSinkEnv env) {
	@SuppressWarnings("static-access")
	@Contract("_ -> new")
	public @NonNull GenerateFiles getGenerateFiles(final Supplier<GenerateResultEnv> fgs) {
		var params = params();
		return env.getGenerateFiles(params, params.getMod(), fgs);
	}

	public @NonNull OutputFileFactoryParams params() {
		return env.getParams(mod, generateNodesIntoSink);
	}
}
