package org.apache.hc.core5.reactor;

import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.reactor.ssl.TransportSecurityLayer;

/* JADX INFO: loaded from: classes5.dex */
public interface ProtocolIOSession extends IOSession, TransportSecurityLayer {
    NamedEndpoint getInitialEndpoint();

    default void registerProtocol(String str, ProtocolUpgradeHandler protocolUpgradeHandler) {
    }

    default void switchProtocol(String str, FutureCallback<ProtocolIOSession> futureCallback) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Protocol switch not supported");
    }
}
