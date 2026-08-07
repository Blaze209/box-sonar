package io.split.android.client.network;

import android.net.http.X509TrustManagerExtensions;
import io.split.android.client.utils.logger.Logger;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
class ChainCleanerImpl implements ChainCleaner {
    private final X509TrustManagerExtensions mTrustManagerExtensions;

    ChainCleanerImpl(X509TrustManager trustManager) {
        this(new X509TrustManagerExtensions(trustManager == null ? TrustManagerProvider.getDefaultX509TrustManager() : trustManager));
    }

    ChainCleanerImpl(X509TrustManagerExtensions trustManagerExtensions) {
        this.mTrustManagerExtensions = trustManagerExtensions;
    }

    @Override // io.split.android.client.network.ChainCleaner
    public List<X509Certificate> clean(String hostname, Certificate[] chain) {
        if (chain == null) {
            return Collections.emptyList();
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (Certificate certificate : chain) {
                try {
                    arrayList.add((X509Certificate) certificate);
                } catch (ClassCastException unused) {
                    Logger.v("Ignored non-X.509 certificate in chain cleaning");
                }
            }
            return this.mTrustManagerExtensions.checkServerTrusted((X509Certificate[]) arrayList.toArray(new X509Certificate[0]), "RSA", hostname);
        } catch (CertificateException unused2) {
            return Collections.emptyList();
        }
    }
}
