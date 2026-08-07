package com.microsoft.identity.common.java.net;

/* JADX INFO: loaded from: classes14.dex */
class RetryFailedException extends RuntimeException {
    private static final long serialVersionUID = 3344864538063263545L;

    public RetryFailedException(Exception exc) {
        super(exc);
    }
}
