package tripleo.elijah.nextgen.outputstatement;

import org.jspecify.annotations.NonNull;

public interface EX_Explanation {
	static @NotNull EX_Explanation withMessage(final @NotNull String message) {
		return new EX_Explanation() {
			@Override
			public String message() {
				return message;
			}
		};
	}

	String message();
}
