package com.microsoft.intune.mam.client.app;

import com.microsoft.intune.mam.client.CachedBehaviorProvider;
import com.microsoft.intune.mam.client.identity.ExternalIdentityUtils;
import com.microsoft.intune.mam.http.CertChainValidator;
import com.microsoft.intune.mam.http.CertChainValidatorFactory;
import com.microsoft.intune.mam.http.MAMTrustManager;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMCertificatePinningManager {
    private static CachedBehaviorProvider<CertChainValidatorFactory> sCachedValidatorFactory = new CachedBehaviorProvider<>(CertChainValidatorFactory.class);

    @Deprecated
    public static SSLSocketFactory getPinningSocketFactory(String str, URL url) throws GeneralSecurityException {
        return getPinningSSLContext(str, url).getSocketFactory();
    }

    public static SSLSocketFactory getPinningSocketFactoryForOID(String str, URL url) throws GeneralSecurityException {
        return getPinningSSLContextForOID(str, url).getSocketFactory();
    }

    @Deprecated
    public static SSLContext getPinningSSLContext(String str, URL url) throws GeneralSecurityException {
        return MAMTrustManager.createSslContext(getValidator(str, url), url.getHost());
    }

    public static SSLContext getPinningSSLContextForOID(String str, URL url) throws GeneralSecurityException {
        return MAMTrustManager.createSslContext(getValidatorForOid(str, url), url.getHost());
    }

    @Deprecated
    public static void validatePins(X509Certificate[] x509CertificateArr, String str, URL url) throws CertificateException {
        getValidator(str, url).validateChain(x509CertificateArr);
    }

    public static void validatePinsForOID(X509Certificate[] x509CertificateArr, String str, URL url) throws CertificateException {
        getValidatorForOid(str, url).validateChain(x509CertificateArr);
    }

    private static CertChainValidator getValidator(String str, URL url) {
        return sCachedValidatorFactory.get().getValidator(str, url);
    }

    private static CertChainValidator getValidatorForOid(String str, URL url) {
        return sCachedValidatorFactory.get().getValidator(ExternalIdentityUtils.identityFromOID(str), url);
    }

    private MAMCertificatePinningManager() {
    }
}
