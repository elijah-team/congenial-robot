package tripleo.elijah.nextgen.outputstatement;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.util.buffer.Buffer;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class GE_BuffersStatement implements EG_Statement {
	@Override
	public @NonNull EX_Explanation getExplanation() {
		return new GE_BuffersExplanation(this);
	}

	private final Map.Entry<String, Collection<Buffer>> entry;

	@Contract(pure = true)
	public GE_BuffersStatement(final Map.Entry<String, Collection<Buffer>> aEntry) {
		entry = aEntry;
	}

	@Override
	public @NonNull String getText() {
		return __.String_join("\n\n", entry.getValue()
				.stream()
				//.filter(entry)
				.map(buffer -> buffer.getText())
				.collect(Collectors.toList()));
	}

	private static class GE_BuffersExplanation implements EX_Explanation {
		final         String              message = "buffers to statement";
		private final GE_BuffersStatement st;

		public GE_BuffersExplanation(final GE_BuffersStatement aGEBuffersStatement) {
			st = aGEBuffersStatement;
		}

		public @NonNull String getText() {
			return message;
		}

		@Override
		public @NonNull String message() {
			return "GE_BuffersExplanation";
		}
	}
}
