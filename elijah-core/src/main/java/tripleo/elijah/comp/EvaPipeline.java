/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.comp;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.DebugFlags;
import tripleo.elijah.Eventual;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.comp.internal.CB_Output;
import tripleo.elijah.comp.internal.CR_State;
import tripleo.elijah.comp.internal.Provenance;
import tripleo.elijah.comp.notation.GN_GenerateNodesIntoSink;
import tripleo.elijah.comp.notation.GN_GenerateNodesIntoSinkEnv;
import tripleo.elijah.lang.i.FormalArgListItem;
import tripleo.elijah.lang.i.FunctionDef;
import tripleo.elijah.lang.i.OS_NamedElement;
import tripleo.elijah.nextgen.outputstatement.EG_Statement;
import tripleo.elijah.nextgen.outputstatement.EX_Explanation;
import tripleo.elijah.nextgen.outputstatement.ReasonedStringListStatement;
import tripleo.elijah.nextgen.outputtree.EOT_FileNameProvider;
import tripleo.elijah.nextgen.outputtree.EOT_OutputFileCreator;
import tripleo.elijah.nextgen.outputtree.EOT_OutputType;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.gen_generic.DoubleLatch;
import tripleo.elijah.stages.gen_generic.pipeline_impl.DefaultGenerateResultSink;
import tripleo.elijah.stages.gen_generic.pipeline_impl.ProcessedNode;
import tripleo.elijah.stages.gen_generic.pipeline_impl.ProcessedNodeImpl;
import tripleo.elijah.stages.instructions.Instruction;
import tripleo.elijah.world.i.LivingFunction;
import tripleo.elijah.world.i.LivingRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static tripleo.elijah.util.Helpers.List_of;

/**
 * Created 8/21/21 10:16 PM
 */
public class EvaPipeline implements PipelineMember, AccessBus.AB_LgcListener {
	private final          CompilationEnclosure       ce;
	private final @NotNull IPipelineAccess            pa;
	private final @NotNull DefaultGenerateResultSink  grs;
	private final @NotNull DoubleLatch<List<EvaNode>> latch2;
	private final @NotNull List<FunctionStatement>    functionStatements = new ArrayList<>();
	private                List<EvaNode>              _lgc;
	private                PipelineLogic              pipelineLogic;
	private                CB_Output                  _processOutput;
	private                CR_State                   _processState;

	@Contract(pure = true)
	public EvaPipeline(@NotNull IPipelineAccess pa0) {
		pa = pa0;

		//

		ce = pa0.getCompilationEnclosure();

		//

		final AccessBus ab = pa.getAccessBus();
		ab.subscribePipelineLogic(aPl -> pipelineLogic = aPl);
		ab.subscribe_lgc(aLgc -> _lgc = aLgc);

		//

		latch2 = new DoubleLatch<List<EvaNode>>(this::lgc_slot);

		//

		grs = new DefaultGenerateResultSink(pa);
		pa.registerNodeList(latch2::notifyData);
		pa.setGenerateResultSink(grs);

		pa.setEvaPipeline(this);


		pa.install_notate(Provenance.EvaPipeline__lgc_slot, GN_GenerateNodesIntoSink.class, GN_GenerateNodesIntoSinkEnv.class);
	}

	@Override
	public void lgc_slot(final @NotNull List<EvaNode> aLgc) {
		final List<ProcessedNode> nodes = processLgc(aLgc);

		for (EvaNode evaNode : aLgc) {
			_processOutput.logProgress(160, "EvaPipeline.recieve >> " + evaNode);
		}

		//var flow = getMyEvents();
		//try {
		//	flow.collect { value ->
		//			println("Received $value")
		//	}
		//	println("My events are consumed successfully")
		//} catch (e: Throwable) {
		//	println("Exception from the flow: $e")
		//}
		//var msf = Flow<ProcessedNode>();

		EOT_FileNameProvider filename1;

		// README 11/04 Really want a "Flow" i/o cot.add...
		for (EvaNode evaNode : aLgc) {
			final var z = new ReasonedStringListStatement();

			if (evaNode instanceof EvaClass aEvaClass) {
				filename1 = __z1(aEvaClass, z);
			} else if (evaNode instanceof EvaNamespace aEvaNamespace) {
				filename1 = __z2(aEvaNamespace, z);
			} else if (evaNode instanceof EvaFunction evaFunction) {
				filename1 = __z3(evaFunction, z);
			} else {
				throw new IllegalStateException("Can't determine node");
			}

			if (!DebugFlags.skip_DUMPS) {
				final EG_Statement          seq = EG_Statement.of(z.getText(), EX_Explanation.withMessage("dump"));
				final EOT_OutputFileCreator off = ce.ca2().createOutputFile2(EOT_OutputType.DUMP);
				off.provideInputs(List_of());
				off.provideFileName(filename1);
				off.provideSeq(seq);
				off.provideCompilation(ce.ca2());
			}
		}

		if (!DebugFlags.skip_DUMPS) {
			for (FunctionStatement functionStatement : functionStatements) {
				final String                filename = functionStatement.getFilename(pa);
				final EG_Statement          seq      = EG_Statement.of(functionStatement.getText(), EX_Explanation.withMessage("dump2"));
				final EOT_OutputFileCreator off      = ce.ca2().createOutputFile2(EOT_OutputType.DUMP);
				off.provideInputs(List_of());
				off.provideFileName(() -> filename);
				off.provideSeq(seq);
				off.provideCompilation(ce.ca2());
			}
		}

		final CompilationEnclosure compilationEnclosure = pa.getCompilationEnclosure();

		compilationEnclosure.getPipelineAccessPromise().then((pa) -> {
			final var env = new GN_GenerateNodesIntoSinkEnv(nodes,
															grs,
															null, //pa.pipelineLogic().mods(),
															compilationEnclosure.getCompilationAccess().testSilence(),
															pa.getAccessBus().gr,
															pa,
															compilationEnclosure);

			final GN_GenerateNodesIntoSink generateNodesIntoSink = new GN_GenerateNodesIntoSink(env);
			_processOutput.logProgress(117, "EvaPipeline >> GN_GenerateNodesIntoSink");
			//pa.notate(Provenance.EvaPipeline__lgc_slot, generateNodesIntoSink);
			pa.notate(Provenance.EvaPipeline__lgc_slot, env);
		});
	}

	@NotNull
	private EOT_FileNameProvider __z3(final EvaFunction evaFunction, final ReasonedStringListStatement z) {
		EOT_FileNameProvider filename1;
		String               filename;
		int                  code = evaFunction.getCode();

		if (code == 0) {
			var cr = ce.getPipelineLogic().dp.codeRegistrar;
			cr.registerFunction1(evaFunction);

			code = evaFunction.getCode();
			assert code != 0;
		}

		final String functionName = evaFunction.getFunctionName();
		filename = "F_" + code + functionName;

		final int finalCode = code;
		filename1 = new EOT_FileNameProvider() {
			@Override
			public String getFilename() {
				final String functionName = evaFunction.getFunctionName();
				var          filename2    = "F_" + finalCode + functionName;
				return filename2;
			}
		};

		final String str = "FUNCTION %d %s %s\n".formatted(code,
														   functionName,
														   ((OS_NamedElement) evaFunction.getFD().getParent()).name());
		z.append(str, "z3-1");
		pa.activeFunction(evaFunction);
		return filename1;
	}

	@NotNull
	private EOT_FileNameProvider __z1(final EvaClass aEvaClass, final ReasonedStringListStatement z) {
		String               filename;
		EOT_FileNameProvider filename1;
		filename = "C_" + aEvaClass.getCode() + aEvaClass.getName();
		z.append("CLASS %d %s\n".formatted(aEvaClass.getCode(),
										   aEvaClass.getName()), "z1-1");
		for (EvaContainer.VarTableEntry varTableEntry : aEvaClass.varTable) {
			z.append("MEMBER %s %s".formatted(varTableEntry.nameToken,
											  varTableEntry.varType), "z1-2");
		}
		for (Map.Entry<FunctionDef, EvaFunction> functionEntry : aEvaClass.functionMap.entrySet()) {
			EvaFunction v = functionEntry.getValue();
			z.append("FUNCTION %d %s\n".formatted(v.getCode(), v.getFD().getNameNode().getText()), "z1-3");

			pa.activeFunction(v);
		}

		filename1 = new EOT_FileNameProvider() {
			@Override
			public String getFilename() {
				var filename2 = "C_" + aEvaClass.getCode() + aEvaClass.getName();
				return filename2;
			}
		};

		pa.activeClass(aEvaClass);
		return filename1;
	}

	@NotNull
	private EOT_FileNameProvider __z2(final EvaNamespace aEvaNamespace, final ReasonedStringListStatement z) {
		EOT_FileNameProvider filename1;
		z.append("NAMESPACE %d %s\n".formatted(aEvaNamespace.getCode(),
											   aEvaNamespace.getName()), "z2-1");
		for (EvaContainer.VarTableEntry varTableEntry : aEvaNamespace.varTable) {
			z.append("MEMBER %s %s\n".formatted(varTableEntry.nameToken,
												varTableEntry.varType), "z2-2");
		}
		for (Map.Entry<FunctionDef, EvaFunction> functionEntry : aEvaNamespace.functionMap.entrySet()) {
			EvaFunction v = functionEntry.getValue();
			z.append("FUNCTION %d %s\n".formatted(v.getCode(), v.getFD().getNameNode().getText()), "z2-3");
		}

		filename1 = new EOT_FileNameProvider() {
			@Override
			public String getFilename() {
				var filename2 = "N_" + aEvaNamespace.getCode() + aEvaNamespace.getName();
				return filename2;
			}
		};

		pa.activeNamespace(aEvaNamespace);
		return filename1;
	}

	private @NotNull List<ProcessedNode> processLgc(final @NotNull List<EvaNode> aLgc) {
		final List<ProcessedNode> l = new ArrayList<>();

		for (EvaNode evaNode : aLgc) {
			l.add(new ProcessedNodeImpl(evaNode));
		}

		return l;
	}

	public void addFunctionStatement(final FunctionStatement aFunctionStatement) {
		functionStatements.add(aFunctionStatement);
	}

	public DefaultGenerateResultSink grs() {
		return grs;
	}

	@Override
	public void run(final CR_State aSt, final CB_Output aOutput) {
		_processState  = aSt;
		_processOutput = aOutput;

		latch2.notifyLatch(true);
	}

	public static class FunctionStatement implements EG_Statement {
		private final IEvaFunctionBase evaFunction;
		private       String           filename;

		public FunctionStatement(final IEvaFunctionBase aEvaFunction) {
			evaFunction = aEvaFunction;
		}

		@Override
		public @NotNull EX_Explanation getExplanation() {
			return EX_Explanation.withMessage("FunctionStatement");
		}

		@Override
		public @NotNull String getText() {
			final StringBuilder sb = new StringBuilder();
			final var           z  = new ReasonedStringListStatement();

			final String str = "FUNCTION %d %s %s\n".formatted(evaFunction.getCode(),
															   evaFunction.getFunctionName(),
															   ((OS_NamedElement) evaFunction.getFD().getParent()).name());
			z.append(str, "function-statement-header");

			z.append("Instructions \n", "function-statement-header2");
			final EvaFunction gf = (EvaFunction) evaFunction;
			for (Instruction instruction : gf.instructionsList) {
				z.append("\t", "function-statement-instruction-spacer-left");
				z.append("" + instruction, "function-statement-instruction-text");
				z.append("\n", "function-statement-instruction-spacer-right");
			}

			{
				//	EvaFunction.printTables(gf);
				{
					for (FormalArgListItem formalArgListItem : gf.getFD().getArgs()) {
						z.append("ARGUMENT " + formalArgListItem.name() + " " + formalArgListItem.typeName() + "\n", "...fali");
					}
					sb.append("VariableTable \n");
					for (VariableTableEntry variableTableEntry : gf.vte_list) {
						z.append("\t" + variableTableEntry + "\n", "...vte-list-item");
					}
					sb.append("ConstantTable \n");
					for (ConstantTableEntry constantTableEntry : gf.cte_list) {
						z.append("\t" + constantTableEntry + "\n", "...cte-list-item");
					}
					z.append("ProcTable     \n", "...pte-header");
					for (ProcTableEntry procTableEntry : gf.prte_list) {
						z.append("\t" + procTableEntry + "\n", "...prte-list-item");
					}
					z.append("TypeTable     \n", "...tte-header");
					for (TypeTableEntry typeTableEntry : gf.tte_list) {
						z.append("\t" + typeTableEntry + "\n", "...tte-list-item");
					}
					z.append("IdentTable    \n", "...idte-list-header");
					for (IdentTableEntry identTableEntry : gf.idte_list) {
						z.append("\t" + identTableEntry + "\n", "...idte-list-item");
					}
				}
			}

			return sb.toString();
		}

		public @NotNull String getFilename(@NotNull IPipelineAccess pa) {
			// HACK 07/07 register if not registered
			if (filename == null) {
				EvaFunction v    = (EvaFunction) evaFunction;
				int         code = v.getCode();

				final var            ce    = pa.getCompilationEnclosure();
				final var            world = ce.getCompilation().world();
				final LivingFunction funct = world.addFunction(v, LivingRepo.Add.NONE);
				funct.codeRegistration((final EvaFunction ef, final Eventual<Integer> ccb)->{
					int         code1 = ef.getCode();
					assert  code1 == 0;
					var cr = ce.getPipelineLogic().dp.codeRegistrar;
					cr.registerFunction1(ef);

					code1 = ef.getCode();
					assert code1 != 0;

					ccb.resolve(code1);
				});

				assert funct.isRegistered();

				funct.listenRegister((Integer code2) -> {
					assert code2.intValue() != 0;

					filename = String.format("F_%d%s", code2, evaFunction.getFunctionName());
				});
			}
			return filename;
		}
	}

//	public void simpleUsageExample() {
//		Parseable pbr = Parsers.newParseable("{:x 1, :y 2}");
//		Parser    p = Parsers.newParser(defaultConfiguration());
//		Map<?, ?> m = (Map<?, ?>) p.nextValue(pbr);
////		assertEquals(m.get(newKeyword("x")), 1L);
////		assertEquals(m.get(newKeyword("y")), 2L);
////		assertEquals(Parser.END_OF_INPUT, p.nextValue(pbr));
//	}

}

//
//
//
