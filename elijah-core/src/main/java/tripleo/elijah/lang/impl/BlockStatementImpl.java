/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.lang.impl;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.lang.i.FormalArgList;
import tripleo.elijah.lang.i.NormalTypeName;
import tripleo.elijah.lang.i.Scope;
import tripleo.elijah.lang.i.StatementClosure;

// Referenced classes of package pak2:
//			Statement, StatementClosure, FormalArgList

public class BlockStatementImpl implements /* Statement, */ tripleo.elijah.lang.i.BlockStatement {

	private final          FormalArgList    fal = new FormalArgListImpl();
	final private          Scope            parent;
	private final @NonNull StatementClosure scope;
	private final          NormalTypeName   tn  = new RegularTypeNameImpl(); // FIXME

	public BlockStatementImpl(final Scope aParent) {
		parent = aParent;
		scope  = new AbstractStatementClosure(parent);
	}

	@Override
	public @NonNull FormalArgList opfal() {
		return fal;
	}

	@Override
	public @NonNull NormalTypeName returnType() {
		return tn;
	}

	@Override
	public @NonNull StatementClosure scope() {
		return scope;
	}
}
