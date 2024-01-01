package tripleo.vendor.batoull22;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;

record EK_Factarray(String st, EK_Fact[] ch) {

	@Override
	public boolean equals(@Nullable Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (EK_Factarray) obj;
		return Objects.equals(this.st, that.st) &&
                Arrays.equals(this.ch, that.ch);
	}

	@Override
	public @NonNull String toString() {
		return "EK_Factarray[" +
				"st=" + st + ", " +
				"ch=" + ch + ']';
	}

}
