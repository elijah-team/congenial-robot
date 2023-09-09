package tripleo.elijah.nextgen.rosetta.DeducePhase

import tripleo.elijah.lang.i.OS_Module
import tripleo.elijah.stages.gen_fn.EvaNode
import tripleo.elijah.stages.logging.ElLog

data class DeducePhase_deduceModule_Request(val module: OS_Module,
                                            val listOfEvaFunctions: MutableIterable<EvaNode>,
                                            val verbosity: ElLog.Verbosity)
