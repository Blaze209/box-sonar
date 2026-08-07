package org.apache.hc.core5.http.protocol;

import java.io.IOException;
import java.util.List;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpResponseInterceptor;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultHttpProcessor implements HttpProcessor {
    private final HttpRequestInterceptor[] requestInterceptors;
    private final HttpResponseInterceptor[] responseInterceptors;

    public DefaultHttpProcessor(HttpRequestInterceptor[] httpRequestInterceptorArr, HttpResponseInterceptor[] httpResponseInterceptorArr) {
        if (httpRequestInterceptorArr != null) {
            int length = httpRequestInterceptorArr.length;
            HttpRequestInterceptor[] httpRequestInterceptorArr2 = new HttpRequestInterceptor[length];
            this.requestInterceptors = httpRequestInterceptorArr2;
            System.arraycopy(httpRequestInterceptorArr, 0, httpRequestInterceptorArr2, 0, length);
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorArr != null) {
            int length2 = httpResponseInterceptorArr.length;
            HttpResponseInterceptor[] httpResponseInterceptorArr2 = new HttpResponseInterceptor[length2];
            this.responseInterceptors = httpResponseInterceptorArr2;
            System.arraycopy(httpResponseInterceptorArr, 0, httpResponseInterceptorArr2, 0, length2);
            return;
        }
        this.responseInterceptors = new HttpResponseInterceptor[0];
    }

    public DefaultHttpProcessor(List<HttpRequestInterceptor> list, List<HttpResponseInterceptor> list2) {
        if (list != null) {
            this.requestInterceptors = (HttpRequestInterceptor[]) list.toArray(new HttpRequestInterceptor[list.size()]);
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (list2 != null) {
            this.responseInterceptors = (HttpResponseInterceptor[]) list2.toArray(new HttpResponseInterceptor[list2.size()]);
        } else {
            this.responseInterceptors = new HttpResponseInterceptor[0];
        }
    }

    public DefaultHttpProcessor(HttpRequestInterceptor... httpRequestInterceptorArr) {
        this(httpRequestInterceptorArr, (HttpResponseInterceptor[]) null);
    }

    public DefaultHttpProcessor(HttpResponseInterceptor... httpResponseInterceptorArr) {
        this((HttpRequestInterceptor[]) null, httpResponseInterceptorArr);
    }

    @Override // org.apache.hc.core5.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        for (HttpRequestInterceptor httpRequestInterceptor : this.requestInterceptors) {
            httpRequestInterceptor.process(httpRequest, entityDetails, httpContext);
        }
    }

    @Override // org.apache.hc.core5.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        for (HttpResponseInterceptor httpResponseInterceptor : this.responseInterceptors) {
            httpResponseInterceptor.process(httpResponse, entityDetails, httpContext);
        }
    }
}
