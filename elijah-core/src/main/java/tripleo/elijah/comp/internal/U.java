package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.Eventual;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

import java.util.List;

public enum U {
	;

	public static void _run_action_list__internal(final @NotNull CR_State crState, final @NotNull CB_Output out, final CR_Action each, final @NotNull List<Operation<Ok>> crActionResultList) {
		each.attach(crState.runner());
		final Eventual<Operation<Ok>> eoo = new Eventual<>();
		eoo.then(res -> {
			crActionResultList.add(res);
		});
		each.execute(crState, out, eoo);
		assert eoo.isResolved(); // !?
	}


}
