package tripleo.elijah.stages.deduce.post_bytecode;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.comp.i.ErrSink;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.lang.i.OS_Type;
import tripleo.elijah.stages.deduce.DeduceTypes2;
import tripleo.elijah.stages.gen_fn.*;

class DeduceType3 implements DED {
	private final @Nullable IDeduceElement3 deduceElement3;
	private final           Diagnostic      diagnostic;

	private       GenType _genType;
	private final OS_Type osType;

	public DeduceType3(final OS_Type aOSType, final Diagnostic aDiagnostic) {
		deduceElement3 = null;
		osType         = aOSType;
		diagnostic     = aDiagnostic;
	}

	public static IDeduceElement3 dispatch(final @NonNull IdentTableEntry aIdentTableEntry, final DeduceTypes2 aDeduceTypes2, final BaseEvaFunction aGeneratedFunction) {
		return aIdentTableEntry.getDeduceElement3(aDeduceTypes2, aGeneratedFunction);
	}

	public DeduceType3(final IDeduceElement3 aDeduceElement3, final OS_Type aOSType, final Diagnostic aDiagnostic1) {
		deduceElement3 = aDeduceElement3;
		osType         = aOSType;
		diagnostic     = aDiagnostic1;
	}

//	public static IDeduceElement3 dispatch(final @NonNull IdentTableEntry aIdentTableEntry) {
//		return aIdentTableEntry.getDeduceElement3(null/*aDeduceTypes2*/, null/*aGeneratedFunction*/);
//	}

//	public static IDeduceElement3 dispatch(final @NonNull ConstantTableEntry aConstantTableEntry) {
//		return aConstantTableEntry.getDeduceElement3();
//	}

	public static IDeduceElement3 dispatch(final @NonNull VariableTableEntry aVariableTableEntry) {
		return aVariableTableEntry.getDeduceElement3();
	}

	public GenType getGenType() {
		if (_genType == null) {
			//_genType          = _inj().new_GenTypeImpl();
			_genType = new GenTypeImpl();
			_genType.setResolved(osType);
		}

		return _genType;
	}

	public boolean isException() {
		return diagnostic != null;
	}

	@Override
	public @NonNull Kind kind() {
		return Kind.DED_Kind_Type;
	}

	public void reportDiagnostic(final @NonNull ErrSink aErrSink) {
		assert isException();

		aErrSink.reportDiagnostic(diagnostic);
	}
	//private DeduceTypes2Injector _inj() {
	//	return deduceTypes2()._inj();
	//}

}
