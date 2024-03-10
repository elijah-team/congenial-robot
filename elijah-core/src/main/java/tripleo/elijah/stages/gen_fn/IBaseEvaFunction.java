package tripleo.elijah.stages.gen_fn;

import io.reactivex.rxjava3.subjects.Subject;
import org.jdeferred2.DoneCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.deduce.nextgen.DR_Ident;
import tripleo.elijah.stages.deduce.nextgen.DR_ProcCall;
import tripleo.elijah.stages.deduce.nextgen.DR_Type;
import tripleo.elijah.stages.deduce.nextgen.DR_Variable;
import tripleo.elijah.stages.gen_generic.Dependency;
import tripleo.elijah.stages.gen_generic.IDependencyReferent;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.util.Eventual;
import tripleo.elijah.world.i.LF_CodeRegistration;
import tripleo.elijah.world.i.LivingFunction;
import tripleo.util.range.Range;

import java.util.List;
import java.util.Map;

public interface IBaseEvaFunction extends DependencyTracker, EvaNode, DeduceTypes2.ExpectationBase, IDependencyReferent, IEvaFunctionBase {
	@Override
	int add(InstructionName aName, List<InstructionArgument> args_, Context ctx);

	@Override
	void addContext(Context context, Range r);

	@Override
	void addElement(OS_Element aElement, DeduceElement aDeduceElement);

	@Override
	int addIdentTableEntry(IdentExpression ident, Context context);

	@Override
	@NotNull Label addLabel();

	@Override
	@NotNull Label addLabel(String base_name, boolean append_int);

	@Override
	int addVariableTableEntry(String name, VariableTableType vtt, TypeTableEntry type, OS_Element el);

	@Override
	@Nullable Label findLabel(int index);

	@Override
	@NotNull InstructionArgument get_assignment_path(@NotNull IExpression expression,
													 @NotNull GenerateFunctions generateFunctions,
													 @NotNull Context context);

	@Override
	int getCode();

	@Override
	@NotNull ConstantTableEntry getConstTableEntry(int index);

	@Override
	Context getContextFromPC(int pc);

	@Override
	@NotNull Dependency getDependency();

	@Override
	@NotNull String getFunctionName();

	@Override
	EvaNode getGenClass();

	@Override
	@NotNull String getIdentIAPathNormal(@NotNull IdentIA ia2);

	@Override
	@NotNull IdentTableEntry getIdentTableEntry(int index);

	@Override
	@Nullable IdentTableEntry getIdentTableEntryFor(@NotNull IExpression expression);

	@Override
	Instruction getInstruction(int anIndex);

	@Override
	EvaContainerNC getParent();

	@Override
	@NotNull ProcTableEntry getProcTableEntry(int index);

	@Override
	@NotNull TypeTableEntry getTypeTableEntry(int index);

	@Override
	@NotNull VariableTableEntry getVarTableEntry(int index);

	@Override
	@NotNull List<Instruction> instructions();

	@Override
	@NotNull List<Label> labels();

	@Override
	@NotNull TypeTableEntry newTypeTableEntry(TypeTableEntry.@NotNull Type type1, OS_Type type);

	@Override
	@NotNull TypeTableEntry newTypeTableEntry(TypeTableEntry.@NotNull Type type1, OS_Type type, IExpression expression);

	@Override
	@NotNull TypeTableEntry newTypeTableEntry(TypeTableEntry.@NotNull Type type1, OS_Type type, IExpression expression, TableEntryIV aTableEntryIV);

	@Override
	@NotNull TypeTableEntry newTypeTableEntry(TypeTableEntry.@NotNull Type type1, OS_Type type, TableEntryIV aTableEntryIV);

	@Override
	int nextTemp();

	@Override
	void place(@NotNull Label label);

	@Override
	void resolveTypeDeferred(@NotNull GenType aType);

	@Override
	void setClass(@NotNull EvaNode aNode);

	@Override
	void setParent(EvaContainerNC aGeneratedContainerNC);

	@Override
	@Nullable InstructionArgument vte_lookup(String text);

	@Override
	void setCode(int aCode);

	Eventual<GenType> typeDeferred();

	Eventual<GenType> typePromise();

	Map<OS_Element, DeduceElement> elements();

	@Override
	String expectationString();

	@NotNull DT_Resolvabley _getIdentIAResolvable(@NotNull IdentIA aIdentIA);

	/*
	 * Hook in for GeneratedClass
	 */
	void onGenClass(@NotNull OnGenClass aOnGenClass);

	@NotNull BaseEvaFunction.__Reactive reactive();

	@NotNull DR_Ident getIdent(IdentExpression aIdent, VariableTableEntry aVteBl1);

	@NotNull DR_Ident getIdent(@NotNull IdentTableEntry aIdentTableEntry);

	@NotNull DR_Ident getIdent(VariableTableEntry aVteBl1);

	@NotNull DR_ProcCall getProcCall(IExpression aZ, ProcTableEntry aPte);

	@NotNull DR_Variable getVar(VariableStatement aElement);

	@NotNull DR_Type buildDrTypeFromNonGenericTypeName(TypeName aNonGenericTypeName);

	void _informGF(GenerateFunctions aGenerateFunctions);

	void onInformGF(DoneCallback<GenerateFunctions> sgf);

	void monitorRequest_IdentTableEntry(@NotNull MonitorRequest_IdentTableEntry aMr);

	void setLiving(LivingFunction aLiving);

	boolean hasLiving();

	void setLiving_codeRegistration(LF_CodeRegistration aCodeRegistration);

	void addDependentFunction(FunctionInvocation aFunctionInvocation);

	void addDependentType(GenType aGenType);

	List<ProcTableEntry> _prte_list();

	List<IdentTableEntry> _idte_list();
	List<TypeTableEntry> _tte_list();
	List<VariableTableEntry> _vte_list();

	FunctionInvocation _fi();

	boolean _deducedAlready();

	void setDeducedAlready();

	void addDr(DR_Ident aDrIdent);

	boolean deferred_calls_contains(int aPc);

	List<ConstantTableEntry> _cte_list();

	Subject<GenType> dependentTypesSubject();

	Subject<FunctionInvocation> dependentFunctionSubject();

	AddDrsSource getAddDrsSource();

	void add_deferred_call(int aI);

	Iterable<? extends Integer> _deferred_calls();

	@Nullable DependencyTracker getDepTracker();

	List<FunctionInvocation> dependentFunctions();

	List<GenType> dependentTypes();

	void noteDependencies(Dependency aD);
}
