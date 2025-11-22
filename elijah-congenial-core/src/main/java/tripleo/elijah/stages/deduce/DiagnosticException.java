package tripleo.elijah.stages.deduce;

import tripleo.elijah_fluffy.diagnostic.ElDiagnostic;

public class DiagnosticException extends Throwable {
	private final ElDiagnostic d;

	public DiagnosticException(final ElDiagnostic aD) {
		d = aD;
	}
}
