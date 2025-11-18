package tripleo.elijah.util;

import org.jdeferred2.DoneCallback;
import org.jdeferred2.FailCallback;
import org.jdeferred2.Promise;
import org.jdeferred2.impl.DeferredObject;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah_fluffy_congenial.diagnostic.Diagnostic;
import tripleo.elijah_durable_congenial.util.EventualExtract;

import java.util.Optional;
import java.util.function.Supplier;

public class Eventual<P> {
	private final DeferredObject<P, Diagnostic, Void> prom = new DeferredObject<>();
	private final String mDescription;
	private Diagnostic diag;

	public Eventual(final String aMDescription) {
		mDescription = aMDescription;
	}

	public Eventual() {
		mDescription = "GENERIC-DESCRIPTION";
	}

	public void resolve(final P p) {
		prom.resolve(p);
	}
	public void succeedWith(final P p) {
		prom.resolve(p);
	}

	public void onSuccess(final DoneCallback<? super P> cb) {
		prom.then(cb);
	}
	public void then(final DoneCallback<? super P> cb) {
		prom.then(cb);
	}

	public void register(final @NotNull EventualRegister ev) {
		ev.register(this);
	}

	public void fail(final Diagnostic d) {
		prom.reject(d);
	}

	public boolean isResolved() {
		return prom.isResolved();
	}

	public String description() {
		return mDescription;
	}

	public boolean isPending() {
		return prom.isPending();
	}

	public void reject(final Diagnostic aDiagnostic) {
		this.diag = aDiagnostic;
		//System.err.println("8899 [Eventual::reject] "+aDiagnostic);
		prom.reject(aDiagnostic);
	}

	public void onFail(final FailCallback<? super Diagnostic> aO) {
		prom.fail(aO);
	}

	public Optional<P> getOptional() {
		if (!prom.isResolved()) {
			return Optional.empty();
		}
		final @NotNull P[] xx = (P[]) new Object[]{null};
		prom.then(fg -> {
			xx[0] = fg;
		});
		return Optional.of((P) xx[0]);
	}

	public Optional<P> getOptional(Supplier<P> s) {
		if (!prom.isResolved()) {
			return Optional.empty();
		}
		final @NotNull P[] xx = (P[]) new Object[]{null};
		prom.then(fg -> {
			xx[0] = s.get();
		});
		return Optional.of((P) xx[0]);
	}

	@Override
	public String toString() {
		var s = new StringBuilder();
		if (prom.isResolved()) {
			s.append("RESOLVED ");
			s.append(getOptional().get());
			s.append('\n');
		} else s.append(super.toString());
		return s.toString();
	}

	@Deprecated
	public Promise.State state() {
		return prom.state();
	}

	public Operation<P> asOperation() {
		switch (state()) {
		case RESOLVED -> {
			return Operation.success(EventualExtract.of(this));
		}
		case REJECTED -> {
			return Operation.failure(this.diag);
		}
		}
		return null;
	}
}
