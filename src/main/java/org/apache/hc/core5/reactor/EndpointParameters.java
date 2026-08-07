package org.apache.hc.core5.reactor;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.net.Ports;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class EndpointParameters implements NamedEndpoint {
    private final Object attachment;
    private final String hostName;
    private final int port;
    private final String scheme;

    public EndpointParameters(String str, String str2, int i, Object obj) {
        this.scheme = (String) Args.notBlank(str, "Protocol scheme");
        this.hostName = (String) Args.notBlank(str2, "Endpoint name");
        this.port = Ports.checkWithDefault(i);
        this.attachment = obj;
    }

    public EndpointParameters(HttpHost httpHost, Object obj) {
        Args.notNull(httpHost, "HTTP host");
        this.scheme = httpHost.getSchemeName();
        this.hostName = httpHost.getHostName();
        this.port = httpHost.getPort();
        this.attachment = obj;
    }

    public String getScheme() {
        return this.scheme;
    }

    @Override // org.apache.hc.core5.net.NamedEndpoint
    public String getHostName() {
        return this.hostName;
    }

    @Override // org.apache.hc.core5.net.NamedEndpoint
    public int getPort() {
        return this.port;
    }

    public Object getAttachment() {
        return this.attachment;
    }

    public String toString() {
        return "EndpointParameters{scheme='" + this.scheme + "', name='" + this.hostName + "', port=" + this.port + ", attachment=" + this.attachment + AbstractJsonLexerKt.END_OBJ;
    }
}
