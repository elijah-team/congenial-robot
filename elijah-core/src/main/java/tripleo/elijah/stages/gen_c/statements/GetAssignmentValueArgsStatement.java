package tripleo.elijah.stages.gen_c.statements;

import org.jetbrains.annotations.Nullable;
import tripleo.elijah.UnintendedUseException;
import tripleo.elijah.nextgen.outputstatement.*;
import tripleo.elijah.stages.instructions.Instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class GetAssignmentValueArgsStatement implements EG_Statement {
	private final List<String> sll = new ArrayList<>();
	private final Instruction inst;

	public GetAssignmentValueArgsStatement(final Instruction aInst) {
		inst = aInst;
	}

	public void add_string(final String aS) {
		sll.add(aS);
	}

	@Override
	public EX_Explanation getExplanation() {
		throw new UnintendedUseException();
		// return null;
	}

	@Override
	public @Nullable String getText() {
		final String gavass = "GetAssignmentValueArgsStatement";

		final EG_SequenceStatement getAssignmentValueArgsStatement = new EG_SequenceStatement(
				new EG_Naming(gavass),
				sll.stream()
						.map(x -> EG_Statement.of(x, EX_Explanation.withMessage(gavass)))
						.collect(Collectors.toList())
		);
		return getAssignmentValueArgsStatement.getText();
	}

	public List<String> stringList() {
		return sll;
	}
}
