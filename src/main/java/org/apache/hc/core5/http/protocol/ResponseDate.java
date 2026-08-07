package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpResponseInterceptor;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseDate implements HttpResponseInterceptor {
    public static final ResponseDate INSTANCE = new ResponseDate();

    @Override // org.apache.hc.core5.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        if (httpResponse.getCode() < 200 || httpResponse.containsHeader("Date")) {
            return;
        }
        httpResponse.setHeader("Date", HttpDateGenerator.INSTANCE.getCurrentDate());
    }
}
