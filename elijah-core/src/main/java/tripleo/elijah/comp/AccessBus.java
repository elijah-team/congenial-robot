package tripleo.elijah.comp;

import org.jdeferred2.DoneCallback;
import org.jdeferred2.impl.DeferredObject;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.comp.internal.CR_State;
import tripleo.elijah.comp.internal.CR_State.PipelinePlugin;
import tripleo.elijah.stages.gen_fn.EvaNode;
import tripleo.elijah.stages.gen_generic.GenerateResult;
import tripleo.elijah.stages.gen_generic.Old_GenerateResult;
import tripleo.vendor.mal.stepA_mal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class AccessBus {
	public final  Old_GenerateResult gr                    = new Old_GenerateResult();
	private final Compilation        _c;
	private final IPipelineAccess    _pa;
	private final stepA_mal.@NonNull MalEnv2                     env;
	private final DeferredObject<Old_GenerateResult, Void, Void> generateResultPromise = new DeferredObject<>();
	private final DeferredObject<List<EvaNode>, Void, Void>      lgcPromise            = new DeferredObject<>();
	private final Map<String, CR_State.PipelinePlugin>           pipelinePlugins       = new HashMap<>();

	public stepA_mal.@NonNull MalEnv2 env() {
		return env;
	}

	public @NonNull Compilation getCompilation() {
		return _c;
	}

	public AccessBus(final Compilation aC, final IPipelineAccess aPa) {
		_c  = aC;
		_pa = aPa;

		env = new stepA_mal.MalEnv2(null); // TODO what does null mean?
	}

	public void add(final @NonNull Function<AccessBus, PipelineMember> aCr) {
		final PipelineMember x = aCr.apply(this);
		_c.getCompilationEnclosure().getCompilationAccess().addPipeline(x);
	}

	public void addPipelinePlugin(final @NonNull PipelinePlugin aPlugin) {
		pipelinePlugins.put(aPlugin.name(), aPlugin);
	}

	public IPipelineAccess getPipelineAccess() {
		return _pa;
	}

	public void resolveGenerateResult(final Old_GenerateResult aGenerateResult) {
		generateResultPromise.resolve(aGenerateResult);
	}

	public void resolvePipelineLogic(final PipelineLogic aPipelineLogic) {
		_pa.getPipelineLogicPromise().resolve(aPipelineLogic);
	}

	public void subscribe_GenerateResult(@NonNull final AB_GenerateResultListener aGenerateResultListener) {
		generateResultPromise.then(aGenerateResultListener::gr_slot);
	}

	public @Nullable PipelinePlugin getPipelinePlugin(final String aPipelineName) {
		if (!(pipelinePlugins.containsKey(aPipelineName))) return null;

		return pipelinePlugins.get(aPipelineName);
	}

	public void subscribe_lgc(@NonNull final AB_LgcListener aLgcListener) {
		lgcPromise.then(aLgcListener::lgc_slot);
	}

	public void subscribePipelineLogic(final DoneCallback<PipelineLogic> aPipelineLogicDoneCallback) {
		_pa.getPipelineLogicPromise().then(aPipelineLogicDoneCallback);
	}

	public interface AB_GenerateResultListener {
		void gr_slot(GenerateResult gr);
	}

	public interface AB_LgcListener {
		void lgc_slot(List<EvaNode> lgc);
	}
}
