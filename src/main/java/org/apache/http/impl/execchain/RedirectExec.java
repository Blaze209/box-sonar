package org.apache.http.impl.execchain;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.ProtocolException;
import org.apache.http.auth.AuthState;
import org.apache.http.client.RedirectException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

/* JADX INFO: loaded from: classes5.dex */
public class RedirectExec implements ClientExecChain {
    private final Log log = LogFactory.getLog(getClass());
    private final RedirectStrategy redirectStrategy;
    private final ClientExecChain requestExecutor;
    private final HttpRoutePlanner routePlanner;

    public RedirectExec(ClientExecChain clientExecChain, HttpRoutePlanner httpRoutePlanner, RedirectStrategy redirectStrategy) {
        Args.notNull(clientExecChain, "HTTP client request executor");
        Args.notNull(httpRoutePlanner, "HTTP route planner");
        Args.notNull(redirectStrategy, "HTTP redirect strategy");
        this.requestExecutor = clientExecChain;
        this.routePlanner = httpRoutePlanner;
        this.redirectStrategy = redirectStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [org.apache.http.HttpRequest, org.apache.http.client.methods.HttpRequestWrapper] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r4v0, types: [org.apache.http.impl.execchain.ClientExecChain] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        CloseableHttpResponse closeableHttpResponseExecute;
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        List<URI> redirectLocations = httpClientContext.getRedirectLocations();
        if (redirectLocations != null) {
            redirectLocations.clear();
        }
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int maxRedirects = requestConfig.getMaxRedirects() > 0 ? requestConfig.getMaxRedirects() : 50;
        int i = 0;
        ?? r3 = httpRequestWrapper;
        while (true) {
            closeableHttpResponseExecute = this.requestExecutor.execute(httpRoute, r3, httpClientContext, httpExecutionAware);
            try {
                if (!requestConfig.isRedirectsEnabled() || !this.redirectStrategy.isRedirected(r3.getOriginal(), closeableHttpResponseExecute, httpClientContext)) {
                    break;
                }
                if (!RequestEntityProxy.isRepeatable(r3)) {
                    if (!this.log.isDebugEnabled()) {
                        break;
                    }
                    this.log.debug("Cannot redirect non-repeatable request");
                    return closeableHttpResponseExecute;
                }
                if (i >= maxRedirects) {
                    throw new RedirectException("Maximum redirects (" + maxRedirects + ") exceeded");
                }
                i++;
                HttpUriRequest redirect = this.redirectStrategy.getRedirect(r3.getOriginal(), closeableHttpResponseExecute, httpClientContext);
                if (!redirect.headerIterator().hasNext()) {
                    redirect.setHeaders(httpRequestWrapper.getOriginal().getAllHeaders());
                }
                HttpUriRequest httpUriRequestWrap = HttpRequestWrapper.wrap(redirect);
                if (httpUriRequestWrap instanceof HttpEntityEnclosingRequest) {
                    RequestEntityProxy.enhance((HttpEntityEnclosingRequest) httpUriRequestWrap);
                }
                URI uri = httpUriRequestWrap.getURI();
                HttpHost httpHostExtractHost = URIUtils.extractHost(uri);
                if (httpHostExtractHost == null) {
                    throw new ProtocolException("Redirect URI does not specify a valid host name: " + uri);
                }
                if (!httpRoute.getTargetHost().equals(httpHostExtractHost)) {
                    AuthState targetAuthState = httpClientContext.getTargetAuthState();
                    if (targetAuthState != null) {
                        this.log.debug("Resetting target auth state");
                        targetAuthState.reset();
                    }
                    AuthState proxyAuthState = httpClientContext.getProxyAuthState();
                    if (proxyAuthState != null && proxyAuthState.isConnectionBased()) {
                        this.log.debug("Resetting proxy auth state");
                        proxyAuthState.reset();
                    }
                }
                httpRoute = this.routePlanner.determineRoute(httpHostExtractHost, httpUriRequestWrap, httpClientContext);
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Redirecting to '" + uri + "' via " + httpRoute);
                }
                EntityUtils.consume(closeableHttpResponseExecute.getEntity());
                closeableHttpResponseExecute.close();
                r3 = httpUriRequestWrap;
            } catch (IOException e) {
                closeableHttpResponseExecute.close();
                throw e;
            } catch (RuntimeException e2) {
                closeableHttpResponseExecute.close();
                throw e2;
            } catch (HttpException e3) {
                try {
                    try {
                        EntityUtils.consume(closeableHttpResponseExecute.getEntity());
                    } catch (IOException e4) {
                        this.log.debug("I/O error while releasing connection", e4);
                    }
                    throw e3;
                } finally {
                    closeableHttpResponseExecute.close();
                }
            }
        }
        return closeableHttpResponseExecute;
    }
}
