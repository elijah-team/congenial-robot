package tripleo.elijah.nextgen.outputstatement;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

/**
 * @author Tripleo Nova
 */
public interface EG_Statement {
	@Contract(value = "_, _ -> new", pure = true)
	static @NonNull EG_Statement of(@NonNull String aText, @NonNull EX_Explanation aExplanation) {
		return new EG_SingleStatement(aText, aExplanation);
	}

	EX_Explanation getExplanation();

	String getText();
}
