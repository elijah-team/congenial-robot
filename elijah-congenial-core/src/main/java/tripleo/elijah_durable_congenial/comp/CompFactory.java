package tripleo.elijah_durable_congenial.comp;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah_fluffy_congenial.diagnostic.Diagnostic;
import tripleo.elijah_durable_congenial.ci.LibraryStatementPart;
import tripleo.elijah_durable_congenial.lang.i.OS_Module;
import tripleo.elijah_durable_congenial.lang.i.Qualident;
import tripleo.elijah_durable_congenial.nextgen.inputtree.EIT_ModuleInput;
import tripleo.elijah_durable_congenial.world.i.WorldModule;

import java.io.File;
import java.util.List;

public interface CompFactory {
	EIT_ModuleInput createModuleInput(OS_Module aModule);

	Qualident createQualident(List<String> sl);

	InputRequest createInputRequest(File aFile, final boolean aDo_out, final @Nullable LibraryStatementPart aLsp);

	WorldModule createWorldModule(OS_Module aModule);

	class InputRequest {
		private final File                 _file;
		private final boolean              _do_out;
		private final LibraryStatementPart lsp;
		@Getter
		@Setter
		private       Diagnostic           failure;
		@Getter
		@Setter
		private       WorldModule          worldModule;

		public InputRequest(final File aFile, final boolean aDoOut, final @Nullable LibraryStatementPart aLsp) {
			_file   = aFile;
			_do_out = aDoOut;
			lsp     = aLsp;
		}

		public File file() {
			return _file;
		}

		public boolean do_out() {
			return _do_out;
		}

		public LibraryStatementPart lsp() {
			return lsp;
		}
	}
}
