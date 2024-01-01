package tripleo.elijah.stages.gen_fn;

import org.jdeferred2.Promise;
import org.jdeferred2.impl.DeferredObject;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.nextgen.reactive.Reactive;
import tripleo.elijah.stages.deduce.DeduceElement;
import tripleo.elijah.stages.gen_generic.Dependency;
import tripleo.elijah.stages.instructions.*;
import tripleo.util.range.Range;

import java.util.List;

public interface IEvaFunctionBase {
	int add(InstructionName aName, List<InstructionArgument> args_, Context ctx);

	void addContext(Context context, Range r);

	void addElement(OS_Element aElement, DeduceElement aDeduceElement);

	int addIdentTableEntry(IdentExpression ident, Context context);

	@NonNull Label addLabel();

	@NonNull Label addLabel(String base_name, boolean append_int);

	int addVariableTableEntry(String name, VariableTableType vtt, TypeTableEntry type, OS_Element el);

	String expectationString();

	@Nullable Label findLabel(int index);

	@NonNull InstructionArgument get_assignment_path(@NonNull IExpression expression,
													 @NonNull GenerateFunctions generateFunctions,
													 Context context);

	int getCode();

	@NonNull ConstantTableEntry getConstTableEntry(int index);

	Context getContextFromPC(int pc);

	Dependency getDependency();

	@NonNull FunctionDef getFD();

	String getFunctionName();

	EvaNode getGenClass();

	String getIdentIAPathNormal(IdentIA ia2);

	@NonNull IdentTableEntry getIdentTableEntry(int index);

	@Nullable IdentTableEntry getIdentTableEntryFor(IExpression expression);

	Instruction getInstruction(int anIndex);

	EvaContainerNC getParent();

	@NonNull ProcTableEntry getProcTableEntry(int index);

	@Nullable VariableTableEntry getSelf();

	@NonNull TypeTableEntry getTypeTableEntry(int index);

	@NonNull VariableTableEntry getVarTableEntry(int index);

	@NonNull List<Instruction> instructions();

	@NonNull List<Label> labels();

	@NonNull TypeTableEntry newTypeTableEntry(TypeTableEntry.Type type1, OS_Type type);

	@NonNull TypeTableEntry newTypeTableEntry(TypeTableEntry.Type type1, OS_Type type, IExpression expression);

	@NonNull TypeTableEntry newTypeTableEntry(TypeTableEntry.Type type1, OS_Type type, IExpression expression, TableEntryIV aTableEntryIV);

	@NonNull TypeTableEntry newTypeTableEntry(TypeTableEntry.Type type1, OS_Type type, TableEntryIV aTableEntryIV);

	int nextTemp();

	void place(@NonNull Label label);

	void resolveTypeDeferred(GenType aType);

	void setClass(@NonNull EvaNode aNode);

	void setCode(int aCode);

	void setParent(EvaContainerNC aGeneratedContainerNC);

	//DeferredObject<GenType, Void, Void> typeDeferred();
	//
	//Promise<GenType, Void, Void> typePromise();

	@Nullable InstructionArgument vte_lookup(String text);

	interface BaseEvaFunction_Reactive extends Reactive {}
}
