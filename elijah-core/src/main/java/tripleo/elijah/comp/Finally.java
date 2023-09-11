package tripleo.elijah.comp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finally {
	Set<Outs> outputOffs = new HashSet<>();
	private List<Input> inputs = new ArrayList<>();
	private boolean turnAllOutputOff;

	public void turnOutputOff(final Outs aOut) {
		outputOffs.add(aOut);
	}

	public boolean outputOn(final Outs aOuts) {
		return !turnAllOutputOff || !outputOffs.contains(aOuts);
	}

	public void addOutput(final CompilerInput aInp, final Out2 ty) {
		inputs.add(new Input(aInp, ty));
	}

	public boolean containsInput(final String aS) {
		return inputs.stream().anyMatch(i -> i.name().equals(aS));
	}

	public void turnAllOutputOff() {
		turnAllOutputOff = true;
	}

	public void addOutput(final CompFactory.InputRequest aInp, final Out2 ty) {
		inputs.add(new Input(aInp, ty));
	}

	public enum Outs {Out_6262, Out_727, Out_350, Out_364, Out_252, Out_2121, Out_486, Out_5757, Out_1069, Out_401b}

	public enum Out2 {
		EZ, ELIJAH
	}

	interface Nameable {
		String getName();
	}

	public class Input {

		private final Nameable nameable;
		private final Out2 ty;

		public Input(final CompilerInput aInp, final Out2 aTy) {
			nameable = new Nameable() {
				@Override
				public String getName() {
					return aInp.getInp();
				}
			};
			ty  = aTy;
		}

		public Input(final CompFactory.InputRequest aInp, final Out2 aTy) {
			nameable = new Nameable() {
				@Override
				public String getName() {
					return aInp.file().toString();
				}
			};
			ty = aTy;
		}

		public String name() {
			return nameable.getName();
		}
	}
}
