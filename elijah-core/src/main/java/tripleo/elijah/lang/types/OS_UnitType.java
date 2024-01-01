package tripleo.elijah.lang.types;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.lang.i.OS_Element;
import tripleo.elijah.lang.i.OS_Type;


public class OS_UnitType extends __Abstract_OS_Type {

	@Override
	public @NonNull String asString() {
		return "<OS_UnitType>";
	}

	@Override
	protected boolean _isEqual(final @NonNull OS_Type aType) {
		return aType.getType() == Type.UNIT_TYPE;
	}

	@Override
	public @Nullable OS_Element getElement() {
		return null;
	}

	@Override
	public @NonNull Type getType() {
		return Type.UNIT_TYPE;
	}

	@Override
	public boolean isUnitType() {
		return true;
	}

	@Override
	public @NonNull String toString() {
		return "<UnitType>";
	}
}


