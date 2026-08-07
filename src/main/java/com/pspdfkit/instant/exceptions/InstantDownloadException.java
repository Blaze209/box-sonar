package com.pspdfkit.instant.exceptions;

/* JADX INFO: loaded from: classes3.dex */
public class InstantDownloadException extends InstantException {
    public InstantDownloadException(String str) {
        super(InstantErrorCode.UNKNOWN, str, (Integer) null);
    }

    public InstantDownloadException(InstantErrorCode instantErrorCode, String str, Integer num) {
        super(instantErrorCode, str, num);
    }
}
