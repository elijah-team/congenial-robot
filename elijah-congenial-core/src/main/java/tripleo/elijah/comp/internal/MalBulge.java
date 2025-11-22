package tripleo.elijah.comp.internal;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.AccessBus;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.internal.CR_State.PipelinePlugin;
import tripleo.vendor.mal.stepA_mal.MalEnv2;
import tripleo.vendor.mal.types;

import java.util.function.Consumer;

public class MalBulge {
	private MalEnv2              env;
	private CompilationEnclosure ce;

	public @NotNull MalEnv2 getEnv() {
		return env;
	}

	public MalBulge(CompilationEnclosure ce) {
		this.env = new MalEnv2(null); // TODO what does null mean?
		this.ce  = ce;

		final AccessBus[] ab = {ce.getPipelineAccess().getAccessBus()};
		assert ab[0] != null;

		ce.getAccessBusPromise().then(Sab -> {
			Preconditions.checkNotNull(ab[0]);

			Consumer<PipelinePlugin> ppl = new Consumer<>() {
				@Override
				public void accept(PipelinePlugin t) {
					ab[0].add(t::instance);
				}
			};

			env.set(new types.MalSymbol("add-pipeline"), new _AddPipeline__MAL(ppl, ab[0]));
		});
	}


	private static class _AddPipeline__MAL extends types.MalFunction {
		private final AccessBus                ab;
		private       Consumer<PipelinePlugin> ppii;

//		public _AddPipeline__MAL(final Consumer<PipelineMember> appii) {
//			ppii = appii;
//		}

		public _AddPipeline__MAL(Consumer<PipelinePlugin> ppl, final AccessBus aAccessBus) {
			ppii = ppl;
			ab   = aAccessBus;
		}

		@Override
		public types.MalVal apply(final types.@NotNull MalList args) throws types.MalThrowable {
			final types.MalVal a0 = args.nth(0);

			if (a0 instanceof final types.@NotNull MalSymbol pipelineSymbol) {
				// 0. accessors
				final String pipelineName = pipelineSymbol.getName();

				// 1. observe side effect
				final PipelinePlugin pipelinePlugin = ab.getPipelinePlugin(pipelineName);
				if (pipelinePlugin == null)
					return types.False;

				// 2. produce effect
				//pipelinePlugin::instance
				assert ab != null;
				ppii.accept(pipelinePlugin);
				return types.True;
			} else {
				// TODO exception? errSink??
				return types.False;
			}
		}
	}
}
