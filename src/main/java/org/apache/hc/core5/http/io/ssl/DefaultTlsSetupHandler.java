package org.apache.hc.core5.http.io.ssl;

import javax.net.ssl.SSLParameters;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.ssl.TLS;
import org.apache.hc.core5.http.ssl.TlsCiphers;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultTlsSetupHandler implements Callback<SSLParameters> {
    private final boolean client;
    public static final DefaultTlsSetupHandler SERVER = new DefaultTlsSetupHandler(false);
    public static final DefaultTlsSetupHandler CLIENT = new DefaultTlsSetupHandler(true);

    public DefaultTlsSetupHandler() {
        this.client = false;
    }

    public DefaultTlsSetupHandler(boolean z) {
        this.client = z;
    }

    @Override // org.apache.hc.core5.function.Callback
    public void execute(SSLParameters sSLParameters) {
        sSLParameters.setProtocols(TLS.excludeWeak(sSLParameters.getProtocols()));
        sSLParameters.setCipherSuites(TlsCiphers.excludeWeak(sSLParameters.getCipherSuites()));
        if (this.client) {
            sSLParameters.setEndpointIdentificationAlgorithm(URIScheme.HTTPS.id);
        }
    }
}
