package org.apache.hc.core5.reactor;

import java.net.SocketAddress;
import java.util.concurrent.Future;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractIOReactorBase implements ConnectionInitiator, IOReactorService {
    abstract IOWorkers.Selector getWorkerSelector();

    AbstractIOReactorBase() {
    }

    @Override // org.apache.hc.core5.reactor.ConnectionInitiator
    public final Future<IOSession> connect(NamedEndpoint namedEndpoint, SocketAddress socketAddress, SocketAddress socketAddress2, Timeout timeout, Object obj, FutureCallback<IOSession> futureCallback) throws IOReactorShutdownException {
        Args.notNull(namedEndpoint, "Remote endpoint");
        if (getStatus().compareTo(IOReactorStatus.ACTIVE) > 0) {
            throw new IOReactorShutdownException("I/O reactor has been shut down");
        }
        try {
            return getWorkerSelector().next().connect(namedEndpoint, socketAddress, socketAddress2, timeout, obj, futureCallback);
        } catch (IOReactorShutdownException e) {
            initiateShutdown();
            throw e;
        }
    }
}
