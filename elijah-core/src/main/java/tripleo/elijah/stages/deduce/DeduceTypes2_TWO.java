package tripleo.elijah.stages.deduce;

import tripleo.elijah.nextgen.rosetta.DeduceTypes2.DeduceTypes2Request;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.stages.gen_fn.EvaFunction;

public class DeduceTypes2_TWO extends DeduceTypes2 {
	public DeduceTypes2_TWO(final DeduceTypes2Request aDeduceTypes2Request) {
		super(aDeduceTypes2Request);
	}

	public void pass(final BaseEvaFunction aEvaFunction) {
		deduceOneFunction((EvaFunction) aEvaFunction, this.phase);
	}
}
