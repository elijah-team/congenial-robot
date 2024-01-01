package tripleo.elijah.stages.gen_generic.pipeline_impl;

import org.jetbrains.annotations.Contract;
import org.jspecify.annotations.NonNull;
import tripleo.elijah.UnintendedUseException;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.nextgen.output.NG_OutputClass;
import tripleo.elijah.nextgen.output.NG_OutputFunction;
import tripleo.elijah.nextgen.output.NG_OutputNamespace;
import tripleo.elijah.stages.garish.GarishClass;
import tripleo.elijah.stages.garish.GarishNamespace;
import tripleo.elijah.stages.gen_c.C2C_Result;
import tripleo.elijah.stages.gen_c.GenerateC;
import tripleo.elijah.stages.gen_fn.EvaClass;
import tripleo.elijah.stages.gen_fn.EvaNamespace;
import tripleo.elijah.stages.gen_fn.EvaNode;
import tripleo.elijah.stages.gen_generic.GenerateFiles;
import tripleo.elijah.stages.gen_generic.GenerateResult;
import tripleo.elijah.stages.pp.IPP_Function;
import tripleo.elijah.stages.pp.PP_Constructor;
import tripleo.elijah.world.i.LivingClass;
import tripleo.elijah.world.i.LivingNamespace;
import tripleo.util.buffer.Buffer;

import java.util.List;

public class DefaultGenerateResultSink implements GenerateResultSink {
	private final @NonNull IPipelineAccess pa;

	@Contract(pure = true)
	public DefaultGenerateResultSink(final @NonNull IPipelineAccess pa0) {
		pa = pa0;
	}

	@Override
	public void add(final EvaNode node) {
		throw new IllegalStateException("Error");
	}

	@Override
	public void addClass_0(final GarishClass aGarishClass, final Buffer aImplBuffer, final Buffer aHeaderBuffer) {
		throw new IllegalStateException("Error");
	}

	@Override
	public void addClass_1(final @NonNull GarishClass aGarishClass,
						   final @NonNull GenerateResult gr,
						   final @NonNull GenerateC aGenerateC) {
		NG_OutputClass o = new NG_OutputClass();
		o.setClass(aGarishClass, aGenerateC);
		pa.addOutput(o);
	}

	@Override
	public void addFunction(final IPP_Function aGf, final List<C2C_Result> aRs, final GenerateFiles aGenerateFiles) {
		NG_OutputFunction o = new NG_OutputFunction();
		o.setFunction(aGf, aGenerateFiles, aRs);
		pa.addOutput(o);
	}

	@Override
	public void additional(final @NonNull GenerateResult aGenerateResult) {
		//throw new IllegalStateException("Error");
	}

	@Override
	public void addNamespace_0(final @NonNull GarishNamespace aGarishNamespace, final Buffer aImplBuffer, final Buffer aHeaderBuffer) {
		throw new IllegalStateException("Error");
	}

	@Override
	public void addNamespace_1(final @NonNull GarishNamespace aGarishNamespace,
							   final @NonNull GenerateResult gr,
							   final @NonNull GenerateC aGenerateC) {
		NG_OutputNamespace o = new NG_OutputNamespace();
		o.setNamespace(aGarishNamespace, aGenerateC);
		pa.addOutput(o);
	}

	@Override
	public LivingClass getLivingClassForEva(final EvaClass aEvaClass) {
		return pa.getCompilation().livingRepo().getClass(aEvaClass);
	}

	@Override
	public LivingNamespace getLivingNamespaceForEva(final EvaNamespace aEvaNamespace) {
		return pa.getCompilation().livingRepo().getNamespace(aEvaNamespace);
	}

	@Override
	public void addFunction(final PP_Constructor aPPConstructor, final List<C2C_Result> aRs, final GenerateC aGenerateC) {
		throw new UnintendedUseException();
	}
}
