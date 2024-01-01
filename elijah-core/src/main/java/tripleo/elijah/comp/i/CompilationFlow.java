package tripleo.elijah.comp.i;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.internal.CompilationImpl;
import tripleo.elijah.util.Mode;
import tripleo.elijah.util.Operation2;
import tripleo.elijah.world.i.WorldModule;

import java.util.function.Consumer;

public interface CompilationFlow {
	//static CompilationFlowMember findPrelude() {
	//	return new CF_FindPrelude(aCopm);
	//}

	static @NonNull CompilationFlowMember deduceModuleWithClasses() {
		return new CompilationFlowMember() {
			@Override
			public void doIt(final Compilation cc, final CompilationFlow flow) {

			}
		};
	}

	static @NonNull CompilationFlowMember findMainClass() {
		return new CompilationFlowMember() {
			@Override
			public void doIt(final Compilation cc, final CompilationFlow flow) {

			}
		};
	}

	static @NonNull CompilationFlowMember finishModule() {
		return new CompilationFlowMember() {
			@Override
			public void doIt(final Compilation cc, final CompilationFlow flow) {

			}
		};
	}

	static @NonNull CompilationFlowMember genFromEntrypoints() {
		return new CompilationFlowMember() {
			@Override
			public void doIt(final Compilation cc, final CompilationFlow flow) {

			}
		};
	}

	static @NonNull CompilationFlowMember getClasses() {
		return new CompilationFlowMember() {
			@Override
			public void doIt(final Compilation cc, final CompilationFlow flow) {


			}
		};
	}

	static @NonNull CompilationFlowMember parseElijah() {
		return new CompilationFlowMember() {
			@Override
			public void doIt(final Compilation cc, final CompilationFlow flow) {
				int y = 2;
			}
		};
	}

	static @NonNull CompilationFlowMember runFunctionMapHooks() {
		return new CompilationFlowMember() {
			@Override
			public void doIt(final Compilation cc, final CompilationFlow flow) {

			}
		};
	}

	void add(CompilationFlowMember aFlowMember);

	static @NonNull CompilationFlowMember returnErrorCount() {
		return new CompilationFlowMember() {
			@Override
			public void doIt(final Compilation cc, final CompilationFlow flow) {

			}
		};
	}

	void run(CompilationImpl aCompilation);

	interface CompilationFlowMember {
		void doIt(Compilation cc, final CompilationFlow flow);
	}

	class CF_FindPrelude implements CompilationFlowMember {
		private final Consumer<Operation2<WorldModule>> copm;

		public CF_FindPrelude(final Consumer<Operation2<WorldModule>> aCopm) {
			copm = aCopm;
		}

		@Override
		public void doIt(final @NonNull Compilation cc, final CompilationFlow flow) {
			final Operation2<WorldModule> prl = cc.findPrelude(Compilation.CompilationAlways.defaultPrelude());
			assert (prl.mode() == Mode.SUCCESS);

			copm.accept(prl);
		}
	}
}
