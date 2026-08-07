package org.apache.hc.core5.http.io.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class HttpEntityWrapper implements HttpEntity {
    private final HttpEntity wrappedEntity;

    public HttpEntityWrapper(HttpEntity httpEntity) {
        this.wrappedEntity = (HttpEntity) Args.notNull(httpEntity, "Wrapped entity");
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public boolean isRepeatable() {
        return this.wrappedEntity.isRepeatable();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return this.wrappedEntity.isChunked();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.wrappedEntity.getContentLength();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentType() {
        return this.wrappedEntity.getContentType();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        return this.wrappedEntity.getContentEncoding();
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public InputStream getContent() throws IOException {
        return this.wrappedEntity.getContent();
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.wrappedEntity.writeTo(outputStream);
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public boolean isStreaming() {
        return this.wrappedEntity.isStreaming();
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public Supplier<List<? extends Header>> getTrailers() {
        return this.wrappedEntity.getTrailers();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return this.wrappedEntity.getTrailerNames();
    }

    public void close() throws IOException {
        this.wrappedEntity.close();
    }

    public String toString() {
        return "Wrapper [" + this.wrappedEntity + "]";
    }
}
