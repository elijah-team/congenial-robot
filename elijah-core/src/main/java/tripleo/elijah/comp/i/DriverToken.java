package tripleo.elijah.comp.i;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

public interface DriverToken {
	@Contract(value = "_ -> new", pure = true)
	static @NonNull DriverToken makeToken(@NonNull String s) {
		return new DriverToken() {
			@Override
			public String asString() {
				return s;
			}
		};
	}

	String asString();
}
