package tripleo.vendor.mal;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.vendor.mal.types.*;

import java.util.HashMap;

public class env {
	public static class Env {
		@Nullable Env                     outer = null;
		@NonNull  HashMap<String, MalVal> data  = new HashMap<String, MalVal>();

		public Env(final Env outer) {
			this.outer = outer;
		}

		public Env(final Env outer, final @NonNull MalList binds, final @NonNull MalList exprs) {
			this.outer = outer;
			for (Integer i = 0; i < binds.size(); i++) {
				final String sym = ((MalSymbol) binds.nth(i)).getName();
				if (sym.equals("&")) {
					data.put(((MalSymbol) binds.nth(i + 1)).getName(),
							 exprs.slice(i));
					break;
				} else {
					data.put(sym, exprs.nth(i));
				}
			}
		}

		public @Nullable Env find(final @NonNull MalSymbol key) {
			if (data.containsKey(key.getName())) {
				return this;
			} else if (outer != null) {
				return outer.find(key);
			} else {
				return null;
			}
		}

		public MalVal get(final @NonNull MalSymbol key) throws MalThrowable {
			final Env e = find(key);
			if (e == null) {
				throw new MalException(
						"'" + key.getName() + "' not found");
			} else {
				return e.data.get(key.getName());
			}
		}

		public @NonNull Env set(final @NonNull MalSymbol key, final MalVal value) {
			data.put(key.getName(), value);
			return this;
		}
	}
}
