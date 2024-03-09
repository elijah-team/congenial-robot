package tripleo.elijah.comp.internal;

public interface CSS_SimpleSignal {
	boolean canRun();

	void simpleSignalRun(final CSS_RunEnv aRunEnv);

	default boolean isOnce() {
		return false;
	}
}
