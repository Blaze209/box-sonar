package org.apache.hc.core5.reactor;

import java.net.SocketAddress;
import java.util.concurrent.Future;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnectionInitiator {
    Future<IOSession> connect(NamedEndpoint namedEndpoint, SocketAddress socketAddress, SocketAddress socketAddress2, Timeout timeout, Object obj, FutureCallback<IOSession> futureCallback);
}
