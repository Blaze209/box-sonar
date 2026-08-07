package com.pspdfkit.internal;

import com.pspdfkit.signatures.KeyFileHelpersKt;
import com.pspdfkit.signatures.SignerOptions;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class s20 {
    public static final List<X509Certificate> a(SignerOptions signerOptions, String str) {
        List<X509Certificate> x509Certificates;
        List<X509Certificate> certificates = signerOptions.getCertificates();
        if (!certificates.isEmpty()) {
            return certificates;
        }
        KeyStore.PrivateKeyEntry privateKeyEntry = signerOptions.getPrivateKeyEntry();
        if (privateKeyEntry == null || (x509Certificates = KeyFileHelpersKt.getX509Certificates(privateKeyEntry)) == null) {
            throw new RuntimeException(str + ": Please provide either X509Certificates or a private key in SignerOptions to proceed.");
        }
        return x509Certificates;
    }
}
