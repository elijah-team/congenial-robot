package tripleo.elijah.stages.gen_fn;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.i.ClassStatement;
import tripleo.elijah.lang.i.FunctionDef;
import tripleo.elijah.stages.deduce.ClassInvocation;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.FunctionInvocation;
import tripleo.elijah.stages.deduce.NULL_DeduceTypes2;
import tripleo.elijah.stages.gen_generic.ICodeRegistrar;
import tripleo.elijah.work.WorkList;

public class DefaultClassGenerator implements IClassGenerator {

	private final          ICodeRegistrar cr;
	private final          DeducePhase    deducePhase;
	private final @NonNull WorkList       wl;

	public DefaultClassGenerator(DeducePhase aDeducePhase) {
		// given
		deducePhase = aDeducePhase;

		// transitive
		cr          = deducePhase.codeRegistrar;

		// creating
		wl = new WorkList();
	}

	@Override
	public ICodeRegistrar getCodeRegistrar() {
		return cr;
	}

	@Override
	public DeducePhase.@NonNull GeneratedClasses getGeneratedClasses() {
		return deducePhase.generatedClasses;
	}

	@Override
	public FunctionInvocation newFunctionInvocation(final FunctionDef fd,
													final ProcTableEntry pte,
													final @NonNull ClassInvocation ci) {
		final @NonNull FunctionInvocation fi = deducePhase.newFunctionInvocation(fd, pte, ci);
		return fi;
	}

	@Override
	public @Nullable ClassInvocation registerClassInvocation(final @NonNull ClassStatement cs, final String className) {
		final ClassInvocation ci = deducePhase.registerClassInvocation(cs, className, new NULL_DeduceTypes2());
		return ci;
	}

	@Override
	public void submitGenerateClass(final @NonNull ClassInvocation ci, final GenerateFunctions gf) {
		wl.addJob(new WlGenerateClass(gf, ci, deducePhase.generatedClasses, cr));
	}

	@Override
	public void submitGenerateFunction(final @NonNull FunctionInvocation fi, final GenerateFunctions gf) {
		wl.addJob(new WlGenerateFunction(gf, fi, cr));
	}

	@Override
	public @NonNull WorkList wl() {
		return wl;
	}
}
