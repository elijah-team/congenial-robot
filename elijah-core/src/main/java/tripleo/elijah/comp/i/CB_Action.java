package tripleo.elijah.comp.i;

import org.jspecify.annotations.Nullable;

import java.util.List;

public interface CB_Action {
	void execute();

	String name();

	@Nullable List<CB_OutputString> outputStrings();

}
