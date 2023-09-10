package tripleo.elijah.nextgen.hooper;

import tripleo.elijah.stages.gen_fn.EvaNode;
import tripleo.elijah.stages.gen_fn.GNCoded;

public class GCN_1 implements GCN {
	public static final DataKey<SymbolResolver> SYMBOL_RESOLVER_KEY = new DataKey<SymbolResolver>() {
	};
	private final       EvaNode                 evaNode;
	private final       GNCoded                 coded = new _Coded(this);

	public GCN_1(final EvaNode aEvaNode) {
		evaNode = aEvaNode;
	}

	@Override
	public EvaNode getEvaNode() {
		return evaNode;
	}

	@Override
	public GNCoded getCoded() {
		return coded;
	}
}
