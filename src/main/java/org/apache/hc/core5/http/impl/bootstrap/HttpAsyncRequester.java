package org.apache.hc.core5.http.impl.bootstrap;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.concurrent.BasicFuture;
import org.apache.hc.core5.concurrent.CallbackContribution;
import org.apache.hc.core5.concurrent.ComplexFuture;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.concurrent.FutureContribution;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpConnection;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.impl.DefaultAddressResolver;
import org.apache.hc.core5.http.nio.AsyncClientEndpoint;
import org.apache.hc.core5.http.nio.AsyncClientExchangeHandler;
import org.apache.hc.core5.http.nio.AsyncPushConsumer;
import org.apache.hc.core5.http.nio.AsyncRequestProducer;
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.nio.RequestChannel;
import org.apache.hc.core5.http.nio.command.RequestExecutionCommand;
import org.apache.hc.core5.http.nio.command.ShutdownCommand;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.apache.hc.core5.http.nio.ssl.TlsUpgradeCapable;
import org.apache.hc.core5.http.nio.support.BasicClientExchangeHandler;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpCoreContext;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.pool.ConnPoolControl;
import org.apache.hc.core5.pool.ManagedConnPool;
import org.apache.hc.core5.pool.PoolEntry;
import org.apache.hc.core5.pool.PoolStats;
import org.apache.hc.core5.reactor.Command;
import org.apache.hc.core5.reactor.EndpointParameters;
import org.apache.hc.core5.reactor.IOEventHandler;
import org.apache.hc.core5.reactor.IOEventHandlerFactory;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.reactor.IOSessionListener;
import org.apache.hc.core5.reactor.ProtocolIOSession;
import org.apache.hc.core5.reactor.ssl.TransportSecurityLayer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class HttpAsyncRequester extends AsyncRequester implements ConnPoolControl<HttpHost> {
    private final ManagedConnPool<HttpHost, IOSession> connPool;
    private final Timeout handshakeTimeout;
    private final TlsStrategy tlsStrategy;

    public HttpAsyncRequester(IOReactorConfig iOReactorConfig, IOEventHandlerFactory iOEventHandlerFactory, Decorator<IOSession> decorator, Callback<Exception> callback, IOSessionListener iOSessionListener, ManagedConnPool<HttpHost, IOSession> managedConnPool, TlsStrategy tlsStrategy, Timeout timeout) {
        super(iOEventHandlerFactory, iOReactorConfig, decorator, callback, iOSessionListener, ShutdownCommand.GRACEFUL_IMMEDIATE_CALLBACK, DefaultAddressResolver.INSTANCE);
        this.connPool = (ManagedConnPool) Args.notNull(managedConnPool, "Connection pool");
        this.tlsStrategy = tlsStrategy;
        this.handshakeTimeout = timeout;
    }

    public HttpAsyncRequester(IOReactorConfig iOReactorConfig, IOEventHandlerFactory iOEventHandlerFactory, Decorator<IOSession> decorator, Callback<Exception> callback, IOSessionListener iOSessionListener, ManagedConnPool<HttpHost, IOSession> managedConnPool) {
        this(iOReactorConfig, iOEventHandlerFactory, decorator, callback, iOSessionListener, managedConnPool, null, null);
    }

    @Override // org.apache.hc.core5.pool.ConnPoolStats
    public PoolStats getTotalStats() {
        return this.connPool.getTotalStats();
    }

    @Override // org.apache.hc.core5.pool.ConnPoolStats
    public PoolStats getStats(HttpHost httpHost) {
        return this.connPool.getStats(httpHost);
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void setMaxTotal(int i) {
        this.connPool.setMaxTotal(i);
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public int getMaxTotal() {
        return this.connPool.getMaxTotal();
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i) {
        this.connPool.setDefaultMaxPerRoute(i);
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        return this.connPool.getDefaultMaxPerRoute();
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void setMaxPerRoute(HttpHost httpHost, int i) {
        this.connPool.setMaxPerRoute(httpHost, i);
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public int getMaxPerRoute(HttpHost httpHost) {
        return this.connPool.getMaxPerRoute(httpHost);
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void closeIdle(TimeValue timeValue) {
        this.connPool.closeIdle(timeValue);
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public void closeExpired() {
        this.connPool.closeExpired();
    }

    @Override // org.apache.hc.core5.pool.ConnPoolControl
    public Set<HttpHost> getRoutes() {
        return this.connPool.getRoutes();
    }

    public Future<AsyncClientEndpoint> connect(HttpHost httpHost, Timeout timeout, Object obj, FutureCallback<AsyncClientEndpoint> futureCallback) {
        return doConnect(httpHost, timeout, obj, futureCallback);
    }

    protected Future<AsyncClientEndpoint> doConnect(final HttpHost httpHost, final Timeout timeout, final Object obj, FutureCallback<AsyncClientEndpoint> futureCallback) {
        Args.notNull(httpHost, "Host");
        Args.notNull(timeout, "Timeout");
        final ComplexFuture complexFuture = new ComplexFuture(futureCallback);
        complexFuture.setDependency(this.connPool.lease(httpHost, null, timeout, new FutureCallback<PoolEntry<HttpHost, IOSession>>() { // from class: org.apache.hc.core5.http.impl.bootstrap.HttpAsyncRequester.1
            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void completed(final PoolEntry<HttpHost, IOSession> poolEntry) {
                final InternalAsyncClientEndpoint internalAsyncClientEndpoint = HttpAsyncRequester.this.new InternalAsyncClientEndpoint(poolEntry);
                IOSession iOSession = (IOSession) poolEntry.getConnection();
                if (iOSession != null && !iOSession.isOpen()) {
                    poolEntry.discardConnection(CloseMode.IMMEDIATE);
                }
                if (poolEntry.hasConnection()) {
                    complexFuture.completed(internalAsyncClientEndpoint);
                } else {
                    complexFuture.setDependency(HttpAsyncRequester.this.requestSession(httpHost, timeout, new EndpointParameters(httpHost, obj), new FutureCallback<IOSession>() { // from class: org.apache.hc.core5.http.impl.bootstrap.HttpAsyncRequester.1.1
                        @Override // org.apache.hc.core5.concurrent.FutureCallback
                        public void completed(IOSession iOSession2) {
                            iOSession2.setSocketTimeout(timeout);
                            poolEntry.assignConnection(iOSession2);
                            complexFuture.completed(internalAsyncClientEndpoint);
                        }

                        @Override // org.apache.hc.core5.concurrent.FutureCallback
                        public void failed(Exception exc) {
                            try {
                                complexFuture.failed(exc);
                            } finally {
                                internalAsyncClientEndpoint.releaseAndDiscard();
                            }
                        }

                        @Override // org.apache.hc.core5.concurrent.FutureCallback
                        public void cancelled() {
                            try {
                                complexFuture.cancel();
                            } finally {
                                internalAsyncClientEndpoint.releaseAndDiscard();
                            }
                        }
                    }));
                }
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void failed(Exception exc) {
                complexFuture.failed(exc);
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void cancelled() {
                complexFuture.cancel();
            }
        }));
        return complexFuture;
    }

    public Future<AsyncClientEndpoint> connect(HttpHost httpHost, Timeout timeout) {
        return connect(httpHost, timeout, null, null);
    }

    public void execute(final HttpHost httpHost, AsyncClientExchangeHandler asyncClientExchangeHandler, final HandlerFactory<AsyncPushConsumer> handlerFactory, final Timeout timeout, final HttpContext httpContext) {
        final AsyncClientExchangeHandler asyncClientExchangeHandler2;
        Args.notNull(asyncClientExchangeHandler, "Exchange handler");
        Args.notNull(timeout, "Timeout");
        Args.notNull(httpContext, AuthenticationConstants.Broker.CHALLENGE_RESPONSE_CONTEXT);
        try {
            asyncClientExchangeHandler2 = asyncClientExchangeHandler;
            try {
                asyncClientExchangeHandler2.produceRequest(new RequestChannel() { // from class: org.apache.hc.core5.http.impl.bootstrap.HttpAsyncRequester$$ExternalSyntheticLambda0
                    @Override // org.apache.hc.core5.http.nio.RequestChannel
                    public final void sendRequest(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext2) throws HttpException, IOException {
                        this.f$0.m16633x97ce0b42(httpHost, timeout, asyncClientExchangeHandler2, handlerFactory, httpContext, httpRequest, entityDetails, httpContext2);
                    }
                }, httpContext);
            } catch (IOException | HttpException e) {
                e = e;
                asyncClientExchangeHandler2.failed(e);
            }
        } catch (IOException | HttpException e2) {
            e = e2;
            asyncClientExchangeHandler2 = asyncClientExchangeHandler;
        }
    }

    /* JADX INFO: renamed from: lambda$execute$0$org-apache-hc-core5-http-impl-bootstrap-HttpAsyncRequester, reason: not valid java name */
    /* synthetic */ void m16633x97ce0b42(HttpHost httpHost, Timeout timeout, final AsyncClientExchangeHandler asyncClientExchangeHandler, final HandlerFactory handlerFactory, final HttpContext httpContext, HttpRequest httpRequest, final EntityDetails entityDetails, HttpContext httpContext2) throws HttpException, IOException {
        final HttpRequest httpRequest2;
        if (httpHost == null) {
            httpHost = defaultTarget(httpRequest);
        }
        if (httpRequest.getAuthority() == null) {
            httpRequest2 = httpRequest;
            httpRequest2.setAuthority(new URIAuthority(httpHost.getHostName(), httpHost.getPort()));
        } else {
            httpRequest2 = httpRequest;
        }
        connect(httpHost, timeout, null, new FutureCallback<AsyncClientEndpoint>() { // from class: org.apache.hc.core5.http.impl.bootstrap.HttpAsyncRequester.2
            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void completed(final AsyncClientEndpoint asyncClientEndpoint) {
                asyncClientEndpoint.execute(new AsyncClientExchangeHandler() { // from class: org.apache.hc.core5.http.impl.bootstrap.HttpAsyncRequester.2.1
                    @Override // org.apache.hc.core5.http.nio.ResourceHolder
                    public void releaseResources() {
                        asyncClientEndpoint.releaseAndDiscard();
                        asyncClientExchangeHandler.releaseResources();
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncDataExchangeHandler
                    public void failed(Exception exc) {
                        asyncClientEndpoint.releaseAndDiscard();
                        asyncClientExchangeHandler.failed(exc);
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncClientExchangeHandler
                    public void cancel() {
                        asyncClientEndpoint.releaseAndDiscard();
                        asyncClientExchangeHandler.cancel();
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncClientExchangeHandler
                    public void produceRequest(RequestChannel requestChannel, HttpContext httpContext3) throws HttpException, IOException {
                        requestChannel.sendRequest(httpRequest2, entityDetails, httpContext3);
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
                    public int available() {
                        return asyncClientExchangeHandler.available();
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
                    public void produce(DataStreamChannel dataStreamChannel) throws IOException {
                        asyncClientExchangeHandler.produce(dataStreamChannel);
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncClientExchangeHandler
                    public void consumeInformation(HttpResponse httpResponse, HttpContext httpContext3) throws HttpException, IOException {
                        asyncClientExchangeHandler.consumeInformation(httpResponse, httpContext3);
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncClientExchangeHandler
                    public void consumeResponse(HttpResponse httpResponse, EntityDetails entityDetails2, HttpContext httpContext3) throws HttpException, IOException {
                        if (entityDetails2 == null) {
                            asyncClientEndpoint.releaseAndReuse();
                        }
                        asyncClientExchangeHandler.consumeResponse(httpResponse, entityDetails2, httpContext3);
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
                    public void updateCapacity(CapacityChannel capacityChannel) throws IOException {
                        asyncClientExchangeHandler.updateCapacity(capacityChannel);
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
                    public void consume(ByteBuffer byteBuffer) throws IOException {
                        asyncClientExchangeHandler.consume(byteBuffer);
                    }

                    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
                    public void streamEnd(List<? extends Header> list) throws HttpException, IOException {
                        asyncClientEndpoint.releaseAndReuse();
                        asyncClientExchangeHandler.streamEnd(list);
                    }
                }, handlerFactory, httpContext);
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void failed(Exception exc) {
                asyncClientExchangeHandler.failed(exc);
            }

            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void cancelled() {
                asyncClientExchangeHandler.cancel();
            }
        });
    }

    public void execute(AsyncClientExchangeHandler asyncClientExchangeHandler, HandlerFactory<AsyncPushConsumer> handlerFactory, Timeout timeout, HttpContext httpContext) {
        execute((HttpHost) null, asyncClientExchangeHandler, handlerFactory, timeout, httpContext);
    }

    public void execute(AsyncClientExchangeHandler asyncClientExchangeHandler, Timeout timeout, HttpContext httpContext) {
        execute(asyncClientExchangeHandler, (HandlerFactory<AsyncPushConsumer>) null, timeout, httpContext);
    }

    public final <T> Future<T> execute(HttpHost httpHost, AsyncRequestProducer asyncRequestProducer, AsyncResponseConsumer<T> asyncResponseConsumer, HandlerFactory<AsyncPushConsumer> handlerFactory, Timeout timeout, HttpContext httpContext, FutureCallback<T> futureCallback) {
        Args.notNull(asyncRequestProducer, "Request producer");
        Args.notNull(asyncResponseConsumer, "Response consumer");
        Args.notNull(timeout, "Timeout");
        final BasicFuture basicFuture = new BasicFuture(futureCallback);
        BasicClientExchangeHandler basicClientExchangeHandler = new BasicClientExchangeHandler(asyncRequestProducer, asyncResponseConsumer, new FutureContribution<T>(basicFuture) { // from class: org.apache.hc.core5.http.impl.bootstrap.HttpAsyncRequester.3
            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void completed(T t) {
                basicFuture.completed(t);
            }
        });
        if (httpContext == null) {
            httpContext = HttpCoreContext.create();
        }
        execute(httpHost, basicClientExchangeHandler, handlerFactory, timeout, httpContext);
        return basicFuture;
    }

    public final <T> Future<T> execute(AsyncRequestProducer asyncRequestProducer, AsyncResponseConsumer<T> asyncResponseConsumer, HandlerFactory<AsyncPushConsumer> handlerFactory, Timeout timeout, HttpContext httpContext, FutureCallback<T> futureCallback) {
        return execute(null, asyncRequestProducer, asyncResponseConsumer, handlerFactory, timeout, httpContext, futureCallback);
    }

    public final <T> Future<T> execute(AsyncRequestProducer asyncRequestProducer, AsyncResponseConsumer<T> asyncResponseConsumer, Timeout timeout, HttpContext httpContext, FutureCallback<T> futureCallback) {
        return execute(asyncRequestProducer, asyncResponseConsumer, null, timeout, httpContext, futureCallback);
    }

    public final <T> Future<T> execute(HttpHost httpHost, AsyncRequestProducer asyncRequestProducer, AsyncResponseConsumer<T> asyncResponseConsumer, Timeout timeout, FutureCallback<T> futureCallback) {
        return execute(httpHost, asyncRequestProducer, asyncResponseConsumer, null, timeout, null, futureCallback);
    }

    public final <T> Future<T> execute(AsyncRequestProducer asyncRequestProducer, AsyncResponseConsumer<T> asyncResponseConsumer, Timeout timeout, FutureCallback<T> futureCallback) {
        return execute(asyncRequestProducer, asyncResponseConsumer, null, timeout, null, futureCallback);
    }

    protected void doTlsUpgrade(final ProtocolIOSession protocolIOSession, NamedEndpoint namedEndpoint, final FutureCallback<ProtocolIOSession> futureCallback) {
        TlsStrategy tlsStrategy = this.tlsStrategy;
        if (tlsStrategy != null) {
            tlsStrategy.upgrade(protocolIOSession, namedEndpoint, null, this.handshakeTimeout, new CallbackContribution<TransportSecurityLayer>(futureCallback) { // from class: org.apache.hc.core5.http.impl.bootstrap.HttpAsyncRequester.4
                @Override // org.apache.hc.core5.concurrent.FutureCallback
                public void completed(TransportSecurityLayer transportSecurityLayer) {
                    FutureCallback futureCallback2 = futureCallback;
                    if (futureCallback2 != null) {
                        futureCallback2.completed(protocolIOSession);
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("TLS upgrade not supported");
    }

    private class InternalAsyncClientEndpoint extends AsyncClientEndpoint implements TlsUpgradeCapable {
        final AtomicReference<PoolEntry<HttpHost, IOSession>> poolEntryRef;

        InternalAsyncClientEndpoint(PoolEntry<HttpHost, IOSession> poolEntry) {
            this.poolEntryRef = new AtomicReference<>(poolEntry);
        }

        private IOSession getIOSession() {
            PoolEntry<HttpHost, IOSession> poolEntry = this.poolEntryRef.get();
            if (poolEntry == null) {
                throw new IllegalStateException("Endpoint has already been released");
            }
            IOSession iOSession = (IOSession) poolEntry.getConnection();
            if (iOSession != null) {
                return iOSession;
            }
            throw new IllegalStateException("I/O session is invalid");
        }

        @Override // org.apache.hc.core5.http.nio.AsyncClientEndpoint
        public void execute(AsyncClientExchangeHandler asyncClientExchangeHandler, HandlerFactory<AsyncPushConsumer> handlerFactory, HttpContext httpContext) {
            IOSession iOSession = getIOSession();
            iOSession.enqueue(new RequestExecutionCommand(asyncClientExchangeHandler, handlerFactory, null, httpContext), Command.Priority.NORMAL);
            if (iOSession.isOpen()) {
                return;
            }
            try {
                asyncClientExchangeHandler.failed(new ConnectionClosedException());
            } finally {
                asyncClientExchangeHandler.releaseResources();
            }
        }

        @Override // org.apache.hc.core5.http.nio.AsyncClientEndpoint
        public boolean isConnected() {
            IOSession iOSession;
            PoolEntry<HttpHost, IOSession> poolEntry = this.poolEntryRef.get();
            if (poolEntry != null && (iOSession = (IOSession) poolEntry.getConnection()) != null && iOSession.isOpen()) {
                IOEventHandler handler = iOSession.getHandler();
                if ((handler instanceof HttpConnection) && ((HttpConnection) handler).isOpen()) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.apache.hc.core5.http.nio.AsyncClientEndpoint
        public void releaseAndReuse() {
            PoolEntry<HttpHost, IOSession> andSet = this.poolEntryRef.getAndSet(null);
            if (andSet != null) {
                IOSession iOSession = (IOSession) andSet.getConnection();
                HttpAsyncRequester.this.connPool.release(andSet, iOSession != null && iOSession.isOpen());
            }
        }

        @Override // org.apache.hc.core5.http.nio.AsyncClientEndpoint
        public void releaseAndDiscard() {
            PoolEntry<HttpHost, IOSession> andSet = this.poolEntryRef.getAndSet(null);
            if (andSet != null) {
                andSet.discardConnection(CloseMode.GRACEFUL);
                HttpAsyncRequester.this.connPool.release(andSet, false);
            }
        }

        @Override // org.apache.hc.core5.http.nio.ssl.TlsUpgradeCapable
        public void tlsUpgrade(NamedEndpoint namedEndpoint, FutureCallback<ProtocolIOSession> futureCallback) {
            IOSession iOSession = getIOSession();
            if (iOSession instanceof ProtocolIOSession) {
                HttpAsyncRequester.this.doTlsUpgrade((ProtocolIOSession) iOSession, namedEndpoint, futureCallback);
                return;
            }
            throw new IllegalStateException("TLS upgrade not supported");
        }
    }
}
