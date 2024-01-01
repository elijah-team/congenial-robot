package tripleo.elijah.stages.write_stage.pipeline_impl;

import org.jspecify.annotations.NonNull;

public class SPrintStream implements XPrintStream {
	private final StringBuilder sb = new StringBuilder();

	public @NonNull String getString() {
		return sb.toString();
	}

	@Override
	public void println(final String aS) {
		sb.append(aS);
		sb.append('\n');
	}
}
