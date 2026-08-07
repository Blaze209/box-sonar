package org.apache.hc.core5.http.protocol;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ForwardedRequest implements HttpRequestInterceptor {
    private static final String FORWARDED_HEADER_NAME = "Forwarded";
    public static final HttpRequestInterceptor INSTANCE = new ForwardedRequest();

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        HttpCoreContext httpCoreContextCast = HttpCoreContext.cast(httpContext);
        ProtocolVersion protocolVersion = httpCoreContextCast.getProtocolVersion() != null ? httpCoreContextCast.getProtocolVersion() : HttpVersion.HTTP_1_1;
        URIAuthority authority = httpRequest.getAuthority();
        if (authority == null) {
            throw new ProtocolException("Request authority not specified");
        }
        int port = authority.getPort();
        StringBuilder sb = new StringBuilder();
        Header firstHeader = httpRequest.getFirstHeader("Forwarded");
        boolean z = firstHeader != null;
        if (z) {
            sb.append(firstHeader.getValue());
            sb.append(", ");
        }
        EndpointDetails endpointDetails = httpCoreContextCast.getEndpointDetails();
        if (endpointDetails != null) {
            SocketAddress remoteAddress = endpointDetails.getRemoteAddress();
            if (remoteAddress instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) remoteAddress;
                String str = inetSocketAddress.getHostString() + ":" + inetSocketAddress.getPort();
                if (inetSocketAddress.getAddress() instanceof Inet6Address) {
                    sb.append("by=\"").append(str).append("\"");
                } else {
                    sb.append("by=").append(str);
                }
            }
            SocketAddress localAddress = endpointDetails.getLocalAddress();
            if (localAddress instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) localAddress;
                String str2 = inetSocketAddress2.getHostString() + ":" + inetSocketAddress2.getPort();
                if (inetSocketAddress2.getAddress() instanceof Inet6Address) {
                    sb.append(";for=\"").append(str2).append("\"");
                } else {
                    sb.append(";for=").append(str2);
                }
            }
        }
        if (sb.length() > 0 && !z) {
            sb.append(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
        }
        sb.append("host=\"").append(authority.getHostName()).append("\"");
        if (port != -1) {
            sb.append(";port=").append(port);
        }
        String protocol = protocolVersion.getProtocol();
        if (protocol != null) {
            sb.append(";proto=").append(protocol);
        }
        httpRequest.setHeader("Forwarded", sb.toString());
    }
}
