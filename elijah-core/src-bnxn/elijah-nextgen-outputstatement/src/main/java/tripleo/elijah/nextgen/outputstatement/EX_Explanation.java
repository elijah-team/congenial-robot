package tripleo.elijah.nextgen.outputstatement;

import org.jspecify.annotations.NonNull;

public interface EX_Explanation {
	static @NonNull EX_Explanation withMessage(final @NonNull String message) {
		return new EX_Explanation() {
			@Override
			public String message() {
				return message;
			}
		};
	}

	String message();
}
