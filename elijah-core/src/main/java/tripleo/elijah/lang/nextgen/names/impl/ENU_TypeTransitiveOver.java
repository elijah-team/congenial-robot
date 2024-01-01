package tripleo.elijah.lang.nextgen.names.impl;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.nextgen.names.i.EN_Understanding;
import tripleo.elijah.stages.gen_fn.ProcTableEntry;

public class ENU_TypeTransitiveOver implements EN_Understanding {
	private final @NonNull ProcTableEntry pte;

	public ENU_TypeTransitiveOver(final @NonNull ProcTableEntry aPte) {

		pte = aPte;
	}
}
