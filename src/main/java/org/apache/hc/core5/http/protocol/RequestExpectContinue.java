package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RequestExpectContinue implements HttpRequestInterceptor {
    public static final RequestExpectContinue INSTANCE = new RequestExpectContinue();

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.containsHeader("Expect") || entityDetails == null) {
            return;
        }
        ProtocolVersion protocolVersion = httpContext.getProtocolVersion();
        if (entityDetails.getContentLength() == 0 || protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
            return;
        }
        httpRequest.addHeader("Expect", "100-continue");
    }
}
