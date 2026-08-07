package com.microsoft.identity.common.adal.internal.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes14.dex */
public final class HttpUrlConnectionFactory {
    private static HttpURLConnection sMockedConnection;
    private static URL sMockedConnectionOpenUrl;

    private HttpUrlConnectionFactory() {
    }

    public static void setMockedHttpUrlConnection(HttpURLConnection httpURLConnection) {
        sMockedConnection = httpURLConnection;
        if (httpURLConnection == null) {
            sMockedConnectionOpenUrl = null;
        }
    }

    public static HttpURLConnection createHttpUrlConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = sMockedConnection;
        if (httpURLConnection != null) {
            sMockedConnectionOpenUrl = url;
            return httpURLConnection;
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static URL getMockedConnectionOpenUrl() {
        return sMockedConnectionOpenUrl;
    }
}
