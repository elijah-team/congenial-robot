package tripleo.elijah.comp.internal;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.i.CB_Action;
import tripleo.elijah.comp.i.CB_OutputString;
import tripleo.elijah.comp.notation.GN_Notable;

import java.util.ArrayList;
import java.util.List;

class NotableAction implements CB_Action {
	private final @NonNull GN_Notable            notable;
	@NonNull
	final                  List<CB_OutputString> o;

	public NotableAction(final @NonNull GN_Notable aNotable) {
		notable = aNotable;
		o       = new ArrayList<>();
	}

	public void _actual_run() {
		notable.run();
	}

	@Override
	public void execute() {
		if (false) notable.run();
	}

	@Override
	public @NonNull String name() {
		return "Notable wrapper";
	}

	@Override
	public List<CB_OutputString> outputStrings() {
		return o;
	}
}
