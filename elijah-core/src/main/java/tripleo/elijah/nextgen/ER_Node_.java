package tripleo.elijah.nextgen;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.nextgen.CP_Path;
import tripleo.elijah.comp.nextgen.i.CE_Path;
import tripleo.elijah.nextgen.outputstatement.EG_Statement;

import java.nio.file.Path;

/**
 * See {@link tripleo.elijah.comp.nextgen.i.CompOutput#writeToPath(CE_Path, EG_Statement)}
 */
// TODO 09/04 Duplication madness
public enum ER_Node_ { ;
	@Contract(value = "_, _ -> new", pure = true)
	public static @NotNull ER_Node of(@NotNull CP_Path p, @NotNull EG_Statement seq) {
		return new ER_Node() {
			@Override
			public @NotNull String toString() {
				return "17 ER_Node " + p.toFile();
			}

			@Override
			public Path getPath() {
				final Path pp = p.getPath();
				return pp;
			}

			@Override
			public EG_Statement getStatement() {
				return seq;
			}
		};
	}
}
