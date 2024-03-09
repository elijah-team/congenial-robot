package tripleo.elijah.nextgen.query;

import tripleo.elijah.comp.nextgen.CP_Path;

import java.nio.file.Path;

public interface QueryDbRef {
	CP_Path getCpPath(); // do this later

	String getId(); // raison...

	Path getNativePath();

	org.eclipse.core.runtime.Path getEclipsePath();

	org.eclipse.xtend.lib.macro.file.Path getXtendPath();
}
