package tripleo.elijah.stages.gen_c.statements;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.nextgen.outputstatement.EX_Explanation;
import tripleo.elijah.stages.deduce.post_bytecode.DeduceElement3_ProcTableEntry;

public class EX_ProcTableEntryExplanation implements EX_Explanation {
	private final @NonNull DeduceElement3_ProcTableEntry pte;

	public EX_ProcTableEntryExplanation(final @NonNull DeduceElement3_ProcTableEntry aPte) {
		pte = aPte;
	}

	@Override
	public @NonNull String message() {
		return "EX_ProcTableEntryExplanation";
	}
}
