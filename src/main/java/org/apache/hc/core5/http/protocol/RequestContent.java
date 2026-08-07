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
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RequestContent implements HttpRequestInterceptor {
    public static final HttpRequestInterceptor INSTANCE = new RequestContent();
    private final boolean overwrite;

    public RequestContent() {
        this(false);
    }

    public RequestContent(boolean z) {
        this.overwrite = z;
    }

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        String method = httpRequest.getMethod();
        if (Method.TRACE.isSame(method) && entityDetails != null) {
            throw new ProtocolException("TRACE request may not enclose an entity");
        }
        if (this.overwrite) {
            httpRequest.removeHeaders("Transfer-Encoding");
            httpRequest.removeHeaders("Content-Length");
        } else {
            if (httpRequest.containsHeader("Transfer-Encoding")) {
                throw new ProtocolException("Transfer-encoding header already present");
            }
            if (httpRequest.containsHeader("Content-Length")) {
                throw new ProtocolException("Content-Length header already present");
            }
        }
        if (entityDetails == null && isContentEnclosingMethod(method)) {
            httpRequest.addHeader("Content-Length", "0");
            return;
        }
        if (entityDetails != null) {
            validateOptionsContentType(httpRequest);
            ProtocolVersion protocolVersion = httpContext.getProtocolVersion();
            if (entityDetails.isChunked() || entityDetails.getContentLength() < 0) {
                if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                    throw new ProtocolException("Chunked transfer encoding not allowed for " + protocolVersion);
                }
                httpRequest.addHeader("Transfer-Encoding", "chunked");
                MessageSupport.addTrailerHeader(httpRequest, entityDetails);
            } else {
                httpRequest.addHeader("Content-Length", Long.toString(entityDetails.getContentLength()));
            }
            MessageSupport.addContentTypeHeader(httpRequest, entityDetails);
            MessageSupport.addContentEncodingHeader(httpRequest, entityDetails);
        }
    }

    private boolean isContentEnclosingMethod(String str) {
        return Method.POST.isSame(str) || Method.PUT.isSame(str) || Method.PATCH.isSame(str);
    }

    public void validateOptionsContentType(HttpRequest httpRequest) throws ProtocolException {
        if (Method.OPTIONS.isSame(httpRequest.getMethod()) && httpRequest.getFirstHeader("Content-Type") == null) {
            throw new ProtocolException("OPTIONS request must have Content-Type header");
        }
    }
}
