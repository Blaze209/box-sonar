package io.split.android.client.network;

import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface CertificatePinningFailureListener {
    void onCertificatePinningFailure(String host, List<X509Certificate> certificateChain);
}
