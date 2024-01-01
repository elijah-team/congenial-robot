package tripleo.elijah.comp.queries;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.CompilationClosure;
import tripleo.elijah.comp.internal.SourceFileParserParams;
import tripleo.elijah.util.Operation2;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class QuerySearchEzFiles {
	private final          Compilation        c;
	private final @NonNull CompilationClosure cc;
	private final          FilenameFilter     ez_files_filter = new EzFilesFilter();

	public QuerySearchEzFiles(final @NonNull CompilationClosure ccl) {
		c = ccl.getCompilation();

		this.cc = ccl;
	}

	public @NonNull Operation2<List<CompilerInstructions>> process(final @NonNull File directory) {
		final List<CompilerInstructions> R = new ArrayList<CompilerInstructions>();

		var errSink = cc.errSink();

		final String[] list = directory.list(ez_files_filter);
		if (list != null) {
			for (final String file_name : list) {
				try {
					final File                 file   = new File(directory, file_name);
					final CompilerInstructions ezFile = parseEzFile(file, file.toString(), cc);
					if (ezFile != null)
						R.add(ezFile);
					else
						errSink.reportError("9995 ezFile is null " + file); // TODO Diagnostic
				} catch (final Exception e) {
					errSink.exception(e);  // TODO Diagnostic or Operation
				}
			}
		}
		return Operation2.success(R);
	}

	@Nullable CompilerInstructions parseEzFile(final @NonNull File f, final @NonNull String file_name, final @NonNull CompilationClosure cc) {
		var p = new SourceFileParserParams(null, f, file_name, cc);
		return c.getCompilationEnclosure().getCompilationRunner().parseEzFile(p).success();
	}

	private static class EzFilesFilter implements FilenameFilter {
		@Override
		public boolean accept(final File file, final String s) {
			final boolean matches2 = Pattern.matches(".+\\.ez$", s);
			return matches2;
		}
	}
}
