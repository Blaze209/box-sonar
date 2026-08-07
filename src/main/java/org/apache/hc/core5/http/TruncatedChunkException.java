package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public class TruncatedChunkException extends MalformedChunkCodingException {
    private static final long serialVersionUID = -23506263930279460L;

    public TruncatedChunkException(String str) {
        super(HttpException.clean(str));
    }

    public TruncatedChunkException(String str, Object... objArr) {
        super(str, objArr);
    }
}
