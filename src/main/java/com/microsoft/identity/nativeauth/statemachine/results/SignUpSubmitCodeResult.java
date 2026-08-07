package com.microsoft.identity.nativeauth.statemachine.results;

import kotlin.Metadata;

/* JADX INFO: compiled from: SignUpResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignUpSubmitCodeResult extends Result {

    /* JADX INFO: compiled from: SignUpResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(SignUpSubmitCodeResult signUpSubmitCodeResult) {
            return Result.DefaultImpls.isComplete(signUpSubmitCodeResult);
        }

        public static boolean isError(SignUpSubmitCodeResult signUpSubmitCodeResult) {
            return Result.DefaultImpls.isError(signUpSubmitCodeResult);
        }

        public static boolean isSuccess(SignUpSubmitCodeResult signUpSubmitCodeResult) {
            return Result.DefaultImpls.isSuccess(signUpSubmitCodeResult);
        }
    }
}
