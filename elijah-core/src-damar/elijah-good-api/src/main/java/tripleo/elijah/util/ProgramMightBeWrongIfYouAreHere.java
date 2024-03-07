package tripleo.elijah.util;

public class ProgramMightBeWrongIfYouAreHere extends RuntimeException {
	public ProgramMightBeWrongIfYouAreHere(final String aS) {
		super(aS);
	}
	public ProgramMightBeWrongIfYouAreHere() {
		super();
	}
}
