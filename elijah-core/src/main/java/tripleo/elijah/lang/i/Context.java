package tripleo.elijah.lang.i;

import com.google.common.collect.ImmutableList;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.lang.impl.ContextImpl;
import tripleo.elijah.lang.nextgen.names.i.EN_Name;

import java.util.ArrayList;
import java.util.List;

public interface Context {
	ContextImpl.Expectation expect(String aName, OS_Element aElement);

	List<ContextImpl.Expectation> getExpectations();

	@NonNull
	Compilation compilation();

	@Nullable Context getParent();

	LookupResultList lookup(@NonNull String name);

	LookupResultList lookup(String name, int level, LookupResultList Result, SearchList alreadySearched,
							boolean one);

	@NonNull
	OS_Module module();

	void addName(EN_Name aName);

	class SearchList {
		@NonNull List<Context> alreadySearched = new ArrayList<>();

		public void add(Context c) {
			alreadySearched.add(c);
		}

		public boolean contains(Context context) {
			return alreadySearched.contains(context);
		}

		public @NonNull ImmutableList<Context> getList() {
			return ImmutableList.copyOf(alreadySearched);
		}
	}
}
