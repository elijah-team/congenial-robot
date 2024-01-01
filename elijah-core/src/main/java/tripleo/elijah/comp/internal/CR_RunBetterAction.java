package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.Stages;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.comp.i.ICompilationAccess;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.comp.i.ProcessRecord;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

public class CR_RunBetterAction implements CR_Action {
	public enum StageToRuntime {
		;

		public static @NonNull RuntimeProcesses get(final @NonNull IPipelineAccess aPa) {
			final ICompilationAccess ca = aPa.getCompilationEnclosure().getCompilationAccess();
			return get(ca.getStage(), ca, aPa);
		}

		@Contract("_, _, _, _ -> new")
		@NonNull
		public static RuntimeProcesses get(final @NonNull Stages stage,
										   final @NonNull ICompilationAccess ca,
										   final @NonNull IPipelineAccess aPa) {
			final ProcessRecord    processRecord = aPa.getProcessRecord();
			final RuntimeProcesses r             = new RuntimeProcesses(ca, processRecord);

			r.add(stage.getProcess(ca, processRecord));

			return r;
		}
	}

	@Override
	public void attach(final @NonNull CompilationRunner cr) {

	}

	@Override
	public @NonNull Operation<Ok> execute(final @NonNull CR_State st, final CB_Output aO) {
		try {
			final ICompilationAccess ca = st.ca();

			st.rt = StageToRuntime.get(ca.getCompilation().pa());
			st.rt.run_better(st, aO);

			return Operation.success(Ok.instance());
		} catch (final Exception aE) {
			aE.printStackTrace(); // TODO debug 07/26
			return Operation.failure(aE);
		}
	}

	@Override
	public @NonNull String name() {
		return "run better";
	}
}
