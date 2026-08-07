package com.microsoft.identity.nativeauth.statemachine.results;

import kotlin.Metadata;

/* JADX INFO: compiled from: JITResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthSubmitChallengeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RegisterStrongAuthSubmitChallengeResult extends Result {

    /* JADX INFO: compiled from: JITResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(RegisterStrongAuthSubmitChallengeResult registerStrongAuthSubmitChallengeResult) {
            return Result.DefaultImpls.isComplete(registerStrongAuthSubmitChallengeResult);
        }

        public static boolean isError(RegisterStrongAuthSubmitChallengeResult registerStrongAuthSubmitChallengeResult) {
            return Result.DefaultImpls.isError(registerStrongAuthSubmitChallengeResult);
        }

        public static boolean isSuccess(RegisterStrongAuthSubmitChallengeResult registerStrongAuthSubmitChallengeResult) {
            return Result.DefaultImpls.isSuccess(registerStrongAuthSubmitChallengeResult);
        }
    }
}
