package tripleo.elijah.stages.deduce;

import org.jdeferred2.DoneCallback;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.IdentIA;
import tripleo.elijah.stages.instructions.InstructionArgument;
import tripleo.elijah.stages.instructions.IntegerIA;
import tripleo.elijah.util.NotImplementedException;
import tripleo.elijah.util.SimplePrintLoggerToRemoveSoon;

public class __Add_Proc_Table_Listeners {
	void add_proc_table_listeners(final @NonNull BaseEvaFunction generatedFunction, final @NonNull ProcTableEntry pte, final DeduceTypes2 aDeduceTypes2) {
		pte.addStatusListener(aDeduceTypes2._inj().new_ProcTableListener(pte, generatedFunction, aDeduceTypes2._inj().new_DeduceClient2(aDeduceTypes2)));

		InstructionArgument en = pte.expression_num;
		if (en != null) {
			if (en instanceof final @NonNull IdentIA identIA) {
				@NonNull IdentTableEntry idte = identIA.getEntry();
				idte.addStatusListener(new SL(generatedFunction, idte, pte, identIA, aDeduceTypes2));
			} else if (en instanceof IntegerIA) {
				// TODO this code does nothing so commented out
/*
				final @NonNull IntegerIA integerIA = (IntegerIA) en;
				@NonNull VariableTableEntry vte = integerIA.getEntry();
				vte.addStatusListener(_inj().new_BaseTableEntry.StatusListener() {
					@Override
					public void onChange(IElementHolder eh, BaseTableEntry.Status newStatus) {
						if (newStatus != BaseTableEntry.Status.KNOWN)
							return;

						@NonNull VariableTableEntry vte2 = vte;

						final OS_Element el = eh.getElement();

						@NonNull ElObjectType type = DecideElObjectType.getElObjectType(el);

						switch (type) {
						case VAR:
							break;
						default:
							throw new NotImplementedException();
						}
					}
				});
*/
			} else
				throw new NotImplementedException();
		}
	}

	class SL implements BaseTableEntry.StatusListener {
		private final BaseEvaFunction generatedFunction;
		private final IdentTableEntry idte;
		private final ProcTableEntry  pte;
		private final IdentIA         identIA;
		private final DeduceTypes2    deduceTypes2;

		SL(final BaseEvaFunction aGeneratedFunction, final IdentTableEntry aIdte, final ProcTableEntry aPte, final IdentIA aIdentIA, final DeduceTypes2 aADeduceTypes2) {
			generatedFunction = aGeneratedFunction;
			idte              = aIdte;
			pte               = aPte;
			identIA           = aIdentIA;
			deduceTypes2      = aADeduceTypes2;
		}

		@Override
		public void onChange(IElementHolder eh, BaseTableEntry.Status newStatus) {
			if (newStatus != BaseTableEntry.Status.KNOWN) {
				return;
			}

			if (eh == null) {
				return;
			}

			final OS_Element el = eh.getElement();

			@NonNull ElObjectType type = DecideElObjectType.getElObjectType(el);

			switch (type) {
			case NAMESPACE:
				@NonNull GenType genType = deduceTypes2._inj().new_GenTypeImpl((NamespaceStatement) el);
				generatedFunction.addDependentType(genType);
				break;
			case CLASS:
				if (idte.type != null && idte.type.genType != null) {
					assert idte.type.genType.getResolved() != null;
					generatedFunction.addDependentType(idte.type.genType);
				} else {
					@NonNull GenType genType2 = deduceTypes2._inj().new_GenTypeImpl((ClassStatement) el);
					generatedFunction.addDependentType(genType2);
				}
				break;
			case FUNCTION:
				@Nullable IdentIA identIA2 = null;
				if (pte.expression_num instanceof IdentIA)
					identIA2 = (IdentIA) pte.expression_num;
				if (identIA2 != null) {
					@NonNull IdentTableEntry idte2          = identIA.getEntry();
					@Nullable ProcTableEntry procTableEntry = idte2.getCallablePTE();
					if (procTableEntry == pte) SimplePrintLoggerToRemoveSoon.println_err_2("940 procTableEntry == pte");
					if (procTableEntry != null) {
						// TODO doesn't seem like we need this
						procTableEntry.onFunctionInvocation(new DoneCallback<FunctionInvocation>() {

							@Override
							public void onDone(@NonNull FunctionInvocation functionInvocation) {
								ClassInvocation     ci  = functionInvocation.getClassInvocation();
								NamespaceInvocation nsi = functionInvocation.getNamespaceInvocation();
								// do we register?? probably not
								assert ci != null || nsi != null;
								@NonNull FunctionInvocation fi = deduceTypes2.newFunctionInvocation((FunctionDef) el, pte, ci != null ? ci : nsi, deduceTypes2.phase);

								{
									if (functionInvocation.getClassInvocation() == fi.getClassInvocation() &&
											functionInvocation.getFunction() == fi.getFunction() &&
											functionInvocation.pte == fi.pte)
										SimplePrintLoggerToRemoveSoon.println_err_2("955 It seems like we are generating the same thing...");
									else {
										int ok = 2;
									}

								}
								generatedFunction.addDependentFunction(fi);
							}
						});
						// END
					}
				}
				break;
			case CONSTRUCTOR:
				int y = 2;
				break;
			default:
				deduceTypes2.LOG.err(String.format("228 Don't know what to do %s %s", type, el));
				break;
			}
		}
	}
}
