package org.apache.hc.core5.reactor.ssl;

import javax.net.ssl.SSLContext;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public interface TransportSecurityLayer {
    TlsDetails getTlsDetails();

    void startTls(SSLContext sSLContext, NamedEndpoint namedEndpoint, SSLBufferMode sSLBufferMode, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier, Timeout timeout) throws UnsupportedOperationException;

    default void startTls(SSLContext sSLContext, NamedEndpoint namedEndpoint, SSLBufferMode sSLBufferMode, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier, Timeout timeout, FutureCallback<TransportSecurityLayer> futureCallback) throws UnsupportedOperationException {
        startTls(sSLContext, namedEndpoint, sSLBufferMode, sSLSessionInitializer, sSLSessionVerifier, timeout);
        if (futureCallback != null) {
            futureCallback.completed(null);
        }
    }
}
