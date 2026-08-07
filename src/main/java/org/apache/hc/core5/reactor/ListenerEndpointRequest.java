package org.apache.hc.core5.reactor;

import java.io.Closeable;
import java.net.SocketAddress;
import org.apache.hc.core5.concurrent.BasicFuture;

/* JADX INFO: loaded from: classes5.dex */
final class ListenerEndpointRequest implements Closeable {
    final SocketAddress address;
    final Object attachment;
    final BasicFuture<ListenerEndpoint> future;

    ListenerEndpointRequest(SocketAddress socketAddress, Object obj, BasicFuture<ListenerEndpoint> basicFuture) {
        this.address = socketAddress;
        this.attachment = obj;
        this.future = basicFuture;
    }

    public void completed(ListenerEndpoint listenerEndpoint) {
        BasicFuture<ListenerEndpoint> basicFuture = this.future;
        if (basicFuture != null) {
            basicFuture.completed(listenerEndpoint);
        }
    }

    public void failed(Exception exc) {
        BasicFuture<ListenerEndpoint> basicFuture = this.future;
        if (basicFuture != null) {
            basicFuture.failed(exc);
        }
    }

    public void cancel() {
        BasicFuture<ListenerEndpoint> basicFuture = this.future;
        if (basicFuture != null) {
            basicFuture.cancel();
        }
    }

    public boolean isCancelled() {
        BasicFuture<ListenerEndpoint> basicFuture = this.future;
        return basicFuture != null && basicFuture.isCancelled();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        cancel();
    }
}
