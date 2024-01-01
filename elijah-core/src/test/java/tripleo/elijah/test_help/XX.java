package tripleo.elijah.test_help;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang.impl.*;
import tripleo.elijah.lang.types.OS_UserType;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.stages.gen_fn.GenType;
import tripleo.elijah.stages.gen_fn.GenTypeImpl;
import tripleo.elijah.stages.gen_fn.TypeTableEntry;
import tripleo.elijah.util.Helpers;

public class XX {

	public @NonNull IdentExpression makeIdent(final String aX) {
		final IdentExpression identExpression = Helpers.string_to_ident(aX);
		return identExpression;
	}

	public @NonNull TypeTableEntry regularTypeName_specifyTableEntry(final @NonNull IdentExpression aIdentExpression,
																	 final @NonNull BaseEvaFunction aBaseGeneratedFunction,
																	 final @NonNull String aTypeName) {
		final RegularTypeName typeName = RegularTypeName.makeWithStringTypeName(aTypeName);
		final OS_Type         type     = new OS_UserType(typeName);
		final TypeTableEntry  tte      = aBaseGeneratedFunction.newTypeTableEntry(TypeTableEntry.Type.SPECIFIED, type, aIdentExpression);

		return tte;
	}

	public @NonNull VariableStatementImpl sequenceAndVarNamed(final IdentExpression aIdentExpression) {
		final VariableSequenceImpl  seq   = new VariableSequenceImpl();
		final VariableStatementImpl x_var = new VariableStatementImpl(seq);

		x_var.setName(aIdentExpression);

		return x_var;
	}

	public IdentExpression makeIdent(final String aFoo, final Context aFooCtx) {
		final IdentExpression identExpression = Helpers.string_to_ident(aFoo);
		identExpression.setContext(aFooCtx);
		return identExpression;
	}

	public GenType makeGenType(final TypeTableEntry tte) {
		final GenType genType = new GenTypeImpl();
		genType.setTypeName(tte.getAttached());
		return genType;
	}

	@NonNull
	public ProcedureCallExpression makeDottedProcedureCall(final IdentExpression x, final IdentExpression foo) {
		final ProcedureCallExpression pce;
		pce = new ProcedureCallExpressionImpl();
		pce.setLeft(new DotExpressionImpl(x, foo));
		return pce;
	}
}
