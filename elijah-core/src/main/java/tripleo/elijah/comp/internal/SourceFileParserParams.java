package tripleo.elijah.comp.internal;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.i.CompilationClosure;

import java.io.File;

public record SourceFileParserParams(/*@NonNull*/ CompilerInput input, @NonNull File f, @NonNull String file_name,
												  @NonNull CompilationClosure cc) {
}
