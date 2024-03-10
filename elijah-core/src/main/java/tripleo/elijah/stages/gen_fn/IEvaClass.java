package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang.nextgen.names.i.EN_Understanding;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.deduce.FunctionInvocation;
import tripleo.elijah.stages.deduce.FunctionMapDeferred;
import tripleo.elijah.stages.garish.GarishClass;
import tripleo.elijah.stages.gen_generic.CodeGenerator;
import tripleo.elijah.stages.gen_generic.GenerateResultEnv;
import tripleo.elijah.stages.gen_generic.ICodeRegistrar;
import tripleo.elijah.stages.gen_generic.IDependencyReferent;
import tripleo.elijah.world.i.LivingClass;
import tripleo.elijah.world.impl.DefaultLivingClass;

import java.util.List;
import java.util.function.Function;

public interface IEvaClass extends DependencyTracker, EvaContainer, IDependencyReferent, GNCoded {
	void addAccessNotation(AccessNotation an);

	void addConstructor(ConstructorDef aConstructorDef, @NotNull EvaConstructor aGeneratedFunction);

	void createCtor0();

	void fixupUserClasses(@NotNull DeduceTypes2 aDeduceTypes2, Context aContext);

	void generateCode(GenerateResultEnv aFileGen, @NotNull CodeGenerator aCodeGenerator);

	@Override
	OS_Element getElement();

	ClassStatement getKlass();

	@NotNull String getName();

	@NotNull String getNumberedName();

	default boolean getPragma(String auto_construct) { // TODO this should be part of ContextImpl
		return false;
	}

	@Override
	@NotNull Role getRole();

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

	void setLiving(LivingClass aLiving);

	void singleGenerate(Class<?> aKey, Function<Void, Boolean> f);
}
