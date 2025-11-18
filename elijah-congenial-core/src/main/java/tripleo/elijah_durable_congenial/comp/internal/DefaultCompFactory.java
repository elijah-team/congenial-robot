package tripleo.elijah_durable_congenial.comp.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah_durable_congenial.ci.LibraryStatementPart;
import tripleo.elijah_durable_congenial.comp.CompFactory;
import tripleo.elijah_durable_congenial.comp.i.CompilationEnclosure;
import tripleo.elijah_durable_congenial.lang.i.OS_Module;
import tripleo.elijah_durable_congenial.lang.i.Qualident;
import tripleo.elijah_durable_congenial.lang.impl.QualidentImpl;
import tripleo.elijah_durable_congenial.nextgen.inputtree.EIT_ModuleInput;
import tripleo.elijah_durable_congenial.util.Helpers;
import tripleo.elijah_durable_congenial.world.i.WorldModule;
import tripleo.elijah_durable_congenial.world.impl.DefaultWorldModule;

import java.io.File;
import java.util.List;

class DefaultCompFactory implements CompFactory {
	//private final CompilationImpl compilation;
	private final CompilationEnclosure ce;

	public DefaultCompFactory(final CompilationImpl aCompilation) {
		//compilation = aCompilation;
		final CompilationEnclosure ce1 = aCompilation.getCompilationEnclosure();
		assert ce1 != null;
		ce = ce1;
	}

	@Override
	public @NotNull EIT_ModuleInput createModuleInput(final OS_Module aModule) {
		return new EIT_ModuleInput(aModule, ce.getCompilation());
	}

	@Override
	public @NotNull Qualident createQualident(final @NotNull List<String> sl) {
		Qualident R = new QualidentImpl();
		for (String s : sl) {
			R.append(Helpers.string_to_ident(s));
		}
		return R;
	}

	@Override
	public @NotNull InputRequest createInputRequest(final File aFile, final boolean aDo_out, final @Nullable LibraryStatementPart aLsp) {
		return new InputRequest(aFile, aDo_out, aLsp);
	}

	@Override
	public @NotNull WorldModule createWorldModule(final OS_Module aModule) {
		final WorldModule R = new DefaultWorldModule(aModule, ce);
		assert R.module() == aModule;
		return R;
	}
}
