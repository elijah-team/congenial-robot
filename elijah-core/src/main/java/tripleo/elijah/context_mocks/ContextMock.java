/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 */
package tripleo.elijah.context_mocks;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import tripleo.elijah.UnintendedUseException;

import tripleo.elijah.comp.Compilation;

import tripleo.elijah.lang.i.Context;
import tripleo.elijah.lang.i.LookupResultList;
import tripleo.elijah.lang.nextgen.names.i.EN_Name;

import tripleo.elijah.lang.i.OS_Element;
import tripleo.elijah.lang.i.OS_Module;

import tripleo.elijah.lang.impl.ContextImpl;

import java.util.Objects;

/**
 * @author Tripleo
 * <p>
 * Created 	Nov 08, 2023
 */
public class ContextMock extends ContextImpl implements Context {
	private final @Nullable OS_Element carrier;
	private final @Nullable Context    _parent;

	public ContextMock(final @NotNull Context aParent, final @NotNull OS_Element fd) {
		_parent = aParent;
		carrier = fd;
	}

	public ContextMock() {
		carrier = null;
		_parent = null;
	}

	//@Override
	//public @NotNull Compilation compilation() {
	//	throw new UnintendedUseException();
	//}
	//
	//@Override
	//public LookupResultList lookup(@NotNull final String name) {
	//	throw new UnintendedUseException();
	//}

	@Override
	public Context getParent() {
		return _parent;
	}

	//@Override
	//public @NotNull OS_Module module() {
	//	throw new UnintendedUseException();
	//}

	//@Override
	//public void addName(final EN_Name aName) {
	//	throw new UnintendedUseException();
	//}

	@Override
	public LookupResultList lookup(final String name, final int level, final LookupResultList Result, final SearchList alreadySearched, final boolean one) {
		LookupResultList result = Result;

		for (final Expectation expectation : getExpectations()) {
			if (Objects.equals(expectation.getName(), name)) {
				expectation.contribute(Result);
			}
		}

		if (carrier != null) {
			if (carrier.getParent() != null) {
				final Context context = getParent();

				if (context != null) {
					result = context.lookup(name, level + 1, Result, alreadySearched, false);
				} else {
					assert false;
				}
			}
		}

		return result;
	}
}
