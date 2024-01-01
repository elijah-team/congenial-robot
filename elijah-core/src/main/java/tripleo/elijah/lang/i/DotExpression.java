package tripleo.elijah.lang.i;

import org.jspecify.annotations.NonNull;

public interface DotExpression extends IExpression {
	@NonNull
	IExpression getRight();

	@Override
	boolean is_simple();

	@Override
	String toString();
}
