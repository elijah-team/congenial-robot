/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 */
package tripleo.elijah.stages.gen_generic;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.ci.LibraryStatementPart;
import tripleo.elijah.stages.gen_fn.EvaNode;
import tripleo.util.buffer.Buffer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created 4/27/21 1:12 AM
 */
public class Old_GenerateResultItem implements GenerateResultItem {
	public final @NonNull  Buffer                buffer;
	public final           int                   counter;
	public final @NonNull  LibraryStatementPart  lsp;
	public final @NonNull  EvaNode               node;
	public final @NonNull  Old_GenerateResult.TY ty;
	private final @NonNull Dependency            dependency;
	public                 String                output;
	public                 IOutputFile           outputFile;

	@Contract(pure = true)
	public Old_GenerateResultItem(final @NonNull Old_GenerateResult.TY aTy,
								  final @NonNull Buffer aBuffer,
								  final @NonNull EvaNode aNode,
								  final @NonNull LibraryStatementPart aLsp,
								  final @NonNull Dependency aDependency,
								  final int aCounter) {
		ty         = aTy;
		buffer     = aBuffer;
		node       = aNode;
		lsp        = aLsp;
		dependency = aDependency;
		counter    = aCounter;
	}

	@Override
	public @NonNull Buffer buffer() {
		return this.buffer;
	}

	/* (non-Javadoc)
	 * @see tripleo.elijah.stages.gen_generic.GenerateResultItem#dependencies()
	 */
	@Override
	public @NonNull List<DependencyRef> dependencies() {
		List<DependencyRef> x = dependency.getNotedDeps().stream()
				.map(dep -> dep.dref)
				.collect(Collectors.toList());
		return x;
	}

	/* (non-Javadoc)
	 * @see tripleo.elijah.stages.gen_generic.GenerateResultItem#getDependency()
	 */
	@Override
	public @NonNull Dependency getDependency() {
		final List<DependencyRef> ds = dependencies();
		return dependency;
	}

	/* (non-Javadoc)
	 * @see tripleo.elijah.stages.gen_generic.GenerateResultItem#jsonString()
	 */
	@Override
	public @NonNull String jsonString() {
		final String sb = "{\".class\": \"GenerateResultItem\", " + "counter: " + counter + ", " +
				"ty: " + ty + ", " +
				"output: " + output + ", " +
				"outputFile: " + outputFile + ", " +
				"lsp: " + lsp + ", " +
				"node: " + node + ", " +
				"buffer: \"\"\"" + buffer.getText() + "\"\"\", " +
				"dependency: " + dependency.jsonString() + ", " +
				"dependencies: " + dependencies() +/*+", "*/
				"}";
		return sb;
	}

	@Override
	public @NonNull LibraryStatementPart lsp() {
		return this.lsp;
	}

	@Override
	public @NonNull EvaNode node() {
		return this.node;
	}

	@Override
	public String output() {
		return this.output;
	}

	@Override
	public GenerateResult.@NonNull TY __ty() {
		return ty;
	}

	/* (non-Javadoc)
	 * @see tripleo.elijah.stages.gen_generic.GenerateResultItem#toString()
	 */
	@Override
	public @NonNull String toString() {
		return "GenerateResultItem{" +
				"counter=" + counter +
				", ty=" + ty +
				", buffer=" + buffer.getText() +
				", node=" + node.identityString() +
				", lsp=" + lsp.getDirName() +
				", dependency=" + dependency.jsonString() +
				", output='" + output + '\'' +
				", outputFile=" + outputFile +
				'}';
	}

	@Override
	public int _counter() {
		return counter;
	}
}

//
// vim:set shiftwidth=4 softtabstop=0 noexpandtab:
//
