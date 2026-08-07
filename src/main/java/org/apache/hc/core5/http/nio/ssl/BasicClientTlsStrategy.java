package org.apache.hc.core5.http.nio.ssl;

import java.net.SocketAddress;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.reactor.ssl.SSLBufferMode;
import org.apache.hc.core5.reactor.ssl.SSLSessionInitializer;
import org.apache.hc.core5.reactor.ssl.SSLSessionVerifier;
import org.apache.hc.core5.reactor.ssl.TransportSecurityLayer;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class BasicClientTlsStrategy implements TlsStrategy {
    private final SSLSessionInitializer initializer;
    private final SSLBufferMode sslBufferMode;
    private final SSLContext sslContext;
    private final SSLSessionVerifier verifier;

    public BasicClientTlsStrategy(SSLContext sSLContext, SSLBufferMode sSLBufferMode, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier) {
        this.sslContext = (SSLContext) Args.notNull(sSLContext, "SSL context");
        this.sslBufferMode = sSLBufferMode;
        this.initializer = sSLSessionInitializer;
        this.verifier = sSLSessionVerifier;
    }

    public BasicClientTlsStrategy(SSLContext sSLContext, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier) {
        this(sSLContext, null, sSLSessionInitializer, sSLSessionVerifier);
    }

    public BasicClientTlsStrategy(SSLContext sSLContext, SSLSessionVerifier sSLSessionVerifier) {
        this(sSLContext, null, null, sSLSessionVerifier);
    }

    public BasicClientTlsStrategy(SSLContext sSLContext) {
        this(sSLContext, null, null, null);
    }

    public BasicClientTlsStrategy() {
        this(SSLContexts.createSystemDefault());
    }

    public BasicClientTlsStrategy(SSLSessionVerifier sSLSessionVerifier) {
        this(SSLContexts.createSystemDefault(), sSLSessionVerifier);
    }

    @Override // org.apache.hc.core5.http.nio.ssl.TlsStrategy
    public void upgrade(TransportSecurityLayer transportSecurityLayer, NamedEndpoint namedEndpoint, Object obj, Timeout timeout, FutureCallback<TransportSecurityLayer> futureCallback) {
        transportSecurityLayer.startTls(this.sslContext, namedEndpoint, this.sslBufferMode, new SSLSessionInitializer() { // from class: org.apache.hc.core5.http.nio.ssl.BasicClientTlsStrategy$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.reactor.ssl.SSLSessionInitializer
            public final void initialize(NamedEndpoint namedEndpoint2, SSLEngine sSLEngine) {
                this.f$0.m16638x3667b768(namedEndpoint2, sSLEngine);
            }
        }, this.verifier, timeout, futureCallback);
    }

    /* JADX INFO: renamed from: lambda$upgrade$0$org-apache-hc-core5-http-nio-ssl-BasicClientTlsStrategy, reason: not valid java name */
    /* synthetic */ void m16638x3667b768(NamedEndpoint namedEndpoint, SSLEngine sSLEngine) {
        SSLParameters sSLParameters = sSLEngine.getSSLParameters();
        sSLParameters.setEndpointIdentificationAlgorithm(URIScheme.HTTPS.id);
        sSLEngine.setSSLParameters(TlsSupport.enforceStrongSecurity(sSLParameters));
        SSLSessionInitializer sSLSessionInitializer = this.initializer;
        if (sSLSessionInitializer != null) {
            sSLSessionInitializer.initialize(namedEndpoint, sSLEngine);
        }
    }

    @Override // org.apache.hc.core5.http.nio.ssl.TlsStrategy
    @Deprecated
    public boolean upgrade(TransportSecurityLayer transportSecurityLayer, HttpHost httpHost, SocketAddress socketAddress, SocketAddress socketAddress2, Object obj, Timeout timeout) {
        if (!URIScheme.HTTPS.same(httpHost != null ? httpHost.getSchemeName() : null)) {
            return false;
        }
        upgrade(transportSecurityLayer, httpHost, obj, timeout, null);
        return true;
    }
}
