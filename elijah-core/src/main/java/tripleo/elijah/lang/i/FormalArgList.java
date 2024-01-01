package tripleo.elijah.lang.i;

import org.jspecify.annotations.NonNull;

import java.util.List;

public interface FormalArgList {
	List<FormalArgListItem> falis();

	@NonNull List<FormalArgListItem> items();

	FormalArgListItem next();

	@Override
	String toString();

	void serializeTo(SmallWriter sw);
}
