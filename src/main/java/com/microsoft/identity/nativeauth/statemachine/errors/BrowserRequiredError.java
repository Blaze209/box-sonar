package com.microsoft.identity.nativeauth.statemachine.errors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Error.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/errors/BrowserRequiredError;", "", "isBrowserRequired", "", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BrowserRequiredError {
    boolean isBrowserRequired();

    /* JADX INFO: compiled from: Error.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isBrowserRequired(BrowserRequiredError browserRequiredError) {
            Intrinsics.checkNotNull(browserRequiredError, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.statemachine.errors.Error");
            return Intrinsics.areEqual(((Error) browserRequiredError).getErrorType(), ErrorTypes.BROWSER_REQUIRED);
        }
    }
}
