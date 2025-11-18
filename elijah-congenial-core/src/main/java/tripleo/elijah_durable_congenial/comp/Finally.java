package tripleo.elijah_durable_congenial.comp;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_durable_congenial.lang.nextgen.names.i.EN_Name;
import tripleo.elijah_durable_congenial.nextgen.inputtree.EIT_InputType;
import tripleo.elijah_durable_congenial.nextgen.outputtree.EOT_FileNameProvider;
import tripleo.elijah_durable_congenial.nextgen.outputtree.EOT_OutputFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finally {
	private final Set<Outs>    outputOffs = new HashSet<>();
	private final List<Input>  inputs     = new ArrayList<>();
	private final List<Output> outputs    = new ArrayList<>();
	private       boolean      turnAllOutputOff;

	public void turnOutputOff(final Outs aOut) {
		outputOffs.add(aOut);
	}

	public boolean outputOn(final Outs aOuts) {
		return !turnAllOutputOff && !outputOffs.contains(aOuts);
	}

	public void addInput(final CompilerInput aInp, final Out2 ty) {
		inputs.add(new Input(aInp, ty));
	}

	public boolean containsInput(final String aS) {
		return inputs.stream().anyMatch(i -> i.name().equals(aS));
	}

	public void turnAllOutputOff() {
		turnAllOutputOff = true;
	}

	public void addInput(final CompFactory.InputRequest aInp, final Out2 ty) {
		inputs.add(new Input(aInp, ty));
	}

	public boolean containsCodeOutput(@NotNull final String s) {
		return outputs.stream().anyMatch(i -> i.name().equals(s));
	}

	public void addCodeOutput(final EOT_FileNameProvider aFileNameProvider, final EOT_OutputFile aOff) {
		outputs.add(new Output(aFileNameProvider, aOff));
	}

	public int codeOutputSize() {
		return outputs.size();
	}

	public int codeInputSize() {
		return inputs.size();
	}

	public boolean containsCodeInput(final String aS) {
		return containsInput(aS);
	}

	public void doOutputOn(final Outs code, final String message) {
		if (outputOn(code)) System.err.println(message);
	}

	public List<EN_Name> namesForCodeInput(final @NotNull String aString) {
		for (Input input : inputs) {

		}
		return null;
	}

	public enum Outs {Out_6262, Out_727, Out_350, Out_364, Out_252, Out_2121, Out_486, Out_5757, Out_1069, Out_141, Out_EVTE_159, Out_353, Out_120, Out_40, Out_153, Out_600142, Out_6011189, Out_401b}

	public enum Out2 {
		EZ, ELIJAH
	}

	public static EIT_InputType t(final Out2 aTy) {
		switch (aTy) {
		case EZ -> {
			return EIT_InputType.EZ_FILE;
		}
		case ELIJAH -> {
			return EIT_InputType.ELIJAH_SOURCE;
		}
		default -> throw new IllegalStateException("Unexpected value: " + aTy);
		}
	}

	public interface Nameable {
		String getName();
	}

	public static class Input {

		private final Nameable      nameable;
		private final EIT_InputType ty;

		public Input(final CompilerInput aInp, final Out2 aTy) {
			nameable = Nameables.of(aInp);
			ty       = t(aTy);
		}

		public Input(final CompFactory.InputRequest aInp, final Out2 aTy) {
			nameable = Nameables.of(aInp);
			ty       = t(aTy);
		}

		public String name() {
			return nameable.getName();
		}

		@Override
		public String toString() {
			return "Input{" +
					"nameable=" + nameable.getName() +
					", ty=" + ty +
					'}';
		}
	}

	public static class Output {
		private final EOT_FileNameProvider fileNameProvider;
		private final EOT_OutputFile       off;

		public Output(final EOT_FileNameProvider aFileNameProvider, final EOT_OutputFile aOff) {
			fileNameProvider = aFileNameProvider;
			off              = aOff;
		}

		public String name() {
			return fileNameProvider.getFilename();
		}

		@Override
		public String toString() {
			return "Output{" +
					"fileNameProvider=" + fileNameProvider.getFilename() +
					'}';
		}
	}
}
