package org.apache.hc.core5.http.impl.io;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.ReasonPhraseCatalog;
import org.apache.hc.core5.http.impl.EnglishReasonPhraseCatalog;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultClassicHttpResponseFactory implements HttpResponseFactory<ClassicHttpResponse> {
    public static final DefaultClassicHttpResponseFactory INSTANCE = new DefaultClassicHttpResponseFactory();
    private final ReasonPhraseCatalog reasonCatalog;

    public DefaultClassicHttpResponseFactory(ReasonPhraseCatalog reasonPhraseCatalog) {
        this.reasonCatalog = (ReasonPhraseCatalog) Args.notNull(reasonPhraseCatalog, "Reason phrase catalog");
    }

    public DefaultClassicHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
    }

    @Override // org.apache.hc.core5.http.HttpResponseFactory
    public ClassicHttpResponse newHttpResponse(int i, String str) {
        return new BasicClassicHttpResponse(i, str);
    }

    @Override // org.apache.hc.core5.http.HttpResponseFactory
    public ClassicHttpResponse newHttpResponse(int i) {
        return new BasicClassicHttpResponse(i, this.reasonCatalog, null);
    }
}
