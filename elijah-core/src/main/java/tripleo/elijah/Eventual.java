package tripleo.elijah;

import org.jdeferred2.DoneCallback;
import org.jdeferred2.FailCallback;
import org.jdeferred2.impl.DeferredObject;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.diagnostic.Diagnostic;

public class Eventual<P> {
	private final DeferredObject<P, Diagnostic, Void> prom = new DeferredObject<>();

	public void resolve(final P p) {
		prom.resolve(p);
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

	/**
	 * Please overload this
	 */
	public String description() {
		return "GENERIC-DESCRIPTION";
	}

	public boolean isPending() {
		return prom.isPending();
	}

	public void reject(final Diagnostic aX) {
		System.err.println("8899 [Eventual::reject] "+aX);
	}

	public void onFail(final FailCallback<? super Diagnostic> aO) {
		prom.fail(aO);
	}
}
