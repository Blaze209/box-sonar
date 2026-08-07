package com.microsoft.identity.common.java.crypto;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes14.dex */
public interface ICertificateGeneratorFunction {
    X509Certificate apply(String str) throws CertificateException, UnsupportedEncodingException, NoSuchProviderException;
}
