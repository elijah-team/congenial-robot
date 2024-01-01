package tripleo.elijah.stages.gen_generic;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;

import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.stages.gen_c.GenerateC;
import tripleo.elijah.util.NotImplementedException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum OutputFileFactory {
	;

	@Contract("_, _, _ -> new")
	public static @NonNull GenerateFiles create(final @NonNull String lang,
												final @NonNull OutputFileFactoryParams params,
												final GenerateResultEnv aFileGen) {
		if (Objects.equals(lang, "c")) {
			final OS_Module mod = params.getMod();

			if (mgfMap.containsKey(mod)) {
				return mgfMap.get(mod);
			}

			final var ce = params.getCompilationEnclosure();
			final GenerateFiles generateC = new GenerateC(params, aFileGen);

			ce.spi(generateC);

			mgfMap.put(mod, generateC);

			return generateC;
		} else
			throw new NotImplementedException();
	}

	private static Map<OS_Module, GenerateFiles> mgfMap = new HashMap<>();
}
