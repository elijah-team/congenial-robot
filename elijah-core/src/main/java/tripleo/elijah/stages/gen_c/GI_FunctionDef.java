package tripleo.elijah.stages.gen_c;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.Eventual;
import tripleo.elijah.lang.i.FunctionDef;
import tripleo.elijah.sanaa.ElIntrinsics;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.util.NotImplementedException;
import tripleo.elijah.util.ProgramMightBeWrongIfYouAreHere;
import tripleo.elijah.world.i.LivingFunction;

public class GI_FunctionDef implements GenerateC_Item {
	private final FunctionDef    _e;
	private final GI_Repo        _repo;
	private       LivingFunction _living;
	private       EvaNode        _evaNode;

	public GI_FunctionDef(final FunctionDef aE, final GI_Repo aGIRepo) {
		_e    = aE;
		_repo = aGIRepo;
	}

	void _re_is_FunctionDef(final @Nullable ProcTableEntry pte,
							final @Nullable EvaClass a_cheat,
							final @NotNull  IdentTableEntry ite,
							final @NotNull  Eventual<EvaNode> resolvedP
						   ) {
		final Z3 z3 = new Z3();

		if (pte != null) {
			pte.onFunctionInvocation(fi -> {
				if (fi != null) {
					fi.onGenerated((BaseEvaFunction gen) -> {
						//noinspection unused
						final var _fi = fi;
						assert gen != null;
						z3.a = gen;
					});
				} else {
					throw new ProgramMightBeWrongIfYouAreHere("what in tarnation??");
				}
			});
		}

		{
			ite.onResolvedType(resolvedIteEvaNode -> {
				if (resolvedIteEvaNode instanceof EvaFunction) {
					z3.b = resolvedIteEvaNode;
				} else if (resolvedIteEvaNode instanceof EvaClass) {
					z3.b = resolvedIteEvaNode;

					// FIXME Bar#quux is not being resolves as a BGF in Hier
					// FIXME 24/03/07 do a special case with COMP*.debug.some-shit

					//FunctionInvocation fi = pte.getFunctionInvocation();
					//fi.setClassInvocation();

					NotImplementedException.raise_stop();
				}
			});
		}

		z3.c = a_cheat;

		do {
			if (z3.a != null) { resolvedP.resolve(z3.a); break; }
			if (z3.b != null) { resolvedP.resolve(z3.b); break; }
			if (z3.c != null) { resolvedP.resolve(z3.c); break; }
			throw new ProgramMightBeWrongIfYouAreHere();
		} while (false);
	}

	/**
	 * Maybe better as an array?
	 * What does hotspot(name??) have to say
	 */
	final class Z3 {
		EvaNode a, b, c; // once sets
	}

	@Override
	public EvaNode getEvaNode() {
		return _evaNode;
	}

	@Override
	public void setEvaNode(final EvaNode aEvaNode) {
		if (aEvaNode == null) {
			int y = 3;
			assert false;
		} else {
			ElIntrinsics.checkNotNull(aEvaNode);

			_evaNode = aEvaNode;
			_living  = _repo.generateC._ce().getCompilation().livingRepo().getFunction((BaseEvaFunction) _evaNode);
		}
	}

	@Override
	public void setEvaNode_by(final GR_EvaNodeAble aKotlinEnvy) {
		aKotlinEnvy.onResolve(this::setEvaNode);
	}

	public void resolving(final GRRR aGRReIsFunctionDef) {
		aGRReIsFunctionDef.reverseResolving(this);
	}
}
