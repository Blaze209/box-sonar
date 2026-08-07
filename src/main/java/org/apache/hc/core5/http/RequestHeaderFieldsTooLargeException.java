package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public class RequestHeaderFieldsTooLargeException extends ProtocolException {
    private static final long serialVersionUID = 1;

    public RequestHeaderFieldsTooLargeException(String str) {
        super(str);
    }

    public RequestHeaderFieldsTooLargeException(String str, Throwable th) {
        super(str, th);
    }
}
