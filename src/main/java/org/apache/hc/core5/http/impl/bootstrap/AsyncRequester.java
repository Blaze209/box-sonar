package org.apache.hc.core5.http.impl.bootstrap;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Future;
import org.apache.hc.core5.concurrent.DefaultThreadFactory;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.function.Resolver;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.impl.DefaultAddressResolver;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.reactor.ConnectionInitiator;
import org.apache.hc.core5.reactor.DefaultConnectingIOReactor;
import org.apache.hc.core5.reactor.IOEventHandlerFactory;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.reactor.IOReactorService;
import org.apache.hc.core5.reactor.IOReactorStatus;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.reactor.IOSessionListener;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncRequester extends AbstractConnectionInitiatorBase implements IOReactorService {
    private final Resolver<HttpHost, InetSocketAddress> addressResolver;
    private final DefaultConnectingIOReactor ioReactor;

    public AsyncRequester(IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig, Decorator<IOSession> decorator, Callback<Exception> callback, IOSessionListener iOSessionListener, Callback<IOSession> callback2, Resolver<HttpHost, InetSocketAddress> resolver) {
        this.ioReactor = new DefaultConnectingIOReactor(iOEventHandlerFactory, iOReactorConfig, new DefaultThreadFactory("requester-dispatch", true), decorator, callback, iOSessionListener, callback2);
        this.addressResolver = resolver == null ? DefaultAddressResolver.INSTANCE : resolver;
    }

    @Override // org.apache.hc.core5.http.impl.bootstrap.AbstractConnectionInitiatorBase
    ConnectionInitiator getIOReactor() {
        return this.ioReactor;
    }

    public Future<IOSession> requestSession(HttpHost httpHost, Timeout timeout, Object obj, FutureCallback<IOSession> futureCallback) {
        Args.notNull(httpHost, "Host");
        Args.notNull(timeout, "Timeout");
        return connect(httpHost, this.addressResolver.resolve(httpHost), null, timeout, obj, futureCallback);
    }

    @Override // org.apache.hc.core5.reactor.IOReactorService
    public void start() {
        this.ioReactor.start();
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

    protected static HttpHost defaultTarget(HttpRequest httpRequest) throws ProtocolException {
        String scheme = httpRequest.getScheme();
        URIAuthority authority = httpRequest.getAuthority();
        if (authority == null) {
            throw new ProtocolException("Request authority not specified");
        }
        return new HttpHost(scheme, authority);
    }
}
