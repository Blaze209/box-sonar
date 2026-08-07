package org.apache.hc.core5.reactor.ssl;

import javax.net.ssl.SSLEngine;
import org.apache.hc.core5.net.NamedEndpoint;

/* JADX INFO: loaded from: classes5.dex */
public interface SSLSessionInitializer {
    void initialize(NamedEndpoint namedEndpoint, SSLEngine sSLEngine);
}
