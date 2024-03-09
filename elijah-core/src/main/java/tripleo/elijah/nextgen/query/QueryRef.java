package tripleo.elijah.nextgen.query;

import org.jdeferred2.DoneCallback;
import tripleo.elijah.util.Eventual;
import tripleo.elijah.util.EventualRegister;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util._Extensionable;

import java.util.HashMap;
import java.util.Map;

public interface QueryRef extends _Extensionable {
	String getId();

	boolean isMaterialized();
	boolean isSaved();

	Eventual<Ok> queueSave();
	Eventual<Ok> queueSave(EventualRegister er);

	String versionString();
	Cons<String> previousVersion();

	void onMaterialize(DoneCallback<Object> dco);

	void onMaterialize(DoneCallback<Object> dco, EventualRegister er);

	@Override
	Object getExt(Class<?> aClass);

	@Override
	void putExt(Class<?> aClass, Object o);

	interface Cons<T> {
		T item();
		void setItem(T t);

		Cons<T> next();
		void setNext(Cons<T> ct);
	}

	abstract class __Extensionable implements _Extensionable {
		private final Map<Object, Object> exts = new HashMap<>();

		@Override
		public Object getExt(Class<?> aClass) {
			if (exts.containsKey(aClass)) {
				return exts.get(aClass);
			}
			return null;
		}

		@Override
		public void putExt(Class<?> aClass, Object o) {
			exts.put(aClass, o);
		}
	}
}
