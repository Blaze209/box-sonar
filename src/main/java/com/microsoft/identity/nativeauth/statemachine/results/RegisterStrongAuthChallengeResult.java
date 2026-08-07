package com.microsoft.identity.nativeauth.statemachine.results;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.microsoft.identity.nativeauth.parameters.NativeAuthRegisterStrongAuthVerificationRequiredResultParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JITResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthChallengeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "VerificationRequired", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RegisterStrongAuthChallengeResult extends Result {

    /* JADX INFO: compiled from: JITResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(RegisterStrongAuthChallengeResult registerStrongAuthChallengeResult) {
            return Result.DefaultImpls.isComplete(registerStrongAuthChallengeResult);
        }

        public static boolean isError(RegisterStrongAuthChallengeResult registerStrongAuthChallengeResult) {
            return Result.DefaultImpls.isError(registerStrongAuthChallengeResult);
        }

        public static boolean isSuccess(RegisterStrongAuthChallengeResult registerStrongAuthChallengeResult) {
            return Result.DefaultImpls.isSuccess(registerStrongAuthChallengeResult);
        }
    }

    /* JADX INFO: compiled from: JITResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthChallengeResult$VerificationRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthChallengeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthRegisterStrongAuthVerificationRequiredResultParameter;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthRegisterStrongAuthVerificationRequiredResultParameter;)V", "getResult", "()Lcom/microsoft/identity/nativeauth/parameters/NativeAuthRegisterStrongAuthVerificationRequiredResultParameter;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class VerificationRequired extends Result.SuccessResult implements RegisterStrongAuthChallengeResult {
        private final NativeAuthRegisterStrongAuthVerificationRequiredResultParameter result;

        public final NativeAuthRegisterStrongAuthVerificationRequiredResultParameter getResult() {
            return this.result;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerificationRequired(NativeAuthRegisterStrongAuthVerificationRequiredResultParameter result) {
            super(result.getNextState$msal_distRelease());
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
        }
    }
}
