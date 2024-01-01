/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.diagnostic.Locatable;
import tripleo.elijah.lang.impl.VariableStatementImpl;
import tripleo.elijah.stages.gen_fn.TypeTableEntry;
import tripleo.elijah.stages.gen_fn.VariableTableEntry;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created 4/13/21 5:46 AM
 */
public class CantDecideType implements Diagnostic {
	private final @NonNull Collection<TypeTableEntry> types;
	private final          VariableTableEntry         vte;

	public CantDecideType(VariableTableEntry aVte, @NonNull Collection<TypeTableEntry> aTypes) {
		vte   = aVte;
		types = aTypes;
	}

	@Override
	public @NonNull String code() {
		return "E1001";
	}

	@Override
	public void report(@NonNull PrintStream stream) {
		stream.printf("---[%s]---: %s%n", code(), message());
		// linecache.print(primary);
		for (Locatable sec : secondary()) {
			//linecache.print(sec)
		}
		stream.flush();
	}

	@Override
	public @NonNull Locatable primary() {
		@NonNull VariableStatementImpl vs = (VariableStatementImpl) vte.getResolvedElement();
		return vs;
	}

	private @NonNull String message() {
		return "Can't decide type";
	}

	@Override
	public @NonNull List<Locatable> secondary() {
		final List<Locatable> c = types.stream()
				.map((TypeTableEntry input) -> {
						 //return input.attached.getElement(); // TODO All elements should be Locatable
						 //return (TypeName)input.attached.getTypename();
						 return (Locatable) null;
					 }
					)
				.collect(Collectors.toList());

		return c;
	}

	@Override
	public @NonNull Severity severity() {
		return Severity.ERROR;
	}
}

//
//
//
