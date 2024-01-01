package tripleo.elijah.lang.i;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.diagnostic.Locatable;
import tripleo.elijah.lang2.ElElementVisitor;

public interface VariableStatement extends @NonNull Locatable, OS_Element {
	@Override
	Context getContext();

	String getName();

	IdentExpression getNameToken();

	TypeModifiers getTypeModifiers();

	void initial(IExpression aExpr);

	@NonNull
	IExpression initialValue();

	void set(TypeModifiers y);

	void setName(IdentExpression s);

	void setTypeName(@NonNull TypeName tn);

	@NonNull
	TypeName typeName();

	@Override
	void visitGen(ElElementVisitor visit);

	@Override
	default void serializeTo(SmallWriter sw) {

	}
}
