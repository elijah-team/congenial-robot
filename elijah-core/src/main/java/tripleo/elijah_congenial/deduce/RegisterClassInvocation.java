package tripleo.elijah_congenial.deduce;

import org.jdeferred2.impl.DeferredObject;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.lang.i.ClassStatement;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.ClassDefinition;
import tripleo.elijah.stages.deduce.ClassInvocation;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.stages.deduce.DerivedClassInvocation;
import tripleo.elijah.stages.gen_fn.EvaClass;
import tripleo.elijah.stages.gen_fn.GenerateFunctions;
import tripleo.elijah.stages.gen_fn_r.RegisterClassInvocation_env;
import tripleo.elijah.work.WorkList;

import java.util.Collection;

public class RegisterClassInvocation {
	// TODO this class is a mess

	private final DeducePhase deducePhase;

	public RegisterClassInvocation(final DeducePhase aDeducePhase) {
		deducePhase = aDeducePhase;
	}

	public @NotNull ClassInvocation registerClassInvocation(@NotNull ClassInvocation aClassInvocation) {
		return registerClassInvocation(new RegisterClassInvocation_env(aClassInvocation, null, null));
	}

	public ClassInvocation registerClassInvocation(final @NotNull RegisterClassInvocation_env env) {
		final ClassInvocation aClassInvocation = env.ci();

		// 1. select which to return
		final ClassStatement              c   = aClassInvocation.getKlass();
		final Collection<ClassInvocation> cis = deducePhase.getClassInvocationsOf(c);

		for (@NotNull ClassInvocation ci : cis) {
			// don't lose information
			if (ci.getConstructorName() != null)
				if (!(ci.getConstructorName().equals(aClassInvocation.getConstructorName())))
					continue;

			boolean i = deducePhase.equivalentGenericPart(aClassInvocation, ci);
			if (i) {
				if (aClassInvocation instanceof DerivedClassInvocation) {
					if (ci instanceof DerivedClassInvocation)
						continue;

					/*if (ci.resolvePromise().isResolved())*/
					{
						ci.onResolve((final @NotNull EvaClass result) -> {
							aClassInvocation.resolveDeferred().resolve(result);
						});
						return aClassInvocation;
					}
				} else
					return ci;
			}
		}

		return part2(aClassInvocation, true, env);
	}

	private @NotNull ClassInvocation part2(final @NotNull ClassInvocation aClassInvocation, boolean put, final @NotNull RegisterClassInvocation_env aEnv) {
		// 2. Check and see if already done
		Collection<ClassInvocation> cls = deducePhase.getClassInvocationsOf(aClassInvocation.getKlass());
		for (@NotNull ClassInvocation ci : cls) {
			if (deducePhase.equivalentGenericPart(ci, aClassInvocation)) {
				return ci;
			}
		}

		if (put) {
			deducePhase.putClassInvocation(aClassInvocation.getKlass(), aClassInvocation);
		}

		// 3. Generate new EvaClass
		final @NotNull WorkList wl = deducePhase._inj().new_WorkList();

		var x = getClassInvocation(aClassInvocation, null, wl, aEnv);

		// 4. Return it
		//final ClassDefinition[] yy = new ClassDefinition[1];
		//x.then(y -> yy[0] =y);
		//return yy[0];
		return x;
	}

	private @NotNull ClassInvocation getClassInvocation(final @NotNull ClassInvocation aClassInvocation, OS_Module mod, final WorkList wl, final @NotNull RegisterClassInvocation_env aEnv) {
		if (mod == null)
			mod = aClassInvocation.getKlass().getContext().module();

		if (false) {
			var prom = deducePhase.generateClass(deducePhase.generatePhase.getGenerateFunctions(mod), aClassInvocation, deducePhase.generatePhase.getWm());

			//return prom;
			return null;
		} else {
			DeferredObject<ClassDefinition, Diagnostic, Void> prom = new DeferredObject<>();

			final GenerateFunctions generateFunctions = deducePhase.generatePhase.getGenerateFunctions(mod);
			wl.addJob(deducePhase._inj().new_WlGenerateClass(generateFunctions, aClassInvocation, deducePhase.generatedClasses, deducePhase.codeRegistrar, aEnv)); // TODO why add now?
			deducePhase.generatePhase.getWm().addJobs(wl);
			deducePhase.generatePhase.getWm().drain(); // TODO find a better place to put this

			prom.resolve(new ClassDefinition(aClassInvocation));

			//return prom;
			return aClassInvocation;
		}
	}
}
