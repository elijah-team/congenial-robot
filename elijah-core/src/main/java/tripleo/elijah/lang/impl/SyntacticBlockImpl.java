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
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.contexts.SyntacticBlockContext;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang2.ElElementVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created 8/30/20 1:49 PM
 */
public class SyntacticBlockImpl
		implements OS_Element, OS_Container, StatementItem, tripleo.elijah.lang.i.SyntacticBlock {

	private final List<FunctionItem>    _items = new ArrayList<>();
	private final OS_Element            _parent;
	private       SyntacticBlockContext ctx;
	private       Scope3                scope3;

	public SyntacticBlockImpl(final OS_Element aParent) {
		_parent = aParent;
	}

	@Override // OS_Container
	public void addToContainer(final OS_Element anElement) {
		if (!(anElement instanceof FunctionItem)) {
            return; // TODO throw?
        }
		scope3.add(anElement);
	}

	@Override
	public void add(OS_Element anElement) {
		addToContainer(anElement);
	}

	@Override
	public void addDocString(Token s1) {
		scope3.addDocString(s1);
	}

	@Override
	public Context getContext() {
		return ctx;
	}

	@Override
	public @NotNull List<FunctionItem> getItems() {
		List<FunctionItem> collection = new ArrayList<>();
		for (OS_Element element : scope3.items()) {
			if (element instanceof FunctionItem)
				collection.add((FunctionItem) element);
		}
		return collection;
		// return _items;
	}

	@Override
	public OS_Element getParent() {
		return _parent;
	}

	@Override
	public @NotNull List<OS_NamedElement> items() {
		// TODO Forgot how to do this in "one" step
		final Stream<OS_NamedElement> items = scope3.items().stream()
				.filter(input -> input instanceof OS_NamedElement)
				.map(input -> (OS_NamedElement) input)
				;
		return items.toList();
	}

	@Override
	public void visitGen(final @NotNull ElElementVisitor visit) {
		visit.visitSyntacticBlock(this);
	}

	@Override
	public void serializeTo(final SmallWriter sw) {

	}

	@Override
	public void scope(Scope3 sco) {
		scope3 = sco;
	}

	@Override
	public void postConstruct() {
	}

	@Override
	public void setContext(final SyntacticBlockContext ctx) {
		this.ctx = ctx;
	}

}

//
//
//
