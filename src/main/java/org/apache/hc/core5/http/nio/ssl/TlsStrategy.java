package org.apache.hc.core5.http.nio.ssl;

import java.net.SocketAddress;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.reactor.ssl.TransportSecurityLayer;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public interface TlsStrategy {
    @Deprecated
    boolean upgrade(TransportSecurityLayer transportSecurityLayer, HttpHost httpHost, SocketAddress socketAddress, SocketAddress socketAddress2, Object obj, Timeout timeout);

    default void upgrade(TransportSecurityLayer transportSecurityLayer, NamedEndpoint namedEndpoint, Object obj, Timeout timeout, FutureCallback<TransportSecurityLayer> futureCallback) {
        upgrade(transportSecurityLayer, new HttpHost(URIScheme.HTTPS.id, namedEndpoint.getHostName(), namedEndpoint.getPort()), null, null, obj, timeout);
        if (futureCallback != null) {
            futureCallback.completed(transportSecurityLayer);
        }
    }
}
