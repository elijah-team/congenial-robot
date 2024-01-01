package tripleo.elijah.nextgen.outputtree;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.nextgen.inputtree.EIT_Input;
import tripleo.elijah.nextgen.inputtree.EIT_Input_HashSourceFile_Triple;
import tripleo.elijah.nextgen.outputstatement.EG_Statement;

import java.util.ArrayList;
import java.util.List;

public class EOT_OutputFile {
	@FunctionalInterface
	public interface FileNameProvider {
		String getFilename();
	}

	public static class DefaultFileNameProvider implements FileNameProvider {
		private final String r;

		public DefaultFileNameProvider(final String aR) {
			r = aR;
		}

		@Override
		public String getFilename() {
			return r;
		}
	}

	private final @NonNull FileNameProvider _filename;
	private final          List<EIT_Input>                       _inputs = new ArrayList<>();
	private final @NonNull EOT_OutputType                        _type;
	private final @NonNull EG_Statement                          _sequence; // TODO List<?> ??
	public                 List<EIT_Input_HashSourceFile_Triple> x;

	public EOT_OutputFile(final @NonNull List<EIT_Input> inputs,
						  final @NonNull FileNameProvider filename,
						  final @NonNull EOT_OutputType type,
						  final @NonNull EG_Statement sequence) {
		_filename = filename;
		_type     = type;
		_sequence = sequence;
		_inputs.addAll(inputs);
	}

	public EOT_OutputFile(final @NonNull List<EIT_Input> inputs,
						  final @NonNull String filename,
						  final @NonNull EOT_OutputType type,
						  final @NonNull EG_Statement sequence) {
		this(inputs, new DefaultFileNameProvider(filename), type, sequence);
	}

	public String getFilename() {
		return _filename.getFilename();
	}

	public @NonNull List<EIT_Input> getInputs() {
		return _inputs;
	}

	public EG_Statement getStatementSequence() {
		return _sequence;
	}

	public EOT_OutputType getType() {
		return _type;
	}

	@Override
	public String toString() {
		return "(%s) '%s'".formatted(_type, _filename.getFilename());
	}

	// rules/constraints whatever
}
