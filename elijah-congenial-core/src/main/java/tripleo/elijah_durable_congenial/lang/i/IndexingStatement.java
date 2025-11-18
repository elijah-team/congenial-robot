package tripleo.elijah_durable_congenial.lang.i;


import tripleo.elijah.xlang.LocatableString;
import tripleo.vendor.antlr277.Token;

public interface IndexingStatement {
	void add(IndexingItem i);

	void setExprs(ExpressionList el);

	default void setName(Token i1) {setName(LocatableString.of(toString()));}

	void setName(LocatableString i1);
}
