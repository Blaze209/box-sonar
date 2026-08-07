package io.split.android.client.network;

import io.split.android.client.utils.logger.Logger;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
class TrustManagerProvider {
    TrustManagerProvider() {
    }

    static X509TrustManager getDefaultX509TrustManager() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            Logger.w("No X509TrustManager found");
            return null;
        } catch (KeyStoreException | NoSuchAlgorithmException e) {
            Logger.e("Error getting default TrustManager: " + e.getMessage());
            return null;
        }
    }
}
