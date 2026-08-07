package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RequestDate implements HttpRequestInterceptor {
    public static final HttpRequestInterceptor INSTANCE = new RequestDate();

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (entityDetails == null || httpRequest.containsHeader("Date")) {
            return;
        }
        httpRequest.setHeader("Date", HttpDateGenerator.INSTANCE.getCurrentDate());
    }
}
