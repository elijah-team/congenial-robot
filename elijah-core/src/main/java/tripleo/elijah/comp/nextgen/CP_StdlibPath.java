package tripleo.elijah.comp.nextgen;

import org.jdeferred2.Promise;
import org.jdeferred2.impl.DeferredObject;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.comp.i.Compilation;

import java.io.File;
import java.nio.file.Path;

public class CP_StdlibPath implements CP_Path, _CP_RootPath {
	private final Compilation                      c;
	private final DeferredObject<Path, Void, Void> _pathPromise = new DeferredObject<>();

	public CP_StdlibPath(final Compilation aC) {
		c = aC;
	}

	@Override
	public @Nullable CP_SubFile subFile(final String aFile) {
		return null;
	}

	@Override
	public CP_Path child(final String aSubPath) {
		return new CP_SubFile(this, aSubPath).getPath();
	}

	@Override
	public @NonNull Path getPath() {
		return Path.of("lib_elijjah");
	}

	@Override
	public @NonNull Promise<Path, Void, Void> getPathPromise() {
		return _pathPromise;
	}

	@Override
	public @NonNull File toFile() {
		return getPath().toFile();
	}

	@Override
	public @Nullable File getRootFile() {
		return null;
	}

	@Override
	public @Nullable CP_Path getParent() {
		return null;
	}

	@Override
	public @Nullable String getName() {
		return null;
	}

	@Override
	public @NonNull _CP_RootPath getRootPath() {
		return this;
	}
}
