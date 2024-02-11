package tripleo.elijah_congenial.pipelines.comp_runner;

import tripleo.elijah.comp.i.CB_Action;
import tripleo.elijah.comp.i.ICompilationAccess;
import tripleo.elijah.comp.i.ProcessRecord;
import tripleo.elijah.comp.internal.CompilationRunner;
import tripleo.elijah.comp.internal.RuntimeProcesses;

public class CongenialRunnerStateImpl implements CongenialRunnerState {
	public CB_Action        cur;
	public     ProcessRecord    pr;
	public     RuntimeProcesses rt;
	public     boolean          started;
	ICompilationAccess ca;
	private CompilationRunner compilationRunner;

	public CongenialRunnerStateImpl(final ICompilationAccess aCa) {
		ca = aCa;

		final ProcessRecord_PipelineAccess pipelineAccess = new ProcessRecord_PipelineAccess(ca);
		ca.getCompilation().getCompilationEnclosure().provide(pipelineAccess);

		pr = new ProcessRecordImpl(ca);
	}

	@Override public ICompilationAccess ca() {
		return ca;
	}

	@Override public CompilationRunner runner() {
		return compilationRunner;
	}

	@Override public void setRunner(CompilationRunner aCompilationRunner) {
		compilationRunner = aCompilationRunner;
	}

}
