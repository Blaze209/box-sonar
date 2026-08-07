package com.microsoft.identity.common.java.nativeauth.controllers.results;

import kotlin.Metadata;

/* JADX INFO: compiled from: MFACommandResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/GetAuthMethodsCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$APIError;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Redirect;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface GetAuthMethodsCommandResult extends INativeAuthCommandResult {

    /* JADX INFO: compiled from: MFACommandResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(GetAuthMethodsCommandResult getAuthMethodsCommandResult) {
            return INativeAuthCommandResult.DefaultImpls.containsPii(getAuthMethodsCommandResult);
        }
    }
}
