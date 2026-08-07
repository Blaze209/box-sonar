package org.apache.hc.core5.http.nio.ssl;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import org.apache.hc.core5.http.ssl.TLS;
import org.apache.hc.core5.http.ssl.TlsCiphers;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.reactor.ssl.SSLSessionInitializer;

/* JADX INFO: loaded from: classes5.dex */
public final class TlsSupport {
    public static SSLParameters enforceStrongSecurity(SSLParameters sSLParameters) {
        sSLParameters.setProtocols(TLS.excludeWeak(sSLParameters.getProtocols()));
        sSLParameters.setCipherSuites(TlsCiphers.excludeWeak(sSLParameters.getCipherSuites()));
        return sSLParameters;
    }

    public static SSLSessionInitializer enforceStrongSecurity(final SSLSessionInitializer sSLSessionInitializer) {
        return new SSLSessionInitializer() { // from class: org.apache.hc.core5.http.nio.ssl.TlsSupport$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.reactor.ssl.SSLSessionInitializer
            public final void initialize(NamedEndpoint namedEndpoint, SSLEngine sSLEngine) {
                TlsSupport.lambda$enforceStrongSecurity$0(sSLSessionInitializer, namedEndpoint, sSLEngine);
            }
        };
    }

    static /* synthetic */ void lambda$enforceStrongSecurity$0(SSLSessionInitializer sSLSessionInitializer, NamedEndpoint namedEndpoint, SSLEngine sSLEngine) {
        sSLEngine.setSSLParameters(enforceStrongSecurity(sSLEngine.getSSLParameters()));
        if (sSLSessionInitializer != null) {
            sSLSessionInitializer.initialize(namedEndpoint, sSLEngine);
        }
    }
}
