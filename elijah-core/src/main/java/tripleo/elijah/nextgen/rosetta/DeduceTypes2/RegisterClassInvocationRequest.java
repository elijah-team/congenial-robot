package tripleo.elijah.nextgen.rosetta.DeduceTypes2;

import tripleo.elijah.lang.i.ClassStatement;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.DeduceTypes2;

public record RegisterClassInvocationRequest(
		DeducePhase deducePhase,
		DeduceTypes2 deduceTypes2,
		ClassStatement classStatement
) { }
