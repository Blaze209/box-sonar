package com.microsoft.intune.mam.http;

import android.net.http.X509TrustManagerExtensions;
import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import java.lang.reflect.Array;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public class MAMTrustManager implements X509TrustManager {
    private final String mConfiguredHost;
    private final X509TrustManager mManager;
    private final CertChainValidator mValidator;

    protected MAMTrustManager(X509TrustManager x509TrustManager, CertChainValidator certChainValidator, String str) {
        this.mManager = x509TrustManager;
        this.mValidator = certChainValidator;
        this.mConfiguredHost = str;
    }

    public static SSLContext createSslContext(String str, TelemetryLogger telemetryLogger, String str2) throws GeneralSecurityException {
        return createSslContext(new MAMTrustManagerHelper(KnownClouds.fromAuthority(str), telemetryLogger, str2), null);
    }

    public static SSLContext createSslContext(CertChainValidator certChainValidator, String str) throws GeneralSecurityException {
        TrustManager mAMTrustManager;
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3");
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        TrustManager[] trustManagerArr = new TrustManager[Array.getLength(trustManagers)];
        int i = 0;
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509ExtendedTrustManager) {
                mAMTrustManager = new MAMExtendedTrustManager((X509ExtendedTrustManager) trustManager, certChainValidator, str);
            } else {
                mAMTrustManager = new MAMTrustManager((X509TrustManager) trustManager, certChainValidator, str);
            }
            trustManagerArr[i] = mAMTrustManager;
            i++;
        }
        sSLContext.init(null, trustManagerArr, null);
        return sSLContext;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.mManager.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (this.mConfiguredHost != null) {
            this.mValidator.validateChain((X509Certificate[]) new X509TrustManagerExtensions(this.mManager).checkServerTrusted(x509CertificateArr, str, this.mConfiguredHost).toArray(new X509Certificate[0]));
        } else {
            this.mManager.checkServerTrusted(x509CertificateArr, str);
            this.mValidator.validateChain(x509CertificateArr);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.mManager.getAcceptedIssuers();
    }
}
