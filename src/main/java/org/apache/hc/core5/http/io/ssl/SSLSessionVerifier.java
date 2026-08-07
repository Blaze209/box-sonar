package org.apache.hc.core5.http.io.ssl;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.apache.hc.core5.http.HttpHost;

/* JADX INFO: loaded from: classes5.dex */
public interface SSLSessionVerifier {
    void verify(HttpHost httpHost, SSLSession sSLSession) throws SSLException;
}
