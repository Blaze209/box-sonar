package org.apache.hc.core5.http.nio.ssl;

import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.reactor.ProtocolIOSession;

/* JADX INFO: loaded from: classes5.dex */
public interface TlsUpgradeCapable {
    void tlsUpgrade(NamedEndpoint namedEndpoint, FutureCallback<ProtocolIOSession> futureCallback);
}
