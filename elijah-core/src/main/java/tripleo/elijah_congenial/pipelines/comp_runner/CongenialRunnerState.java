package tripleo.elijah_congenial.pipelines.comp_runner;

import tripleo.elijah.comp.i.ICompilationAccess;
import tripleo.elijah.comp.internal.CompilationRunner;

public interface CongenialRunnerState {
	ICompilationAccess ca();

	CompilationRunner runner();

	void setRunner(CompilationRunner aCompilationRunner);
}
