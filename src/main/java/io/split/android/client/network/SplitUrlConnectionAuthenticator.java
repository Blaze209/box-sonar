package io.split.android.client.network;

import java.net.HttpURLConnection;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class SplitUrlConnectionAuthenticator {
    private final SplitAuthenticator mProxyAuthenticator;

    SplitUrlConnectionAuthenticator(SplitAuthenticator splitAuthenticator) {
        this.mProxyAuthenticator = splitAuthenticator;
    }

    HttpURLConnection authenticate(HttpURLConnection connection) {
        Map<String, String> headers;
        SplitAuthenticatedRequest splitAuthenticatedRequestAuthenticate = this.mProxyAuthenticator.authenticate(new SplitAuthenticatedRequest(connection));
        if (splitAuthenticatedRequestAuthenticate != null && (headers = splitAuthenticatedRequestAuthenticate.getHeaders()) != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                    connection.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        }
        return connection;
    }
}
