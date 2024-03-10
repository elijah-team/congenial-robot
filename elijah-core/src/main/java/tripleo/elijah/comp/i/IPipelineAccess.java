package tripleo.elijah.comp.i;

import org.jdeferred2.DoneCallback;
import org.jetbrains.annotations.NotNull;

import tripleo.elijah.stages.gen_fn.IBaseEvaFunction;
import tripleo.elijah.util.Eventual;
import tripleo.elijah.comp.AccessBus;
import tripleo.elijah.comp.EvaPipeline;
import tripleo.elijah.comp.PipelineLogic;
import tripleo.elijah.comp.WritePipeline;
import tripleo.elijah.comp.internal.Provenance;
import tripleo.elijah.comp.notation.GN_Env;
import tripleo.elijah.comp.notation.GN_Notable;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.inputtree.EIT_ModuleList;
import tripleo.elijah.nextgen.output.NG_OutputItem;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.gen_c.GenerateC;
import tripleo.elijah.stages.gen_fn.IEvaClass;
import tripleo.elijah.stages.gen_fn.EvaNamespace;
import tripleo.elijah.stages.gen_fn.EvaNode;
import tripleo.elijah.stages.gen_generic.pipeline_impl.GenerateResultSink;
import tripleo.elijah.stages.logging.ElLog;
import tripleo.elijah_congenial.pipelines.eva.FunctionStatement;

import java.util.List;
import java.util.function.Consumer;

public interface IPipelineAccess {
	void addLog(ElLog aLOG);
	void addOutput(NG_OutputItem aO);

	void setNodeList(List<EvaNode> aEvaNodeList);
	void registerNodeList(DoneCallback<List<EvaNode>> done);

	void activeClass(IEvaClass aEvaClass);
	List<IEvaClass> getActiveClasses();

	void activeNamespace(EvaNamespace aEvaNamespace);
	List<EvaNamespace> getActiveNamespaces();

	List<IBaseEvaFunction> getActiveFunctions();
	void activeFunction(IBaseEvaFunction aEvaFunction);
	void addFunctionStatement(FunctionStatement aFunctionStatement);

	void _send_GeneratedClass(EvaNode aClass);

	void waitGenC(OS_Module mod, Consumer<GenerateC> aCb);

	void install_notate(Provenance aProvenance, Class<? extends GN_Notable> aRunClass, Class<? extends GN_Env> aEnvClass);

	void notate(Provenance provenance, GN_Notable aNotable);
	void notate(Provenance aProvenance, GN_Env aPlRun2);
	DeducePhase getDeducePhase();

	EIT_ModuleList getModuleList();

	void _ModuleList_add(OS_Module aM);


	void resolvePipelinePromise(PipelineLogic aPipelineLogic);

	void setWritePipeline(WritePipeline aWritePipeline);
	void setEvaPipeline(@NotNull EvaPipeline agp);
	void setGenerateResultSink(GenerateResultSink aGenerateResultSink);

	void _setAccessBus(AccessBus ab);

	@NotNull Eventual<EvaPipeline> getEvaPipelinePromise();
	@NotNull Eventual<PipelineLogic> getPipelineLogicPromise();

	AccessBus getAccessBus();
	Compilation getCompilation();
	CompilationEnclosure getCompilationEnclosure();
	GenerateResultSink getGenerateResultSink();
	WritePipeline getWritePipeline();
	//List<NG_OutputItem> getOutputs();
}
