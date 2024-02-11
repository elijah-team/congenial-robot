package tripleo.elijah.comp;

import org.jdeferred2.DoneCallback;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.comp.internal.CB_Output;
import tripleo.elijah.comp.internal.CR_State;
import tripleo.elijah.comp.internal.Provenance;
import tripleo.elijah.comp.notation.GN_Env;
import tripleo.elijah.comp.notation.GN_Notable;
import tripleo.elijah.stages.gen_fn.EvaNode;
import tripleo.elijah.stages.gen_generic.pipeline_impl.GenerateResultSink;
import tripleo.elijah_congenial.pipelines.eva.EvaPipelineImpl;
import tripleo.elijah_congenial.pipelines.eva.EvaPipelineImpl_PipelineAccess;
import tripleo.elijah_congenial.pipelines.eva.FunctionStatement;

import java.util.List;

/**
 * Created 8/21/21 10:16 PM
 */
public class EvaPipeline implements PipelineMember, AccessBus.AB_LgcListener {
	private final EvaPipelineImpl carrier;

	@Contract(pure = true)
	public EvaPipeline(@NotNull IPipelineAccess pa0) {
		carrier = new EvaPipelineImpl(new EvaPipelineImpl_PipelineAccess() {
			@Override
			public CompilationEnclosure getCompilationEnclosure() {
				return pa0.getCompilationEnclosure();
			}

			@Override
			public AccessBus getAccessBus() {
				return pa0.getAccessBus();
			}

			@Override
			public void registerNodeList(final DoneCallback<List<EvaNode>> cb) {
				pa0.registerNodeList(cb);
			}

			@Override
			public void setGenerateResultSink(final GenerateResultSink aGenerateResultSink) {
				pa0.setGenerateResultSink(aGenerateResultSink);
			}

			@Override
			public void setEvaPipeline(final EvaPipelineImpl aEvaPipeline) {
				pa0.setEvaPipeline(EvaPipeline.this);
			}

			@Override
			public void install_notate(final Provenance aProvenance, final Class<GN_Notable> aNotableClass, final Class<GN_Env> aEnvClass) {

			}
		});
	}

	@Override
	public void lgc_slot(final @NotNull List<EvaNode> aLgc) {
		carrier.lgc_slot(aLgc);
	}

	// 1 here and up
	@Override
	public void run(final CR_State aSt, final CB_Output aOutput) {
		carrier.run(aSt, aOutput);
	}

	// 2
	public void addFunctionStatement(final FunctionStatement aFunctionStatement) {
		carrier.addFunctionStatement(aFunctionStatement);
	}
}
