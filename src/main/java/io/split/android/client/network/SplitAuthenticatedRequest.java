package io.split.android.client.network;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class SplitAuthenticatedRequest implements AuthenticatedRequest<HttpURLConnection> {
    private final Map<String, String> mHeaders = new ConcurrentHashMap();
    private final String mUrl;

    SplitAuthenticatedRequest(HttpURLConnection connection) {
        this.mUrl = (connection == null || connection.getURL() == null) ? null : connection.getURL().toString();
    }

    @Override // io.split.android.client.network.AuthenticatedRequest
    public void setHeader(String name, String value) {
        this.mHeaders.put(name, value);
    }

    @Override // io.split.android.client.network.AuthenticatedRequest
    public String getHeader(String name) {
        return this.mHeaders.get(name);
    }

    @Override // io.split.android.client.network.AuthenticatedRequest
    public Map<String, String> getHeaders() {
        return new HashMap(this.mHeaders);
    }

    @Override // io.split.android.client.network.AuthenticatedRequest
    public String getRequestUrl() {
        return this.mUrl;
    }
}
