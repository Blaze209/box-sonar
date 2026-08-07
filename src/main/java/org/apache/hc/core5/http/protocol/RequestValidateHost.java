package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RequestValidateHost implements HttpRequestInterceptor {
    public static final RequestValidateHost INSTANCE = new RequestValidateHost();

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.getAuthority() != null) {
            return;
        }
        Header header = httpRequest.getHeader("Host");
        if (header != null) {
            try {
                httpRequest.setAuthority(URIAuthority.create(header.getValue()));
            } catch (URISyntaxException e) {
                throw new ProtocolException(e.getMessage(), e);
            }
        } else {
            if ((httpRequest.getVersion() != null ? httpRequest.getVersion() : HttpVersion.HTTP_1_1).greaterEquals(HttpVersion.HTTP_1_1)) {
                throw new ProtocolException("Host header is absent");
            }
        }
    }
}
