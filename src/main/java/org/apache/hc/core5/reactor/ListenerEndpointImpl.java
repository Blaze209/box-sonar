package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.Closer;

/* JADX INFO: loaded from: classes5.dex */
class ListenerEndpointImpl implements ListenerEndpoint {
    final SocketAddress address;
    final Object attachment;
    private final AtomicBoolean closed = new AtomicBoolean();
    private final SelectionKey key;

    public ListenerEndpointImpl(SelectionKey selectionKey, Object obj, SocketAddress socketAddress) {
        this.key = selectionKey;
        this.address = socketAddress;
        this.attachment = obj;
    }

    @Override // org.apache.hc.core5.reactor.ListenerEndpoint
    public SocketAddress getAddress() {
        return this.address;
    }

    public String toString() {
        return "endpoint: " + this.address;
    }

    @Override // org.apache.hc.core5.reactor.ListenerEndpoint
    public boolean isClosed() {
        return this.closed.get();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed.compareAndSet(false, true)) {
            this.key.cancel();
            this.key.channel().close();
        }
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        Closer.closeQuietly(this);
    }
}
