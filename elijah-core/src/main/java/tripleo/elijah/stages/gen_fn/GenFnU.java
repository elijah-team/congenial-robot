package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.lang.i.OS_Element;
import tripleo.elijah.lang.i.OS_Type;
import tripleo.elijah.lang.i.TypeName;
import tripleo.elijah.lang.types.OS_UnknownType;
import tripleo.elijah.stages.deduce.FunctionInvocation;
import tripleo.elijah.stages.instructions.IdentIA;
import tripleo.elijah.stages.instructions.InstructionArgument;
import tripleo.elijah.stages.instructions.IntegerIA;
import tripleo.elijah.stages.instructions.ProcIA;
import tripleo.elijah.util.Helpers;
import tripleo.elijah.util.SimplePrintLoggerToRemoveSoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public enum GenFnU {
	;

	@NotNull
	public static String getNameHelper(@NotNull Map<TypeName, OS_Type> aGenericPart) {
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

	public static void printTables(@NotNull EvaFunction gf) {
		SimplePrintLoggerToRemoveSoon.println_out_2("VariableTable ");
		for (VariableTableEntry variableTableEntry : gf.vte_list) {
			SimplePrintLoggerToRemoveSoon.println_out_2("\t" + variableTableEntry);
		}
		SimplePrintLoggerToRemoveSoon.println_out_2("ConstantTable ");
		for (ConstantTableEntry constantTableEntry : gf.cte_list) {
			SimplePrintLoggerToRemoveSoon.println_out_2("\t" + constantTableEntry);
		}
		SimplePrintLoggerToRemoveSoon.println_out_2("ProcTable     ");
		for (ProcTableEntry procTableEntry : gf.prte_list) {
			SimplePrintLoggerToRemoveSoon.println_out_2("\t" + procTableEntry);
		}
		SimplePrintLoggerToRemoveSoon.println_out_2("TypeTable     ");
		for (TypeTableEntry typeTableEntry : gf.tte_list) {
			SimplePrintLoggerToRemoveSoon.println_out_2("\t" + typeTableEntry);
		}
		SimplePrintLoggerToRemoveSoon.println_out_2("IdentTable    ");
		for (IdentTableEntry identTableEntry : gf.idte_list) {
			SimplePrintLoggerToRemoveSoon.println_out_2("\t" + identTableEntry);
		}
	}

	public static @NotNull List<InstructionArgument> _getIdentIAPathList(@NotNull InstructionArgument oo) {
		LinkedList<InstructionArgument> s = new LinkedList<InstructionArgument>();
		while (oo != null) {
			if (oo instanceof IntegerIA) {
				s.addFirst(oo);
				oo = null;
			} else if (oo instanceof IdentIA) {
				final IdentTableEntry ite1 = ((IdentIA) oo).getEntry();
				s.addFirst(oo);
				oo = ite1.getBacklink();
			} else if (oo instanceof ProcIA) {
				s.addFirst(oo);
				oo = null;
			} else
				throw new IllegalStateException("Invalid InstructionArgument");
		}
		return s;
	}

	public static @NotNull List<DT_Resolvable> _getIdentIAResolvableList(@NotNull InstructionArgument oo) {
		LinkedList<DT_Resolvable> R = new LinkedList<>();
		while (oo != null) {
			if (oo instanceof IntegerIA integerIA) {
				@NotNull final VariableTableEntry vte = integerIA.getEntry();

				if (vte._vs == null) {
					if (vte.get_p_elementPromise().isResolved()) {
						final @NotNull InstructionArgument finalOo = oo;
						vte.get_p_elementPromise().then(el1 -> R.addFirst(DT_Resolvable.from(finalOo, el1, null)));
					} else {
						R.addFirst(DT_Resolvable.from(oo, null, null));
					}
				} else {
					R.addFirst(DT_Resolvable.from(oo, vte._vs, null));
				}
				oo = null;
			} else if (oo instanceof final IdentIA identIA) {
				final IdentTableEntry ite1 = identIA.getEntry();

				final OS_Element[] el = {null};
				ite1.elementPromise((el1) -> el[0] = el1, null);
				//ite1._p_resolvedElementPromise.then(el1 -> el[0] = el1);

				//assert el[0] != null;

				FunctionInvocation cfi = null;
				if (ite1._callable_pte() != null) {
					var cpte = ite1._callable_pte();
					if (cpte.getFunctionInvocation() != null) {
						cfi = cpte.getFunctionInvocation();
					}
				}

				//assert cfi != null;
				// ^^ fails for folders.forEach

				R.addFirst(DT_Resolvable.from(oo, el[0], cfi));
				oo = ite1.getBacklink();
			} else if (oo instanceof ProcIA procIA) {
				var pte = procIA.getEntry();
				assert pte != null;

				final OS_Element[] el = {null};
				pte.get_p_elementPromise().then(el1 -> el[0] = el1);

				assert el[0] != null;

				FunctionInvocation cfi = null;
				if (pte.getFunctionInvocation() != null) {
					cfi = pte.getFunctionInvocation();
				}

				assert cfi != null;

				R.addFirst(DT_Resolvable.from(oo, el[0], cfi));
				oo = null;
			} else
				throw new IllegalStateException("Invalid InstructionArgument");
		}
		return R;
	}
}
