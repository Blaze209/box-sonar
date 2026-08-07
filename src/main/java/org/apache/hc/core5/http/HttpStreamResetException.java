package org.apache.hc.core5.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class HttpStreamResetException extends IOException {
    private static final long serialVersionUID = 1;

    public HttpStreamResetException(String str) {
        super(str);
    }

    public HttpStreamResetException(String str, Throwable th) {
        super(str, th);
    }
}
