package tripleo.elijah.stages.gen_generic;

import tripleo.elijah.lang.i.ClassStatement;
import tripleo.elijah.stages.gen_fn.GNCoded;
import tripleo.elijah.stages.gen_fn.IEvaClass;
import tripleo.elijah.world.i.LivingClass;

public interface IREvaClass extends GNCoded {
	ClassStatement getKlass();	@Override
	int getCode();

	IEvaClass getEvaClass();	@Override
	void setCode(int aI);

	void setLiving(LivingClass aLivingClass);	@Override
	default Role getRole() {
		return Role.CLASS;
	}






}
