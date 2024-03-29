/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah;

import org.junit.Test;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.IO;
import tripleo.elijah.comp.StdErrSink;
import tripleo.elijah.comp.internal.DefaultCompilerController;
import tripleo.elijah.factory.comp.CompilationFactory;

import static org.junit.Assert.assertEquals;
import static tripleo.elijah.util.Helpers.List_of;

/**
 * Created 3/5/21 4:32 AM
 */
public class ClassInstantiationTest {

	@Test
	public void classInstantiation() {
		String      f = "test/basic1/class_instantiation/";
		final Compilation  c    = CompilationFactory.mkCompilationSilent(new StdErrSink(), new IO());

		c.feedInputs(List_of(new CompilerInput(f)), new DefaultCompilerController());

		System.err.println("Errorcount is " + c.errorCount());

		assertEquals(1_000_000, c.errorCount());
	}

	@Test
	public void classInstantiation2() {
		String      f = "test/basic1/class_instantiation2/";
		final Compilation  c    = CompilationFactory.mkCompilationSilent(new StdErrSink(), new IO());

		c.feedInputs(List_of(new CompilerInput(f)), new DefaultCompilerController());

		System.err.println("Errorcount is " + c.errorCount());

		assertEquals(1_000_000, c.errorCount());
	}

	@Test
	public void classInstantiation3() {
		String      f = "test/basic1/class_instantiation3/";
		final Compilation  c    = CompilationFactory.mkCompilationSilent(new StdErrSink(), new IO());

		c.feedInputs(List_of(new CompilerInput(f)), new DefaultCompilerController());

		System.err.println("Errorcount is " + c.errorCount());

		assertEquals(1_000_000, c.errorCount());
	}

	@Test
	public void classInstantiation4() {
		String      f = "test/basic1/class_instantiation4/";
		final Compilation  c    = CompilationFactory.mkCompilationSilent(new StdErrSink(), new IO());

		c.feedInputs(List_of(new CompilerInput(f)), new DefaultCompilerController());

		System.err.println("Errorcount is " + c.errorCount());

		assertEquals(1_000_000, c.errorCount());
	}
}

//
//
//
