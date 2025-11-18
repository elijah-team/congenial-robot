/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_durable_congenial.lang.impl;

import lombok.*;
import tripleo.elijah.xlang.LocatableString;
import tripleo.elijah_durable_congenial.lang.i.ExpressionList;
import tripleo.elijah_durable_congenial.lang.i.IndexingItem;
import tripleo.elijah_durable_congenial.lang.i.IndexingStatement;
import tripleo.elijah_durable_congenial.lang.i.OS_Module;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tripleo
 * <p>
 * Created Apr 15, 2020 at 4:59:21 AM
 */
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class IndexingStatementImpl implements IndexingStatement {
	private final List<IndexingItem> items = new ArrayList<>();
	//@With // ??
	private final OS_Module          parent;
	@With
	private       ExpressionList     exprs;
	@With
	private       LocatableString    name;

	public IndexingStatementImpl(final OS_Module aModule) {
		parent = aModule;
	}

	@Override
	public void add(final IndexingItem i) {
		items.add(i);
	}

	@Override
	public void setExprs(final ExpressionList el) {
		exprs = el;
	}

	@Override
	public void setName(final LocatableString i1) {
		name = i1;
	}

	/*
	 * public void setParent(OS_Module aParent) { parent = aParent; }
	 *
	 * public void setModule(final OS_Module module) { parent = module;}
	 */
}

//
//
//
