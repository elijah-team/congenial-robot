package tripleo.elijah.stages.gen_fn_r;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import tripleo.elijah.lang.i.ClassStatement;
import tripleo.elijah.stages.deduce.ClassInvocation;
import tripleo.elijah.stages.gen_fn.GenerateFunctions;
import tripleo.elijah.u.ElIntrinsics;

public final class GenerateEvaClassRequest {
   private final @NonNull GenerateFunctions generateFunctions;
   private final @NonNull ClassStatement classStatement;
   private final @NonNull ClassInvocation classInvocation;
   private final @NonNull RegisterClassInvocation_env passthruEnv;

   public GenerateEvaClassRequest(@NonNull GenerateFunctions generateFunctions, @NonNull ClassStatement classStatement, @NonNull ClassInvocation classInvocation, @NonNull RegisterClassInvocation_env passthruEnv) {
      ElIntrinsics.checkNotNullParameter(generateFunctions, "generateFunctions");
      ElIntrinsics.checkNotNullParameter(classStatement, "classStatement");
      ElIntrinsics.checkNotNullParameter(classInvocation, "classInvocation");
      ElIntrinsics.checkNotNullParameter(passthruEnv, "passthruEnv");
      this.generateFunctions = generateFunctions;
      this.classStatement = classStatement;
      this.classInvocation = classInvocation;
      this.passthruEnv = passthruEnv;
   }

   public final @NonNull GenerateFunctions getGenerateFunctions() {
      return this.generateFunctions;
   }

   public final @NonNull ClassStatement getClassStatement() {
      return this.classStatement;
   }

   public final @NonNull ClassInvocation getClassInvocation() {
      return this.classInvocation;
   }

   public final @NonNull RegisterClassInvocation_env getPassthruEnv() {
      return this.passthruEnv;
   }

   public final @NonNull GenerateFunctions component1() {
      return this.generateFunctions;
   }

   public final @NonNull ClassStatement component2() {
      return this.classStatement;
   }

   public final @NonNull ClassInvocation component3() {
      return this.classInvocation;
   }

   public final @NonNull RegisterClassInvocation_env component4() {
      return this.passthruEnv;
   }

   public final @NonNull GenerateEvaClassRequest copy(@NonNull GenerateFunctions generateFunctions, @NonNull ClassStatement classStatement, @NonNull ClassInvocation classInvocation, @NonNull RegisterClassInvocation_env passthruEnv) {
      ElIntrinsics.checkNotNullParameter(generateFunctions, "generateFunctions");
      ElIntrinsics.checkNotNullParameter(classStatement, "classStatement");
      ElIntrinsics.checkNotNullParameter(classInvocation, "classInvocation");
      ElIntrinsics.checkNotNullParameter(passthruEnv, "passthruEnv");
      return new GenerateEvaClassRequest(generateFunctions, classStatement, classInvocation, passthruEnv);
   }

   public static GenerateEvaClassRequest copy$default(GenerateEvaClassRequest var0, GenerateFunctions var1, ClassStatement var2, ClassInvocation var3, RegisterClassInvocation_env var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.generateFunctions;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.classStatement;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.classInvocation;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.passthruEnv;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public @NonNull String toString() {
      String var10000 = String.valueOf(this.generateFunctions);
      return "GenerateEvaClassRequest(generateFunctions=" + var10000 + ", classStatement=" + String.valueOf(this.classStatement) + ", classInvocation=" + String.valueOf(this.classInvocation) + ", passthruEnv=" + String.valueOf(this.passthruEnv) + ")";
   }

   public int hashCode() {
      int result = this.generateFunctions.hashCode();
      result = result * 31 + this.classStatement.hashCode();
      result = result * 31 + this.classInvocation.hashCode();
      result = result * 31 + this.passthruEnv.hashCode();
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof GenerateEvaClassRequest)) {
         return false;
      } else {
         GenerateEvaClassRequest var2 = (GenerateEvaClassRequest)other;
         if (!ElIntrinsics.areEqual(this.generateFunctions, var2.generateFunctions)) {
            return false;
         } else if (!ElIntrinsics.areEqual(this.classStatement, var2.classStatement)) {
            return false;
         } else {
            return !ElIntrinsics.areEqual(this.classInvocation, var2.classInvocation) ? false : ElIntrinsics.areEqual(this.passthruEnv, var2.passthruEnv);
         }
      }
   }
}
