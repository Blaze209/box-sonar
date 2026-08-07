package com.pspdfkit.instant.exceptions;

/* JADX INFO: loaded from: classes3.dex */
public class InstantSyncException extends InstantException {
    public InstantSyncException(String str) {
        super(InstantErrorCode.UNKNOWN, str, new Object[0]);
    }

    public InstantSyncException(String str, Throwable th) {
        super(str, th);
    }

    public InstantSyncException(InstantErrorCode instantErrorCode, String str, Integer num) {
        super(instantErrorCode, str, num);
    }
}
