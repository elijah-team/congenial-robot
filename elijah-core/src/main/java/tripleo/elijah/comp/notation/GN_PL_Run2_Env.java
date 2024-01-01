package tripleo.elijah.comp.notation;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.PipelineLogic;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.world.i.WorldModule;

import java.util.function.Consumer;

public record GN_PL_Run2_Env(@NonNull PipelineLogic pipelineLogic,
							 @NonNull WorldModule mod,
							 @NonNull CompilationEnclosure ce,
							 @NonNull Consumer<WorldModule> worldConsumer) implements GN_Env {
}
