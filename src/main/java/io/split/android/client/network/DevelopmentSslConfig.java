package io.split.android.client.network;

import io.split.android.client.utils.logger.Logger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
public class DevelopmentSslConfig {
    private final HostnameVerifier hostnameVerifier;
    private final SSLSocketFactory sslSocketFactory;
    private final X509TrustManager trustManager;

    public DevelopmentSslConfig(X509TrustManager trustManager, HostnameVerifier hostnameVerifier) {
        SSLSocketFactory socketFactory = null;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{trustManager}, null);
            socketFactory = sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            Logger.w("Failed to initialize development SSL config: " + e.getLocalizedMessage());
            trustManager = null;
        }
        this.sslSocketFactory = socketFactory;
        this.trustManager = trustManager;
        this.hostnameVerifier = hostnameVerifier;
    }

    public DevelopmentSslConfig(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager, HostnameVerifier hostnameVerifier) {
        this.sslSocketFactory = sslSocketFactory;
        this.trustManager = trustManager;
        this.hostnameVerifier = hostnameVerifier;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public X509TrustManager getTrustManager() {
        return this.trustManager;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }
}
