package tripleo.elijah_durable_congenial.comp;

public class Nameables {
	public static Finally.Nameable of(final CompilerInput aInp) {
		return new Finally.Nameable() {
			@Override
			public String getName() {
				return aInp.getInp();
			}
		};
	}

	public static Finally.Nameable of(final CompFactory.InputRequest aInp) {
		return new Finally.Nameable() {
			@Override
			public String getName() {
				return aInp.file().toString();
			}
		};
	}
}
