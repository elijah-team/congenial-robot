package tripleo.elijah.stages.deduce;

import tripleo.elijah.nextgen.query.QueryRef;
import tripleo.elijah_congenial.deduce.umbrella.DS_NamedEntity;

public interface DS_FunctionEntity extends DS_NamedEntity {
	@Override
	QueryRef getQueryRef();
}
