package com.microsoft.identity.common.java.net;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class HttpRequest {
    private static final String HOST = "Host";
    private final byte[] mRequestContent;
    private final String mRequestContentType;
    private final Map<String, String> mRequestHeaders;
    private final String mRequestMethod;
    private final URL mRequestUrl;

    public URL getRequestUrl() {
        return this.mRequestUrl;
    }

    public byte[] getRequestContent() {
        byte[] bArr = this.mRequestContent;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public String getRequestContentType() {
        return this.mRequestContentType;
    }

    public String getRequestMethod() {
        return this.mRequestMethod;
    }

    Map<String, String> getRequestHeaders() {
        return Collections.unmodifiableMap(this.mRequestHeaders);
    }

    public HttpRequest(URL url, Map<String, String> map, String str, byte[] bArr, String str2) {
        HashMap map2 = new HashMap();
        this.mRequestHeaders = map2;
        if (url == null) {
            throw new NullPointerException("requestUrl is marked non-null but is null");
        }
        if (map == null) {
            throw new NullPointerException("requestHeaders is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("requestMethod is marked non-null but is null");
        }
        this.mRequestUrl = url;
        map2.put("Host", url.getAuthority());
        map2.putAll(map);
        this.mRequestMethod = str;
        this.mRequestContent = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.mRequestContentType = str2;
    }
}
