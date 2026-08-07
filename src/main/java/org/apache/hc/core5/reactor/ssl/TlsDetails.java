package org.apache.hc.core5.reactor.ssl;

import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public final class TlsDetails {
    private final String applicationProtocol;
    private final SSLSession sslSession;

    public TlsDetails(SSLSession sSLSession, String str) {
        this.sslSession = sSLSession;
        this.applicationProtocol = str;
    }

    public SSLSession getSSLSession() {
        return this.sslSession;
    }

    public String getApplicationProtocol() {
        return this.applicationProtocol;
    }

    public String toString() {
        return "TlsDetails{sslSession=" + this.sslSession + ", applicationProtocol='" + this.applicationProtocol + "'}";
    }
}
