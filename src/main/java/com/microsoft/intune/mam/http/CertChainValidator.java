package com.microsoft.intune.mam.http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes3.dex */
public interface CertChainValidator {
    void validateChain(X509Certificate[] x509CertificateArr) throws CertificateException;
}
