package com.microsoft.identity.nativeauth.statemachine.results;

import kotlin.Metadata;

/* JADX INFO: compiled from: SignInResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignInSubmitCodeResult extends Result {

    /* JADX INFO: compiled from: SignInResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(SignInSubmitCodeResult signInSubmitCodeResult) {
            return Result.DefaultImpls.isComplete(signInSubmitCodeResult);
        }

        public static boolean isError(SignInSubmitCodeResult signInSubmitCodeResult) {
            return Result.DefaultImpls.isError(signInSubmitCodeResult);
        }

        public static boolean isSuccess(SignInSubmitCodeResult signInSubmitCodeResult) {
            return Result.DefaultImpls.isSuccess(signInSubmitCodeResult);
        }
    }
}
