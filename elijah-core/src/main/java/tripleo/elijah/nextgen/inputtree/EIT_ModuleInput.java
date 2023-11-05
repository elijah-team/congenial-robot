package tripleo.elijah.nextgen.inputtree;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import tripleo.elijah.comp.Compilation;
import tripleo.elijah.lang.i.OS_Module;

import tripleo.elijah.nextgen.model.SM_Module;

import tripleo.elijah.nextgen.model.impl.SM_Module_;

public class EIT_ModuleInput implements EIT_Input {
	private final Compilation c;
	private final OS_Module   module;

	@Contract(pure = true)
	public EIT_ModuleInput(final OS_Module aModule, final Compilation aC) {
		module = aModule;
		c      = aC;
	}

	public @NotNull SM_Module computeSourceModel() {
		final SM_Module sm = new SM_Module_(this);
		return sm;
	}

/*
	public void doGenerate(final List<EvaNode> nodes,
						   final WorkManager wm,
						   final @NotNull Consumer<GenerateResult> resultConsumer,
						   final CompilationEnclosure ce) {
		// 0. get lang
		final String lang = langOfModule();

		// 1. find Generator (GenerateFiles) eg. GenerateC
		final OutputFileFactoryParams p             = new OutputFileFactoryParams(module, ce);
		final GenerateFiles           generateFiles = OutputFileFactory.create(lang, p);

		// 2. query results
		final GenerateResult gr2 = generateFiles.resultsFromNodes(nodes, wm, ((GenerateC) generateFiles).resultSink);

		// 3. #drain workManager -> README part of workflow. may change later as appropriate
		wm.drain();

		// 4. tail process results
		resultConsumer.accept(gr2);
	}

	@NotNull
	private String langOfModule() {
		final LibraryStatementPart lsp  = module.getLsp();
		final CompilerInstructions ci   = lsp.getInstructions();
		final String               lang = ci.genLang() == null ? Compilation.CompilationAlways.defaultPrelude() : ci.genLang();
		// DEFAULT(compiler-default), SPECIFIED(gen-clause: codePoint), INHERITED(cp) // CodePoint??
		return lang;
	}
*/

	@Override
	public @NotNull EIT_InputType getType() {
		return EIT_InputType.ELIJAH_SOURCE;
	}

	public OS_Module module() {
		return this.module;
	}
}
