package tripleo.elijah.stages.gen_c;

import org.jdeferred2.DoneCallback;
import tripleo.elijah.Eventual;
import tripleo.elijah.lang.i.OS_Element;
import tripleo.elijah.stages.gen_fn.EvaClass;
import tripleo.elijah.stages.gen_fn.EvaNode;
import tripleo.elijah.stages.gen_fn.IdentTableEntry;
import tripleo.elijah.stages.gen_fn.ProcTableEntry;

import java.util.Objects;

public final class GR_re_is_FunctionDef implements GRRR {
	private final ProcTableEntry  pte;
	private final EvaClass        cheat;
	private final IdentTableEntry ite;
	private final CRI_Ident       cri_ident;
	private final OS_Element      repo_element;
	private final GI_FunctionDef  gi_item;

	public GR_re_is_FunctionDef(ProcTableEntry aPte, EvaClass a_cheat, IdentTableEntry aIte, final CRI_Ident aCRIIdent, GI_FunctionDef aGiItem) {
		this.pte     = aPte;
		this.cheat   = a_cheat;
		this.ite     = aIte;
		cri_ident    = aCRIIdent;
		repo_element = ite.getResolvedElement();
		gi_item      = aGiItem;
	}

	public ProcTableEntry aPte() {
		return pte;
	}

	public EvaClass a_cheat() {
		return cheat;
	}

	public IdentTableEntry aIte() {
		return ite;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (GR_re_is_FunctionDef) obj;
		return Objects.equals(this.pte, that.pte) &&
				Objects.equals(this.cheat, that.cheat) &&
				Objects.equals(this.ite, that.ite);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pte, cheat, ite);
	}

	@Override
	public String toString() {
		return "GR_re_is_FunctionDef[" +
				"aPte=" + pte + ", " +
				"a_cheat=" + cheat + ", " +
				"aIte=" + ite + ']';
	}

	private final Eventual<EvaNode> resolvedP = new Eventual<>();

	public void onResolve(final DoneCallback<EvaNode> cb) {
		((GI_FunctionDef) repo_element).resolving(this);
		resolvedP.then(cb);
	}

	public CRI_Ident getCri_ident() {
		return cri_ident;
	}

	@Override
	public void reverseResolving(final Object aObject) {
		//assert
		this.gi_item._re_is_FunctionDef(pte, cheat, ite, resolvedP);
	}
}
