package tripleo.elijah_congenial.pipelines.pipeline_logic;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.PipelineLogic;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.notation.GN_Env;
import tripleo.elijah.world.i.WorldModule;

import java.util.function.Consumer;

public record GN_PL_Run2_Env(@NotNull PipelineLogic pipelineLogic,
							 @NotNull WorldModule mod,
							 @NotNull CompilationEnclosure ce,
							 @NotNull Consumer<WorldModule> worldConsumer) implements GN_Env {
}
