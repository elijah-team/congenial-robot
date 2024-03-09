package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.i.CB_Action;
import tripleo.elijah.comp.i.CB_OutputString;
import tripleo.elijah.comp.i.CR_Action;
import tripleo.elijah.util.SimplePrintLoggerToRemoveSoon;

import java.util.ArrayList;
import java.util.List;

import static tripleo.elijah.util.Helpers.List_of;

class CB_FindCIs implements CB_Action {
	private final CompilationRunner   compilationRunner;
	//private final List<CompilerInput> _inputs;

	@Contract(pure = true)
	public CB_FindCIs(final CompilationRunner aCompilationRunner, final List<CompilerInput> ignoredAInputs) {
		compilationRunner = aCompilationRunner;
		//_inputs           = aInputs;
		o                 = compilationRunner.getCompilationEnclosure().getCB_Output();
	}

	private final CB_Output o;

	@Override
	public void execute() {
		final List<CR_ActionSupplier> crActionList = List_of(
				FindCIsSupplier.of(compilationRunner),
				AlmostCompleteSupplier.of()
															);

		for (final CR_ActionSupplier actionSupplier : crActionList) {
			final CR_Action action = actionSupplier.get();

			U._run_action_list__internal(compilationRunner.crState, o, action, new ArrayList<>());

			//action.attach(compilationRunner);
			//final Eventual<Operation<Ok>> eoo = new Eventual<>();
			//action.execute(compilationRunner.crState, o, eoo);
		}

		for (final CB_OutputString outputString : o.get()) {
			//08/13
			SimplePrintLoggerToRemoveSoon.println_out_3("** CB_FindCIs :: outputString :: " + outputString.getText());
		}
	}

	@Contract(pure = true)
	@Override
	public @NotNull String name() {
		return "FindCIs";
	}

	@Override
	public @NotNull List<CB_OutputString> outputStrings() {
		return o.get();
	}
}
