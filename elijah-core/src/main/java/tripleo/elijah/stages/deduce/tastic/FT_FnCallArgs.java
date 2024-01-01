/* -*- Mode: Java; tab-width: 4; indent-tabs-mode: t; c-basic-offset: 4 -*- */
/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce.tastic;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.ReadySupplier_1;
import tripleo.elijah.comp.i.ErrSink;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang2.BuiltInTypes;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.stages.logging.ElLog;
import tripleo.elijah.util.NotImplementedException;

import java.util.List;

import static tripleo.elijah.stages.deduce.DeduceTypes2.to_int;

public class FT_FnCallArgs implements ITastic {
	final @NonNull ElLog LOG;

	final @NonNull DeduceTypes2 deduceTypes2;
	private final  FnCallArgs   fca;

	@Override
	public void do_assign_call(final @NonNull BaseEvaFunction generatedFunction, final @NonNull Context ctx,
							   final @NonNull IdentTableEntry idte, final int instructionIndex) {
		final @NonNull ProcTableEntry pte = generatedFunction.getProcTableEntry(to_int(fca.getArg(0)));
		for (final @NonNull TypeTableEntry tte : pte.getArgs()) {
			LOG.info("771 " + tte);
			final IExpression e = tte.__debug_expression;
			if (e == null)
				continue;
			switch (e.getKind()) {
			case NUMERIC: {
				tte.setAttached(deduceTypes2._inj().new_OS_BuiltinType(BuiltInTypes.SystemInteger));
				idte.type = tte; // TODO why not addPotentialType ? see below for example
			}
			break;
			case IDENT: {
				final @Nullable InstructionArgument vte_ia = generatedFunction
						.vte_lookup(((IdentExpression) e).getText());
				final @NonNull List<TypeTableEntry> ll = deduceTypes2
						.getPotentialTypesVte((EvaFunction) generatedFunction, vte_ia);
				if (ll.size() == 1) {
					tte.setAttached(ll.get(0).getAttached());
					idte.addPotentialType(instructionIndex, ll.get(0));
				} else
					throw new NotImplementedException();
			}
			break;
			default: {
				throw new NotImplementedException();
			}
			}
		}
		{
			final String               s    = ((IdentExpression) pte.__debug_expression).getText();
			final LookupResultList     lrl  = ctx.lookup(s);
			final @Nullable OS_Element best = lrl.chooseBest(null);
			if (best != null) {
				pte.setResolvedElement(best, new GG_ResolveEvent() {String id="FT_FnCallArgs::do_assign_call";});

				// TODO do we need to add a dependency for class, etc?
				if (true) {
					if (best instanceof ConstructorDef cd) {
						// TODO Dont know how to handle this
						int y = 2;
					} else if (best instanceof FunctionDef || best instanceof DefFunctionDef) {
						final OS_Element parent = best.getParent();
						IInvocation      invocation;
						if (parent instanceof final @NonNull NamespaceStatement nsp) {
							invocation = deduceTypes2._inj().new_NamespaceInvocation(nsp);
						} else if (parent instanceof final @NonNull ClassStatement csp) {
							invocation = deduceTypes2._inj().new_ClassInvocation(csp, null, new ReadySupplier_1<>(deduceTypes2));
						} else
							throw new NotImplementedException();

						FunctionInvocation fi = deduceTypes2.newFunctionInvocation((FunctionDef) best, pte,
																				   invocation, deduceTypes2.phase);
						generatedFunction.addDependentFunction(fi);
					} else if (best instanceof ClassStatement) {
						GenType genType = GenTypeImpl.genCIFrom((ClassStatement) best, deduceTypes2);
						generatedFunction.addDependentType(genType);
					}
				}
			} else
				throw new NotImplementedException();
		}
	}

	@Contract(pure = true)
	public FT_FnCallArgs(final @NonNull DeduceTypes2 aDeduceTypes2, final FnCallArgs aO) {
		deduceTypes2 = aDeduceTypes2;
		fca          = aO;
		//
		LOG = aDeduceTypes2.LOG;
	}

	@Override
	public void do_assign_call(final @NonNull BaseEvaFunction generatedFunction, final @NonNull Context ctx,
							   final @NonNull VariableTableEntry vte, final @NonNull Instruction instruction, final OS_Element aName) {
		// NOTE Interesting non static syntax
		final DeduceTypes2.DeduceClient4 client4          = deduceTypes2._inj().new_DeduceClient4(deduceTypes2);
		final DoAssignCall               dac              = deduceTypes2._inj().new_DoAssignCall(client4, generatedFunction, this);
		final int                        instructionIndex = instruction.getIndex();
		final @NonNull ProcTableEntry    pte              = ((ProcIA) fca.getArg(0)).getEntry();

		if (aName instanceof IdentExpression ie) {
			ie.getName().addUnderstanding(deduceTypes2._inj().new_ENU_FunctionCallTarget(pte));
			ie.getName().addUnderstanding(deduceTypes2._inj().new_ENU_TypeTransitiveOver(pte));
		}

		if (pte.typeDeferred().isResolved()) {
			pte.typeDeferred().then(gt -> {
				final TypeName nonGenericTypeName = gt.getNonGenericTypeName();

				if (null == nonGenericTypeName) return;

				var drType = generatedFunction.buildDrTypeFromNonGenericTypeName(nonGenericTypeName);

				gt.setDrType(drType);

				if (gt instanceof ForwardingGenType fgt) {
					fgt.unsparkled();
				}
			});
		}

		final ExpressionConfession ece = pte.expressionConfession();

		switch (ece.getType()) {
		case exp_num -> {
		}
		case exp -> {
		}
		default -> throw new IllegalStateException("Unexpected value: " + ece.getType());
		}

		var exp = pte.expression;
		var en  = exp.getEntry();

		if (pte.expression_num instanceof @NonNull final IdentIA identIA) {

			//08/13 System.err.println("--------------------- 158 "+(generatedFunction._getIdentIAResolvable(identIA).getNormalPath(generatedFunction, identIA)));

			final FT_FCA_IdentIA             fca_ident = deduceTypes2._inj().new_FT_FCA_IdentIA(FT_FnCallArgs.this, identIA, vte);
			final FT_FCA_IdentIA.Resolve_VTE rvte      = deduceTypes2._inj().new_FT_FCA_IdentIA_Resolve_VTE(vte, ctx, pte, instruction, fca);

			try {
				fca_ident.resolve_vte(dac, rvte);
				fca_ident.make2(dac, rvte);
				fca_ident.loop1(dac, rvte);
				fca_ident.loop2(dac, rvte);
			} catch (FCA_Stop e) {
			}
		} else if (pte.expression_num instanceof final @NonNull IntegerIA integerIA) {
			int y = 2;
		}
	}

	/**
	 * Created 12/12/21 12:30 AM
	 */
	public class DoAssignCall {
		final                  DeduceTypes2.DeduceClient4 dc;
		final                  ErrSink                    errSink;
		final @NonNull         BaseEvaFunction            generatedFunction;
		final @NonNull         ElLog                      LOG;
		private final @NonNull OS_Module                  module;

		public OS_Module getModule() {
			return module;
		}

		public DoAssignCall(final DeduceTypes2.DeduceClient4 aDeduceClient4,
							final @NonNull BaseEvaFunction aGeneratedFunction) {
			dc                = aDeduceClient4;
			generatedFunction = aGeneratedFunction;
			//
			module  = dc.getModule();
			LOG     = dc.getLOG();
			errSink = dc.getErrSink();
		}

		public static class NullFoundElement extends FoundElement {
			public NullFoundElement(DeduceTypes2.@NonNull DeduceClient4 dc) {
				super(dc.getPhase());
			}

			@Override
			public void foundElement(final OS_Element e) {
			}

			@Override
			public void noFoundElement() {

			}
		}
	}

}

//
// vim:set shiftwidth=4 softtabstop=0 noexpandtab:
//
