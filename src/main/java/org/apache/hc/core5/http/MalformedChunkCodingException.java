package org.apache.hc.core5.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class MalformedChunkCodingException extends IOException {
    private static final long serialVersionUID = 2158560246948994524L;

    public MalformedChunkCodingException() {
    }

    public MalformedChunkCodingException(String str) {
        super(str);
    }

    public MalformedChunkCodingException(String str, Object... objArr) {
        super(HttpException.clean(String.format(str, objArr)));
    }
}
