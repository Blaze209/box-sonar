package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.Set;
import java.util.concurrent.Future;
import org.apache.hc.core5.concurrent.FutureCallback;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnectionAcceptor {
    Set<ListenerEndpoint> getEndpoints();

    Future<ListenerEndpoint> listen(SocketAddress socketAddress, FutureCallback<ListenerEndpoint> futureCallback);

    void pause() throws IOException;

    void resume() throws IOException;

    default Future<ListenerEndpoint> listen(SocketAddress socketAddress, Object obj, FutureCallback<ListenerEndpoint> futureCallback) {
        return listen(socketAddress, futureCallback);
    }
}
