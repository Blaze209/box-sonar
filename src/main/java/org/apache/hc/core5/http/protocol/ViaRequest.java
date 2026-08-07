package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ViaRequest implements HttpRequestInterceptor {
    public static final HttpRequestInterceptor INSTANCE = new ViaRequest();

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws ProtocolException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        ProtocolVersion protocolVersion = httpContext.getProtocolVersion() != null ? httpContext.getProtocolVersion() : HttpVersion.HTTP_1_1;
        URIAuthority authority = httpRequest.getAuthority();
        if (authority == null) {
            throw new ProtocolException("Request authority not specified");
        }
        if (!protocolVersion.greaterEquals(HttpVersion.HTTP_1_1)) {
            throw new ProtocolException("Invalid protocol version: %s", protocolVersion);
        }
        if (httpRequest.containsHeader("Via")) {
            return;
        }
        String str = protocolVersion.getProtocol() + " " + protocolVersion.getMajor() + "." + protocolVersion.getMinor() + " " + authority.getHostName();
        int port = authority.getPort();
        if (port != -1) {
            str = str + ":" + port;
        }
        httpRequest.addHeader("Via", str);
    }
}
