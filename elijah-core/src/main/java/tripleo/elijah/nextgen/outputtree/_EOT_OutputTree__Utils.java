package tripleo.elijah.nextgen.outputtree;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.nextgen.outputstatement.EG_SequenceStatement;
import tripleo.elijah.nextgen.outputstatement.EG_Statement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class _EOT_OutputTree__Utils {

	static @NonNull List<EG_Statement> _extractStatementSequenceFromAllOutputFiles(final @NonNull Collection<EOT_OutputFile> tt) {
		List<EG_Statement> list2 = new ArrayList<>();
		for (EOT_OutputFile of1 : tt) {
			list2.addAll(_extractStatementSequenceFromOutputFile(of1));
		}
		return list2;
	}

	private static @NonNull List<EG_Statement> _extractStatementSequenceFromOutputFile(final @NonNull EOT_OutputFile of1) {
		var llll = new ArrayList<EG_Statement>();

		final EG_Statement sequence = of1.getStatementSequence();

		if (sequence instanceof EG_SequenceStatement seqst) {
			llll.addAll(seqst._list());
		} else {
			llll.add(sequence);
		}

		return llll;
	}
}
