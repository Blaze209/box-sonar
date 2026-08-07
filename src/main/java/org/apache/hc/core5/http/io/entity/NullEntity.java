package org.apache.hc.core5.http.io.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;

/* JADX INFO: loaded from: classes5.dex */
public final class NullEntity implements HttpEntity {
    public static final NullEntity INSTANCE = new NullEntity();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return 0L;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentType() {
        return null;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public Supplier<List<? extends Header>> getTrailers() {
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return false;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
    }

    private NullEntity() {
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public InputStream getContent() throws UnsupportedOperationException, IOException {
        return EmptyInputStream.INSTANCE;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return Collections.emptySet();
    }
}
