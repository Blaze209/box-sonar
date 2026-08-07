package org.apache.hc.core5.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class NoHttpResponseException extends IOException {
    private static final long serialVersionUID = -7658940387386078766L;

    public NoHttpResponseException(String str) {
        super(HttpException.clean(str));
    }

    public NoHttpResponseException(String str, Throwable th) {
        super(str, th);
    }
}
