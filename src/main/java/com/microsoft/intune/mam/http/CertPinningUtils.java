package com.microsoft.intune.mam.http;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes3.dex */
public final class CertPinningUtils {
    public static String getPublicKeyHash(X509Certificate x509Certificate, String str) throws NoSuchAlgorithmException {
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(encoded);
        return Base64.encodeToString(messageDigest.digest(), 2);
    }

    private CertPinningUtils() {
    }
}
