package tripleo.elijah.stages.gen_fn_r;

import lombok.Getter;
import tripleo.elijah.stages.gen_fn.IEvaClass;
import tripleo.elijah.util.Eventual;

public class GenerateEvaClassResponse {
	@Getter	private final Eventual<IEvaClass> evaClassPromise = new Eventual<>();

//	public Eventual<EvaClass> getEvaClassPromise() {
//		// antilombok
//		return evaClassPromise;
//	}
}
