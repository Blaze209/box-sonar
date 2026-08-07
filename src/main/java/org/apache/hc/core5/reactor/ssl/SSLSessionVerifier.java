package org.apache.hc.core5.reactor.ssl;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import org.apache.hc.core5.net.NamedEndpoint;

/* JADX INFO: loaded from: classes5.dex */
public interface SSLSessionVerifier {
    TlsDetails verify(NamedEndpoint namedEndpoint, SSLEngine sSLEngine) throws SSLException;
}
