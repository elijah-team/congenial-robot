package tripleo.elijah.nextgen.rosetta.DeducePhase

import tripleo.elijah.lang.i.OS_Module
import tripleo.elijah.nextgen.rosetta.DeduceTypes2.DeduceTypes2Request
import tripleo.elijah.nextgen.rosetta.Rosetta
import tripleo.elijah.stages.deduce.DeducePhase
import tripleo.elijah.stages.deduce.DeduceTypes2
import tripleo.elijah.stages.gen_fn.EvaNode
import tripleo.elijah.stages.logging.ElLog

data class DeducePhase_deduceModule_Request(
        val module: OS_Module,
        val listOfEvaFunctions: MutableIterable<EvaNode>,
        val verbosity: ElLog.Verbosity,
) {
    fun createDeduceTypes2(aDeducePhase: DeducePhase): DeduceTypes2 {
        val deduceTypes2Request = DeduceTypes2Request(module = module, deducePhase = aDeducePhase, verbosity = verbosity)
        return Rosetta.create(deduceTypes2Request)
    }
}
