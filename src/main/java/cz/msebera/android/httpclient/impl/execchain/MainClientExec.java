package cz.msebera.android.httpclient.impl.execchain;

import com.google.api.client.http.HttpMethods;
import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.BasicRouteDirector;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRouteDirector;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.auth.HttpAuthenticator;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class MainClientExec implements ClientExecChain {
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpProcessor httpProcessor, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this.log = new HttpClientAndroidLog(getClass());
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

    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        HttpResponse response;
        String str;
        MainClientExec mainClientExec = this;
        HttpRoute httpRoute2 = httpRoute;
        HttpRequest httpRequest = httpRequestWrapper;
        HttpClientContext httpClientContext2 = httpClientContext;
        HttpExecutionAware httpExecutionAware2 = httpExecutionAware;
        Args.notNull(httpRoute2, "HTTP route");
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientContext2, "HTTP context");
        AuthState targetAuthState = httpClientContext2.getTargetAuthState();
        if (targetAuthState == null) {
            targetAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.target-scope", targetAuthState);
        }
        AuthState authState = targetAuthState;
        AuthState proxyAuthState = httpClientContext2.getProxyAuthState();
        if (proxyAuthState == null) {
            proxyAuthState = new AuthState();
            httpClientContext2.setAttribute("http.auth.proxy-scope", proxyAuthState);
        }
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest) httpRequest);
        }
        Object userToken = httpClientContext2.getUserToken();
        ConnectionRequest connectionRequestRequestConnection = mainClientExec.connManager.requestConnection(httpRoute2, userToken);
        if (httpExecutionAware2 != null) {
            if (httpExecutionAware2.isAborted()) {
                connectionRequestRequestConnection.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpExecutionAware2.setCancellable(connectionRequestRequestConnection);
        }
        RequestConfig requestConfig = httpClientContext2.getRequestConfig();
        try {
            int connectionRequestTimeout = requestConfig.getConnectionRequestTimeout();
            HttpClientConnection httpClientConnection = connectionRequestRequestConnection.get(connectionRequestTimeout > 0 ? connectionRequestTimeout : 0L, TimeUnit.MILLISECONDS);
            httpClientContext2.setAttribute("http.connection", httpClientConnection);
            if (requestConfig.isStaleConnectionCheckEnabled() && httpClientConnection.isOpen()) {
                mainClientExec.log.debug("Stale connection check");
                if (httpClientConnection.isStale()) {
                    mainClientExec.log.debug("Stale connection detected");
                    httpClientConnection.close();
                }
            }
            ConnectionHolder connectionHolder = new ConnectionHolder(mainClientExec.log, mainClientExec.connManager, httpClientConnection);
            if (httpExecutionAware2 != null) {
                try {
                    httpExecutionAware2.setCancellable(connectionHolder);
                } catch (HttpException e) {
                    connectionHolder.abortConnection();
                    throw e;
                } catch (ConnectionShutdownException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                    interruptedIOException.initCause(e2);
                    throw interruptedIOException;
                } catch (IOException e3) {
                    connectionHolder.abortConnection();
                    throw e3;
                } catch (RuntimeException e4) {
                    connectionHolder.abortConnection();
                    throw e4;
                }
            }
            int i = 1;
            int i2 = 1;
            while (true) {
                if (i2 > i && !RequestEntityProxy.isRepeatable(httpRequest)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if (httpExecutionAware2 != null && httpExecutionAware2.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if (!httpClientConnection.isOpen()) {
                    mainClientExec.log.debug("Opening connection " + httpRoute2);
                    mainClientExec = this;
                    try {
                        mainClientExec.establishRoute(proxyAuthState, httpClientConnection, httpRoute2, httpRequest, httpClientContext2);
                    } catch (TunnelRefusedException e5) {
                        if (mainClientExec.log.isDebugEnabled()) {
                            mainClientExec.log.debug(e5.getMessage());
                        }
                        response = e5.getResponse();
                    }
                }
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
                        mainClientExec.log.debug("Target auth state: " + authState.getState());
                    }
                    mainClientExec.authenticator.generateAuthResponse(httpRequest, authState, httpClientContext2);
                }
                if (!httpRequest.containsHeader("Proxy-Authorization") && !httpRoute.isTunnelled()) {
                    if (mainClientExec.log.isDebugEnabled()) {
                        mainClientExec.log.debug("Proxy auth state: " + proxyAuthState.getState());
                    }
                    mainClientExec.authenticator.generateAuthResponse(httpRequest, proxyAuthState, httpClientContext2);
                }
                HttpResponse httpResponseExecute = mainClientExec.requestExecutor.execute(httpRequest, httpClientConnection, httpClientContext2);
                if (mainClientExec.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext2)) {
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
                } else {
                    httpResponseExecute = httpResponseExecute;
                    connectionHolder.markNonReusable();
                }
                mainClientExec = this;
                httpClientContext2 = httpClientContext;
                AuthState authState2 = authState;
                AuthState authState3 = proxyAuthState;
                HttpResponse httpResponse = httpResponseExecute;
                if (!mainClientExec.needAuthentication(authState2, authState3, httpRoute, httpResponse, httpClientContext2)) {
                    response = httpResponse;
                    break;
                }
                HttpEntity entity = httpResponse.getEntity();
                if (connectionHolder.isReusable()) {
                    EntityUtils.consume(entity);
                } else {
                    httpClientConnection.close();
                    if (authState3.getState() == AuthProtocolState.SUCCESS && authState3.getAuthScheme() != null && authState3.getAuthScheme().isConnectionBased()) {
                        mainClientExec.log.debug("Resetting proxy auth state");
                        authState3.reset();
                    }
                    if (authState2.getState() == AuthProtocolState.SUCCESS && authState2.getAuthScheme() != null && authState2.getAuthScheme().isConnectionBased()) {
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
                httpRequest = httpRequest;
                authState = authState2;
                proxyAuthState = authState3;
                httpClientConnection = httpClientConnection;
                i = 1;
                httpExecutionAware2 = httpExecutionAware;
            }
            if (userToken == null) {
                userToken = mainClientExec.userTokenHandler.getUserToken(httpClientContext2);
                httpClientContext2.setAttribute("http.user-token", userToken);
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
        } catch (InterruptedException e6) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", e6);
        } catch (ExecutionException e7) {
            e = e7;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            throw new RequestAbortedException("Request execution failed", e);
        }
    }

    void establishRoute(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws IOException, HttpException {
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
                    routeTracker.connectProxy(httpRoute.getProxyHost(), false);
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
