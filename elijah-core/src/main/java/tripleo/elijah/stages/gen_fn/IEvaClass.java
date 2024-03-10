package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang.types.OS_UnknownType;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.gen_generic.CodeGenerator;
import tripleo.elijah.stages.gen_generic.GenerateResultEnv;
import tripleo.elijah.stages.gen_generic.ICodeRegistrar;
import tripleo.elijah.stages.gen_generic.IDependencyReferent;
import tripleo.elijah.util.Helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IEvaClass extends DependencyTracker, EvaContainer, IDependencyReferent, GNCoded {
	@NotNull
	static String getNameHelper(@NotNull Map<TypeName, OS_Type> aGenericPart) {
		final List<String> ls = new ArrayList<String>();
		for (Map.Entry<TypeName, OS_Type> entry : aGenericPart.entrySet()) { // TODO Is this guaranteed to be in order?
			final OS_Type value = entry.getValue(); // This can be another ClassInvocation using GenType
			final String  name;

			if (value instanceof OS_UnknownType) {
				name = "?";
			} else {
				name = value.getClassOf().getName();
			}
			ls.add(name); // TODO Could be nested generics
		}
		return Helpers.String_join(", ", ls);
	}

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
}
