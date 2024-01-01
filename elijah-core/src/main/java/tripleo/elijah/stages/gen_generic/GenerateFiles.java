package tripleo.elijah.stages.gen_generic;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.stages.gen_fn.EvaClass;
import tripleo.elijah.stages.gen_fn.EvaConstructor;
import tripleo.elijah.stages.gen_fn.EvaFunction;
import tripleo.elijah.stages.gen_fn.EvaNode;
import tripleo.elijah.stages.gen_generic.pipeline_impl.GenerateResultSink;
import tripleo.elijah.stages.logging.ElLog;
import tripleo.elijah.stages.pp.IPP_Constructor;
import tripleo.elijah.stages.pp.IPP_Function;
import tripleo.elijah.stages.pp.PP_Constructor;
import tripleo.elijah.stages.pp.PP_Function;
import tripleo.elijah.work.WorkList;
import tripleo.elijah.work.WorkManager;

import java.util.Collection;
import java.util.List;

public interface GenerateFiles extends CodeGenerator {
	void generate_constructor(IPP_Constructor aGf, GenerateResult aGr, WorkList aWl, GenerateResultSink aResultSink, final WorkManager aWorkManager, final @NonNull GenerateResultEnv aFileGen);

	void generate_function(IPP_Function aEvaFunction, GenerateResult aGenerateResult, WorkList aWorkList, GenerateResultSink aResultSink);

	GenerateResult generateCode(Collection<EvaNode> lgn, @NonNull GenerateResultEnv aFileGen);

	<T> GenerateResultEnv getFileGen();

	GenerateResult resultsFromNodes(@NonNull List<EvaNode> aNodes, WorkManager wm, GenerateResultSink grs, @NonNull GenerateResultEnv fg);

	ElLog elLog();

	void finishUp(final GenerateResult aGenerateResult, final WorkManager wm, final WorkList aWorkList);

	@NonNull
	static Collection<EvaNode> classes_to_list_of_generated_nodes(@NonNull Collection<EvaClass> aEvaClasses) {
		return Collections2.transform(aEvaClasses, new Function<EvaClass, EvaNode>() {
			@org.checkerframework.checker.nullness.qual.Nullable
			@Override
			public @Nullable EvaNode apply(@org.checkerframework.checker.nullness.qual.Nullable EvaClass input) {
				return input;
			}
		});
	}

	@NonNull
	static Collection<EvaNode> constructors_to_list_of_generated_nodes(@NonNull Collection<EvaConstructor> aEvaConstructors) {
		return Collections2.transform(aEvaConstructors, new Function<EvaConstructor, EvaNode>() {
			@org.checkerframework.checker.nullness.qual.Nullable
			@Override
			public @Nullable EvaNode apply(@org.checkerframework.checker.nullness.qual.Nullable EvaConstructor input) {
				return input;
			}
		});
	}

	@NonNull
	static Collection<EvaNode> functions_to_list_of_generated_nodes(@NonNull Collection<EvaFunction> generatedFunctions) {
		return Collections2.transform(generatedFunctions, new Function<EvaFunction, EvaNode>() {
			@org.checkerframework.checker.nullness.qual.Nullable
			@Override
			public @Nullable EvaNode apply(@org.checkerframework.checker.nullness.qual.Nullable EvaFunction input) {
				return input;
			}
		});
	}
}
