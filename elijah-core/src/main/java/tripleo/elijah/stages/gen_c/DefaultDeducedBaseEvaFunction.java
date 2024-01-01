package tripleo.elijah.stages.gen_c;

import io.reactivex.rxjava3.subjects.Subject;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.Eventual;
import tripleo.elijah.ci.LibraryStatementPart;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.DeduceElement;
import tripleo.elijah.stages.deduce.FunctionInvocation;
import tripleo.elijah.stages.deduce.OnGenClass;
import tripleo.elijah.stages.deduce.nextgen.DR_Ident;
import tripleo.elijah.stages.deduce.nextgen.DR_ProcCall;
import tripleo.elijah.stages.deduce.nextgen.DR_Type;
import tripleo.elijah.stages.deduce.nextgen.DR_Variable;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.gen_generic.Dependency;
import tripleo.elijah.stages.gen_generic.GenerateResultEnv;
import tripleo.elijah.stages.instructions.*;
import tripleo.util.range.Range;

import java.util.List;
import java.util.Map;

public class DefaultDeducedBaseEvaFunction implements DeducedBaseEvaFunction {
	private final BaseEvaFunction carrier;

	public DefaultDeducedBaseEvaFunction(final BaseEvaFunction aEvaFunction) {
		carrier = aEvaFunction;
	}

	public void addDependentFunction(@NonNull final FunctionInvocation aFunction) {
		carrier.addDependentFunction(aFunction);
	}

	public void addDependentType(@NonNull final GenType aType) {
		carrier.addDependentType(aType);
	}

	public @NonNull List<FunctionInvocation> dependentFunctions() {
		return carrier.dependentFunctions();
	}

	public Subject<FunctionInvocation> dependentFunctionSubject() {
		return carrier.dependentFunctionSubject();
	}

	public @NonNull List<GenType> dependentTypes() {
		return carrier.dependentTypes();
	}

	public Subject<GenType> dependentTypesSubject() {
		return carrier.dependentTypesSubject();
	}

	public void noteDependencies(final @NonNull Dependency d) {
		carrier.noteDependencies(d);
	}

	public @NonNull DT_Resolvabley _getIdentIAResolvable(final @NonNull IdentIA aIdentIA) {
		return carrier._getIdentIAResolvable(aIdentIA);
	}

	@Override
	public int add(final InstructionName aName, final List<InstructionArgument> args_, final Context ctx) {
		return carrier.add(aName, args_, ctx);
	}

	@Override
	public void addContext(final Context context, final Range r) {
		carrier.addContext(context, r);
	}

	@Override
	public void addElement(final OS_Element aElement, final DeduceElement aDeduceElement) {
		carrier.addElement(aElement, aDeduceElement);
	}

	@Override
	public int addIdentTableEntry(final IdentExpression ident, final Context context) {
		return carrier.addIdentTableEntry(ident, context);
	}

	@Override
	public @NonNull Label addLabel() {
		return carrier.addLabel();
	}

	@Override
	public @NonNull Label addLabel(final String base_name, final boolean append_int) {
		return carrier.addLabel(base_name, append_int);
	}

	@Override
	public int addVariableTableEntry(final String name, final VariableTableType vtt, final TypeTableEntry type, final OS_Element el) {
		return carrier.addVariableTableEntry(name, vtt, type, el);
	}

	public @NonNull DR_Type buildDrTypeFromNonGenericTypeName(final TypeName aNonGenericTypeName) {
		return carrier.buildDrTypeFromNonGenericTypeName(aNonGenericTypeName);
	}

	public Map<OS_Element, DeduceElement> elements() {
		return carrier.elements();
	}

	@Override
	public String expectationString() {
		return carrier.expectationString();
	}

	@Override
	public @Nullable Label findLabel(final int index) {
		return carrier.findLabel(index);
	}

	@Override
	public @NonNull InstructionArgument get_assignment_path(final @NonNull IExpression expression, final @NonNull GenerateFunctions generateFunctions, final @NonNull Context context) {
		return carrier.get_assignment_path(expression, generateFunctions, context);
	}

	@Override
	public int getCode() {
		return carrier.getCode();
	}

	@Override
	public @NonNull ConstantTableEntry getConstTableEntry(final int index) {
		return carrier.getConstTableEntry(index);
	}

	@Override
	public Context getContextFromPC(final int pc) {
		return carrier.getContextFromPC(pc);
	}

	@Override
	public @NonNull Dependency getDependency() {
		return carrier.getDependency();
	}

	@Override
	public @NonNull String getFunctionName() {
		return carrier.getFunctionName();
	}

	@Override
	public EvaNode getGenClass() {
		return carrier.getGenClass();
	}

	public @NonNull DR_Ident getIdent(final IdentExpression aIdent, final VariableTableEntry aVteBl1) {
		return carrier.getIdent(aIdent, aVteBl1);
	}

	public @NonNull DR_Ident getIdent(final @NonNull IdentTableEntry aIdentTableEntry) {
		return carrier.getIdent(aIdentTableEntry);
	}

	public @NonNull DR_Ident getIdent(final VariableTableEntry aVteBl1) {
		return carrier.getIdent(aVteBl1);
	}

	@Override
	public @NonNull String getIdentIAPathNormal(final @NonNull IdentIA ia2) {
		return carrier.getIdentIAPathNormal(ia2);
	}

	@Override
	public @NonNull IdentTableEntry getIdentTableEntry(final int index) {
		return carrier.getIdentTableEntry(index);
	}

	@Override
	public @Nullable IdentTableEntry getIdentTableEntryFor(final @NonNull IExpression expression) {
		return carrier.getIdentTableEntryFor(expression);
	}

	@Override
	public Instruction getInstruction(final int anIndex) {
		return carrier.getInstruction(anIndex);
	}

	@Override
	public EvaContainerNC getParent() {
		return carrier.getParent();
	}

	public @NonNull DR_ProcCall getProcCall(final IExpression aZ, final ProcTableEntry aPte) {
		return carrier.getProcCall(aZ, aPte);
	}

	@Override
	public @NonNull ProcTableEntry getProcTableEntry(final int index) {
		return carrier.getProcTableEntry(index);
	}

	@Override
	public @NonNull TypeTableEntry getTypeTableEntry(final int index) {
		return carrier.getTypeTableEntry(index);
	}

	public @NonNull DR_Variable getVar(final VariableStatement aElement) {
		return carrier.getVar(aElement);
	}

	@Override
	public @NonNull VariableTableEntry getVarTableEntry(final int index) {
		return carrier.getVarTableEntry(index);
	}

	@Override
	public @NonNull List<Instruction> instructions() {
		return carrier.instructions();
	}

	@Override
	public @NonNull List<Label> labels() {
		return carrier.labels();
	}

	@Override
	public @NonNull TypeTableEntry newTypeTableEntry(final TypeTableEntry.@NonNull Type type1, final OS_Type type) {
		return carrier.newTypeTableEntry(type1, type);
	}

	@Override
	public @NonNull TypeTableEntry newTypeTableEntry(final TypeTableEntry.@NonNull Type type1, final OS_Type type, final IExpression expression) {
		return carrier.newTypeTableEntry(type1, type, expression);
	}

	@Override
	public @NonNull TypeTableEntry newTypeTableEntry(final TypeTableEntry.@NonNull Type type1,
													 final OS_Type type,
													 final IExpression expression,
													 final TableEntryIV aTableEntryIV) {
		return carrier.newTypeTableEntry(type1, type, expression, aTableEntryIV);
	}

	@Override
	public @NonNull TypeTableEntry newTypeTableEntry(final TypeTableEntry.@NonNull Type type1,
													 final OS_Type type,
													 final TableEntryIV aTableEntryIV) {
		return carrier.newTypeTableEntry(type1, type, aTableEntryIV);
	}

	@Override
	public int nextTemp() {
		return carrier.nextTemp();
	}

	@Override
	public void onGenClass(final @NonNull OnGenClass aOnGenClass) {
		carrier.onGenClass(aOnGenClass);
	}

	@Override
	public void place(final @NonNull Label label) {
		carrier.place(label);
	}

	@Override
	public BaseEvaFunction.@NonNull __Reactive reactive() {
		return carrier.reactive();
	}

	@Override
	public IEvaFunctionBase getCarrier() {
		return carrier;
	}

	@Override
	public OS_Module getModule__() {
		return carrier.module();
	}

	@Override
	public WhyNotGarish_Function getWhyNotGarishFunction(final @NonNull GenerateC aGc) {
		return aGc.a_lookup(carrier);
	}

	@Override
	public void resolveTypeDeferred(final @NonNull GenType aType) {
		carrier.resolveTypeDeferred(aType);
	}

	@Override
	public void setClass(@NonNull final EvaNode aNode) {
		carrier.setClass(aNode);
	}

	@Override
	public void setCode(final int aCode) {
		carrier.setCode(aCode);
	}

	@Override
	public void setParent(final EvaContainerNC aGeneratedContainerNC) {
		carrier.setParent(aGeneratedContainerNC);
	}

	@Override
	public Eventual<GenType> typeDeferred() {
		return carrier.typeDeferred();
	}

	@Override
	public Eventual<GenType> typePromise() {
		return carrier.typePromise();
	}

	@Override
	public void generateCodeForMethod(final Generate_Code_For_Method aGcfm, final GenerateResultEnv aFileGen) {
		aGcfm.generateCodeForMethod(this, aFileGen);
	}

	@Override
	public LibraryStatementPart evaLayer_module_lsp() {
		return ((EvaNode) getCarrier()).module().getLsp();
	}

	@Override
	public EvaNode getEvaNodeEscapeHatch() {

		// FIXME 12/21 Is this correct??
		return new EvaNode() {
			@Override
			public String identityString() {
				return identityString();
			}

			@Override
			public OS_Module module() {
				return getModule__();
			}
		};
	}

	@Override
	public @Nullable InstructionArgument vte_lookup(final String text) {
		return carrier.vte_lookup(text);
	}

	public String identityString() {
		return carrier.identityString();
	}

	public OS_Module module() {
		return carrier.module();
	}

	@Override
	public @NonNull FunctionDef getFD() {
		return carrier.getFD();
	}

	@Override
	public @Nullable VariableTableEntry getSelf() {
		return carrier.getSelf();
	}
}
