package org.apache.hc.core5.http.impl.bootstrap;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.Set;
import java.util.concurrent.Future;
import org.apache.hc.core5.concurrent.DefaultThreadFactory;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.reactor.ConnectionAcceptor;
import org.apache.hc.core5.reactor.ConnectionInitiator;
import org.apache.hc.core5.reactor.DefaultListeningIOReactor;
import org.apache.hc.core5.reactor.IOEventHandlerFactory;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.reactor.IOReactorService;
import org.apache.hc.core5.reactor.IOReactorStatus;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.reactor.IOSessionListener;
import org.apache.hc.core5.reactor.ListenerEndpoint;
import org.apache.hc.core5.util.TimeValue;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncServer extends AbstractConnectionInitiatorBase implements IOReactorService, ConnectionAcceptor {
    private final DefaultListeningIOReactor ioReactor;

    public AsyncServer(IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig, Decorator<IOSession> decorator, Callback<Exception> callback, IOSessionListener iOSessionListener, Callback<IOSession> callback2) {
        this.ioReactor = new DefaultListeningIOReactor(iOEventHandlerFactory, iOReactorConfig, new DefaultThreadFactory("server-dispatch", true), new DefaultThreadFactory("server-listener", true), decorator, callback, iOSessionListener, callback2);
    }

    @Override // org.apache.hc.core5.reactor.IOReactorService
    public void start() {
        this.ioReactor.start();
    }

    @Override // org.apache.hc.core5.http.impl.bootstrap.AbstractConnectionInitiatorBase
    ConnectionInitiator getIOReactor() {
        return this.ioReactor;
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, Object obj, FutureCallback<ListenerEndpoint> futureCallback) {
        return this.ioReactor.listen(socketAddress, obj, futureCallback);
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, FutureCallback<ListenerEndpoint> futureCallback) {
        return listen(socketAddress, null, futureCallback);
    }

    public Future<ListenerEndpoint> listen(SocketAddress socketAddress) {
        return this.ioReactor.listen(socketAddress, null);
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public void pause() throws IOException {
        this.ioReactor.pause();
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public void resume() throws IOException {
        this.ioReactor.resume();
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public Set<ListenerEndpoint> getEndpoints() {
        return this.ioReactor.getEndpoints();
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public IOReactorStatus getStatus() {
        return this.ioReactor.getStatus();
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public void initiateShutdown() {
        this.ioReactor.initiateShutdown();
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public void awaitShutdown(TimeValue timeValue) throws InterruptedException {
        this.ioReactor.awaitShutdown(timeValue);
    }

    @Override // org.apache.hc.core5.reactor.IOReactor, org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        this.ioReactor.close(closeMode);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ioReactor.close();
    }
}
