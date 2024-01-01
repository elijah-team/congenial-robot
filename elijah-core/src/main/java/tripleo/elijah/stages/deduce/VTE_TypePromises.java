/* -*- Mode: Java; tab-width: 4; indent-tabs-mode: t; c-basic-offset: 4 -*- */
/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce;

import org.jdeferred2.DoneCallback;
import org.jdeferred2.Promise;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.Finally;
import tripleo.elijah.lang.i.Context;
import tripleo.elijah.lang.i.FunctionDef;
import tripleo.elijah.lang.i.OS_Type;
import tripleo.elijah.lang.i.VariableStatement;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.IntegerIA;
import tripleo.elijah.util.SimplePrintLoggerToRemoveSoon;

import java.util.Objects;

/**
 * Created 11/27/21 12:51 PM
 */
public enum VTE_TypePromises {
	;

	// region ProcTableListener

	public static @NonNull Promise<GenType, Void, Void> do_assign_call_args_ident_vte_promise(final @NonNull TypeTableEntry aTte, final @NonNull VariableTableEntry aVte1) {
		final Promise<GenType, Void, Void> p = aVte1.typePromise();
		p.done(new DoneCallback<GenType>() {
			@Override
			public void onDone(GenType result) {
//					assert vte != vte1;
//					aTte.setAttached(result.resolved != null ? result.resolved : result.typeName);
				aTte.genType.copy(result);
//					vte.addPotentialType(aInstructionIndex, result); // TODO!!
			}
		});
		return p;
	}

	static void dunder(final @NonNull String pn, final @NonNull IntegerIA aIntegerIA, final @NonNull ProcTableEntry pte, final @NonNull DeduceTypes2 aDeduceTypes2) {
		aIntegerIA.getEntry().typePromise().then(new DoneCallback<GenType>() {
			@Override
			public void onDone(@NonNull GenType result) {
				boolean found1 = aDeduceTypes2.lookup_name_calls(result.getResolved().getClassOf().getContext(), pn, pte);
				if (found1) {
					int y = 2;
//					tripleo.elijah.util.Stupidity.println_out_2("3071 "+pte.getStatus());
					IInvocation invocation = result.getCi();
//							final BaseFunctionDef fd = gf.getFD();
					final FunctionDef fd = pte.getFunctionInvocation().getFunction();
					if (pte.getFunctionInvocation() == null) {
						@NonNull FunctionInvocation fi = aDeduceTypes2.newFunctionInvocation(fd, pte, invocation, aDeduceTypes2.phase);
						pte.setFunctionInvocation(fi);
					} else
						SimplePrintLoggerToRemoveSoon.println_out_2("175 pte.fi is not null");
					aIntegerIA.gf.addDependentFunction(pte.getFunctionInvocation()); // TODO is this needed (here)?
				} else {
					int y = 3;
					SimplePrintLoggerToRemoveSoon.println_out_2("3074");
				}
			}
		});
	}

	static void found_parent(final @NonNull DeduceTypes2.PromiseExpectation<GenType> aPromiseExpectation,
							 final @NonNull BaseEvaFunction generatedFunction,
							 final @NonNull VariableTableEntry aBte,
							 final @NonNull IdentTableEntry ite,
							 final @NonNull DeduceTypes2 aDeduceTypes2) {
		aBte.typePromise().done(new DoneCallback<GenType>() {
			@Override
			public void onDone(@NonNull GenType result) {
				aPromiseExpectation.satisfy(result);
				final OS_Type attached1 = result.getResolved() != null ? result.getResolved() : result.getTypeName();
				if (attached1 != null) {
					switch (attached1.getType()) {
					case USER_CLASS:
						if (ite.type == null) {
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");
							SimplePrintLoggerToRemoveSoon.println_err_2("198 ======================================================");

							break;
						}
						if (ite.type.getAttached() == null)
							ite.makeType(generatedFunction, TypeTableEntry.Type.TRANSIENT, attached1);
						else {
							aDeduceTypes2.LOG.err(String.format("3603 Trying to set %s to %s", ite.type.getAttached(), attached1));
						}
						break;
					case USER:
						try {
							@NonNull GenType ty3 = aDeduceTypes2.resolve_type(attached1, attached1.getTypeName().getContext());
							// no expression or TableEntryIV below
							@NonNull TypeTableEntry tte4 = generatedFunction.newTypeTableEntry(TypeTableEntry.Type.TRANSIENT, null);
							// README trying to keep genType up to date
							tte4.setAttached(attached1);
							tte4.setAttached(ty3);
							ite.type = tte4; // or ty2?
						} catch (ResolveError aResolveError) {
							aResolveError.printStackTrace();
						}
						break;
					}
				}
			}
		});
	}

	// endregion ProcTableListener

	// region DeduceTypes2

	public static void getItemFali(final @NonNull BaseEvaFunction generatedFunction,
								   final @NonNull Context ctx,
								   final @NonNull VariableTableEntry aVte2,
								   final @NonNull DeduceTypes2 aDeduceTypes2) {
		aVte2.typePromise().done(new DoneCallback<GenType>() {
			@Override
			public void onDone(@NonNull GenType result) {

				aVte2.getDeduceElement3().getItemFali(ctx, aDeduceTypes2, result);

			}
		});
	}

	static void resolved_element_pte(final Constructable co,
									 final ProcTableEntry pte,
									 final AbstractDependencyTracker depTracker,
									 final @NonNull FunctionDef fd,
									 final @NonNull VariableTableEntry aVariableTableEntry,
									 final @NonNull ProcTableListener aProcTableListener) {
		aVariableTableEntry.typePromise().then(new DoneCallback<GenType>() {
			@Override
			public void onDone(@NonNull GenType result) {
				//assert result.resolved.getClassOf() == fd.getParent();
				if (result.getResolved().getClassOf() != fd.getParent()) {

					final Compilation c = fd.getContext().compilation();
					if (c.reports().outputOn(Finally.Outs.Out_EVTE_159)) {
						System.err.println("EVTE-159 violation (likely String vs ConstString)");
					}

				}

				final GenType genType1 = aVariableTableEntry.getType().genType;

				if (genType1 instanceof ForwardingGenType fgt)
					fgt.unsparkled();

				@NonNull ProcTableListener.E_Is_FunctionDef e_Is_FunctionDef = aProcTableListener.new E_Is_FunctionDef(
						pte, fd, fd.getParent()).invoke(genType1.getNonGenericTypeName());
				@Nullable FunctionInvocation fi      = e_Is_FunctionDef.getFi();
				GenType                      genType = e_Is_FunctionDef.getGenType();
				aProcTableListener.finish(co, depTracker, fi, genType);
			}
		});
	}

	// endregion DeduceTypes2

	static void resolved_element_pte_VariableStatement(final Constructable co,
													   final AbstractDependencyTracker depTracker,
													   final @NonNull FunctionDef fd,
													   final @NonNull VariableStatement variableStatement,
													   final @NonNull ProcTableEntry aProcTableEntry,
													   final @NonNull ClassInvocation aCi,
													   final @NonNull ProcTableListener aProcTableListener) {
		aCi.resolvePromise().done(new DoneCallback<EvaClass>() {
			@Override
			public void onDone(final @NonNull EvaClass result) {
				for (EvaContainer.VarTableEntry varTableEntry : result.varTable) {
					if (varTableEntry.nameToken.getText().equals(variableStatement.getName())) {
						assert varTableEntry.varType.getClassOf() == fd.getParent();

						@NonNull ProcTableListener.E_Is_FunctionDef e_Is_FunctionDef = aProcTableListener.new E_Is_FunctionDef(aProcTableEntry, fd, fd.getParent()).invoke(null/*variableTableEntry.type.genType.nonGenericTypeName*/);
						@Nullable FunctionInvocation                fi1              = e_Is_FunctionDef.getFi();
						GenType                                     genType1         = e_Is_FunctionDef.getGenType();
						aProcTableListener.finish(co, depTracker, fi1, genType1);

						break;
					}
				}
			}
		});
	}

	static void resolved_element_pte_VariableStatement2(final Constructable co,
														final AbstractDependencyTracker depTracker,
														final ProcTableEntry pte,
														final @NonNull FunctionDef fd,
														final @NonNull VariableTableEntry aVariableTableEntry,
														final @NonNull ProcTableListener aProcTableListener) {
		aVariableTableEntry.typePromise().then(new DoneCallback<GenType>() {
			@Override
			public void onDone(@NonNull GenType result) {
				if (result.getResolved().getClassOf() != fd.getParent()) {
					SimplePrintLoggerToRemoveSoon.println_err_2("** Failed assertion");
				}

				@NonNull ProcTableListener.E_Is_FunctionDef e_Is_FunctionDef = aProcTableListener.new E_Is_FunctionDef(pte, fd, fd.getParent()).invoke(aVariableTableEntry.getType().genType.getNonGenericTypeName());
				@Nullable FunctionInvocation                fi               = e_Is_FunctionDef.getFi();
				GenType                                     genType          = e_Is_FunctionDef.getGenType();
				aProcTableListener.finish(co, depTracker, Objects.requireNonNull(fi), genType);
			}
		});
	}
}

//
// vim:set shiftwidth=4 softtabstop=0 noexpandtab:
//
