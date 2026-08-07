package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RequestUserAgent implements HttpRequestInterceptor {
    public static final HttpRequestInterceptor INSTANCE = new RequestUserAgent();
    private final String userAgent;

    public RequestUserAgent(String str) {
        this.userAgent = str;
    }

    public RequestUserAgent() {
        this(null);
    }

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        String str;
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.containsHeader("User-Agent") || (str = this.userAgent) == null) {
            return;
        }
        httpRequest.addHeader("User-Agent", str);
    }
}
