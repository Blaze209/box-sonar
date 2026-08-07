package com.microsoft.identity.nativeauth.statemachine.results;

import kotlin.Metadata;

/* JADX INFO: compiled from: SignUpResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitAttributesResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignUpSubmitAttributesResult extends SignUpResult {

    /* JADX INFO: compiled from: SignUpResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(SignUpSubmitAttributesResult signUpSubmitAttributesResult) {
            return SignUpResult.DefaultImpls.isComplete(signUpSubmitAttributesResult);
        }

        public static boolean isError(SignUpSubmitAttributesResult signUpSubmitAttributesResult) {
            return SignUpResult.DefaultImpls.isError(signUpSubmitAttributesResult);
        }

        public static boolean isSuccess(SignUpSubmitAttributesResult signUpSubmitAttributesResult) {
            return SignUpResult.DefaultImpls.isSuccess(signUpSubmitAttributesResult);
        }
    }
}
