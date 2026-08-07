package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.MisdirectedRequestException;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class RequestConformance implements HttpRequestInterceptor {
    public static final RequestConformance INSTANCE = new RequestConformance();

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (TextUtils.isBlank(httpRequest.getScheme())) {
            throw new ProtocolException("Request scheme is not set");
        }
        if (TextUtils.isBlank(httpRequest.getPath())) {
            throw new ProtocolException("Request path is not set");
        }
        URIAuthority authority = httpRequest.getAuthority();
        if (authority != null && ((URIScheme.HTTP.same(httpRequest.getScheme()) || URIScheme.HTTPS.same(httpRequest.getScheme())) && TextUtils.isBlank(authority.getHostName()))) {
            throw new ProtocolException("Request host is empty");
        }
        HttpCoreContext httpCoreContextCast = HttpCoreContext.cast(httpContext);
        if (URIScheme.HTTPS.same(httpRequest.getScheme()) && httpCoreContextCast.getSSLSession() == null) {
            throw new MisdirectedRequestException("HTTPS request over non-secure connection");
        }
    }
}
