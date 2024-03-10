package tripleo.elijah.stages.gen_fn;

import tripleo.elijah.stages.deduce.nextgen.DR_Item;

import java.util.List;

public interface AddDrsSource {
	IBaseEvaFunction getFunction();

	List<DR_Item> getItems();
}
