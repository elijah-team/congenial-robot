package tripleo.elijah.comp.i;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.inputtree.EIT_Input;
import tripleo.elijah.nextgen.outputstatement.EG_Statement;
import tripleo.elijah.nextgen.outputtree.EOT_FileNameProvider;
import tripleo.elijah.nextgen.outputtree.EOT_OutputFile;
import tripleo.elijah.nextgen.outputtree.EOT_OutputTree;
import tripleo.elijah.nextgen.outputtree.EOT_OutputType;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;
import tripleo.elijah.world.i.LivingRepo;
import tripleo.elijah.world.i.WorldModule;

import java.util.List;

public interface ICompilationAccess2 {
	LivingRepo world();

	EOT_OutputTree getOutputTree();

	void addCodeOutput(EOT_FileNameProvider aFileNameProvider, EOT_OutputFile aOutputFile);

	void addCodeOutput(EOT_FileNameProvider aFilename, EOT_OutputFile aOutputFile, boolean addFlag);

	WorldModule createWorldModule(OS_Module aMod);

	EOT_OutputFile createOutputFile(List<EIT_Input> aInputs,
									EOT_FileNameProvider aFilename,
									EOT_OutputType aEOTOutputType,
									EG_Statement aStatement);

	@NotNull Operation<Ok> mal_ReadEval(String string);
}
