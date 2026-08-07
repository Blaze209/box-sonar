package com.pspdfkit.instant.internal.jni;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeHTTPResponse {
    final byte[] mBodyData;
    final HashMap<String, String> mHeaders;
    final int mStatusCode;

    public NativeHTTPResponse(int i, HashMap<String, String> map, byte[] bArr) {
        this.mStatusCode = i;
        this.mHeaders = map;
        this.mBodyData = bArr;
    }

    public byte[] getBodyData() {
        return this.mBodyData;
    }

    public HashMap<String, String> getHeaders() {
        return this.mHeaders;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String toString() {
        return "NativeHTTPResponse{mStatusCode=" + this.mStatusCode + ",mHeaders=" + this.mHeaders + ",mBodyData=" + this.mBodyData + "}";
    }
}
