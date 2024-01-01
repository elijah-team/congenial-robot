package tripleo.elijah.stages.gen_c.statements;

import org.jspecify.annotations.NonNull;

public interface GCR_Rule {
	public static @NonNull GCR_Rule withMessage(@NonNull String message) {
		return new GCR_Rule() {
			@Override
			public String text() {
				return message;
			}
		};
	}

	String text();
}
