package tripleo.elijah_durable_congenial.lang.i;

import tripleo.vendor.antlr277.Token;

public interface VariableReference extends IExpression {
	String getName();

	@Override
	OS_Type getType();

	@Override
	boolean is_simple();

	@Override
	String repr_();

	void setMain(String s);

	void setMain(Token t);

	@Override
	void setType(OS_Type deducedExpression);

	@Override
	String toString();
}
