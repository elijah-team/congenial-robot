package tripleo.elijah.nextgen.outputstatement;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

import java.util.List;

/**
 * @author Tripleo Nova
 */
public class EG_CompoundStatement implements EG_Statement {
	private final @NonNull EG_Statement   beginning;
	private final @NonNull EG_Statement   ending;
	private final @NonNull EX_Explanation explanation;
	private final          boolean        indent;
	private final @NonNull EG_Statement   middle;

	@Contract(pure = true)
	public EG_CompoundStatement(final @NonNull EG_Statement aBeginning,
								final @NonNull EG_Statement aEnding,
								final @NonNull EG_Statement aMiddle,
								final boolean aIndent,
								final @NonNull EX_Explanation aExplanation) {
		beginning   = aBeginning;
		ending      = aEnding;
		middle      = aMiddle;
		indent      = aIndent;
		explanation = aExplanation;
	}

	public EG_CompoundStatement(final @NonNull EG_Statement aBeginning,
								final @NonNull EG_Statement aEnding,
								final List<EG_Statement> aStatementList,
								final boolean aIndent,
								final @NonNull EX_Explanation aExplanation) {
		beginning   = aBeginning;
		ending      = aEnding;
		middle      = new EG_SequenceStatement(new EG_Naming("<<compound>>"), aStatementList);
		indent      = aIndent;
		explanation = aExplanation;
	}

	@Override
	public @NonNull EX_Explanation getExplanation() {
		return explanation;
	}

	@Override
	public @NonNull String getText() {
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(beginning.getText());

		if (indent) {
			// TODO 11/16 write a test for this
			final String middleText = middle.getText();

			for (String s : middleText.split("\n")) {
				stringBuilder.append("\t");
				stringBuilder.append(s);
				stringBuilder.append("\n");
			}
		} else {
			stringBuilder.append(middle.getText());
		}

		stringBuilder.append(ending.getText());

		return stringBuilder.toString();
	}
}
