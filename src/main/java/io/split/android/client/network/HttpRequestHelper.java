package io.split.android.client.network;

import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes4.dex */
class HttpRequestHelper {
    HttpRequestHelper() {
    }

    static HttpURLConnection openConnection(Proxy proxy, SplitUrlConnectionAuthenticator proxyAuthenticator, URL url, HttpMethod method, Map<String, String> headers, boolean useProxyAuthentication) throws IOException {
        HttpURLConnection httpURLConnectionAuthenticate;
        if (proxy != null) {
            httpURLConnectionAuthenticate = (HttpURLConnection) url.openConnection(proxy);
            if (useProxyAuthentication && proxyAuthenticator != null) {
                httpURLConnectionAuthenticate = proxyAuthenticator.authenticate(httpURLConnectionAuthenticate);
            }
        } else {
            httpURLConnectionAuthenticate = (HttpURLConnection) url.openConnection();
        }
        httpURLConnectionAuthenticate.setRequestMethod(method.name());
        addHeaders(httpURLConnectionAuthenticate, headers);
        return httpURLConnectionAuthenticate;
    }

    static void applyTimeouts(long readTimeout, long connectionTimeout, HttpURLConnection connection) {
        if (readTimeout > 0) {
            connection.setReadTimeout(Utils.getAsInt(readTimeout));
        }
        if (connectionTimeout > 0) {
            connection.setConnectTimeout(Utils.getAsInt(connectionTimeout));
        }
    }

    static void applySslConfig(SSLSocketFactory sslSocketFactory, DevelopmentSslConfig developmentSslConfig, HttpURLConnection connection) {
        if (sslSocketFactory != null) {
            if (connection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) connection).setSSLSocketFactory(sslSocketFactory);
            } else {
                Logger.e("Failed to set SSL socket factory.");
            }
        }
        if (developmentSslConfig != null) {
            try {
                if (connection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) connection).setSSLSocketFactory(developmentSslConfig.getSslSocketFactory());
                    ((HttpsURLConnection) connection).setHostnameVerifier(developmentSslConfig.getHostnameVerifier());
                } else {
                    Logger.e("Failed to set SSL socket factory.");
                }
            } catch (Exception e) {
                Logger.e("Could not set development SSL config: " + e.getLocalizedMessage());
            }
        }
    }

    static void checkPins(HttpURLConnection connection, CertificateChecker certificateChecker) throws SSLPeerUnverifiedException {
        if (certificateChecker == null || !(connection instanceof HttpsURLConnection)) {
            return;
        }
        certificateChecker.checkPins((HttpsURLConnection) connection);
    }

    private static void addHeaders(HttpURLConnection request, Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            if (entry != null) {
                request.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
