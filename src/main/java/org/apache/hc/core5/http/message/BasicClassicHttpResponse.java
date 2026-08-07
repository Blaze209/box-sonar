package org.apache.hc.core5.http.message;

import java.io.IOException;
import java.util.Locale;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ReasonPhraseCatalog;
import org.apache.hc.core5.io.Closer;

/* JADX INFO: loaded from: classes5.dex */
public class BasicClassicHttpResponse extends BasicHttpResponse implements ClassicHttpResponse {
    private static final long serialVersionUID = 1;
    private HttpEntity entity;

    public BasicClassicHttpResponse(int i, ReasonPhraseCatalog reasonPhraseCatalog, Locale locale) {
        super(i, reasonPhraseCatalog, locale);
    }

    public BasicClassicHttpResponse(int i, String str) {
        super(i, str);
    }

    public BasicClassicHttpResponse(int i) {
        super(i);
    }

    @Override // org.apache.hc.core5.http.HttpEntityContainer
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // org.apache.hc.core5.http.HttpEntityContainer
    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Closer.close(this.entity);
    }
}
