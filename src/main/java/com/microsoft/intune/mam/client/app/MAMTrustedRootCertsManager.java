package com.microsoft.intune.mam.client.app;

import com.microsoft.intune.mam.client.CachedBehaviorProvider;
import com.microsoft.intune.mam.client.identity.ExternalIdentityUtils;
import com.microsoft.intune.mam.http.TrustedRootCertsManagerBehavior;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMTrustedRootCertsManager {
    private static final CachedBehaviorProvider<TrustedRootCertsManagerBehavior> S_CACHED_TRUSTED_ROOT_CERTS_BEHAVIOR = new CachedBehaviorProvider<>(TrustedRootCertsManagerBehavior.class);

    @Deprecated
    public static SSLContext createSSLContext(String str, String str2) throws GeneralSecurityException {
        return S_CACHED_TRUSTED_ROOT_CERTS_BEHAVIOR.get().createSslContext(str, str2);
    }

    public static SSLContext createSSLContextForOID(String str, String str2) throws GeneralSecurityException {
        return S_CACHED_TRUSTED_ROOT_CERTS_BEHAVIOR.get().createSslContext(ExternalIdentityUtils.identityFromOID(str), str2);
    }

    @Deprecated
    public static SSLSocketFactory createSSLSocketFactory(String str, String str2) throws GeneralSecurityException {
        return createSSLContext(str, str2).getSocketFactory();
    }

    public static SSLSocketFactory createSSLSocketFactoryForOID(String str, String str2) throws GeneralSecurityException {
        return createSSLContextForOID(str, str2).getSocketFactory();
    }

    @Deprecated
    public static TrustManager[] createX509TrustManagers(String str) throws GeneralSecurityException {
        return S_CACHED_TRUSTED_ROOT_CERTS_BEHAVIOR.get().createTrustManagers(str);
    }

    public static TrustManager[] createX509TrustManagersForOID(String str) throws GeneralSecurityException {
        return S_CACHED_TRUSTED_ROOT_CERTS_BEHAVIOR.get().createTrustManagers(ExternalIdentityUtils.identityFromOID(str));
    }

    private MAMTrustedRootCertsManager() {
    }
}
