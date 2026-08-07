package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public class ProtocolException extends HttpException {
    private static final long serialVersionUID = -2143571074341228994L;

    public ProtocolException() {
    }

    public ProtocolException(String str) {
        super(str);
    }

    public ProtocolException(String str, Object... objArr) {
        super(str, objArr);
    }

    public ProtocolException(String str, Throwable th) {
        super(str, th);
    }
}
