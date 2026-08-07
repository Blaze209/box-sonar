package com.microsoft.intune.mam.http;

import android.net.http.X509TrustManagerExtensions;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;

/* JADX INFO: loaded from: classes3.dex */
public class MAMExtendedTrustManager extends X509ExtendedTrustManager {
    private final String mConfiguredHost;
    private X509ExtendedTrustManager mManager;
    private final CertChainValidator mValidator;

    protected MAMExtendedTrustManager(X509ExtendedTrustManager x509ExtendedTrustManager, CertChainValidator certChainValidator, String str) {
        this.mManager = x509ExtendedTrustManager;
        this.mValidator = certChainValidator;
        this.mConfiguredHost = str;
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        this.mManager.checkClientTrusted(x509CertificateArr, str, socket);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        this.mManager.checkClientTrusted(x509CertificateArr, str, sSLEngine);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.mManager.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        this.mManager.checkServerTrusted(x509CertificateArr, str, socket);
        validateChain(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        this.mManager.checkServerTrusted(x509CertificateArr, str, sSLEngine);
        validateChain(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (this.mConfiguredHost == null) {
            this.mManager.checkServerTrusted(x509CertificateArr, str);
        }
        validateChain(x509CertificateArr, str);
    }

    private void validateChain(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (this.mConfiguredHost != null) {
            this.mValidator.validateChain((X509Certificate[]) new X509TrustManagerExtensions(this.mManager).checkServerTrusted(x509CertificateArr, str, this.mConfiguredHost).toArray(new X509Certificate[0]));
        } else {
            this.mValidator.validateChain(x509CertificateArr);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.mManager.getAcceptedIssuers();
    }
}
