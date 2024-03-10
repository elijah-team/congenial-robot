package tripleo.elijah.world.impl;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.comp.functionality.f291.AmazingPart;
import tripleo.elijah.lang.i.ClassStatement;
import tripleo.elijah.stages.garish.GarishClass;
import tripleo.elijah.stages.gen_fn.IEvaClass;
import tripleo.elijah.stages.gen_generic.IREvaClass;
import tripleo.elijah.world.i.LivingClass;

public class DefaultLivingClass implements LivingClass {
	private final           ClassStatement _element;
	private final @Nullable IEvaClass       _gc;
	private final IREvaClass _gcr;
	private @Nullable       GarishClass    _garish;

	@Contract(pure = true)
	public DefaultLivingClass(final ClassStatement aElement) {
		_element = aElement;
		_gc      = null;
		_garish  = null;
		_gcr     = null;
	}

	public DefaultLivingClass(final @NotNull IEvaClass aClass) {
		_element = aClass.getKlass();
		_gc      = aClass;
		_garish  = null;
		_gcr     = null;
	}

	public DefaultLivingClass(final IREvaClass aClass) {
		_element = aClass.getKlass();
		_gc      = aClass.getEvaClass();
		_gcr     = aClass;
		_garish  = null;
	}

	@Override
	public @Nullable IEvaClass evaNode() {
		return _gc;
	}

	@Override
	public ClassStatement getElement() {
		return _element;
	}

	@Override
	public int getCode() {
		return _gc.getCode();
	}

	public IEvaClass gc() {
		return _gc;
	}

	@Override
	@Contract(mutates = "this")
	public @NotNull GarishClass getGarish() {
		if (_garish == null) {
			_garish = new GarishClass(this);
		}

		return _garish;
	}

	@Override
	public void offer(final AmazingPart amazingPart) {
		amazingPart.reverseOffer(this);
	}

	//@Override
	//public void setGarish(final GarishClass aGarishClass) {
	//	_garish = aGarishClass;
	//}
}
