package org.apache.hc.core5.http.impl.nio;

import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.ReasonPhraseCatalog;
import org.apache.hc.core5.http.impl.EnglishReasonPhraseCatalog;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpResponseFactory implements HttpResponseFactory<HttpResponse> {
    public static final DefaultHttpResponseFactory INSTANCE = new DefaultHttpResponseFactory();
    private final ReasonPhraseCatalog reasonCatalog;

    public DefaultHttpResponseFactory(ReasonPhraseCatalog reasonPhraseCatalog) {
        this.reasonCatalog = (ReasonPhraseCatalog) Args.notNull(reasonPhraseCatalog, "Reason phrase catalog");
    }

    public DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
    }

    @Override // org.apache.hc.core5.http.HttpResponseFactory
    public HttpResponse newHttpResponse(int i, String str) {
        return new BasicHttpResponse(i, str);
    }

    @Override // org.apache.hc.core5.http.HttpResponseFactory
    public HttpResponse newHttpResponse(int i) {
        return new BasicHttpResponse(i, this.reasonCatalog, null);
    }
}
