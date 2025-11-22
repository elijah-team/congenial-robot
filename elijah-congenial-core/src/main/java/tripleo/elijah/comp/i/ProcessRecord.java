package tripleo.elijah.comp.i;

import tripleo.elijah.context_mocks.PipelineLogic;

public interface ProcessRecord {
	ICompilationAccess ca();

	IPipelineAccess pa();

	PipelineLogic pipelineLogic();

	void writeLogs();
}
