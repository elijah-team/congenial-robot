package tripleo.elijah.world.i;

import tripleo.elijah.util.Eventual;
import tripleo.elijah_congenial.pipelines.pipeline_logic.GN_PL_Run2;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.inputtree.EIT_ModuleInput;
import tripleo.elijah.stages.deduce.DeducePhase;

public interface WorldModule {
	OS_Module module();

	EIT_ModuleInput input();

	GN_PL_Run2.GenerateFunctionsRequest rq();

	Eventual<DeducePhase.GeneratedClasses> getEventual();
}
