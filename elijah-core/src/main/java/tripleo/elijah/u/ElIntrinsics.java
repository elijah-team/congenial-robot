package tripleo.elijah.u;

import org.jspecify.annotations.NonNull;

import tripleo.elijah.comp.i.CD_FindStdLib;
import tripleo.elijah.lang.i.OS_Module;

public class ElIntrinsics {

	public static <T> void checkNotNullParameter(@NonNull Object ce, T string) {
		assert string != null;		
	}

	public static <T> void checkNotNullExpressionValue(Object var10000, T string) {
		assert string != null;		
	}

	public static <T> void checkNotNull(Object var10001, T string) {
		assert string != null;		
	}

	public static <T> void checkNotNull(T var3) {
		assert var3 != null;		
	}

	public static <T> boolean areEqual(@NonNull T module, @NonNull T module2) {
		if (module == module2) return true;
		return false;
	}

}
