package com.microsoft.intune.mam.http;

import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineTrustedRootCertsManagerBehavior implements TrustedRootCertsManagerBehavior {
    private final IdentityParamConverter mIdentityParamConverter;

    public OfflineTrustedRootCertsManagerBehavior(IdentityParamConverter identityParamConverter) {
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.http.TrustedRootCertsManagerBehavior
    @Deprecated
    public SSLContext createSslContext(String str, String str2) throws GeneralSecurityException {
        return createSslContext(this.mIdentityParamConverter.fromUpnParam(str), str2);
    }

    @Override // com.microsoft.intune.mam.http.TrustedRootCertsManagerBehavior
    public SSLContext createSslContext(MAMIdentity mAMIdentity, String str) throws GeneralSecurityException {
        if (str == null) {
            return SSLContext.getDefault();
        }
        SSLContext sSLContext = SSLContext.getInstance(str);
        sSLContext.init(null, createTrustManagers(mAMIdentity), null);
        return sSLContext;
    }

    @Override // com.microsoft.intune.mam.http.TrustedRootCertsManagerBehavior
    @Deprecated
    public TrustManager[] createTrustManagers(String str) throws GeneralSecurityException {
        return createTrustManagers(this.mIdentityParamConverter.fromUpnParam(str));
    }

    @Override // com.microsoft.intune.mam.http.TrustedRootCertsManagerBehavior
    public TrustManager[] createTrustManagers(MAMIdentity mAMIdentity) throws GeneralSecurityException {
        return getDefaultTrustManagers();
    }

    private TrustManager[] getDefaultTrustManagers() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        return trustManagerFactory.getTrustManagers();
    }
}
