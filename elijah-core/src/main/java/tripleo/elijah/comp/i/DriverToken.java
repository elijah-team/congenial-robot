package tripleo.elijah.comp.i;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

public interface DriverToken {
	@Contract(value = "_ -> new", pure = true)
	static @NotNull DriverToken makeToken(@NotNull String s) {
		return new DriverToken() {
			@Override
			public String asString() {
				return s;
			}
		};
	}

	String asString();
}
