package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.Eventual;
import tripleo.elijah.comp.Stages;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.comp.i.ICompilationAccess;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

public class CR_RunBetterAction implements CR_Action {
	@Override
	public void attach(final @NotNull CompilationRunner cr) {

	}

	@Override
	public void execute(final @NotNull CR_State st, final CB_Output aCBOutput, final Eventual<Operation<Ok>> eoo) {
		st.ce().getPipelineAccessPromise().then(
				(IPipelineAccess pa) -> {
					final RuntimeProcesses rt = StageToRuntime.get(pa);

					try {
						rt.run_better(st, aCBOutput);
					} catch (Exception aE) {
						aE.printStackTrace(); // TODO debug 07/26
						eoo.fail(aE);
					}

					eoo.resolve(Operation.success(Ok.instance()));
				});
	}

	public enum StageToRuntime {
		;

		public static @NotNull RuntimeProcesses get(final @NotNull IPipelineAccess aPa) {
			final ICompilationAccess ca = aPa.getCompilationEnclosure().getCompilationAccess();
			return get(ca.getStage(), ca, aPa);
		}

		@Contract("_, _, _, _ -> new")
		@NotNull
		public static RuntimeProcesses get(final @NotNull Stages stage,
										   final @NotNull ICompilationAccess ca,
										   final @NotNull IPipelineAccess aPa) {
			final RuntimeProcesses r = new RuntimeProcesses(ca);

			r.add(stage.getProcess(ca));

			return r;
		}
	}

	@Override
	public @NotNull String name() {
		return "run better";
	}
}
