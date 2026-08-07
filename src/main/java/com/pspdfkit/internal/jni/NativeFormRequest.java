package com.pspdfkit.internal.jni;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeFormRequest {
    final HashMap<String, String> mHeaders;
    final NativeHTTPMethod mHttpMethod;

    public NativeFormRequest(NativeHTTPMethod nativeHTTPMethod, HashMap<String, String> map) {
        this.mHttpMethod = nativeHTTPMethod;
        this.mHeaders = map;
    }

    public HashMap<String, String> getHeaders() {
        return this.mHeaders;
    }

    public NativeHTTPMethod getHttpMethod() {
        return this.mHttpMethod;
    }

    public String toString() {
        return "NativeFormRequest{mHttpMethod=" + this.mHttpMethod + ",mHeaders=" + this.mHeaders + "}";
    }
}
