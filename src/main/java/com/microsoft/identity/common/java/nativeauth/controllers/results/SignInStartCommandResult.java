package com.microsoft.identity.common.java.nativeauth.controllers.results;

import kotlin.Metadata;

/* JADX INFO: compiled from: SignInCommandResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$APIError;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$InvalidUsername;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$CodeRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$Complete;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$InvalidCredentials;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$MFARequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$StrongAuthMethodRegistrationRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$UserNotFound;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignInStartCommandResult extends INativeAuthCommandResult {

    /* JADX INFO: compiled from: SignInCommandResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(SignInStartCommandResult signInStartCommandResult) {
            return INativeAuthCommandResult.DefaultImpls.containsPii(signInStartCommandResult);
        }
    }
}
