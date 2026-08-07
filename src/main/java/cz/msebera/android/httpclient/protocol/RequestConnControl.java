package cz.msebera.android.httpclient.protocol;

import com.google.api.client.http.HttpMethods;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class RequestConnControl implements HttpRequestInterceptor {
    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase(HttpMethods.CONNECT) || httpRequest.containsHeader("Connection")) {
            return;
        }
        httpRequest.addHeader("Connection", "Keep-Alive");
    }
}
