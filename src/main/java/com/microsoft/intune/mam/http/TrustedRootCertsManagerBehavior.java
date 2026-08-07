package com.microsoft.intune.mam.http;

import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public interface TrustedRootCertsManagerBehavior {
    SSLContext createSslContext(MAMIdentity mAMIdentity, String str) throws GeneralSecurityException;

    @Deprecated
    SSLContext createSslContext(String str, String str2) throws GeneralSecurityException;

    TrustManager[] createTrustManagers(MAMIdentity mAMIdentity) throws GeneralSecurityException;

    @Deprecated
    TrustManager[] createTrustManagers(String str) throws GeneralSecurityException;
}
