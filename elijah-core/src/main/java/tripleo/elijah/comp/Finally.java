package tripleo.elijah.comp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finally {
	Set<Outs> outputOffs = new HashSet<>();
	private List<Input> inputs = new ArrayList<>();

	public void turnOutputOff(final Outs aOut) {
		outputOffs.add(aOut);
	}

	public boolean outputOn(final Outs aOuts) {
		return !outputOffs.contains(aOuts);
	}

	public void addOutput(final CompilerInput aInp, final Out2 ty) {
		inputs.add(new Input(aInp, ty));
	}

	public boolean containsInput(final String aS) {
		return inputs.stream().anyMatch(i -> i.name().equals(aS));
	}

	public enum Outs {Out_6262, Out_401b}

	public enum Out2 {
		EZ, ELIJAH
	}

	public class Input {
		private final CompilerInput inp;
		private final Out2 ty;

		public Input(final CompilerInput aInp, final Out2 aTy) {
			inp = aInp;
			ty  = aTy;
		}

		public String name() {
			return inp.getInp();
		}
	}
}
