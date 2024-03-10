package tripleo.elijah.lang.i;

import antlr.Token;

public interface El_Category extends OS_Element {

	@Override
	default void serializeTo(SmallWriter sw) {

	}

	Token getToken();
}
