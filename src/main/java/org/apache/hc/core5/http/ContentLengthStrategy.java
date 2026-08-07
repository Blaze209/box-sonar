package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public interface ContentLengthStrategy {
    public static final long CHUNKED = -1;
    public static final long UNDEFINED = -9223372036854775807L;

    long determineLength(HttpMessage httpMessage) throws HttpException;
}
