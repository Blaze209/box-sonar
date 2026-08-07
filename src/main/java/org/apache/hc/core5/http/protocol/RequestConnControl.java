package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HeaderElements;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RequestConnControl implements HttpRequestInterceptor {
    public static final HttpRequestInterceptor INSTANCE = new RequestConnControl();

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (Method.CONNECT.isSame(httpRequest.getMethod()) || httpRequest.containsHeader("Connection")) {
            return;
        }
        if (httpRequest.containsHeader("Upgrade")) {
            httpRequest.addHeader("Connection", HeaderElements.UPGRADE);
        } else {
            httpRequest.addHeader("Connection", HeaderElements.KEEP_ALIVE);
        }
    }
}
