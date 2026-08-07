package com.microsoft.intune.mam.http;

import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineCertChainValidatorFactory implements CertChainValidatorFactory {
    private final IdentityParamConverter mIdentityParamConverter;

    public OfflineCertChainValidatorFactory(IdentityParamConverter identityParamConverter) {
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.http.CertChainValidatorFactory
    @Deprecated
    public CertChainValidator getValidator(String str, URL url) {
        return getValidator(this.mIdentityParamConverter.fromUpnParam(str), url);
    }

    @Override // com.microsoft.intune.mam.http.CertChainValidatorFactory
    public CertChainValidator getValidator(MAMIdentity mAMIdentity, URL url) {
        return new CertChainValidator() { // from class: com.microsoft.intune.mam.http.OfflineCertChainValidatorFactory.1
            @Override // com.microsoft.intune.mam.http.CertChainValidator
            public void validateChain(X509Certificate[] x509CertificateArr) throws CertificateException {
            }
        };
    }
}
