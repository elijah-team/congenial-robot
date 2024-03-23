package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.Stages;
import tripleo.elijah.comp.i.*;

public class RuntimeProcesses {
	private final @NotNull ICompilationAccess ca;
	private                RuntimeProcess     process;

	@Contract(pure = true)
	public RuntimeProcesses(final @NotNull ICompilationAccess aca) {
		ca = aca;
	}

	public void add(final RuntimeProcess aProcess) {
		process = aProcess;
	}

	public void run_better(CR_State st, CB_Output output) throws Exception {
		// do nothing. job over
		if (ca.getStage() == Stages.E) return;

		// rt.prepare();
		//tripleo.elijah.util.Stupidity.println_err_2("***** RuntimeProcess [prepare] named " + process);
		process.prepare();

		// rt.run();
		//tripleo.elijah.util.Stupidity.println_err_2("***** RuntimeProcess [run    ] named " + process);
		process.run(ca.getCompilation(), st, output);

		// rt.postProcess(pr);
		//tripleo.elijah.util.Stupidity.println_err_2("***** RuntimeProcess [postProcess] named " + process);
		process.postProcess();

		//tripleo.elijah.util.Stupidity.println_err_2("***** RuntimeProcess^ [postProcess/writeLogs]");
		ca.writeLogs();
	}

	public int size() {
		return process == null ? 0 : 1;
	}
}

//
//
//
