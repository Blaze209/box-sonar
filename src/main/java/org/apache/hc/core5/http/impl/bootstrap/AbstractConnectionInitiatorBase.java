package org.apache.hc.core5.http.impl.bootstrap;

import java.net.SocketAddress;
import java.util.concurrent.Future;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.reactor.ConnectionInitiator;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractConnectionInitiatorBase implements ConnectionInitiator {
    abstract ConnectionInitiator getIOReactor();

    AbstractConnectionInitiatorBase() {
    }

    @Override // org.apache.hc.core5.reactor.ConnectionInitiator
    public final Future<IOSession> connect(NamedEndpoint namedEndpoint, SocketAddress socketAddress, SocketAddress socketAddress2, Timeout timeout, Object obj, FutureCallback<IOSession> futureCallback) {
        return getIOReactor().connect(namedEndpoint, socketAddress, socketAddress2, timeout, obj, futureCallback);
    }
}
