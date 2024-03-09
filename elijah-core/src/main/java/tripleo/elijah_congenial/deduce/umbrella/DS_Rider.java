package tripleo.elijah_congenial.deduce.umbrella;

import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah_congenial.deduce.umbrella.DS_Base;

/**
 * This is a complement to {@link DS_Base} in resolveWith.<br/>
 * It is used to provide information about the environment in which/
 * for which the resolve is running.<br/>
 * <br/>
 * {@code #generatedFunction} is the function in which the name is being looked up from
 */
public interface DS_Rider {
	BaseEvaFunction generatedFunction();
}
