package tripleo.elijah_congenial.p.comp_driver;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.i.CD_CompilationRunnerStart;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.internal.*;
import tripleo.elijah.util.Mode;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

import java.util.ArrayList;
import java.util.List;

import static tripleo.elijah.util.Helpers.List_of;

public class CD_CompilationRunnerStart_1 implements CD_CompilationRunnerStart {

	@Override
	public void start(final @NotNull CompilerInstructions aRootCI,
					  final @NotNull CR_State crState,
					  final @NotNull CB_Output out) {
		final @NotNull CompilationRunner cr          = crState.runner();
		final Compilation                compilation = crState.ce().getCompilation();
		//final @NotNull Compilation.CompilationConfig cfg            = compilation.cfg();
		//final CompilationEnclosure ce = compilation.getCompilationEnclosure();
		//final List<CompilerInput>                    compilerInputs = ce.getCompilerInput();

		compilation.pushItem(new CSS_SimpleSignal() {
			@Override
			public boolean canRun() {
				return true;
			}

			@Override
			public void simpleSignalRun(final CSS_RunEnv aRunEnv) {
				assert cr == aRunEnv.cr();
				//assert ce == aRunEnv.ce();
				assert compilation == aRunEnv.ce().getCompilation();

				// TODO 23/11/16 ca3??
				//  also this maybe wanted to be progressive (see other )
				// README 24/03/09 A Progressive is
				//  (a collection of joins/ek/latches or incremental)
				final CompilerBeginning beginning = new CompilerBeginning(compilation,
																		  aRootCI,
																		  null, //compilerInputs,
																		  cr.progressSink,
																		  null //cfg
				);

				// TODO 23/11/16 pa.notate (? -> prob)
				if (crState.started()) {
					boolean should_never_happen = false;
					assert should_never_happen;
				} else {
					crState.set_started();
				}

				//final CR_FindCIs              f1 = crState.runner().cr_find_cis;
				final CR_ProcessInitialAction f2 = new CR_ProcessInitialAction(beginning);
				//final CR_AlmostComplete       f3 = new CR_AlmostComplete();
				final CR_RunBetterAction f4 = new CR_RunBetterAction();

				//final @NotNull List<CR_Action>     crActionList       = List_of(f1, f2, f3, f4);
				final @NotNull List<CR_Action>     crActionList       = List_of(f2, f4);
				final @NotNull List<Operation<Ok>> crActionResultList = new ArrayList<>(crActionList.size());

				for (final CR_Action each : crActionList) {
					U._run_action_list__internal(crState, out, each, crActionResultList);
				}

				for (int i = 0; i < crActionResultList.size(); i++) {
					var                 action           = crActionList.get(i);
					final Operation<Ok> booleanOperation = crActionResultList.get(i);

					final String s = ("5959 %s %b").formatted(action.name(), (booleanOperation.mode() == Mode.SUCCESS));
					out.logProgress(5959, s);
				}
			}

			@Override
			public boolean isOnce() {
				return true; // yes no complain complainHere(Consumer<CSS_ComplaintEnv>) // or you could just
			}
		});
	}
}
