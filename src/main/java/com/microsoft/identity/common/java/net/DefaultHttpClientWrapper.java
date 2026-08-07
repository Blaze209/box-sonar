package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.interfaces.IHttpClientWrapper;

/* JADX INFO: loaded from: classes14.dex */
public class DefaultHttpClientWrapper implements IHttpClientWrapper {
    @Override // com.microsoft.identity.common.java.interfaces.IHttpClientWrapper
    public HttpClient wrap(HttpClient httpClient) {
        if (httpClient != null) {
            return httpClient;
        }
        throw new NullPointerException("client is marked non-null but is null");
    }
}
