package org.apache.hc.core5.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectionClosedException extends IOException {
    private static final long serialVersionUID = 617550366255636674L;

    public ConnectionClosedException() {
        super("Connection is closed");
    }

    public ConnectionClosedException(String str) {
        super(HttpException.clean(str));
    }

    public ConnectionClosedException(String str, Object... objArr) {
        super(HttpException.clean(String.format(str, objArr)));
    }

    public ConnectionClosedException(String str, Throwable th) {
        super(str, th);
    }
}
