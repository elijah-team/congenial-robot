package tripleo.elijah.stages.post_deduce;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.stages.gen_fn.EvaClass;
import tripleo.elijah.stages.gen_fn.EvaNamespace;
import tripleo.elijah.stages.gen_fn.IBaseEvaFunction;
import tripleo.elijah.stages.gen_fn.IEvaClass;
import tripleo.elijah.stages.gen_generic.ICodeRegistrar;
import tripleo.elijah.stages.gen_generic.IREvaClass;
import tripleo.elijah.world.i.LivingRepo;

public class DefaultCodeRegistrar implements ICodeRegistrar {
	private final Compilation compilation;

	public DefaultCodeRegistrar(final Compilation aC) {
		compilation = aC;
	}

	@Override
	public void registerClass(final IREvaClass aClass) {
		compilation.livingRepo().addClass(aClass, LivingRepo.Add.MAIN_CLASS);
	}

	@Override
	public void registerClass1(final IREvaClass aClass) {
		compilation.livingRepo().addClass(aClass, LivingRepo.Add.NONE);
	}

	@Override
	public void registerFunction(final @NotNull IBaseEvaFunction aFunction) {
		compilation.livingRepo().addFunction(aFunction, LivingRepo.Add.MAIN_FUNCTION);
	}

	@Override
	public void registerFunction1(final IBaseEvaFunction aFunction) {
		compilation.livingRepo().addFunction(aFunction, LivingRepo.Add.NONE);
	}

	@Override
	public void registerNamespace(final EvaNamespace aNamespace) {
		compilation.livingRepo().addNamespace(aNamespace, LivingRepo.Add.NONE);
	}
}
