package com.microsoft.identity.nativeauth.statemachine.results;

import kotlin.Metadata;

/* JADX INFO: compiled from: SignInResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignInSubmitPasswordResult extends Result {

    /* JADX INFO: compiled from: SignInResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(SignInSubmitPasswordResult signInSubmitPasswordResult) {
            return Result.DefaultImpls.isComplete(signInSubmitPasswordResult);
        }

        public static boolean isError(SignInSubmitPasswordResult signInSubmitPasswordResult) {
            return Result.DefaultImpls.isError(signInSubmitPasswordResult);
        }

        public static boolean isSuccess(SignInSubmitPasswordResult signInSubmitPasswordResult) {
            return Result.DefaultImpls.isSuccess(signInSubmitPasswordResult);
        }
    }
}
