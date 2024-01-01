package tripleo.elijah.nextgen.rosetta.DeduceTypes2;

import org.jspecify.annotations.NonNull;
import tripleo.elijah.nextgen.rosetta.DeducePhase.DeducePhase_deduceModule_Request;
import tripleo.elijah.stages.deduce.DeducePhase;
import tripleo.elijah.u.ElIntrinsics;

public final class DeduceTypes2_deduceFunctions_Request {
   @NonNull
   private final DeducePhase_deduceModule_Request request;
   @NonNull
   private final Iterable listOfEvaFunctions;
   private final boolean b;
   @NonNull
   private final DeducePhase deducePhase;

   public DeduceTypes2_deduceFunctions_Request(@NonNull DeducePhase_deduceModule_Request request, @NonNull Iterable listOfEvaFunctions, boolean b, @NonNull DeducePhase deducePhase) {
      ElIntrinsics.checkNotNullParameter(request, "request");
      ElIntrinsics.checkNotNullParameter(listOfEvaFunctions, "listOfEvaFunctions");
      ElIntrinsics.checkNotNullParameter(deducePhase, "deducePhase");

      this.request = request;
      this.listOfEvaFunctions = listOfEvaFunctions;
      this.b = b;
      this.deducePhase = deducePhase;
   }

   @NonNull
   public final DeducePhase_deduceModule_Request getRequest() {
      return this.request;
   }

   @NonNull
   public final Iterable getListOfEvaFunctions() {
      return this.listOfEvaFunctions;
   }

   public final boolean getB() {
      return this.b;
   }

   @NonNull
   public final DeducePhase getDeducePhase() {
      return this.deducePhase;
   }
}
