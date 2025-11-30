package tripleo.elijah

import gumtree.spoon.AstComparator
import gumtree.spoon.builder.SpoonGumTreeBuilder
import gumtree.spoon.diff.Diff
import gumtree.spoon.diff.DiffImpl
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import spoon.SpoonModelBuilder
import spoon.compiler.SpoonResource
import spoon.reflect.CtModel
import spoon.reflect.declaration.CtType
import spoon.reflect.factory.Factory
import spoon.support.compiler.VirtualFile // :=)
import spoon.support.compiler.jdt.JDTBasedSpoonCompiler // TODO big closure, separate jar
import spoon.testing.utils.ModelUtils.createFactory
import tripleo.elijah_durable_congenial.comp.Finally
import tripleo.elijah_durable_congenial.comp.i.Compilation
import tripleo.elijah_durable_congenial.comp.signal.DeducePipeline_finishedSignal // !
import tripleo.elijah_durable_congenial.factory.comp.CompilationFactory
import tripleo.elijah_durable_congenial.util.Helpers
import kotlin.test.assertEquals

@Ignore
@Suppress("PrivatePropertyName", // REPORTS is strange here, I'm sure it makes sense (see line 35)
	"ClassName")
class TestBasic_fact1_Gumtree { // fixme: move from junit for naming vanity
	private var REPORTS: Finally? = null
	private lateinit var c: Compilation

	@Before
	fun setUp() {
		val s = "test/basic/fact1/main2"
		c = CompilationFactory.mkCompilationSilent()
		c.feedCmdLine(Helpers.List_of(s, "-sO"))
		this.REPORTS = c.reports()

		// fixme This fails: move to actually
		assertEquals(true, c.getSignalResult(DeducePipeline_finishedSignal.INSTANCE))
	}

	@Test
	fun testInputs_fact1() {
		val ac = AstComparator()
		val scanner = SpoonGumTreeBuilder()

		val compare: Diff = DiffImpl(
			scanner.treeContext,
			scanner.getTree(m(ac, "a")),
			scanner.getTree(m(ac, "b"))
		)

		val ros = compare.rootOperations
		for (ro in ros) {
			System.err.println("9999-0053 $ro") // very not kt-style? (there you go)
		}

		assertEquals(listOf(), ros)
	}

	private fun m(
		@Suppress("unused") ac: AstComparator,
		filename: String
	): CtType<*>? { // fixme while we are here: Something about KProperty, re generation (also [will] looking at xtend)
		/// re aesthetics: ugly but necessary
		val content = String(TestBasic_fact1_Gumtree::class.java.getResourceAsStream(filename)!!.readAllBytes())
		val resource = VirtualFile(content, filename)
		return getCtType(resource)
	}

	/// This is the wrong type of function?
	fun getCtType(resource: SpoonResource?): CtType<*>? {
		val factory: Factory = createFactory()
		factory.model.setBuildModelIsFinished<CtModel>(false)
		val compiler: SpoonModelBuilder = JDTBasedSpoonCompiler(factory)
		compiler.factory.environment.setLevel("OFF")
		compiler.addInputSource(resource)
		compiler.build()
		if (factory.Type().all.isEmpty()) {
			return null
		}

		// let's first take the first type.
		val type = factory.Type().all[0]
		// Now, let's ask the factory the type (which will set up the corresponding package)
		return factory.Type().get<Any>(type.qualifiedName)
	}
}
