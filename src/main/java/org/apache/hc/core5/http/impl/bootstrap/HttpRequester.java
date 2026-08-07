package org.apache.hc.core5.http.impl.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Resolver;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.ConnectionRequestTimeoutException;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.DefaultAddressResolver;
import org.apache.hc.core5.http.impl.io.DefaultBHttpClientConnectionFactory;
import org.apache.hc.core5.http.impl.io.HttpRequestExecutor;
import org.apache.hc.core5.http.io.EofSensorInputStream;
import org.apache.hc.core5.http.io.EofSensorWatcher;
import org.apache.hc.core5.http.io.HttpClientConnection;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.HttpConnectionFactory;
import org.apache.hc.core5.http.io.HttpResponseInformationCallback;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.HttpEntityWrapper;
import org.apache.hc.core5.http.io.ssl.SSLSessionVerifier;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.io.SocketSupport;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.pool.ConnPoolControl;
import org.apache.hc.core5.pool.ManagedConnPool;
import org.apache.hc.core5.pool.PoolEntry;
import org.apache.hc.core5.pool.PoolStats;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class HttpRequester implements ConnPoolControl<HttpHost>, ModalCloseable {
    private final Resolver<HttpHost, InetSocketAddress> addressResolver;
    private final ManagedConnPool<HttpHost, HttpClientConnection> connPool;
    private final HttpConnectionFactory<? extends HttpClientConnection> connectFactory;
    private final HttpProcessor httpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final SocketConfig socketConfig;
    private final SSLSessionVerifier sslSessionVerifier;
    private final Callback<SSLParameters> sslSetupHandler;
    private final SSLSocketFactory sslSocketFactory;

    public HttpRequester(HttpRequestExecutor httpRequestExecutor, HttpProcessor httpProcessor, ManagedConnPool<HttpHost, HttpClientConnection> managedConnPool, SocketConfig socketConfig, HttpConnectionFactory<? extends HttpClientConnection> httpConnectionFactory, SSLSocketFactory sSLSocketFactory, Callback<SSLParameters> callback, SSLSessionVerifier sSLSessionVerifier, Resolver<HttpHost, InetSocketAddress> resolver) {
        this.requestExecutor = (HttpRequestExecutor) Args.notNull(httpRequestExecutor, "Request executor");
        this.httpProcessor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.connPool = (ManagedConnPool) Args.notNull(managedConnPool, "Connection pool");
        this.socketConfig = socketConfig == null ? SocketConfig.DEFAULT : socketConfig;
        this.connectFactory = httpConnectionFactory == null ? new DefaultBHttpClientConnectionFactory(Http1Config.DEFAULT, CharCodingConfig.DEFAULT) : httpConnectionFactory;
        this.sslSocketFactory = sSLSocketFactory == null ? (SSLSocketFactory) SSLSocketFactory.getDefault() : sSLSocketFactory;
        this.sslSetupHandler = callback;
        this.sslSessionVerifier = sSLSessionVerifier;
        this.addressResolver = resolver == null ? DefaultAddressResolver.INSTANCE : resolver;
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

    public ClassicHttpResponse execute(HttpClientConnection httpClientConnection, ClassicHttpRequest classicHttpRequest, HttpResponseInformationCallback httpResponseInformationCallback, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpClientConnection, "HTTP connection");
        Args.notNull(classicHttpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        if (!httpClientConnection.isOpen()) {
            throw new ConnectionClosedException();
        }
        this.requestExecutor.preProcess(classicHttpRequest, this.httpProcessor, httpContext);
        ClassicHttpResponse classicHttpResponseExecute = this.requestExecutor.execute(classicHttpRequest, httpClientConnection, httpResponseInformationCallback, httpContext);
        this.requestExecutor.postProcess(classicHttpResponseExecute, this.httpProcessor, httpContext);
        return classicHttpResponseExecute;
    }

    public ClassicHttpResponse execute(HttpClientConnection httpClientConnection, ClassicHttpRequest classicHttpRequest, HttpContext httpContext) throws HttpException, IOException {
        return execute(httpClientConnection, classicHttpRequest, (HttpResponseInformationCallback) null, httpContext);
    }

    public boolean keepAlive(HttpClientConnection httpClientConnection, ClassicHttpRequest classicHttpRequest, ClassicHttpResponse classicHttpResponse, HttpContext httpContext) throws IOException {
        boolean zKeepAlive = this.requestExecutor.keepAlive(classicHttpRequest, classicHttpResponse, httpClientConnection, httpContext);
        if (!zKeepAlive) {
            httpClientConnection.close();
        }
        return zKeepAlive;
    }

    public <T> T execute(HttpClientConnection httpClientConnection, ClassicHttpRequest classicHttpRequest, HttpContext httpContext, HttpClientResponseHandler<T> httpClientResponseHandler) throws HttpException, IOException {
        try {
            ClassicHttpResponse classicHttpResponseExecute = execute(httpClientConnection, classicHttpRequest, httpContext);
            try {
                T tHandleResponse = httpClientResponseHandler.handleResponse(classicHttpResponseExecute);
                EntityUtils.consume(classicHttpResponseExecute.getEntity());
                if (!this.requestExecutor.keepAlive(classicHttpRequest, classicHttpResponseExecute, httpClientConnection, httpContext)) {
                    httpClientConnection.close();
                }
                if (classicHttpResponseExecute != null) {
                    classicHttpResponseExecute.close();
                }
                return tHandleResponse;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (classicHttpResponseExecute != null) {
                        try {
                            classicHttpResponseExecute.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException | RuntimeException | HttpException e) {
            httpClientConnection.close(CloseMode.IMMEDIATE);
            throw e;
        }
    }

    private HttpClientConnection createConnection(Socket socket, HttpHost httpHost) throws IOException {
        socket.setSoTimeout(this.socketConfig.getSoTimeout().toMillisecondsIntBound());
        socket.setReuseAddress(this.socketConfig.isSoReuseAddress());
        socket.setTcpNoDelay(this.socketConfig.isTcpNoDelay());
        socket.setKeepAlive(this.socketConfig.isSoKeepAlive());
        if (this.socketConfig.getRcvBufSize() > 0) {
            socket.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
        }
        if (this.socketConfig.getSndBufSize() > 0) {
            socket.setSendBufferSize(this.socketConfig.getSndBufSize());
        }
        if (this.socketConfig.getTcpKeepIdle() > 0) {
            SocketSupport.setOption(socket, SocketSupport.TCP_KEEPIDLE, Integer.valueOf(this.socketConfig.getTcpKeepIdle()));
        }
        if (this.socketConfig.getTcpKeepInterval() > 0) {
            SocketSupport.setOption(socket, SocketSupport.TCP_KEEPINTERVAL, Integer.valueOf(this.socketConfig.getTcpKeepInterval()));
        }
        if (this.socketConfig.getTcpKeepCount() > 0) {
            SocketSupport.setOption(socket, SocketSupport.TCP_KEEPCOUNT, Integer.valueOf(this.socketConfig.getTcpKeepCount()));
        }
        int millisecondsIntBound = this.socketConfig.getSoLinger().toMillisecondsIntBound();
        if (millisecondsIntBound >= 0) {
            socket.setSoLinger(true, millisecondsIntBound);
        }
        InetSocketAddress inetSocketAddressResolve = this.addressResolver.resolve(httpHost);
        socket.connect(inetSocketAddressResolve, this.socketConfig.getSoTimeout().toMillisecondsIntBound());
        if (URIScheme.HTTPS.same(httpHost.getSchemeName())) {
            SSLSocket sSLSocket = (SSLSocket) this.sslSocketFactory.createSocket(socket, httpHost.getHostName(), inetSocketAddressResolve.getPort(), false);
            if (this.sslSetupHandler != null) {
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                this.sslSetupHandler.execute(sSLParameters);
                sSLSocket.setSSLParameters(sSLParameters);
            }
            try {
                sSLSocket.startHandshake();
                SSLSession session = sSLSocket.getSession();
                if (session == null) {
                    throw new SSLHandshakeException("SSL session not available");
                }
                SSLSessionVerifier sSLSessionVerifier = this.sslSessionVerifier;
                if (sSLSessionVerifier != null) {
                    sSLSessionVerifier.verify(httpHost, session);
                }
                return (HttpClientConnection) this.connectFactory.createConnection(sSLSocket, socket);
            } catch (IOException e) {
                Closer.closeQuietly(sSLSocket);
                throw e;
            }
        }
        return (HttpClientConnection) this.connectFactory.createConnection(socket);
    }

    public ClassicHttpResponse execute(HttpHost httpHost, final ClassicHttpRequest classicHttpRequest, HttpResponseInformationCallback httpResponseInformationCallback, Timeout timeout, final HttpContext httpContext) throws HttpException, IOException {
        Socket socket;
        Args.notNull(httpHost, "HTTP host");
        Args.notNull(classicHttpRequest, "HTTP request");
        Future<PoolEntry<HttpHost, HttpClientConnection>> futureLease = this.connPool.lease(httpHost, null, timeout, null);
        Timeout timeoutDefaultsToInfinite = Timeout.defaultsToInfinite(timeout);
        try {
            PoolEntry<HttpHost, HttpClientConnection> poolEntry = futureLease.get(timeoutDefaultsToInfinite.getDuration(), timeoutDefaultsToInfinite.getTimeUnit());
            final PoolEntryHolder poolEntryHolder = new PoolEntryHolder(poolEntry);
            try {
                HttpClientConnection httpClientConnectionCreateConnection = (HttpClientConnection) poolEntry.getConnection();
                if (httpClientConnectionCreateConnection == null) {
                    if (this.socketConfig.getSocksProxyAddress() != null) {
                        socket = new Socket(new Proxy(Proxy.Type.SOCKS, this.socketConfig.getSocksProxyAddress()));
                    } else {
                        socket = new Socket();
                    }
                    Socket socket2 = socket;
                    try {
                        httpClientConnectionCreateConnection = createConnection(socket2, httpHost);
                        poolEntry.assignConnection(httpClientConnectionCreateConnection);
                    } catch (IOException | RuntimeException e) {
                        Closer.closeQuietly(socket2);
                        throw e;
                    }
                }
                if (classicHttpRequest.getAuthority() == null) {
                    classicHttpRequest.setAuthority(new URIAuthority(httpHost.getHostName(), httpHost.getPort()));
                }
                final ClassicHttpResponse classicHttpResponseExecute = execute(httpClientConnectionCreateConnection, classicHttpRequest, httpResponseInformationCallback, httpContext);
                HttpEntity entity = classicHttpResponseExecute.getEntity();
                if (entity != null) {
                    classicHttpResponseExecute.setEntity(new HttpEntityWrapper(entity) { // from class: org.apache.hc.core5.http.impl.bootstrap.HttpRequester.1
                        @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
                        public boolean isStreaming() {
                            return true;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void releaseConnection() throws IOException {
                            try {
                                HttpClientConnection connection = poolEntryHolder.getConnection();
                                if (connection != null && HttpRequester.this.requestExecutor.keepAlive(classicHttpRequest, classicHttpResponseExecute, connection, httpContext)) {
                                    if (super.isStreaming()) {
                                        Closer.close(super.getContent());
                                    }
                                    poolEntryHolder.releaseConnection();
                                }
                            } finally {
                                poolEntryHolder.discardConnection();
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void abortConnection() {
                            poolEntryHolder.discardConnection();
                        }

                        @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
                        public InputStream getContent() throws IOException {
                            return new EofSensorInputStream(super.getContent(), new EofSensorWatcher() { // from class: org.apache.hc.core5.http.impl.bootstrap.HttpRequester.1.1
                                @Override // org.apache.hc.core5.http.io.EofSensorWatcher
                                public boolean eofDetected(InputStream inputStream) throws IOException {
                                    releaseConnection();
                                    return false;
                                }

                                @Override // org.apache.hc.core5.http.io.EofSensorWatcher
                                public boolean streamClosed(InputStream inputStream) throws IOException {
                                    releaseConnection();
                                    return false;
                                }

                                @Override // org.apache.hc.core5.http.io.EofSensorWatcher
                                public boolean streamAbort(InputStream inputStream) throws IOException {
                                    abortConnection();
                                    return false;
                                }
                            });
                        }

                        @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
                        public void writeTo(OutputStream outputStream) throws IOException {
                            if (outputStream != null) {
                                try {
                                    super.writeTo(outputStream);
                                } catch (IOException | RuntimeException unused) {
                                    abortConnection();
                                    return;
                                }
                            }
                            close();
                        }

                        @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, java.io.Closeable, java.lang.AutoCloseable
                        public void close() throws IOException {
                            releaseConnection();
                        }
                    });
                    return classicHttpResponseExecute;
                }
                HttpClientConnection connection = poolEntryHolder.getConnection();
                if (!this.requestExecutor.keepAlive(classicHttpRequest, classicHttpResponseExecute, connection, httpContext)) {
                    connection.close();
                }
                poolEntryHolder.releaseConnection();
                return classicHttpResponseExecute;
            } catch (IOException | RuntimeException | HttpException e2) {
                poolEntryHolder.discardConnection();
                throw e2;
            }
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException(e3.getMessage());
        } catch (ExecutionException e4) {
            throw new HttpException("Unexpected failure leasing connection", e4);
        } catch (TimeoutException unused) {
            throw new ConnectionRequestTimeoutException("Connection request timeout");
        }
    }

    public ClassicHttpResponse execute(HttpHost httpHost, ClassicHttpRequest classicHttpRequest, Timeout timeout, HttpContext httpContext) throws HttpException, IOException {
        return execute(httpHost, classicHttpRequest, (HttpResponseInformationCallback) null, timeout, httpContext);
    }

    public <T> T execute(HttpHost httpHost, ClassicHttpRequest classicHttpRequest, Timeout timeout, HttpContext httpContext, HttpClientResponseHandler<T> httpClientResponseHandler) throws HttpException, IOException {
        ClassicHttpResponse classicHttpResponseExecute = execute(httpHost, classicHttpRequest, (HttpResponseInformationCallback) null, timeout, httpContext);
        try {
            T tHandleResponse = httpClientResponseHandler.handleResponse(classicHttpResponseExecute);
            EntityUtils.consume(classicHttpResponseExecute.getEntity());
            if (classicHttpResponseExecute != null) {
                classicHttpResponseExecute.close();
            }
            return tHandleResponse;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (classicHttpResponseExecute == null) {
                    throw th2;
                }
                try {
                    classicHttpResponseExecute.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }

    public ConnPoolControl<HttpHost> getConnPoolControl() {
        return this.connPool;
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        this.connPool.close(closeMode);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.connPool.close();
    }

    private class PoolEntryHolder {
        private final AtomicReference<PoolEntry<HttpHost, HttpClientConnection>> poolEntryRef;

        PoolEntryHolder(PoolEntry<HttpHost, HttpClientConnection> poolEntry) {
            this.poolEntryRef = new AtomicReference<>(poolEntry);
        }

        HttpClientConnection getConnection() {
            PoolEntry<HttpHost, HttpClientConnection> poolEntry = this.poolEntryRef.get();
            if (poolEntry != null) {
                return (HttpClientConnection) poolEntry.getConnection();
            }
            return null;
        }

        void releaseConnection() {
            PoolEntry<HttpHost, HttpClientConnection> andSet = this.poolEntryRef.getAndSet(null);
            if (andSet != null) {
                HttpClientConnection httpClientConnection = (HttpClientConnection) andSet.getConnection();
                HttpRequester.this.connPool.release(andSet, httpClientConnection != null && httpClientConnection.isOpen());
            }
        }

        void discardConnection() {
            PoolEntry<HttpHost, HttpClientConnection> andSet = this.poolEntryRef.getAndSet(null);
            if (andSet != null) {
                andSet.discardConnection(CloseMode.GRACEFUL);
                HttpRequester.this.connPool.release(andSet, false);
            }
        }
    }
}
