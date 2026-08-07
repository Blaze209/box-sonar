package com.microsoft.identity.common.java.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes14.dex */
public class SSLSocketFactoryWrapper extends SSLSocketFactory {
    private static final String TAG = "SSLSocketFactoryWrapper";
    private static final String TLS_AES_128_GCM_SHA256 = "TLS_AES_128_GCM_SHA256";
    private static final String TLS_AES_256_GCM_SHA384 = "TLS_AES_256_GCM_SHA384";
    private static final String TLS_CHACHA20_POLY1305_SHA256 = "TLS_CHACHA20_POLY1305_SHA256";
    private final SSLSocketFactory mBaseSocketFactory;
    private final List<String> mEnabledSSLProtocol;
    public static final List<String> SUPPORTED_SSL_PROTOCOLS = Collections.unmodifiableList(Arrays.asList("SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"));
    private static String sLastHandshakeTLSversion = "";

    static void setLastHandshakeTLSversion(String str) {
        sLastHandshakeTLSversion = str;
    }

    static synchronized String getLastHandshakeTLSversion() {
        return sLastHandshakeTLSversion;
    }

    public SSLSocketFactoryWrapper(SSLSocketFactory sSLSocketFactory, List<String> list) {
        if (sSLSocketFactory == null) {
            throw new NullPointerException("baseSocketFactory is marked non-null but is null");
        }
        this.mBaseSocketFactory = sSLSocketFactory;
        this.mEnabledSSLProtocol = list == null ? SUPPORTED_SSL_PROTOCOLS : list;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.mBaseSocketFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.mBaseSocketFactory.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return modifyEnabledSockets(this.mBaseSocketFactory.createSocket(socket, str, i, z));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return modifyEnabledSockets(this.mBaseSocketFactory.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return modifyEnabledSockets(this.mBaseSocketFactory.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return modifyEnabledSockets(this.mBaseSocketFactory.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return modifyEnabledSockets(this.mBaseSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket modifyEnabledSockets(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.setEnabledProtocols(getEnabledProtocols(sSLSocket));
            sSLSocket.setEnabledCipherSuites(getEnabledCipherSuites(sSLSocket));
            sSLSocket.addHandshakeCompletedListener(new HandshakeCompletedListener() { // from class: com.microsoft.identity.common.java.net.SSLSocketFactoryWrapper.1
                @Override // javax.net.ssl.HandshakeCompletedListener
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                    SSLSocketFactoryWrapper.setLastHandshakeTLSversion(handshakeCompletedEvent.getSession().getProtocol());
                }
            });
        }
        return socket;
    }

    private String[] getEnabledProtocols(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            throw new NullPointerException("sslSocket is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        List listAsList = Arrays.asList(sSLSocket.getSupportedProtocols());
        for (String str : this.mEnabledSSLProtocol) {
            if (listAsList.contains(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    private String[] getEnabledCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            throw new NullPointerException("sslSocket is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, sSLSocket.getEnabledCipherSuites());
        List listAsList = Arrays.asList(sSLSocket.getSupportedCipherSuites());
        if (listAsList.contains(TLS_AES_128_GCM_SHA256)) {
            arrayList.add(TLS_AES_128_GCM_SHA256);
        }
        if (listAsList.contains(TLS_AES_256_GCM_SHA384)) {
            arrayList.add(TLS_AES_256_GCM_SHA384);
        }
        if (listAsList.contains(TLS_CHACHA20_POLY1305_SHA256)) {
            arrayList.add(TLS_CHACHA20_POLY1305_SHA256);
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }
}
