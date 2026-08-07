package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpResponseInterceptor;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseConformance implements HttpResponseInterceptor {
    public static final ResponseConformance INSTANCE = new ResponseConformance();

    @Override // org.apache.hc.core5.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        int code = httpResponse.getCode();
        if ((code == 204 || code == 304) && entityDetails != null) {
            throw new ProtocolException("Response " + code + " must not enclose an entity");
        }
    }
}
