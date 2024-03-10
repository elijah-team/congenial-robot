/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.lang.impl;

import antlr.Token;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang2.ElElementVisitor;

/**
 * Created 3/26/21 4:47 AM
 */
public class El_CategoryImpl implements El_Category {
	private final AccessNotation notation;

	public El_CategoryImpl(AccessNotation aNotation) {
		notation = aNotation;
	}

	public El_CategoryImpl(final AccessNotationImpl aNotation, final Token aCategory) {
		notation = aNotation;
		//category = aCategory;
	}

	@Nullable
	public String getCategoryName() {
		final var category = notation.getCategory();
		if (category == null)
			return null;
		final String x = category.asString();
		return x; // luckily you dont use this because you broke it
		//return Helpers.remove_single_quotes_from_string(x);
	}

	@Override
	public Context getContext() {
		return this.notation.getContext();
	}

	@Override
	public OS_Element getParent() {
//		return parent;
		return this.notation.getParent();
	}

	@Override
	public void visitGen(ElElementVisitor visit) {
		// TODO Auto-generated method stub
//		visit.visitCategory(this);
	}

	@Override
	public void serializeTo(final SmallWriter sw) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Token getToken() {
		return notation.getCategory().getToken();
	}
}

//
//
//
