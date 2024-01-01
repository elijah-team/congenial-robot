package tripleo.elijah.lang.i;

import org.jspecify.annotations.NonNull;

public interface ParserClosure extends ProgramClosure {
	OS_Package defaultPackageName(Qualident aPackageName);

	@NotNull
	OS_Module module();
}
