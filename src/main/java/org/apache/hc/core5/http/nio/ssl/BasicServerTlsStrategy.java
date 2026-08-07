package org.apache.hc.core5.http.nio.ssl;

import java.net.SocketAddress;
import javax.net.ssl.SSLContext;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.reactor.ssl.SSLBufferMode;
import org.apache.hc.core5.reactor.ssl.SSLSessionInitializer;
import org.apache.hc.core5.reactor.ssl.SSLSessionVerifier;
import org.apache.hc.core5.reactor.ssl.TransportSecurityLayer;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class BasicServerTlsStrategy implements TlsStrategy {
    private final SSLSessionInitializer initializer;
    private final SecurePortStrategy securePortStrategy;
    private final SSLBufferMode sslBufferMode;
    private final SSLContext sslContext;
    private final SSLSessionVerifier verifier;

    @Deprecated
    public BasicServerTlsStrategy(SSLContext sSLContext, SecurePortStrategy securePortStrategy, SSLBufferMode sSLBufferMode, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier) {
        this.sslContext = (SSLContext) Args.notNull(sSLContext, "SSL context");
        this.securePortStrategy = securePortStrategy;
        this.sslBufferMode = sSLBufferMode;
        this.initializer = sSLSessionInitializer;
        this.verifier = sSLSessionVerifier;
    }

    @Deprecated
    public BasicServerTlsStrategy(SSLContext sSLContext, SecurePortStrategy securePortStrategy, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier) {
        this(sSLContext, securePortStrategy, null, sSLSessionInitializer, sSLSessionVerifier);
    }

    @Deprecated
    public BasicServerTlsStrategy(SSLContext sSLContext, SecurePortStrategy securePortStrategy, SSLSessionVerifier sSLSessionVerifier) {
        this(sSLContext, securePortStrategy, null, null, sSLSessionVerifier);
    }

    @Deprecated
    public BasicServerTlsStrategy(SSLContext sSLContext, SecurePortStrategy securePortStrategy) {
        this(sSLContext, securePortStrategy, null, null, null);
    }

    @Deprecated
    public BasicServerTlsStrategy(SecurePortStrategy securePortStrategy) {
        this(SSLContexts.createSystemDefault(), securePortStrategy);
    }

    public BasicServerTlsStrategy(SSLSessionVerifier sSLSessionVerifier) {
        this(SSLContexts.createSystemDefault(), sSLSessionVerifier);
    }

    public BasicServerTlsStrategy(SSLContext sSLContext, SSLBufferMode sSLBufferMode, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier) {
        this.sslContext = (SSLContext) Args.notNull(sSLContext, "SSL context");
        this.sslBufferMode = sSLBufferMode;
        this.initializer = sSLSessionInitializer;
        this.verifier = sSLSessionVerifier;
        this.securePortStrategy = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasicServerTlsStrategy(SSLContext sSLContext, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier) {
        this(sSLContext, (SSLBufferMode) null, sSLSessionInitializer, sSLSessionVerifier);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasicServerTlsStrategy(SSLContext sSLContext, SSLSessionVerifier sSLSessionVerifier) {
        this(sSLContext, (SSLBufferMode) null, (SSLSessionInitializer) null, sSLSessionVerifier);
    }

    public BasicServerTlsStrategy(SSLContext sSLContext) {
        this(sSLContext, null, null, null, null);
    }

    public BasicServerTlsStrategy() {
        this(SSLContexts.createSystemDefault());
    }

    private boolean isApplicable(SocketAddress socketAddress) {
        SecurePortStrategy securePortStrategy = this.securePortStrategy;
        return securePortStrategy == null || securePortStrategy.isSecure(socketAddress);
    }

    @Override // org.apache.hc.core5.http.nio.ssl.TlsStrategy
    public void upgrade(TransportSecurityLayer transportSecurityLayer, NamedEndpoint namedEndpoint, Object obj, Timeout timeout, FutureCallback<TransportSecurityLayer> futureCallback) {
        transportSecurityLayer.startTls(this.sslContext, namedEndpoint, this.sslBufferMode, TlsSupport.enforceStrongSecurity(this.initializer), this.verifier, timeout, futureCallback);
    }

    @Override // org.apache.hc.core5.http.nio.ssl.TlsStrategy
    @Deprecated
    public boolean upgrade(TransportSecurityLayer transportSecurityLayer, HttpHost httpHost, SocketAddress socketAddress, SocketAddress socketAddress2, Object obj, Timeout timeout) {
        if (!isApplicable(socketAddress)) {
            return false;
        }
        upgrade(transportSecurityLayer, httpHost, obj, timeout, null);
        return true;
    }
}
