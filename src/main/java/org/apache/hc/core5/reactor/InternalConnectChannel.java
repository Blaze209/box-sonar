package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.io.SocketTimeoutExceptionFactory;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
final class InternalConnectChannel extends InternalChannel {
    private final long creationTimeMillis = System.currentTimeMillis();
    private final InternalDataChannel dataChannel;
    private final IOEventHandlerFactory eventHandlerFactory;
    private final SelectionKey key;
    private final IOReactorConfig reactorConfig;
    private final IOSessionRequest sessionRequest;
    private final SocketChannel socketChannel;

    InternalConnectChannel(SelectionKey selectionKey, SocketChannel socketChannel, IOSessionRequest iOSessionRequest, InternalDataChannel internalDataChannel, IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig) {
        this.key = selectionKey;
        this.socketChannel = socketChannel;
        this.sessionRequest = iOSessionRequest;
        this.dataChannel = internalDataChannel;
        this.eventHandlerFactory = iOEventHandlerFactory;
        this.reactorConfig = iOReactorConfig;
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    void onIOEvent(int i) throws IOException {
        if ((i & 8) != 0) {
            if (this.socketChannel.isConnectionPending()) {
                this.socketChannel.finishConnect();
            }
            if (checkTimeout(System.currentTimeMillis())) {
                this.key.attach(this.dataChannel);
                if (this.reactorConfig.getSocksProxyAddress() == null) {
                    InternalDataChannel internalDataChannel = this.dataChannel;
                    internalDataChannel.upgrade(this.eventHandlerFactory.createHandler(internalDataChannel, this.sessionRequest.attachment));
                    this.sessionRequest.completed(this.dataChannel);
                    this.dataChannel.handleIOEvent(8);
                    return;
                }
                SocksProxyProtocolHandler socksProxyProtocolHandler = new SocksProxyProtocolHandler(this.dataChannel, this.sessionRequest, this.eventHandlerFactory, this.reactorConfig);
                this.dataChannel.upgrade(socksProxyProtocolHandler);
                socksProxyProtocolHandler.connected(this.dataChannel);
            }
        }
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    Timeout getTimeout() {
        return this.sessionRequest.timeout;
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    long getLastEventTime() {
        return this.creationTimeMillis;
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    void onTimeout(Timeout timeout) throws IOException {
        this.sessionRequest.failed(SocketTimeoutExceptionFactory.create(timeout));
        close();
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    void onException(Exception exc) {
        this.sessionRequest.failed(exc);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.key.cancel();
        this.socketChannel.close();
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        this.key.cancel();
        Closer.closeQuietly(this.socketChannel);
    }

    public String toString() {
        return this.sessionRequest.toString();
    }
}
