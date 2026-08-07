package org.apache.hc.core5.http;

import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionRequestTimeoutException extends InterruptedIOException {
    private static final long serialVersionUID = 1;

    public ConnectionRequestTimeoutException() {
    }

    public ConnectionRequestTimeoutException(String str) {
        super(HttpException.clean(str));
    }
}
