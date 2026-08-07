package org.apache.http.impl.execchain;

import com.google.api.client.http.HttpMethods;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthState;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

/* JADX INFO: loaded from: classes5.dex */
public class MainClientExec implements ClientExecChain {
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpProcessor httpProcessor, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this.log = LogFactory.getLog(getClass());
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        Args.notNull(httpProcessor, "Proxy HTTP processor");
        Args.notNull(authenticationStrategy, "Target authentication strategy");
        Args.notNull(authenticationStrategy2, "Proxy authentication strategy");
        Args.notNull(userTokenHandler, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        this.proxyHttpProcessor = httpProcessor;
        this.targetAuthStrategy = authenticationStrategy;
        this.proxyAuthStrategy = authenticationStrategy2;
        this.userTokenHandler = userTokenHandler;
    }

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this(httpRequestExecutor, httpClientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, new ImmutableHttpProcessor(new RequestTargetHost()), authenticationStrategy, authenticationStrategy2, userTokenHandler);
    }

    /* JADX WARN: Code duplicated, block: B:180:0x0335  */
    /* JADX WARN: Code duplicated, block: B:183:0x033e  */
    /* JADX WARN: Code duplicated, block: B:187:0x034b  */
    /* JADX WARN: Code duplicated, block: B:190:0x0354  */
    @Override // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        AuthState authState;
        AuthState authState2;
        HttpClientConnection httpClientConnection;
        HttpResponse response;
        Object userToken;
        AuthState authState3;
        String str;
        MainClientExec mainClientExec = this;
        HttpRoute httpRoute2 = httpRoute;
        HttpRequest httpRequest = httpRequestWrapper;
        HttpClientContext httpClientContext2 = httpClientContext;
        Args.notNull(httpRoute2, "HTTP route");
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientContext2, "HTTP context");
        AuthState targetAuthState = httpClientContext2.getTargetAuthState();
        if (targetAuthState == null) {
            targetAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.target-scope", targetAuthState);
        }
        AuthState authState4 = targetAuthState;
        AuthState proxyAuthState = httpClientContext2.getProxyAuthState();
        if (proxyAuthState == null) {
            proxyAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.proxy-scope", proxyAuthState);
        }
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest) httpRequest);
        }
        Object userToken2 = httpClientContext2.getUserToken();
        ConnectionRequest connectionRequestRequestConnection = mainClientExec.connManager.requestConnection(httpRoute2, userToken2);
        if (httpExecutionAware != null) {
            if (httpExecutionAware.isAborted()) {
                connectionRequestRequestConnection.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpExecutionAware.setCancellable(connectionRequestRequestConnection);
        }
        RequestConfig requestConfig = httpClientContext2.getRequestConfig();
        try {
            int connectionRequestTimeout = requestConfig.getConnectionRequestTimeout();
            HttpClientConnection httpClientConnection2 = connectionRequestRequestConnection.get(connectionRequestTimeout > 0 ? connectionRequestTimeout : 0L, TimeUnit.MILLISECONDS);
            httpClientContext2.setAttribute("http.connection", httpClientConnection2);
            if (requestConfig.isStaleConnectionCheckEnabled() && httpClientConnection2.isOpen()) {
                mainClientExec.log.debug("Stale connection check");
                if (httpClientConnection2.isStale()) {
                    mainClientExec.log.debug("Stale connection detected");
                    httpClientConnection2.close();
                }
            }
            ConnectionHolder connectionHolder = new ConnectionHolder(mainClientExec.log, mainClientExec.connManager, httpClientConnection2);
            if (httpExecutionAware != null) {
                try {
                    try {
                        try {
                            httpExecutionAware.setCancellable(connectionHolder);
                        } catch (Error e) {
                            e = e;
                            mainClientExec.connManager.shutdown();
                            throw e;
                        }
                    } catch (HttpException e2) {
                        connectionHolder.abortConnection();
                        throw e2;
                    } catch (ConnectionShutdownException e3) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                        interruptedIOException.initCause(e3);
                        throw interruptedIOException;
                    }
                } catch (IOException e4) {
                    e = e4;
                    authState = proxyAuthState;
                    authState2 = authState4;
                    connectionHolder.abortConnection();
                    if (authState.isConnectionBased()) {
                        authState.reset();
                    }
                    if (authState2.isConnectionBased()) {
                        authState2.reset();
                    }
                    throw e;
                } catch (RuntimeException e5) {
                    e = e5;
                    authState = proxyAuthState;
                    authState2 = authState4;
                    connectionHolder.abortConnection();
                    if (authState.isConnectionBased()) {
                        authState.reset();
                    }
                    if (authState2.isConnectionBased()) {
                        authState2.reset();
                    }
                    throw e;
                }
            }
            int i = 1;
            int i2 = 1;
            while (true) {
                if (i2 > i && !RequestEntityProxy.isRepeatable(httpRequest)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if (httpExecutionAware != null && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (httpClientConnection2.isOpen()) {
                    HttpClientConnection httpClientConnection3 = httpClientConnection2;
                    authState = proxyAuthState;
                    httpClientConnection = httpClientConnection3;
                } else {
                    try {
                        AuthState authState5 = proxyAuthState;
                        try {
                            mainClientExec.log.debug("Opening connection " + httpRoute2);
                            mainClientExec = this;
                            try {
                                mainClientExec.establishRoute(authState5, httpClientConnection2, httpRoute2, httpRequest, httpClientContext2);
                                HttpClientConnection httpClientConnection4 = httpClientConnection2;
                                authState = authState5;
                                httpClientConnection = httpClientConnection4;
                            } catch (TunnelRefusedException e6) {
                                if (mainClientExec.log.isDebugEnabled()) {
                                    mainClientExec.log.debug(e6.getMessage());
                                }
                                response = e6.getResponse();
                                userToken2 = userToken2;
                            }
                        } catch (IOException e7) {
                            e = e7;
                            authState = authState5;
                            authState2 = authState4;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                                authState.reset();
                            }
                            if (authState2.isConnectionBased()) {
                                authState2.reset();
                            }
                            throw e;
                        } catch (RuntimeException e8) {
                            e = e8;
                            authState = authState5;
                            authState2 = authState4;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                                authState.reset();
                            }
                            if (authState2.isConnectionBased()) {
                                authState2.reset();
                            }
                            throw e;
                        }
                    } catch (Error e9) {
                        e = e9;
                        mainClientExec = this;
                        mainClientExec.connManager.shutdown();
                        throw e;
                    }
                }
                try {
                    int socketTimeout = requestConfig.getSocketTimeout();
                    if (socketTimeout >= 0) {
                        httpClientConnection.setSocketTimeout(socketTimeout);
                    }
                    if (httpExecutionAware != null && httpExecutionAware.isAborted()) {
                        throw new RequestAbortedException("Request aborted");
                    }
                    if (mainClientExec.log.isDebugEnabled()) {
                        mainClientExec.log.debug("Executing request " + httpRequest.getRequestLine());
                    }
                    if (!httpRequest.containsHeader("Authorization")) {
                        if (mainClientExec.log.isDebugEnabled()) {
                            mainClientExec.log.debug("Target auth state: " + authState4.getState());
                        }
                        mainClientExec.authenticator.generateAuthResponse(httpRequest, authState4, httpClientContext2);
                    }
                    if (!httpRequest.containsHeader("Proxy-Authorization") && !httpRoute.isTunnelled()) {
                        if (mainClientExec.log.isDebugEnabled()) {
                            mainClientExec.log.debug("Proxy auth state: " + authState.getState());
                        }
                        mainClientExec.authenticator.generateAuthResponse(httpRequest, authState, httpClientContext2);
                    }
                    httpClientContext2.setAttribute("http.request", httpRequest);
                    HttpResponse httpResponseExecute = mainClientExec.requestExecutor.execute(httpRequest, httpClientConnection, httpClientContext2);
                    if (mainClientExec.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext2)) {
                        try {
                            authState3 = authState;
                            try {
                                long keepAliveDuration = mainClientExec.keepAliveStrategy.getKeepAliveDuration(httpResponseExecute, httpClientContext2);
                                if (mainClientExec.log.isDebugEnabled()) {
                                    if (keepAliveDuration > 0) {
                                        str = "for " + keepAliveDuration + " " + TimeUnit.MILLISECONDS;
                                    } else {
                                        str = "indefinitely";
                                    }
                                    mainClientExec.log.debug("Connection can be kept alive " + str);
                                } else {
                                    httpResponseExecute = httpResponseExecute;
                                }
                                connectionHolder.setValidFor(keepAliveDuration, TimeUnit.MILLISECONDS);
                                connectionHolder.markReusable();
                            } catch (IOException e10) {
                                e = e10;
                                authState2 = authState4;
                                authState = authState3;
                                connectionHolder.abortConnection();
                                if (authState.isConnectionBased()) {
                                    authState.reset();
                                }
                                if (authState2.isConnectionBased()) {
                                    authState2.reset();
                                }
                                throw e;
                            } catch (RuntimeException e11) {
                                e = e11;
                                authState2 = authState4;
                                authState = authState3;
                                connectionHolder.abortConnection();
                                if (authState.isConnectionBased()) {
                                    authState.reset();
                                }
                                if (authState2.isConnectionBased()) {
                                    authState2.reset();
                                }
                                throw e;
                            }
                        } catch (IOException e12) {
                            e = e12;
                            authState2 = authState4;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                                authState.reset();
                            }
                            if (authState2.isConnectionBased()) {
                                authState2.reset();
                            }
                            throw e;
                        } catch (RuntimeException e13) {
                            e = e13;
                            authState2 = authState4;
                            connectionHolder.abortConnection();
                            if (authState.isConnectionBased()) {
                                authState.reset();
                            }
                            if (authState2.isConnectionBased()) {
                                authState2.reset();
                            }
                            throw e;
                        }
                    } else {
                        authState3 = authState;
                        httpResponseExecute = httpResponseExecute;
                        connectionHolder.markNonReusable();
                    }
                    mainClientExec = this;
                    httpClientContext2 = httpClientContext;
                    authState2 = authState4;
                    authState = authState3;
                    HttpResponse httpResponse = httpResponseExecute;
                    try {
                        if (!mainClientExec.needAuthentication(authState2, authState, httpRoute, httpResponse, httpClientContext2)) {
                            response = httpResponse;
                            break;
                        }
                        HttpEntity entity = httpResponse.getEntity();
                        if (connectionHolder.isReusable()) {
                            EntityUtils.consume(entity);
                        } else {
                            httpClientConnection.close();
                            if (authState.getState() == AuthProtocolState.SUCCESS && authState.isConnectionBased()) {
                                mainClientExec.log.debug("Resetting proxy auth state");
                                authState.reset();
                            }
                            if (authState2.getState() == AuthProtocolState.SUCCESS && authState2.isConnectionBased()) {
                                mainClientExec.log.debug("Resetting target auth state");
                                authState2.reset();
                            }
                        }
                        HttpRequest original = httpRequest.getOriginal();
                        if (!original.containsHeader("Authorization")) {
                            httpRequest.removeHeaders("Authorization");
                        }
                        if (!original.containsHeader("Proxy-Authorization")) {
                            httpRequest.removeHeaders("Proxy-Authorization");
                        }
                        i2++;
                        httpRoute2 = httpRoute;
                        authState4 = authState2;
                        proxyAuthState = authState;
                        httpClientConnection2 = httpClientConnection;
                        httpRequest = httpRequest;
                        userToken2 = userToken2;
                        i = 1;
                    } catch (IOException e14) {
                        e = e14;
                        connectionHolder.abortConnection();
                        if (authState.isConnectionBased()) {
                            authState.reset();
                        }
                        if (authState2.isConnectionBased()) {
                            authState2.reset();
                        }
                        throw e;
                    } catch (RuntimeException e15) {
                        e = e15;
                        connectionHolder.abortConnection();
                        if (authState.isConnectionBased()) {
                            authState.reset();
                        }
                        if (authState2.isConnectionBased()) {
                            authState2.reset();
                        }
                        throw e;
                    }
                } catch (IOException e16) {
                    e = e16;
                } catch (RuntimeException e17) {
                    e = e17;
                }
            }
            if (userToken2 == null) {
                userToken = mainClientExec.userTokenHandler.getUserToken(httpClientContext2);
                httpClientContext2.setAttribute("http.user-token", userToken);
            } else {
                userToken = userToken2;
            }
            if (userToken != null) {
                connectionHolder.setState(userToken);
            }
            HttpEntity entity2 = response.getEntity();
            if (entity2 != null && entity2.isStreaming()) {
                return new HttpResponseProxy(response, connectionHolder);
            }
            connectionHolder.releaseConnection();
            return new HttpResponseProxy(response, null);
        } catch (InterruptedException e18) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", e18);
        } catch (ExecutionException e19) {
            e = e19;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new RequestAbortedException("Request execution failed", e);
        }
    }

    void establishRoute(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        int iNextStep;
        int connectTimeout = httpClientContext.getRequestConfig().getConnectTimeout();
        RouteTracker routeTracker = new RouteTracker(httpRoute);
        do {
            HttpRoute route = routeTracker.toRoute();
            iNextStep = this.routeDirector.nextStep(httpRoute, route);
            switch (iNextStep) {
                case -1:
                    throw new HttpException("Unable to establish route: planned = " + httpRoute + "; current = " + route);
                case 0:
                    this.connManager.routeComplete(httpClientConnection, httpRoute, httpClientContext);
                    break;
                case 1:
                    this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
                    routeTracker.connectTarget(httpRoute.isSecure());
                    break;
                case 2:
                    this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
                    routeTracker.connectProxy(httpRoute.getProxyHost(), httpRoute.isSecure() && !httpRoute.isTunnelled());
                    break;
                case 3:
                    boolean zCreateTunnelToTarget = createTunnelToTarget(authState, httpClientConnection, httpRoute, httpRequest, httpClientContext);
                    this.log.debug("Tunnel to target created.");
                    routeTracker.tunnelTarget(zCreateTunnelToTarget);
                    break;
                case 4:
                    int hopCount = route.getHopCount() - 1;
                    boolean zCreateTunnelToProxy = createTunnelToProxy(httpRoute, hopCount, httpClientContext);
                    this.log.debug("Tunnel to proxy created.");
                    routeTracker.tunnelProxy(httpRoute.getHopTarget(hopCount), zCreateTunnelToProxy);
                    break;
                case 5:
                    this.connManager.upgrade(httpClientConnection, httpRoute, httpClientContext);
                    routeTracker.layerProtocol(httpRoute.isSecure());
                    break;
                default:
                    throw new IllegalStateException("Unknown step indicator " + iNextStep + " from RouteDirector.");
            }
        } while (iNextStep > 0);
    }

    private boolean createTunnelToTarget(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        AuthState authState2;
        HttpClientContext httpClientContext2;
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int connectTimeout = requestConfig.getConnectTimeout();
        HttpHost targetHost = httpRoute.getTargetHost();
        HttpHost proxyHost = httpRoute.getProxyHost();
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest(HttpMethods.CONNECT, targetHost.toHostString(), httpRequest.getProtocolVersion());
        this.requestExecutor.preProcess(basicHttpRequest, this.proxyHttpProcessor, httpClientContext);
        HttpResponse httpResponse = null;
        while (true) {
            if (httpResponse == null) {
                if (!httpClientConnection.isOpen()) {
                    this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
                }
                basicHttpRequest.removeHeaders("Proxy-Authorization");
                this.authenticator.generateAuthResponse(basicHttpRequest, authState, httpClientContext);
                HttpResponse httpResponseExecute = this.requestExecutor.execute(basicHttpRequest, httpClientConnection, httpClientContext);
                this.requestExecutor.postProcess(httpResponseExecute, this.proxyHttpProcessor, httpClientContext);
                if (httpResponseExecute.getStatusLine().getStatusCode() < 200) {
                    throw new HttpException("Unexpected response to CONNECT request: " + httpResponseExecute.getStatusLine());
                }
                if (requestConfig.isAuthenticationEnabled()) {
                    authState2 = authState;
                    httpClientContext2 = httpClientContext;
                    if (this.authenticator.isAuthenticationRequested(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState2, httpClientContext2) && this.authenticator.handleAuthChallenge(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState2, httpClientContext2)) {
                        if (this.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext2)) {
                            this.log.debug("Connection kept alive");
                            EntityUtils.consume(httpResponseExecute.getEntity());
                        } else {
                            httpClientConnection.close();
                        }
                        httpResponse = null;
                    }
                    authState = authState2;
                    httpClientContext = httpClientContext2;
                } else {
                    authState2 = authState;
                    httpClientContext2 = httpClientContext;
                }
                httpResponse = httpResponseExecute;
                authState = authState2;
                httpClientContext = httpClientContext2;
            } else {
                if (httpResponse.getStatusLine().getStatusCode() <= 299) {
                    return false;
                }
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    httpResponse.setEntity(new BufferedHttpEntity(entity));
                }
                httpClientConnection.close();
                throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
            }
        }
    }

    private boolean createTunnelToProxy(HttpRoute httpRoute, int i, HttpClientContext httpClientContext) throws HttpException {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean needAuthentication(AuthState authState, AuthState authState2, HttpRoute httpRoute, HttpResponse httpResponse, HttpClientContext httpClientContext) {
        if (!httpClientContext.getRequestConfig().isAuthenticationEnabled()) {
            return false;
        }
        HttpHost targetHost = httpClientContext.getTargetHost();
        if (targetHost == null) {
            targetHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost = targetHost.getPort() < 0 ? new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName()) : targetHost;
        boolean zIsAuthenticationRequested = this.authenticator.isAuthenticationRequested(httpHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        HttpHost httpHost2 = httpHost;
        HttpHost proxyHost = httpRoute.getProxyHost();
        if (proxyHost == null) {
            proxyHost = httpRoute.getTargetHost();
        }
        HttpHost httpHost3 = proxyHost;
        boolean zIsAuthenticationRequested2 = this.authenticator.isAuthenticationRequested(httpHost3, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        if (zIsAuthenticationRequested) {
            return this.authenticator.handleAuthChallenge(httpHost2, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        }
        if (zIsAuthenticationRequested2) {
            return this.authenticator.handleAuthChallenge(httpHost3, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        }
        return false;
    }
}
