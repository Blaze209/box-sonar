package com.microsoft.intune.mam.http;

import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
public class MAMSDLSSLSocketFactory extends SSLSocketFactory {
    private String[] mAllowedCipherSuites;
    private SSLContext mSSLContext;
    private static final String[] BANNED_ALGORITHMS = {"_MD2", "_MD4", "_MD5", "RC2", "RC4", "3DES", "ECDSA", "ECDH_"};
    private static final String[] ALLOWED_PROTOCOLS = {"TLSv1.2"};

    public MAMSDLSSLSocketFactory(String str, TelemetryLogger telemetryLogger, String str2) throws GeneralSecurityException {
        this(null, str, telemetryLogger, str2);
    }

    public MAMSDLSSLSocketFactory(SSLContext sSLContext, String str, TelemetryLogger telemetryLogger, String str2) throws GeneralSecurityException {
        this.mSSLContext = sSLContext;
        if (sSLContext == null) {
            this.mSSLContext = MAMTrustManager.createSslContext(str, telemetryLogger, str2);
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : this.mSSLContext.getDefaultSSLParameters().getCipherSuites()) {
            String[] strArr = BANNED_ALGORITHMS;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (str3.toLowerCase(Locale.US).contains(strArr[i].toLowerCase(Locale.US))) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    arrayList.add(str3);
                    break;
                }
            }
        }
        this.mAllowedCipherSuites = (String[]) arrayList.toArray(new String[0]);
    }

    private void secureSSLSocket(SSLSocket sSLSocket) {
        sSLSocket.setEnabledCipherSuites(this.mAllowedCipherSuites);
        sSLSocket.setEnabledProtocols(ALLOWED_PROTOCOLS);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.mAllowedCipherSuites;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.mAllowedCipherSuites;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.mSSLContext.getSocketFactory().createSocket(socket, str, i, z);
        secureSSLSocket(sSLSocket);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.mSSLContext.getSocketFactory().createSocket(str, i);
        secureSSLSocket(sSLSocket);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.mSSLContext.getSocketFactory().createSocket(inetAddress, i);
        secureSSLSocket(sSLSocket);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.mSSLContext.getSocketFactory().createSocket(str, i, inetAddress, i2);
        secureSSLSocket(sSLSocket);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.mSSLContext.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
        secureSSLSocket(sSLSocket);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.mSSLContext.getSocketFactory().createSocket();
        secureSSLSocket(sSLSocket);
        return sSLSocket;
    }
}
