package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RequestTargetHost implements HttpRequestInterceptor {
    public static final HttpRequestInterceptor INSTANCE = new RequestTargetHost();

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        ProtocolVersion protocolVersion = httpContext.getProtocolVersion();
        if ((Method.CONNECT.isSame(httpRequest.getMethod()) && protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) || httpRequest.containsHeader("Host")) {
            return;
        }
        URIAuthority authority = httpRequest.getAuthority();
        if (authority == null) {
            if (!protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                throw new ProtocolException("Target host is unknown");
            }
        } else {
            if (authority.getUserInfo() != null) {
                authority = new URIAuthority(authority.getHostName(), authority.getPort());
            }
            httpRequest.addHeader("Host", authority);
        }
    }
}
