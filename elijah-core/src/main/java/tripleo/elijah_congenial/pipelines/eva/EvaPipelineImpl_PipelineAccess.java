package tripleo.elijah_congenial.pipelines.eva;

import org.jdeferred2.DoneCallback;

import tripleo.elijah.comp.AccessBus;
import tripleo.elijah.comp.i.CompilationEnclosure;

import tripleo.elijah.comp.internal.Provenance;

import tripleo.elijah.comp.notation.GN_Env;
import tripleo.elijah.comp.notation.GN_Notable;

import tripleo.elijah.stages.gen_fn.EvaNode;

import tripleo.elijah.stages.gen_generic.pipeline_impl.GenerateResultSink;

import java.util.List;

public interface EvaPipelineImpl_PipelineAccess {
	CompilationEnclosure getCompilationEnclosure();

	AccessBus getAccessBus();

	void registerNodeList(DoneCallback<List<EvaNode>> cb);

	void setGenerateResultSink(GenerateResultSink aGenerateResultSink);

	void setEvaPipeline(EvaPipelineImpl aEvaPipeline);

	void install_notate(Provenance aProvenance, Class<GN_Notable> aNotableClass, Class<GN_Env> aEnvClass);
}
