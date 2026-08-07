package com.microsoft.identity.common.java.nativeauth.controllers.results;

import kotlin.Metadata;

/* JADX INFO: compiled from: SignUpCommandResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$APIError;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$InvalidUsername;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$AttributesRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$AuthNotSupported;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$CodeRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$Complete;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpCommandResult$UsernameAlreadyExists;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignUpStartCommandResult extends INativeAuthCommandResult {

    /* JADX INFO: compiled from: SignUpCommandResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(SignUpStartCommandResult signUpStartCommandResult) {
            return INativeAuthCommandResult.DefaultImpls.containsPii(signUpStartCommandResult);
        }
    }
}
