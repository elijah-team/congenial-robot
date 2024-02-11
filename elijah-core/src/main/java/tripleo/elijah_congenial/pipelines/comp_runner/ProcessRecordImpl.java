package tripleo.elijah_congenial.pipelines.comp_runner;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.PipelineLogic;
import tripleo.elijah.comp.i.ICompilationAccess;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.comp.i.ProcessRecord;

public class ProcessRecordImpl implements ProcessRecord {
	private final @NotNull ICompilationAccess ca;
	private final          IPipelineAccess    pa;
	private final @NotNull PipelineLogic      pipelineLogic;

	public ProcessRecordImpl(final @NotNull ICompilationAccess ca0) {
		ca = ca0;

		pa = ca.getCompilation().get_pa();

		pipelineLogic = new PipelineLogic(pa, ca);
	}

	@Contract(pure = true)
	@Override
	public ICompilationAccess ca() {
		return ca;
	}

	@Contract(pure = true)
	@Override
	public IPipelineAccess pa() {
		return pa;
	}

	@Contract(pure = true)
	@Override
	public PipelineLogic pipelineLogic() {
		return pipelineLogic;
	}

	@Override
	public void writeLogs() {
		ca.getCompilation().cfg().stage.writeLogs(ca);
	}
}
