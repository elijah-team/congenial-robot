package tripleo.elijah_congenial.deduce;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.lang.i.ClassStatement;
import tripleo.elijah.lang.i.FunctionDef;
import tripleo.elijah.lang.i.NamespaceStatement;
import tripleo.elijah.lang.i.OS_Element;
import tripleo.elijah.nextgen.ClassDefinition;
import tripleo.elijah.nextgen.diagnostic.CouldntGenerateClass;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.deduce.declarations.DeferredMember;
import tripleo.elijah.stages.deduce.declarations.DeferredMemberFunction;
import tripleo.elijah.stages.deduce_c.ResolvedVariables;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.gen_fn_r.RegisterClassInvocation_env;
import tripleo.elijah.stages.gen_generic.ICodeRegistrar;
import tripleo.elijah.stages.logging.ElLog;
import tripleo.elijah.stages.post_deduce.DefaultCodeRegistrar;
import tripleo.elijah.stateful.State;
import tripleo.elijah.work.WorkJob;
import tripleo.elijah.work.WorkList;
import tripleo.elijah.work.WorkManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class DeducePhaseInjector {
	public WlGenerateClass new_WlGenerateClass(final GenerateFunctions aGenerateFunctions, final ClassInvocation aClassInvocation, final DeducePhase.GeneratedClasses aGeneratedClasses, final ICodeRegistrar aCodeRegistrar) {
		return new WlGenerateClass(aGenerateFunctions, aClassInvocation, aGeneratedClasses, aCodeRegistrar);
	}

	public WorkManager new_WorkManager() {
		return new WorkManager();
	}

	public DeducePhase.GeneratedClasses new_GeneratedClasses(final DeducePhase aDeducePhase) {
		return aDeducePhase.new GeneratedClasses();
	}

	public ClassDefinition new_ClassDefinition(final ClassInvocation aCi) {
		return new ClassDefinition(aCi);
	}

	public Map<NamespaceStatement, NamespaceInvocation> new_HashMap__NamespaceInvocationMap() {
		return new HashMap<NamespaceStatement, NamespaceInvocation>();
	}

	public Country1 new_Country1(final DeducePhase aDeducePhase) {
		return new Country1(aDeducePhase);
	}

	public List<DeferredMemberFunction> new_ArrayList__DeferredaMemberFunction() {
		return new ArrayList<>();
	}

	public List<FoundElement> new_ArrayList__FoundElement() {
		return new ArrayList<>();
	}

	public Map<IdentTableEntry, OnType> new_HashMap__IdentTableEntry() {
		return new HashMap<>();
	}

	public List<State> new_ArrayList__State() {
		return new ArrayList<>();
	}

	public List<DE3_Active> new_ArrayList__DE3_Active() {
		return new ArrayList<>();
	}

	public List<IFunctionMapHook> new_ArrayList__IFunctionMapHook() {
		return new ArrayList<>();
	}

	public List<DeferredMember> new_ArrayList__DeferredMember() {
		return new ArrayList<>();
	}

	public DeducePhase.DRS new_DRS() {
		return new DeducePhase.DRS();
	}

	public DeducePhase.WAITS new_WAITS() {
		return new DeducePhase.WAITS();
	}

	public ICodeRegistrar new_DefaultCodeRegistrar(final Compilation aCompilation) {
		return new DefaultCodeRegistrar(aCompilation);
	}

	public ElLog new_ElLog(final String aS, final ElLog.Verbosity aVerbosity, final String aDeducePhase) {
		return new ElLog(aS, aVerbosity, aDeducePhase);
	}

	public List<EvaNode> new_ArrayList__EvaNode() {
		return new ArrayList<>();
	}

	public Diagnostic new_CouldntGenerateClass(final ClassDefinition aCd, final GenerateFunctions aGf, final ClassInvocation aCi) {
		return new CouldntGenerateClass(aCd, aGf, aCi);
	}

	public FunctionInvocation new_FunctionInvocation(final FunctionDef aF, final ProcTableEntry aO, final IInvocation aCi, final GeneratePhase aGeneratePhase) {
		return new FunctionInvocation(aF, aO, aCi, aGeneratePhase);
	}

	public DeducePhase.DeferredMemberFunctionParentIsClassStatement new_DeferredMemberFunctionParentIsClassStatement(final DeferredMemberFunction aDeferredMemberFunction, final IInvocation aInvocation, final DeducePhase aDeducePhase) {
		return aDeducePhase.new DeferredMemberFunctionParentIsClassStatement(aDeferredMemberFunction, aInvocation);
	}

	public NamespaceInvocation new_NamespaceInvocation(final NamespaceStatement aParent) {
		return new NamespaceInvocation(aParent);
	}

	public GenType new_GenTypeImpl() {
		return new GenTypeImpl();
	}

	public @NotNull ClassInvocation new_ClassInvocation(final ClassStatement aParent, final String aConstructorName, final @NotNull Supplier<DeduceTypes2> aDeduceTypes2Supplier) {
		return new ClassInvocation(aParent, aConstructorName, aDeduceTypes2Supplier);
	}

	public RegisterClassInvocation new_RegisterClassInvocation(final DeducePhase aDeducePhase) {
		return new RegisterClassInvocation(aDeducePhase);
	}

	public ResolvedVariables new_ResolvedVariables(final IdentTableEntry aIdentTableEntry, final OS_Element aParent, final String aVarName) {
		return new ResolvedVariables(aIdentTableEntry, aParent, aVarName);
	}

	public List<IEvaClass> new_ArrayList__EvaClass() {
		return new ArrayList<>();
	}

	public Function<EvaNode, Map<FunctionDef, EvaFunction>> new_GetFunctionMapNamespace() {
		return new DeducePhase.DeferredMemberFunctionParentIsClassStatement.GetFunctionMapNamespace();
	}

	public Function<EvaNode, Map<FunctionDef, EvaFunction>> new_GetFunctionMapClass() {
		return new DeducePhase.DeferredMemberFunctionParentIsClassStatement.GetFunctionMapClass();
	}

	public List<EvaNode> new_ArrayList__EvaNode(final List<EvaNode> aGeneratedClasses) {
		return new ArrayList<>(aGeneratedClasses);
	}

	public WorkList new_WorkList() {
		return new WorkList();
	}

	public WorkJob new_WlGenerateClass(final GenerateFunctions aGenerateFunctions, final ClassInvocation aClassInvocation, final DeducePhase.GeneratedClasses aGeneratedClasses, final ICodeRegistrar aCodeRegistrar, final RegisterClassInvocation_env aEnv) {
		return new WlGenerateClass(aGenerateFunctions, aClassInvocation, aGeneratedClasses, aCodeRegistrar, aEnv);
	}
}
