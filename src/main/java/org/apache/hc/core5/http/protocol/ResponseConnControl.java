package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HeaderElement;
import org.apache.hc.core5.http.HeaderElements;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpResponseInterceptor;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseConnControl implements HttpResponseInterceptor {
    public static final ResponseConnControl INSTANCE = new ResponseConnControl();

    @Override // org.apache.hc.core5.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        boolean z;
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpCoreContext httpCoreContextCast = HttpCoreContext.cast(httpContext);
        int code = httpResponse.getCode();
        if (code == 400 || code == 408 || code == 411 || code == 413 || code == 414 || code == 503 || code == 501) {
            httpResponse.setHeader("Connection", HeaderElements.CLOSE);
            return;
        }
        if (httpResponse.containsHeader("Connection")) {
            return;
        }
        ProtocolVersion protocolVersion = httpCoreContextCast.getProtocolVersion();
        if (entityDetails != null && entityDetails.getContentLength() < 0 && protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
            httpResponse.setHeader("Connection", HeaderElements.CLOSE);
            return;
        }
        HttpRequest request = httpCoreContextCast.getRequest();
        boolean z2 = false;
        if (request != null) {
            Iterator<HeaderElement> itIterate = MessageSupport.iterate(request, "Connection");
            z = false;
            while (itIterate.hasNext()) {
                HeaderElement next = itIterate.next();
                if (next.getName().equalsIgnoreCase(HeaderElements.CLOSE)) {
                    z2 = true;
                    break;
                } else if (next.getName().equalsIgnoreCase(HeaderElements.KEEP_ALIVE)) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (z2) {
            httpResponse.addHeader("Connection", HeaderElements.CLOSE);
            return;
        }
        if (httpResponse.containsHeader("Upgrade")) {
            httpResponse.addHeader("Connection", HeaderElements.UPGRADE);
        } else if (z) {
            httpResponse.addHeader("Connection", HeaderElements.KEEP_ALIVE);
        } else if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
            httpResponse.addHeader("Connection", HeaderElements.CLOSE);
        }
    }
}
