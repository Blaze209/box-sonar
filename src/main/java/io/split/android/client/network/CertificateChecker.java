package io.split.android.client.network;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes4.dex */
public interface CertificateChecker {
    void checkPins(HttpsURLConnection httpsConnection) throws SSLPeerUnverifiedException;
}
