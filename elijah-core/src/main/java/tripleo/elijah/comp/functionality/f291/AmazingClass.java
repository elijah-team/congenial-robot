package tripleo.elijah.comp.functionality.f291;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.functionality.f291.Amazing;
import tripleo.elijah.comp.functionality.f291.WPIS_GenerateOutputs;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.lang.i.OS_Module;
import tripleo.elijah.nextgen.output.NG_OutputClass;
import tripleo.elijah.stages.gen_c.GenerateC;
import tripleo.elijah.stages.gen_fn.EvaClass;

class AmazingClass implements Amazing {
	private final OS_Module                        mod;
	private final Compilation                      compilation;
	private final WPIS_GenerateOutputs.OutputItems itms;
	private final EvaClass                         c;

	public AmazingClass(final @NotNull EvaClass c,
						final @NotNull WPIS_GenerateOutputs.OutputItems aOutputItems,
						final IPipelineAccess aPa) {
		this.c              = c;
		mod                 = c.module();
		compilation         = mod.getCompilation();
		itms                = aOutputItems;
	}

	void waitGenC(final GenerateC ggc) {
		var oc = new NG_OutputClass();
		oc.setClass(compilation.livingRepo().getClass(c).getGarish(), ggc);
		itms.addItem(oc);
	}

	public OS_Module mod() {
		return mod;
	}
}
