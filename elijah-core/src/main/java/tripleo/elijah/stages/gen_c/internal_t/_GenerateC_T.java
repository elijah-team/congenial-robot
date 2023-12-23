package tripleo.elijah.stages.gen_c.internal_t;

import tripleo.elijah.stages.gen_c.*;
import tripleo.elijah.stages.gen_fn.*;

import java.util.HashMap;
import java.util.Map;

public abstract class _GenerateC_T {
	protected final Map<EvaNode, WhyNotGarish_Item> a_directory = new HashMap<>();

	public WhyNotGarish_Constructor a_lookup(final EvaConstructor aGf) {
	  if (a_directory.containsKey(aGf)) {
		return (WhyNotGarish_Constructor) a_directory.get(aGf);
	  }

	  var ncc1907 = new WhyNotGarish_Constructor(aGf, _this());
	  a_directory.put(aGf, ncc1907);
	  return ncc1907;
	}

	public WhyNotGarish_Function a_lookup(final BaseEvaFunction aGf) {
	  if (a_directory.containsKey(aGf)) {
		return (WhyNotGarish_Function) a_directory.get(aGf);
	  }

	  var ncf = new WhyNotGarish_Function(aGf, _this());
	  a_directory.put(aGf, ncf);
	  return ncf;
	}

	public WhyNotGarish_Class a_lookup(final EvaClass aGc) {
	  if (a_directory.containsKey(aGc)) {
		return (WhyNotGarish_Class) a_directory.get(aGc);
	  }

	  var ncc = new WhyNotGarish_Class(aGc, _this());
	  a_directory.put(aGc, ncc);
	  return ncc;
	}

	public WhyNotGarish_Namespace a_lookup(final EvaNamespace en) {
	  if (a_directory.containsKey(en)) {
		return (WhyNotGarish_Namespace) a_directory.get(en);
	  }

	  var ncn = new WhyNotGarish_Namespace(en, _this());
	  a_directory.put(en, ncn);
	  return ncn;
	}

	public abstract GenerateC _this();

	public WhyNotGarish_Function a_lookup(final DeducedBaseEvaFunction aGf) {
	  return a_lookup((BaseEvaFunction) aGf.getCarrier());
	}
}
