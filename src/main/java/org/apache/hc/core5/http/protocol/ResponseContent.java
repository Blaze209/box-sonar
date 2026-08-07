package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpResponseInterceptor;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseContent implements HttpResponseInterceptor {
    public static final ResponseContent INSTANCE = new ResponseContent();
    private final boolean overwrite;

    public ResponseContent() {
        this(false);
    }

    public ResponseContent(boolean z) {
        this.overwrite = z;
    }

    @Override // org.apache.hc.core5.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        if (this.overwrite) {
            httpResponse.removeHeaders("Transfer-Encoding");
            httpResponse.removeHeaders("Content-Length");
        } else {
            if (httpResponse.containsHeader("Transfer-Encoding")) {
                throw new ProtocolException("Transfer-encoding header already present");
            }
            if (httpResponse.containsHeader("Content-Length")) {
                throw new ProtocolException("Content-Length header already present");
            }
        }
        ProtocolVersion protocolVersion = httpContext.getProtocolVersion();
        if (entityDetails != null) {
            if (entityDetails.getContentLength() >= 0 && !entityDetails.isChunked()) {
                httpResponse.addHeader("Content-Length", Long.toString(entityDetails.getContentLength()));
            } else if (protocolVersion.greaterEquals(HttpVersion.HTTP_1_1)) {
                httpResponse.addHeader("Transfer-Encoding", "chunked");
                MessageSupport.addTrailerHeader(httpResponse, entityDetails);
            }
            MessageSupport.addContentTypeHeader(httpResponse, entityDetails);
            MessageSupport.addContentEncodingHeader(httpResponse, entityDetails);
            return;
        }
        int code = httpResponse.getCode();
        if (code == 204 || code == 304) {
            return;
        }
        httpResponse.addHeader("Content-Length", "0");
    }
}
