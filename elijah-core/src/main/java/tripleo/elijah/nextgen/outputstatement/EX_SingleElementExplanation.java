package tripleo.elijah.nextgen.outputstatement;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.i.OS_Element;

public class EX_SingleElementExplanation implements EX_Explanation {

	private final @NonNull OS_Element _element;

	@Contract(pure = true)
	public EX_SingleElementExplanation(final @NonNull OS_Element aElement) {
		_element = aElement;
	}

	public @NonNull OS_Element getElement() {
		return _element;
	}

	@Override
	public @NonNull String message() {
		return "EX_SingleElementExplanation";
	}
}
