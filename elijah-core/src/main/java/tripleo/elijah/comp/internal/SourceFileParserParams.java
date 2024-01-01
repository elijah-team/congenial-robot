package tripleo.elijah.comp.internal;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.i.CompilationClosure;

import java.io.File;

public record SourceFileParserParams(/*@NotNull*/ CompilerInput input, @NotNull File f, @NotNull String file_name,
												  @NotNull CompilationClosure cc) {
}
