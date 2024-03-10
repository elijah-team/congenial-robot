package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_generic.*;
import tripleo.elijah.world.i.LivingClass;

import java.util.List;
import java.util.function.Function;

public interface IEvaClass extends DependencyTracker, EvaContainer, IDependencyReferent, GNCoded, IREvaClass {
	void addAccessNotation(AccessNotation an);

	void addConstructor(ConstructorDef aConstructorDef, @NotNull EvaConstructor aGeneratedFunction);

	void createCtor0();

	void fixupUserClasses(@NotNull DeduceTypes2 aDeduceTypes2, Context aContext);

	void generateCode(GenerateResultEnv aFileGen, @NotNull CodeGenerator aCodeGenerator);

	@Override
	OS_Element getElement();

	@Override
	ClassStatement getKlass();

	@NotNull String getName();

	@NotNull String getNumberedName();

	default boolean getPragma(String auto_construct) { // TODO this should be part of ContextImpl
		return false;
	}

	//@Override
	//@NotNull Role getRole();

	@Override
	void register(@NotNull ICodeRegistrar aCr);

	@Override
	String identityString();

	@Override
	OS_Module module();

	boolean isGeneric();

	boolean resolve_var_table_entries(@NotNull DeducePhase aDeducePhase);

	void addDependentFunction(FunctionInvocation aDependentFunction);

	EvaNode getFunction(FunctionDef aFunctionDef);

	void addFunction(FunctionDef aFunctionDef, EvaFunction aGf);

	List<VarTableEntry> varTable();

	EvaFunction functionMapGet(FunctionDef aFunctionDef);

	void functionMapDeferred(final FunctionDef aFunctionDef, final FunctionMapDeferred aFunctionMapDeferred);

	void addDependentType(GenType aGenType);

	void putConstructor(ConstructorDef aCd, EvaConstructor aGf);

	@Override
	void setLiving(LivingClass aLiving);

	void singleGenerate(Class<?> aKey, Function<Void, Boolean> f);

	ClassInvocation _ci();
}
